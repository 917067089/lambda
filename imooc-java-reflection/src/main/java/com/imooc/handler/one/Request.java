package com.imooc.handler.one;

/**
 * 利用责任链模式编制6.1 员工请假审批功能
 */
public class Request {
    int day;//请假天数

    public Request(int day) {
        this.day = day;
    }
}
