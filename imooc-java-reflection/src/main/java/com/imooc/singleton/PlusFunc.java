package com.imooc.singleton;

public class PlusFunc implements IFunc {
    private PlusFunc() {
    }
    private static class My{
        private static final PlusFunc single= new PlusFunc();
    }
    public static PlusFunc getInstance(){
        return My.single;
    }
    @Override
    public int service(int one, int two) {
        return one +two;
    }
}
