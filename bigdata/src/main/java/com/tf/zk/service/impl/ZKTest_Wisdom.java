package com.tf.zk.service.impl;

import com.tf.zk.service.ZKTest;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ZKTest_Wisdom implements ZKTest {

    @Override
    public Map<String, String> getChildNodeAndValue(String path, ZooKeeper zk) throws Exception {
        Map<String, String> result = new ConcurrentHashMap<>();
        getNodesRecursive(path, zk, result);
        return result;
    }

    private void getNodesRecursive(String path, ZooKeeper zk, Map<String, String> result) throws Exception {
        List<String> nodes = zk.getChildren(path, false);
        if (nodes == null || nodes.size() == 0){
            result.put(path, String.valueOf(zk.getData(path, false, new Stat())));
            return ;
        }
        for (String node : nodes) {
            getNodesRecursive(path + "/" + node, zk, result);
        }
        result.put(path, String.valueOf(zk.getData(path, false, new Stat())));
    }



    @Override
    public boolean rmr(String path, ZooKeeper zk) throws InterruptedException{
        List children;
        try {
            children = zk.getChildren(path, false);
        } catch (KeeperException.NoNodeException e) {
            return true;
        }catch (KeeperException e1){
            return false;
        }

        if (children != null) {
            Iterator list = children.iterator();

            while(list.hasNext()) {
                String subPath = (String)list.next();
                if (!this.rmr(path + "/" + subPath, zk)) {
                    return false;
                }
            }
        }
        try{
            zk.delete(path, -1);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    @Override
    public boolean createZNode(String znodePath, String data, ZooKeeper zk) throws Exception {
        if (znodePath == null) {
            System.out.println("path must not be null.");
            return false;
        } else {
            try {
                zk.create(znodePath, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            } catch (KeeperException.NodeExistsException e01) {
                throw e01;
            } catch (KeeperException.NoNodeException e02) {
                String parentDir = znodePath.substring(0, znodePath.lastIndexOf(47));
                createZNode(parentDir,"", zk);
                createZNode(znodePath,data, zk);
            }
            return true;
        }
    }

    @Override
    public boolean clearChildNode(String path, ZooKeeper zk) throws Exception {
        List<String> nodes = zk.getChildren(path, false);
        if (nodes == null || nodes.size() == 0){
            zk.setData(path, null, -1);
            return true;
        }
        for (String node : nodes) {
            clearChildNode(path + "/" + node, zk);
        }
        zk.setData(path, null, -1);
        return true;
    }

}
