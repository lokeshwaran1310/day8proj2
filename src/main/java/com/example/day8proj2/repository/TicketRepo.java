package com.example.day8proj2.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day8proj2.domain.Ticket;
public interface TicketRepo extends JpaRepository<Ticket, Long>{
    
}
