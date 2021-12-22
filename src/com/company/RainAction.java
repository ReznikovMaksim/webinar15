package com.company;

import java.util.Random;

public class RainAction implements ActionStrategy{
    @Override
    public void doAction(Cart cart) {
        System.out.println("сегодня дождь!");
        if(cart.getLig() >= 2) cart.setLig(cart.getLig() - 2);
        if(cart.getLig() < 2) cart.setLig(0);
        if(new Random().nextInt(3) == 2){
            System.out.println("о нет, дождь намочил товар!");
            ActionStrategy.worse(cart);
        }
    }
}
