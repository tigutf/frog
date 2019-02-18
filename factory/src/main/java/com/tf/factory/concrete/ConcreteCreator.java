package com.tf.factory.concrete;

import com.tf.factory.abstractClass.Creator;
import com.tf.factory.abstractClass.Product;

/**
 * @Author TF
 * @Date 2019/2/19 1:12
 * @Desc 具体的工厂类
 */
public class ConcreteCreator extends Creator {
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product=null;
        try {
            product = (Product)Class.forName(c.getName()).newInstance();
        }catch (Exception e) {
            //异常处理
        }
        return (T)product;
    }
}
