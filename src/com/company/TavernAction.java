package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TavernAction implements ActionStrategy{
    @Override
    public void doAction(Cart cart) {
        if(cart.getMoney() <= 10){
            System.out.println("нет денег на ночлег");
            return;
        }
        List<Good> goods = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            int index = new Random().nextInt(cart.getGoods().size());
            goods.add(cart.getGoods().get(index));
            cart.setMoney(cart.getMoney() + goods.get(i).sell());
            cart.setWeight(cart.getWeight() + goods.get(i).getWeight());
        }
        cart.getGoods().removeAll(goods);
        cart.fillGoods();
    }
}
