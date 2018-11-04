package com.tf.rule;

public enum TypeEnum {

    TYPE_ENUM_A("A","com.tf.rule.strategy.impl.AtestProcess"),
    TYPE_ENUM_B("B","com.tf.rule.strategy.impl.BtestProcess");

    private String key ;
    private  String value;

    TypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValue(String key) {
        for (TypeEnum typeEnum : TypeEnum.values()){
            if (typeEnum.key.equalsIgnoreCase(key)){
                return typeEnum.value;
            }
        }
        return null;
    }
}
