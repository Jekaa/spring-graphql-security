package com.example.springgraphqlsecurity.service;

import com.example.springgraphqlsecurity.model.Customer;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CrmService {

    private final Map<Integer, Customer> db = new ConcurrentHashMap<>();

    private final AtomicInteger id = new AtomicInteger();

    @Secured("ROLE_VIEWER")
    public Mono<Customer> getCustomerById(Integer id) {
        var customer = this.db.get(id);
        return Mono.just(customer);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Mono<Customer> inset(String name) {
        var newCustomer = new Customer(id.incrementAndGet(), name);
        this.db.put(newCustomer.id(), newCustomer);
        return Mono.just(newCustomer);
    }
}
