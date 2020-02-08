package com.imooc.factory;

import java.io.IOException;

/**
 * 定义文件产品
 * 定义文件接口：
 */
public interface IRead<T> {
     T read(String ... in) throws IOException;
}
