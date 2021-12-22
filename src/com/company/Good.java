package com.company;

public class Good {
    private Goods name;
    private double price;
    private double weight;
    private GoodsState state;

    public Good(Goods name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        state = GoodsState.GOOD;
    }
    public double sell(){
        switch (state){
            case GOOD:
                return price * 2;
            case NORMAL:
                return price * 1.5;
            case BAD:
                return price * 0.5;
        }
        return 0;
    }
    public void changeState(){
        switch (state){
            case GOOD:
                state = GoodsState.NORMAL;
                break;
            case NORMAL:
                state = GoodsState.BAD;
                break;
            case BAD:
                System.out.println("состояние и так уже хуже некуда, этот товар трудно испортить");
                break;
        }
    }
    public Goods getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public GoodsState getState() {
        return state;
    }
}
