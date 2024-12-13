package com.example.caranalyzer.controller;

import com.example.caranalyzer.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/search")
    public List<String> search(@RequestParam String query, @RequestParam(required = false) Integer year) {
        return carService.searchCars(query);
    }
}
