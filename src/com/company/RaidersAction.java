package com.company;

public class RaidersAction implements ActionStrategy{
    @Override
    public void doAction(Cart cart) {
        if(cart.getMoney() >= 10){
            System.out.println("заплатили разбойникам деньгами");
            cart.setMoney(cart.getMoney()-10);
            return;
        }
        System.out.println("заплатили разбойникам товаром");
        Good g = null;
        for(int i = 0; i < cart.getGoods().size(); i++){
            if(cart.getGoods().get(i).getState().equals(GoodsState.GOOD)){
                g = cart.getGoods().get(i);
            }
        }
        cart.getGoods().remove(g);
    }
}
