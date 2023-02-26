package example.enums;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Function;

public enum TableEnum {
    A ("A", (str)->{
        System.out.println("TableEnum.A start to access method...");
        return "Hello, " + str ;
    }),
    B("B", (str)->{
        System.out.println("TableEnum.B 开始进入方法B...");
        return "Hello, " + str ;
    })
    ;

    private String tableName;
    private Function<String, String> logic;

    private TableEnum(String name, Function func){
        this.tableName = name;
        this.logic = func;
    }

    public String getTableName(){
        return this.tableName;
    }

    public static TableEnum get(String tableName){
        try{
            TableEnum en = Arrays.stream(org.example.enums.TableEnum.values()).filter(val->{
                if(val.getTableName().equals(tableName)) return true;
                else return false;
            }).findFirst().get();
            return en;
        }catch (NoSuchElementException e){
            System.out.println(tableName + "该类型不在TableEnum枚举范围内");
            return null;
        }
    }

    public String invoke(String param){
        return logic.apply(param);
    }


    public static void main(String[] args) {
        TableEnum nn = get("X");
        if (nn == null)
        System.out.println("空的");
        else
        System.out.println(nn);
    }

}
