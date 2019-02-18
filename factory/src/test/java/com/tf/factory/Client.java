package com.tf.factory;

import com.tf.factory.abstractClass.Creator;
import com.tf.factory.abstractClass.Product;
import com.tf.factory.concrete.ConcreteCreator;
import com.tf.factory.concrete.ConcreteProduct1;
import com.tf.factory.concrete.ConcreteProduct2;

/**
 * @Author TF
 * @Date 2019/2/19 1:15
 * @Desc TODO
 */
public class Client {

    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product1 = creator.createProduct(ConcreteProduct1.class);
        Product product2 = creator.createProduct(ConcreteProduct2.class);
        product1.methodB();
        product2.methodB();
        /**
         * do something other...
         * */
    }
}
