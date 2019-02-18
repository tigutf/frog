package com.tf.factory.concrete;

import com.tf.factory.abstractClass.Product;

/**
 * @Author TF
 * @Date 2019/2/19 0:57
 * @Desc TODO
 */
public class ConcreteProduct1 extends Product {
    @Override
    public void methodA() {
        super.methodA();
    }

    @Override
    public void methodB() {
        System.out.println("this is ConcreteProduct1");
    }
}
