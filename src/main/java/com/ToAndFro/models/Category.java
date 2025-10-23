package com.ToAndFro.models;

public enum Category {
    TRANSPORT("Транспорт"),
    REAL_ESTATE("Нерухомість"),
    ELECTRONICS("Електроніка"),
    HOME_GARDEN("Дім і сад"),
    JOB("Робота"),
    SERVICES("Послуги"),
    FASHION("Мода"),
    ANIMALS("Тварини");

    private final String ukrainianName;

    Category(String ukrainianName) {
        this.ukrainianName = ukrainianName;
    }

    public String getUkrainianName() {
        return ukrainianName;
    }
}
