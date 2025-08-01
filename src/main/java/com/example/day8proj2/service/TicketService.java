package com.example.day8proj2.service;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day8proj2.domain.Ticket;
import com.example.day8proj2.repository.TicketRepo;
@Service
public class TicketService {
    @Autowired
     private TicketRepo ticketrepo;

    public List<Map<String, Object>> getFormattedTickets() {
        List<Ticket> tickets = ticketrepo.findAll();
        List<Map<String, Object>> response = new ArrayList<>();

        for (Ticket ticket : tickets) {
            Map<String, Object> item = new LinkedHashMap<>();
            item.put("title", ticket.getTitle());
            item.put("user", ticket.getUser().getFullname());

            List<String> tagNames = new ArrayList<>();
            ticket.getTags().forEach(tag -> tagNames.add(tag.getName()));
            item.put("tags", tagNames);

            response.add(item);
        }
        return response;
    }
}
