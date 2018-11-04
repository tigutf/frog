package com.tf.rule.strategy;

public class ProcessFactory {
    private static ProcessStrategy instance = null;

    public static ProcessStrategy getInstance(String clzName){
        try {
            instance = (ProcessStrategy)Class.forName(clzName).newInstance();
        }catch (Exception e){
            System.out.println("Class not found.check the param 'clzName'. ");
            return  null;
        }
        return instance;
    }
}
