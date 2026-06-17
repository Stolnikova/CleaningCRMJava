package com.example.cleaningcrmjava.enums;

public enum ServiceUnit {
    SQUARE_METERS("кв. м"),
    PIECES("шт."),
    SEATS("місць");

    private final String ukrainianName;

    ServiceUnit(String ukrainianName) {
        this.ukrainianName = ukrainianName;
    }

    public String toUkrainianString() {
        return ukrainianName;
    }
}
