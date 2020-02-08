package com.imooc.factory;

public class SupserFactory extends  AbstractFactory {
    @Override
    public ICar createCar() {
        return new SuperCar();
    }

    @Override
    public IBus createBus() {
        return new SuperBus();
    }
}
