package com.company;

public enum GoodsState {
    GOOD("хорошее"),
    NORMAL("среднее"),
    BAD("плохое");

    private String description;

    GoodsState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
