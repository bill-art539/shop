#!/bin/bash
#执行容器重启
docker cp /jars/shop-goods-provider-1.0-SNAPSHOT.jar rpc_goods_provider:/usr/local/
docker cp /jars/shop-user-provider-1.0-SNAPSHOT.jar  rpc_user_provider:/usr/local/
docker cp /jars/shop-order-provider-1.0-SNAPSHOT.jar rpc_order_provider:/usr/local/
docker cp /jars/shop-ali-pay-provider-1.0-SNAPSHOT.jar rpc_ali_pay_provider:/usr/local/
docker cp /jars/shop-ali-pay-consumer-1.0-SNAPSHOT.jar rpc_ali_pay_consumer:/usr/local/
docker cp /jars/shop-user-consumer-1.0-SNAPSHOT.jar rpc_user_consumer:/usr/local/
docker cp /jars/shop-order-consumer-1.0-SNAPSHOT.jar rpc_order_consumer:/usr/local/
docker cp /jars/shop-goods-consumer-1.0-SNAPSHOT.jar rpc_goods_consumer:/usr/local/
docker cp /jars/shop-pre-1.0-SNAPSHOT.jar rpc_shop_pre:/usr/local
#重启消费者
docker restart rpc_ali_pay_consumer rpc_user_consumer rpc_order_consumer rpc_goods_consumer rpc_shop_pre
#重启提供者
docker restart rpc_user_provider rpc_goods_provider rpc_order_provider rpc_ali_pay_provider
#重启界面
docker exec -d rpc_shop_pre nohup java -jar  /usr/local/shop-pre-1.0-SNAPSHOT.jar > /usr/local/goods_provider.logs

##启动提供者
docker exec -d rpc_goods_provider nohup java -jar  /usr/local/shop-goods-provider-1.0-SNAPSHOT.jar > /usr/local/goods_provider.logs
docker exec -d rpc_user_provider  nohup java -jar  /usr/local/shop-user-provider-1.0-SNAPSHOT.jar
docker exec -d rpc_order_provider nohup java -jar  /usr/local/shop-order-provider-1.0-SNAPSHOT.jar
docker exec -d rpc_ali_pay_provider nohup java -jar  /usr/local/shop-ali-pay-provider-1.0-SNAPSHOT.jar

##启动消费者
docker exec -d rpc_ali_pay_consumer nohup java -jar  /usr/local/shop-ali-pay-consumer-1.0-SNAPSHOT.jar
docker exec -d rpc_user_consumer nohup java -jar  /usr/local/shop-user-consumer-1.0-SNAPSHOT.jar
docker exec -d rpc_order_consumer nohup java -jar  /usr/local/shop-order-consumer-1.0-SNAPSHOT.jar
docker exec -d rpc_goods_consumer nohup java -jar  /usr/local/shop-goods-consumer-1.0-SNAPSHOT.jar

