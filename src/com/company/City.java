package com.company;

import java.util.Random;

public class City {
    private String name;
    private int distance;

    public City(String name) {
        this.name = name;
        distance = new Random().nextInt(51)+50;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
