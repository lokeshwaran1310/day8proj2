
package com.example.day8proj2.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="tusers")
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long userid;
    private String fullname;
    private String email;
    
    @OneToMany(mappedBy="user")
    private List<Ticket> tickets;

    public long getUserid() {
        return userid;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public List<Ticket> getTickList() {
        return tickets;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTickList(List<Ticket> tickets) {
        this.tickets = tickets;
    }









}
