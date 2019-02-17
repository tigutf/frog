package com.tf.strategy.rule.strategy;

import java.util.List;
import java.util.Map;

public interface ProcessStrategy<T> {
    /**
     * @param result 结果集
     * @param params 参数集
     * @param key 结果集映射key
     * */
    void operate(Map result, List<T> params, String key);
}
