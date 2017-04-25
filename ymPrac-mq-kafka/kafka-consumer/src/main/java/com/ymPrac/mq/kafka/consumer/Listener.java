package com.ymPrac.mq.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {

    /**
     * 监听kafka消息,如果有消息则消费,同步数据到新烽火的库
     * @param record 消息实体bean
     */
    @KafkaListener(topics = "linuxsogood-topic", group = "sync-group")
    public void listen(ConsumerRecord<?, ?> record) {

    }

    /**
     * 消息是店铺类型,店铺消息处理入库
     */
    private void proceedStore() {

    }

}