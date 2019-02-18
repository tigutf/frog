package com.tf.singleton;

/**
 * @Author TF
 * @Date 2019/2/18 0:52
 * @Desc 单例模式的通用代码
 */
public class Singleton {
    private static final Singleton singleton = new Singleton();//定义为静态的且为final的常量，则只能被初始化一次
    //将构造函数私有化，限制产生多个对象
    private Singleton(){}
    //通过该方法获得实例对象
    public static Singleton getSingleton(){
        return singleton;
    }
    //类中其他方法，尽量是static
    public static void doSomething(){ }
}
