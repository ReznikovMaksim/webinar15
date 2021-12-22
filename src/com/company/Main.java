package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    Cart c = new Cart();
        startTravel(c);
    }
    public static void startTravel(Cart c){
        Random r = new Random();
        String f = "пройдено %s. Осталось ехать - %s";
        System.out.println("поехали! Едем в " + c.getCityOfDestanation().getName());
        while (c.getCoveredDistance() < c.getCityOfDestanation().getDistance()){
            System.out.println(
                    String.format(f,c.getCoveredDistance(),
                            c.getCityOfDestanation().getDistance() - c.getCoveredDistance()
                    )
            );
            c.setLig(r.nextInt(5)+1);
            c.getRandomAction();
            c.setCoveredDistance(c.getCoveredDistance()+c.getLig());
            System.out.println("за сегодня прошли " + c.getLig() + " лиг");
        }
        System.out.println("приехали");
        c.sellAllGoods();
    }
}
