#!/bin/bash
##启动消费者
docker exec -d rpc_ali_pay_consumer nohup java -jar  /usr/local/shop-ali-pay-consumer-1.0-SNAPSHOT.jar
docker exec -d rpc_user_consumer nohup java -jar  /usr/local/shop-user-consumer-1.0-SNAPSHOT.jar
docker exec -d rpc_order_consumer nohup java -jar  /usr/local/shop-order-consumer-1.0-SNAPSHOT.jar
docker exec -d rpc_goods_consumer nohup java -jar  /usr/local/shop-goods-consumer-1.0-SNAPSHOT.jar
docker exec -d rpc_shop_pre nohup java -jar  /usr/local/shop-pre-1.0-SNAPSHOT.jar
