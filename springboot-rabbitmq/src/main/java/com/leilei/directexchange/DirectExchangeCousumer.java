package com.leilei.directexchange;

import com.leilei.common.Vehicle;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lei
 * @version 1.0
 * @date 2020/7/14 22:49
 * @desc 路由模式消费者 我这里rabbit_direct_queue_one 使用两个消费者接受消息
 * rabbit_direct_queue_two 使用一个消费者接收消息
 */
@Component
public class DirectExchangeCousumer {
    @RabbitListener(queues = "rabbit_direct_queue_one")
    public void consumerOne(Vehicle vehicle) {
        System.out.println("rabbit_direct_queue_one队列 消费者1：收到消息---" + vehicle);
    }
    @RabbitListener(queues = "rabbit_direct_queue_one")
    public void consumerTwo(Vehicle vehicle) {
        System.out.println("rabbit_direct_queue_one队列 消费者2：收到消息---" + vehicle);
    }
    @RabbitListener(queues = "rabbit_direct_queue_two")
    public void consumerDirect(Vehicle vehicle) {
        System.out.println("rabbit_direct_queue_two队列 ：收到消息---" + vehicle);
    }
}
