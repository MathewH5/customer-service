package com.mathew.consorcio.customer.controller;

import com.mathew.consorcio.customer.model.CreateCustomerRequest;
import com.mathew.consorcio.customer.model.CustomerResponse;
import com.mathew.consorcio.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
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
    public ResponseEntity<CustomerResponse> creatCustomer(@RequestBody CreateCustomerRequest request){
        CustomerResponse created = service.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

}
