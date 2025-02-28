package com.example.hotel_reservation.service;

import com.example.hotel_reservation.model.Hotel;
import com.example.hotel_reservation.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class HotelService {

    private static final Logger logger = LoggerFactory.getLogger(HotelService.class);

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        logger.debug("Fetching all hotels");
        return hotelRepository.findAll();
    }
    @Transactional
    public Hotel addHotel(Hotel hotel) {
        logger.debug("Adding new hotel: {}", hotel.getName());
        try {
            return hotelRepository.save(hotel);
        } catch (Exception e) {
            logger.error("Error adding hotel: {}", e.getMessage());
            throw new RuntimeException("Error adding hotel: " + e.getMessage());
        }
    }
}
