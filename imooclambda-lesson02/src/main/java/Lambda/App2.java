package Lambda;

public class App2 {
    String s1 ="全局变量";
    //1.匿名内部类型中对于变量的访问。
    public void testInnerClass(){
        String s2="局部变量";
        new Thread(new Runnable() {
            String s3 ="内部变量";
            @Override
            public void run() {
                //访问全局变量
//                this.s1  this 关键字-表示当前内部类型对象。 this 一般是指的当前类的对象
                System.out.println(s1);

                //访问局部变量
                System.out.println(s2);//局部变量的访问-不能对局部变量进行数据的修改 [final]
//                s2="hello";

                //访问内部变量
                System.out.println(s3);
                System.out.println(this.s3);
            }
        }).start();
    }
    //2.lambda 表达式变量赋值
    public void testLambda(){
        String s2="局部变量Lambda";
        new Thread(() -> {
            String s3 = "内部变量Lambda";
            //访问全局变量
            System.out.println(this.s1);// 在使用lambda 式事 ，this指最外层的类 即 关键字 ，表示是所属方法所在类型的对象
            //局部变量
            System.out.println(s2);
//            s2="22"; 不能进行修改，默认变量修饰符是final
            System.out.println(s3);
            s3=s3+"内部变量可以修改";//里面的变量可以进行修改
            System.out.println(s3);
        }).start();
    }
    public static void main (String[] args){
        App2 app2 =new App2();
        app2.testInnerClass();
        app2.testLambda();
    }
}
