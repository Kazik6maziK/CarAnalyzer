package com.example.caranalyzer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {
    private String id;
    private String name;
    private List<Model> models;

    // Конструкторы, геттеры и сеттеры
    public Car() {}

    public Car(String id, String name, List<Model> models) {
        this.id = id;
        this.name = name;
        this.models = models;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    // Вложенный класс для модели автомобиля
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Model {
        private String id;
        private String name;
        private Integer yearFrom;
        private Integer yearTo;

        // Конструкторы, геттеры и сеттеры
        public Model() {}

        public Model(String id, String name, Integer yearFrom, Integer yearTo) {
            this.id = id;
            this.name = name;
            this.yearFrom = yearFrom;
            this.yearTo = yearTo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getYearFrom() {
            return yearFrom;
        }

        public void setYearFrom(Integer yearFrom) {
            this.yearFrom = yearFrom;
        }

        public Integer getYearTo() {
            return yearTo;
        }

        public void setYearTo(Integer yearTo) {
            this.yearTo = yearTo;
        }
    }
}
