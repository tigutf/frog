package com.tf.factory.abstractClass;

/**
 * @Author TF
 * @Date 2019/2/19 0:52
 * @Desc 在工厂方法模式中，抽象产品类Product负责定义产品的共性，实现对事物最抽象的定义，工厂所要生产的对象
 */
public abstract class Product {
    //产品类的公共方法
    public void methodA(){
        // 业务逻辑处理 doSomething()
    }
    //抽象方法
    public abstract void methodB();
}