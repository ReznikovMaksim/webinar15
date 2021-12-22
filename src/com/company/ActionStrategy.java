package com.company;

import java.util.Random;

public interface ActionStrategy {
    void doAction(Cart cart);

    static void worse(Cart cart){
        int index = new Random().nextInt(cart.getGoods().size());
        cart.getGoods().get(index).changeState();
        System.out.println("состояние товара - " + cart.getGoods().get(index).getState().getDescription());
    }
}
