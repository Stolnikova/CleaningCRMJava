package com.example.cleaningcrmjava.enums;

public enum OrderStatus {
    PLANNED("Заплановано"),
    COMPLETED("Виконано"),
    CANCELLED("Відмінено");

    private final String ukrainianName;

     OrderStatus(String ukrainianName) {
        this.ukrainianName = ukrainianName;
    }

    public String toUkrainianString() {
        return ukrainianName;
    }
}
