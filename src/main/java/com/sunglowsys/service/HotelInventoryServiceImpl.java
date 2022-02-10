package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.repository.HotelInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelInventoryServiceImpl implements HotelInventoryService{

    @Autowired
    private HotelInventoryRepository hotelInventoryRepository;

    @Override
    public HotelInventory createHotelInventory(HotelInventory hotelInventory) {
        return hotelInventoryRepository.save(hotelInventory);
    }

    @Override
    public HotelInventory update(HotelInventory hotelInventory, Long id) {
        HotelInventory hotelInventory1 = findById(id);
        if(hotelInventory.getTotalInventory() != null){
            hotelInventory1.setTotalInventory(hotelInventory.getTotalInventory());
        }
        HotelInventory result = hotelInventoryRepository.save(hotelInventory1);
        return result;
    }

    @Override
    public List<HotelInventory> findAll() {
        return hotelInventoryRepository.findAll();
    }

    @Override
    public HotelInventory findById(Long id) {
        return hotelInventoryRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        hotelInventoryRepository.deleteById(id);
    }
}
