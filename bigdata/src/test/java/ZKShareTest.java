import com.tf.zk.service.impl.ZKTest_Wisdom;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class ZKShareTest {

    private ZooKeeper getZooKeeper() throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 50000000, new Watcher() {

            @Override
            public void process(WatchedEvent event) {
                if (event.getState() == Watcher.Event.KeeperState.SyncConnected) {
                    System.out.println("连接成功");
                    countDownLatch.countDown();
                }
            }

        });
        countDownLatch.await();
        return zooKeeper;
    }


    @Test
    public void getChildNodeAndValueTest() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = getZooKeeper();
        ZKTest_Wisdom tester = new ZKTest_Wisdom();
        Map<String, String> result = tester.getChildNodeAndValue("/bigdata0", zooKeeper);
        for (String key : result.keySet()) {
            System.out.print("#key:" + key + "==>");
            System.out.println("#value:" + result.get(key));
        }
    }
    @Test
    public void createZNodeTest() throws Exception {
        ZKTest_Wisdom tester = new ZKTest_Wisdom();
        ZooKeeper zooKeeper = getZooKeeper();
        boolean result = tester.createZNode("/znode0/znode1/znode2","test createZNode", zooKeeper);
        System.out.println("result:"+result);
        System.out.println(tester.getChildNodeAndValue("/znode0",zooKeeper));
    }


    @Test
    public void rmrZNodeTest() throws Exception {
        ZKTest_Wisdom tester = new ZKTest_Wisdom();
        ZooKeeper zooKeeper = getZooKeeper();
        boolean result = tester.rmr("/znode0", zooKeeper);
        System.out.println("result:"+result);
    }

    @Test
    public void clearChildNodeTest() throws Exception {
        ZKTest_Wisdom tester = new ZKTest_Wisdom();
        ZooKeeper zooKeeper = getZooKeeper();
        boolean result = tester.clearChildNode("/znode0", zooKeeper);
        System.out.println("result:"+result);
        System.out.println(tester.getChildNodeAndValue("/znode0", zooKeeper));
    }

}
