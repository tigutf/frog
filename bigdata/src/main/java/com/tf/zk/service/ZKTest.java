package com.tf.zk.service;


import org.apache.zookeeper.ZooKeeper;
import java.util.Map;
/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 日期： 2021年04月09日 下午11:39:10
 *
 * 编程思维训练
 * 1、级联查看某节点下所有节点及节点值
 * 2、删除一个节点，不管有有没有任何子节点
 * 3、级联创建任意节点
 * 4、清空子节点
 *
 * 注意事项：
 * 1、关于方法名和参数列表，大家可以自行决定是否要修改。
 * 2、请大家编写自己姓名的实现类，比如 ZKHomeWork_Zhangsan，实现 ZKHomeWork 接口，实现这四个方法。
 * 3、请大家写一个测试类，可以运行看效果的那种测试类
 */
public interface ZKTest {
    /**
     * 级联查看某节点下所有节点及节点值
     */
    public Map<String, String> getChildNodeAndValue(String path, ZooKeeper zk) throws Exception;
    /**
     * 删除一个节点，不管有有没有任何子节点
     */
    public boolean rmr(String path, ZooKeeper zk) throws Exception;
    /**
     * 级联创建任意节点
     * /a/b/c/d/e
     */
    public boolean createZNode(String znodePath, String data, ZooKeeper zk) throws Exception;
    /**
     * 清空子节点
     */
    public boolean clearChildNode(String znodePath, ZooKeeper zk) throws Exception;
}
