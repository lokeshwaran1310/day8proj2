package com.example.day8proj2.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day8proj2.domain.Tag;

public interface TagRepo extends JpaRepository<Tag, Long>{
    
}
