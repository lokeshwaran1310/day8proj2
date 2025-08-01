package com.example.day8proj2.controller;
import java.util.List;
import java.util.Map;
import com.example.day8proj2.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/tickets")
public class TicketController { 
    @Autowired
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping
    public List<Map<String, Object>> getTickets() {
        return ticketService.getFormattedTickets();
    }
}
