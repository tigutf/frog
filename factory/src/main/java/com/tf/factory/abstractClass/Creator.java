package com.tf.factory.abstractClass;

/**
 * @Author TF
 * @Date 2019/2/19 0:59
 * @Desc 抽象工厂类---参考设计模式之禅
 */
public abstract class Creator {

    /**
     * 创建一个产品对象，其输入参数类型可以自行设置
     * 通常为String、Enum、Class等，当然也可以为空
     * */
    public abstract <T extends Product> T createProduct(Class<T> c);
}
