package com.tf.singleton;

/**
 * @Author TF
 * @Date 2019/2/18 1:02
 * @Desc 懒汉式的单例模式-使用到的时候才创建对象
 */
public class SingletonLazy {
    private static SingletonLazy singleton = null;//对象未定义为final，需要考虑并发多线程问题
    //将构造函数私有化，限制产生多个对象
    private SingletonLazy(){}
    //通过该方法获得实例对象,用synchronized修饰保证同步
    public synchronized static SingletonLazy getSingletonA(){
        if(singleton == null){
            singleton = new SingletonLazy();
        }
        return singleton;
    }
    //同步代码块实现
    public static SingletonLazy getSingletonB(){
        if(singleton == null){
            synchronized (SingletonLazy.class){
                if (singleton == null){//避免多线程下，获取到锁进入同步块时对象已被创建，所以多加一层判空
                    singleton = new SingletonLazy();
                }
            }
        }
        return singleton;
    }
    //类中其他方法，尽量是static
    public static void doSomething(){ }
}
