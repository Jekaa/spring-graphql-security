package com.example.springgraphqlsecurity.controller;

import com.example.springgraphqlsecurity.model.Customer;
import com.example.springgraphqlsecurity.service.CrmService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class SecureGraphqlController {

    private final CrmService crm;

    public SecureGraphqlController(CrmService crm) {
        this.crm = crm;
    }


    @MutationMapping
    Mono<Customer> insert(@Argument String name) {
        return this.crm.inset(name);
    }

    @QueryMapping
    Mono<Customer> customerById(@Argument Integer id) {
        return this.crm.getCustomerById(id);
    }
}
