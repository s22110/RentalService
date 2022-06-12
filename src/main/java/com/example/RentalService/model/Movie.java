package com.example.RentalService.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    private Integer id;
    private String name;
    private CategoryEnum category;
    private boolean isAvailable;

    public Movie() {
        isAvailable = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!this.name.equals(name))
            this.name = name;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        if (this.category != category)
            this.category = category;
    }

    @JsonProperty("isAvailable")
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        if (this.isAvailable != isAvailable)
            this.isAvailable = isAvailable;
    }
}
