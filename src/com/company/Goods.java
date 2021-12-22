package com.company;

public enum Goods {
    MEAT("мясо"),
    SUGAR("сахар"),
    CORN("кукуруза");

    private String name;

    Goods(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
