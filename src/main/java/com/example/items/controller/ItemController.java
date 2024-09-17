package com.example.items.controller;

import com.example.items.dao.ItemRepo;
import com.example.items.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:3000") // Replace with your frontend URL - If you only want to enable CORS for specific controllers or endpoints, you can use the @CrossOrigin annotation.
public class ItemController {

    @Autowired
    private ItemRepo itemRepo;

    @GetMapping
    public List<Item> getAllItems(){
        return itemRepo.findAll();
    }

    @PostMapping
    public Item createItem(@RequestBody  Item item){
        return itemRepo.save(item);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id){
        return itemRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id , @RequestBody Item item){
        item.setId(id);
        return itemRepo.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id){
        itemRepo.deleteById(id);
    }
}
