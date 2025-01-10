package com.crm.crm.repository;

import com.crm.crm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // No need to define methods unless you need custom queries.
    // JpaRepository provides basic CRUD operations by default.
}
