package com.mathew.consorcio.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public List<Customer> listCustomers(){
        return List.of(
                new Customer(1L, "Mathew"),
                new Customer(2L, "Pavi")
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerByid(@PathVariable long id){
        if (id == 1L) {
            return ResponseEntity.ok(new Customer(1L, "Mathew"));
        }

        if (id == 2L) {
            return ResponseEntity.ok(new Customer(2L, "Cliente Exemplo"));
        }

        return ResponseEntity.notFound().build(); // 404
    }

}
