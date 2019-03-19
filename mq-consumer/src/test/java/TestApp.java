/*
import com.hp.xyl.mq.ConsumerApplication;
import com.hp.xyl.mq.service.ConsumerService;
import com.hp.xyl.mq.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

*/
/**
 * Author:xyl
 * Date:2019/3/14 16:26
 * Description:
 *//*

@SpringBootTest(classes = {ConsumerApplication.class})
@RunWith(SpringRunner.class)
public class TestApp {
    @Resource
    private ProducerService producerService;
    @Resource
    private ConsumerService consumerService;

    @Test
    public void testMq() {
        for (int i = 0; i < 10; i++) {
            producerService.sendMessage("queueMsg", "测试队列消息" + i);
            producerService.sendPubMessage("pub_sub", "test pub_sub" + i);
        }
    }
}
*/
