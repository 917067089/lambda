package com.imooc.factory;

import org.junit.Test;

import java.io.IOException;

/**
 * 编写读写文件功能
 *  具体功能是：读取文本文件，包括：GBK、UTF-8\UNICODE 编码下的文本文件。要求是全文内容，
 *  读取图像文件包括：BMP\GIF\JPG 文件，要求获得图像宽度、长度、每一点的RGB的三基色信息
 */
public class ReadTest {
    @Test
    public void testtextRead(){
       AbstractReadFactory abstractReadFactory = new TextFactory();
        TextRead textRead = (TextRead) abstractReadFactory.craete();
        String[] str={"D:\\IdeaWorkspace\\lambda\\imooc-java-reflection\\src\\main\\resouce\\log.txt","GBK"};
        String result = textRead.read(str);
        System.out.println("读取文件的内容微"+result);
    }
    @Test
    public void testImageRead() throws IOException {
        AbstractReadFactory abstractReadFactory = new ImageFactory();
        ImageRead imageRead = (ImageRead) abstractReadFactory.craete();
        String[] str={"D:\\IdeaWorkspace\\lambda\\imooc-java-reflection\\src\\main\\resouce\\20200201.png","GBK"};
        ImageInfo imageInfo = imageRead.read(str);
        System.out.println("读取图像"+imageInfo);
    }

    @Test
    public void testImageRead2() throws IOException {
        IRead iRead=  AbstractReadFactory.create("com.imooc.factory.ImageFactory").craete();
        iRead.read("D:\\IdeaWorkspace\\lambda\\imooc-java-reflection\\src\\main\\resouce\\20200201.png");
        System.out.println();

    }

    @Test
    public void testtextRead3() throws IOException {
        ProductFactory<IRead> productFactory = new ProductFactory();
        productFactory.create("com.imooc.factory.ImageFactory").read("D:\\IdeaWorkspace\\lambda\\imooc-java-reflection\\src\\main\\resouce\\20200201.png");
        AbstractReadFactory abstractReadFactory = new TextFactory();
        TextRead textRead = (TextRead) abstractReadFactory.craete();
        String[] str={"D:\\IdeaWorkspace\\lambda\\imooc-java-reflection\\src\\main\\resouce\\log.txt","GBK"};
        String result = textRead.read(str);
        System.out.println("读取文件的内容微"+result);
    }
}
