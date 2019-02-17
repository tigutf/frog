package com.tf.strategy.rule.strategy.impl;

import com.tf.strategy.rule.strategy.ProcessStrategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AtestProcess implements ProcessStrategy<String> {
    @Override
    public void operate(Map result, List<String> params, String key) {
        if (params.isEmpty() || params.size()<=0){
            //TODO 打印日志告知入参为空
            return ;
        }
        String str = onHandler(params);
        System.out.println(str);
        result.put(key,str);
    }

    private String onHandler(List<String> params){
        List tmp = params.stream().distinct().sorted().collect(Collectors.toList());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < tmp.size(); i++) {
            sb.append(tmp.get(i));
        }
        return sb.toString();
    }
}
