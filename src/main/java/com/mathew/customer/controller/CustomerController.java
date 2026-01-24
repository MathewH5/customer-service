package com.mathew.customer.controller;

import com.mathew.customer.model.CustomerRequest;
import com.mathew.customer.model.CustomerResponse;
import com.mathew.customer.service.CreateCustomerService;
import com.mathew.customer.service.CustomerService;
import com.mathew.customer.service.UpdateCustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;
    private final CreateCustomerService createCustomer;
    private final UpdateCustomerService updateCustomer;

    public CustomerController(CustomerService service, CreateCustomerService createCustomer, UpdateCustomerService updateCustomer) {
        this.service = service;
        this.createCustomer = createCustomer;
        this.updateCustomer = updateCustomer;
    }

    @GetMapping
    public List<CustomerResponse> listCustomers(){
        return service.getCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerByid(@PathVariable Long id){
        return service.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> creatCustomer(@RequestBody CustomerRequest request){
        CustomerResponse created = createCustomer.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest request){
         CustomerResponse update = updateCustomer.execute(id,request);
         return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
    }
}
