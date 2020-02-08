package com.imooc.method;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1.静态方法引用的使用
 * 类型名称.方法名称 （原先的）-- 类名称::方法名称
 *2.实例方法引用的使用
 * 创建类型对应的一个对象 --》 对象应用::实例方法名称
 */
public class lambdamehtod {
    @Test
    public void test1(){
        //存储Person对象的列表
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("tom","男",16));
        personList.add(new Person("jerry","女",36));
        personList.add(new Person("netter","男",26));
        //实现排序
        //1.匿名内部类  增加排序规则
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println("匿名内部类:"+personList);
        //2.lambda的实现
        Collections.sort(personList,(p1,p2) -> p1.getAge() -p2.getAge());
        System.out.println("lambda的实现："+personList);
        //3.静态方法引用
        Collections.sort(personList,Person::compareByAge);
        System.out.println("静态方法："+personList);
        //4 实例方法引用
        PersonUtil pu = new PersonUtil();
        Collections.sort(personList,pu::compareByName);
        System.out.println("netter".hashCode());
        System.out.println("tom".hashCode());
        System.out.println("jerry".hashCode());
        System.out.println("实例方法："+personList);

        //5 构造方法引用:绑定函数式接口 构造方法来获取当前对象 根据当前接口，获取某个指定对对象的构造接口  Person::new  前面表示这个类，后面表示这个类的构造方法
        IPerson ip = Person::new;
        Person person = ip.initPerson("jerry","男",22);
        System.out.println(ip);
        System.out.println(person);
//        System.out.println(ip2);

    }
}
@Data//get set 方法
    @AllArgsConstructor//所有属性的构造发方法
    @NoArgsConstructor//无惨构造方法
class Person{
    private String name;//姓名
    private String gender;//性别
    private int age;//年龄

    public static int compareByAge(Person p1,Person p2){
        return p1.getAge()-p2.getAge();
    }
}
class PersonUtil{
    //增加一个实例方法
    public int compareByName(Person p1,Person p2){
        return p1.getName().hashCode() - p2.getName().hashCode();
    }
}

interface IPerson{
    //抽象方法：通过指定类型的构造方法初始化对象数据
    Person initPerson(String name,String gender,int age);
}