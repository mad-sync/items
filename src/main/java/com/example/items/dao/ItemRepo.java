package com.example.items.dao;

import com.example.items.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item , Long> {
}
