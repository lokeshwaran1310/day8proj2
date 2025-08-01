package com.example.day8proj2.domain;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ticketid;
    private String title;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "tickettags",
        joinColumns = @JoinColumn(name = "ticketid"),
        inverseJoinColumns = @JoinColumn(name = "tagid")
    )
    private Set<Tag> tags;

    public long getTicketid() {
        return ticketid;
    }

    public void setTicketid(long ticketid) {
        this.ticketid = ticketid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    

    
}
