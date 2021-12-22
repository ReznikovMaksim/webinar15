package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

public class Cart {
    private double weight;
    private double money;
    private List<Good> goods;
    private int lig;
    private int coveredDistance;
    private City cityOfDestanation;
    private ActionStrategy strategy;

    public Cart() {
        weight = 500;
        money = 500;
        goods = new ArrayList<>();
        fillGoods();
        fillCity();
    }
    private void fillCity(){
        List<City> cities = new ArrayList<>(
                List.of(
                        new City("Москва"),
                        new City("Бишкек"),
                        new City("Ош")
                )
        );
        cityOfDestanation = cities.get(new Random().nextInt(3));
    }
    public void fillGoods(){
        List<Good> allTypesOfGoods = new ArrayList<>(
                List.of(new Good(Goods.MEAT,30,20),
                        new Good(Goods.CORN, 20, 15),
                        new Good(Goods.SUGAR, 15, 30)
                        )
        );
        while (true){
            Good g = allTypesOfGoods.get(new Random().nextInt(3));
            Pred p = (d1, d2) -> d1 - d2 <= 0;
            if(p.test(weight, g.getWeight())){
                System.out.println("телега заполнена, место закончилось");
                return;
            }
            if(p.test(money,g.getPrice())){
                System.out.println("закончлись денги");
                return;
            }
            goods.add(g);
            weight -= g.getWeight();
            money -= g.getPrice();
            String f = "купил продукт %s за %s, он весит %s.\nВ телеге осталось %s места, %s денег";
            System.out.printf(f+"\n",g.getName().getName(),g.getPrice(),g.getWeight(),weight,money);
        }
    }
    public void sellAllGoods(){
        String f = "продан товар %s за %s";
        for(int i = 0; i < goods.size(); i++){
            System.out.println(String.format(f,goods.get(i).getName().getName(),goods.get(i).sell()));
            money += goods.get(i).sell();
        }
        goods = new ArrayList<>();
        System.out.println("итого денег - " + money);
    }
    public void getRandomAction(){
        Random r = new Random();
        ActionStrategy a1 = (c) -> System.out.println("обычный день, ничего не произошло");
        ActionStrategy a2 = (c) -> {
            System.out.println("Ровная дорога");
            if(c.getLig() >= 4){ c.setLig(5);}
            else{c.setLig(c.getLig()+2);}
        };
        ActionStrategy a3 = (c) -> {System.out.println("сломалось колесо"); c.setLig(0);};
        ActionStrategy a4 = (c) -> {System.out.println("Река"); c.setLig(0);};
        ActionStrategy a5 = (c) -> {
            System.out.println("Встретил местного"); c.setLig(c.getLig()+r.nextInt(4)+3);
        };
        List<ActionStrategy> actions = new ArrayList<>(
                List.of(
                        new RainAction(),
                        a1, a2, a3, a4, a5,
                        new RaidersAction(),
                        ActionStrategy::worse,
                        new TavernAction()
                )
        );
        strategy = actions.get(r.nextInt(actions.size()));
        doAction();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void doAction(){
        strategy.doAction(this);
    }
    public City getCityOfDestanation() {
        return cityOfDestanation;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public void setLig(int lig) {
        this.lig = lig;
    }

    public void setCoveredDistance(int coveredDistance) {
        this.coveredDistance = coveredDistance;
    }

    public double getMoney() {
        return money;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public int getLig() {
        return lig;
    }

    public int getCoveredDistance() {
        return coveredDistance;
    }
}
