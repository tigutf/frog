package com.tf.strategy.rule.controller;

import com.tf.strategy.rule.TypeEnum;
import com.tf.strategy.rule.dao.FieldConfigRuleRepository;
import com.tf.strategy.rule.domain.FieldConfigRule;
import com.tf.strategy.rule.strategy.ProcessFactory;
import com.tf.strategy.rule.strategy.ProcessStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/test")
public class HelloWorldController {
    @Autowired
    private FieldConfigRuleRepository fieldConfigRuleRepository;

    @RequestMapping("/helloConfig")
    public String resetPsw(String configKey){
        Map<String,Object> result = new HashMap<>();
        FieldConfigRule rule = fieldConfigRuleRepository.findByFieldKey(configKey);
        String className = TypeEnum.getValue(rule.getFieldKey());
        ProcessStrategy ps = ProcessFactory.getInstance(className);
        List params = Arrays.asList(rule.getParams().split(","));
        ps.operate(result, params, rule.getFieldKey());
        System.out.println(result.get(rule.getFieldKey()));
        return String.valueOf(result.get(rule.getFieldKey()));
    }
}
