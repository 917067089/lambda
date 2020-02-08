package com.imooc.factory;

public class DnFactory extends AbstractFactory3 {
    @Override
    public ICar createCar() {
        return new DnCar();
    }

}
