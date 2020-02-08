package com.imooc.handler.one;

/**
 * 生成责任链前后顺序关系类
 * 从createaChain()方法可以看出，责任链首节点是组对象，后续节点是主任对象，主任对象的后续节点是经理对象。handler()方法负责把请求的reeqeust 对象req 放入责任链首节点中并开始运行。
 */
public class MyChain {
    private Handler one = new ZuZhang();
    private Handler two = new ZhuRen();
    private Handler throee = new JingLi();

    public void createChain(){
        one.setNext(two);//生成责任链前后顺序关系类
        two.setNext(throee);
    }
    public void hadler(Request request){
        one.hadler(request);
    }
}
