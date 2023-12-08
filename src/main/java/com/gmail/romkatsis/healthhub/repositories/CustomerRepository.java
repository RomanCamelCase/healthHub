package com.gmail.romkatsis.healthhub.repositories;

import com.gmail.romkatsis.healthhub.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
