package com.example.caranalyzer.service;

import com.example.caranalyzer.model.Car;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CarService {
    private final List<Car> cars;

    public CarService() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        cars = objectMapper.readValue(new File("src/main/resources/cars.json"), new TypeReference<List<Car>>() {
        });
    }

    public List<String> searchCars(String input) {
        List<String> results = new ArrayList<>();
        String vin = null;
        String brand = null;
        String model = null;
        String year = null;

        // Регулярное выражение для VIN
        Pattern vinPattern = Pattern.compile("\\b[a-hj-npr-zA-HJ-NPR-Z0-9]{17}\\b");
        Matcher vinMatcher = vinPattern.matcher(input);
        if (vinMatcher.find()) {
            vin = vinMatcher.group();
            results.add("VIN: " + vin);
        } else {
            results.add("VIN: Not Found");
        }

        // Поиск года в тексте (годы с 1900 по 2099)
        Pattern yearPattern = Pattern.compile("\\b(19|20)\\d{2}\\b");
        Matcher yearMatcher = yearPattern.matcher(input);
        if (yearMatcher.find()) {
            year = yearMatcher.group();
            results.add("Year: " + year);
        } else {
            results.add("Year: Not Found");
        }

        // Проверка на наличие марки и модели
        for (Car car : cars) {
            if (input.toLowerCase().contains(car.getName().toLowerCase())) {
                brand = car.getName();
                for (var modelObj : car.getModels()) {
                    if (input.toLowerCase().contains(modelObj.getName().toLowerCase())) {
                        model = modelObj.getName();
                        break;
                    }
                }
                break;
            }
        }

        // Добавление марки и модели в результаты
        if (brand != null) {
            results.add("Brand: " + brand);
        } else {
            results.add("Brand: Not Found");
        }

        if (model != null) {
            results.add("Model: " + model);
        } else {
            results.add("Model: Not Found");
        }

        return results;
    }
}
