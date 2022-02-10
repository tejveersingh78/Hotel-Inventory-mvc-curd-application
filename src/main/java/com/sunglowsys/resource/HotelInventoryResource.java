package com.sunglowsys.resource;


import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.service.HotelInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelInventoryResource {

    @Autowired
    private HotelInventoryService hotelInventoryService;

    @PostMapping("/hotelInvetories")
    public ResponseEntity<?> create(@RequestBody HotelInventory hotelInventory){
        HotelInventory result = hotelInventoryService.createHotelInventory(hotelInventory);
        return ResponseEntity.ok().body("HotelInventory is created Successfully : " + result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HotelInventory> update(@RequestBody HotelInventory hotelInventory ,@PathVariable("id") Long id){
        HotelInventory result = hotelInventoryService.update(hotelInventory,id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public List<HotelInventory> getAll(){
        List<HotelInventory> result = hotelInventoryService.findAll();
        return result;
    }

    @GetMapping("/hotelInventories/{id}")
    public HotelInventory getById(@PathVariable("id") Long id){
        return hotelInventoryService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        hotelInventoryService.delete(id);
        return ResponseEntity.ok().body("HotelInventory is deleted on this Id : " + id);
    }
}
