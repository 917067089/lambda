package com.imooc.singleton;

import java.io.FileOutputStream;
import java.util.Calendar;

/**
 * 编制日志类。一般来说应用程序都有日志文件，记录一些执行信息，该功能利用单例对象来实现是比较恰当。本实例时最基本功能，包括：记录时间及相关内容字符串，
 *
 * \n               10          换行
 *
 * \r                13            回车CR
 *
 * '\r' 回车，回到当前行的行首，而不会换到下一行，如果接着输出的话，本行以前的内容会被逐一覆盖；
 *
 * '\n' 换行，换到当前位置的下一行，而不会回到行首；
 */
public class FileLogger {
    private String path="D:\\IdeaWorkspace\\lambda\\imooc-java-reflection\\src\\main\\resouce\\log.txt";
    private FileOutputStream out;

    private FileLogger() {
        try {
            out=new FileOutputStream(path,true);
            System.out.println("this is new instance!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void write(String msg){
        try {
            Calendar c = Calendar.getInstance();
            int y = c.get(Calendar.YEAR);
            int m= c.get(Calendar.MONTH);
            int d = c.get(Calendar.DAY_OF_MONTH);
            int hh =c.get(Calendar.HOUR);
            int mm=c.get(Calendar.MINUTE);
            int ss=c.get(Calendar.SECOND);
            String strTime="time:%d-%02d-%02d %02d;%02d;%02d;\r\n";
            strTime = String.format(strTime, y,m,d,hh,mm,ss);
            System.out.println(strTime);
            String strContent="content:\r\n"+msg+"\r\n";
            byte buf[] = strTime.getBytes("gbk");
            out.write(buf);
            buf = strContent.getBytes("gbk");
            out.write(buf);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void close(){
        try{
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static class My{
        static FileLogger log;
        static {
            try{
                log = new FileLogger();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static FileLogger getInstance(){
        return My.log;
    }
}
