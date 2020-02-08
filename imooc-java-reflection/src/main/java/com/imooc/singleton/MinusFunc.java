package com.imooc.singleton;

public class MinusFunc implements IFunc {
    public MinusFunc() {
    }
    private static class My{
        private static final MinusFunc single = new MinusFunc();
    }
    public static MinusFunc getInstance(){
        return My.single;
    }
    @Override
    public int service(int one, int two) {
        return one - two;
    }
}
