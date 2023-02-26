package example;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.utils.MultipleParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Preconditions;
import org.example.enums.TableEnum;
import org.example.util.CshopData;

/**
 * 流任务 - 业务逻辑
 *
 * @author tigutf
 *
 * @since 1.0.0
 * */
public class CshopStreamJob {

    public static void main(String[] args) throws Exception {

        // Checking input parameters
        final MultipleParameterTool params = MultipleParameterTool.fromArgs(args);

        // set up the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // make parameters available in the web interface
        env.getConfig().setGlobalJobParameters(params);

        // get input data
        DataStream<String> text = null;
        if (params.has("input")) {
            // union all the inputs from text files
            for (String input : params.getMultiParameterRequired("input")) {
                if (text == null) {
                    text = env.readTextFile(input);
                } else {
                    text = text.union(env.readTextFile(input));
                }
            }
            Preconditions.checkNotNull(text, "Input DataStream should not be null.");
        } else {
            System.out.println("Executing example with default input data set.");
            System.out.println("Use --input to specify file input.");
            // get default test text data
            text = env.fromElements(CshopData.WORDS);
        }

        text.map(new MapFunction<String, String>() {
            public String map(String line) throws Exception {
                JSONObject jsonObject = JSONUtil.parseObj(line);
                String name = jsonObject.getObj("table","").toString();
                System.out.println("Table Name: "+ name);
                TableEnum enumLogic = TableEnum.get(name);
                if (enumLogic != null){
                    return enumLogic.invoke(jsonObject.getObj("referenceNo","").toString());
                }else {
                    System.out.println(jsonObject.getObj("referenceNo","").toString() + "不存在");
                    return "";
                }
            }
        }).print();
        // execute program
        env.execute("Streaming WordCount");
    }

}
