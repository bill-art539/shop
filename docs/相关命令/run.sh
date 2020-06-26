#!/bin/bash

who=$1

bridgename="env10"
bridgeip="192.168.10.0/24"

containers[0]="env10_2_Nginx01"
containers[1]="env10_3_Redis01"
containers[2]="env10_4_Mysql01"
containers[3]="env10_5_Zookeeper01"
containers[4]="env10_6_Mq01"
containers[5]="env10_7_Mycat01"
containers[6]="env10_201_confluence"
containers[7]="env10_202_jira"
containers[8]="env10_203_dubboadmin"
containers[9]="env10_204_jenkins"
containers[10]="env10_8_Kong01"
containers[11]="env10_9_postgresql01"
containers[12]="env10_100_nodejs01"
containers[13]="env10_205_eureka"
containers[14]="env10_206_konga"
containers[15]="env10_207_nexus"

containers[16]="rpc_goods_provider"
containers[17]="rpc_user_provider"
containers[18]="rpc_order_provider"
containers[19]="rpc_idworker_provider"
containers[20]="rpc_redis_provider"
containers[21]="rpc_mq_provider"
containers[22]="rpc_ali_pay_provider"

containers[23]="rpc_goods_consumer"
containers[24]="rpc_order_consumer"
containers[25]="rpc_ali_pay_consumer"
containers[26]="rpc_user_consumer"

containers[27]="rpc_shop_pre"



if [[ "$who"x == "nginx"x ]]; then
	docker stop ${containers[0]}
	docker rm ${containers[0]}
	docker run -d -p 80:80 --net=${bridgename} --ip=192.168.10.2 --restart=always --name ${containers[0]} yi/centos7-ssh-tengine-local
elif [[ "$who"x == "redis"x ]]; then
	docker stop ${containers[1]}
	docker rm ${containers[1]}
	docker run -d -p 6379:6379 --net=${bridgename} --ip=192.168.10.3 --restart=always --name ${containers[1]} yi/centos7-redis
elif [[ "$who"x == "mysql"x ]]; then
	docker stop ${containers[2]}
	docker rm ${containers[2]}
	docker run -d -p 3306:3306 --net=${bridgename} --ip=192.168.10.4 --restart=always --name ${containers[2]} yi/centos7-mysql5.6.38
elif [[ "$who"x == "zookeeper"x ]]; then
	docker stop ${containers[3]}
	docker rm ${containers[3]}
	docker run -d -p 2181:2181 --net=${bridgename} --ip=192.168.10.5 --restart=always --name ${containers[3]} yi/centos7-zookeeper3.4.11
elif [[ "$who"x == "mq"x ]]; then
	docker stop ${containers[4]}
	docker rm ${containers[4]}
	docker run -d -p 61616:61616 -p 8161:8161  --net=${bridgename} --ip=192.168.10.6 --restart=always --name ${containers[4]} yi/centos7-activemq5.15.2
elif [[ "$who"x == "mycat"x ]]; then
	docker stop ${containers[5]}
	docker rm ${containers[5]}
	docker run -d --net=${bridgename} --ip=192.168.10.7 --restart=always --name ${containers[5]} yi/centos7-mycat1.6
elif [[ "$who"x == "confluence"x ]]; then
	docker stop ${containers[6]}
	docker rm ${containers[6]}
	docker run -d --net=${bridgename} --ip=192.168.10.201 --restart=always --name ${containers[6]} yi/centos7-confluence
elif [[ "$who"x == "jira"x ]]; then
	docker stop ${containers[7]}
	docker rm ${containers[7]}
	docker run -d --net=${bridgename} --ip=192.168.10.202 --restart=always --name ${containers[7]} yi/centos7-jira
elif [[ "$who"x == "dubboadmin"x ]]; then
	docker stop ${containers[8]}
	docker rm ${containers[8]}
	docker run -d --net=${bridgename} --ip=192.168.10.203 --restart=always --name ${containers[8]} yi/centos7-dubboadmin284
elif [[ "$who"x == "jenkins"x ]]; then
	docker stop ${containers[9]}
	docker rm ${containers[9]}
	docker run -d --net=${bridgename} --ip=192.168.10.204 --restart=always --name ${containers[9]} yi/centos7-jenkins
elif [[ "$who"x == "kong"x ]]; then
	docker stop ${containers[10]}
	docker rm ${containers[10]}
	docker run -d -p 8001:22 --net=${bridgename} --ip=192.168.10.8 --restart=always --name ${containers[10]} yi/centos7-kong
elif [[ "$who"x == "postgresql"x ]] ; then
	docker stop ${containers[11]}
	docker rm ${containers[11]}
	docker run -d -p 5432:5432 --net=${bridgename} --ip=192.168.10.9 --privileged=true --name ${containers[11]} --restart=always yi/centos7-postgresql9.6 /usr/sbin/init
elif [[ "$who"x == "nodejs"x ]]; then
	docker stop ${containers[12]}
	docker rm ${containers[12]}
	docker run -d --net=${bridgename} --ip=192.168.10.100 --restart=always --name ${containers[12]} yi/centos7-nodejs
elif [[ "$who"x == "geteureka"x ]]; then
	docker stop ${containers[13]}
	docker rm ${containers[13]}
	docker run -d --net=${bridgename} --ip=192.168.10.205 --restart=always --name ${containers[13]} yi/centos7-eureka
elif [[ "$who"x == "konga"x ]]; then
	docker stop ${containers[14]}
	docker rm ${containers[14]}
	docker run -d --net=${bridgename} --ip=192.168.10.206 --name ${containers[14]} --restart=always -e "NODE_ENV=prodection" yi/centos7-konga
elif [[ "$who"x == "nexus"x ]]; then
	docker stop ${containers[15]}
	docker rm ${containers[15]}
	docker run -d -p 8081:8081 --net=${bridgename} --ip=192.168.10.207 --name ${containers[15]} --restart=always yi/centos7-nexus
elif [[ "$who"x == "goods_provider"x ]]; then
	docker stop ${containers[16]}
	docker rm ${containers[16]}
	docker run  -d -p 8093:8093 -p 20803:20803 --net=${bridgename} --ip=192.168.10.101 --name ${containers[16]} --restart=always yi/centos7-jdk8u151
elif [[ "$who"x == "user_provider"x ]]; then
	docker stop ${containers[17]}
	docker rm ${containers[17]}
	docker run -d -p 8092:8092 -p  20802:20802 --net=${bridgename} --ip=192.168.10.102 --name ${containers[17]} --restart=always yi/centos7-jdk8u151
elif [[ "$who"x == "order_provider"x ]]; then
	docker stop ${containers[18]}
	docker rm ${containers[18]]}
	docker run -d -p 8094:8094 -p  20804:20804  --net=${bridgename} --ip=192.168.10.103 --name ${containers[18]} --restart=always yi/centos7-jdk8u151
elif [[ "$who"x == "idworker_provider"x ]]; then
	docker stop ${containers[19]}
	docker rm ${containers[19]]}
	docker run -d -p 8091:8091 -p  20801:20801 --net=${bridgename} --ip=192.168.10.104 --name ${containers[19]} --restart=always yi/centos7-jdk8u151
elif [[ "$who"x == "redis_provider"x ]]; then
	docker stop ${containers[20]}
	docker rm ${containers[20]]}
	docker run -d -p 8096:8096 -p  20806:20806 --net=${bridgename} --ip=192.168.10.105 --name ${containers[20]} --restart=always yi/centos7-jdk8u151
elif [[ "$who"x == "mq_provider"x ]]; then
	docker stop ${containers[21]}
	docker rm ${containers[21]]}
	docker run -d -p 8095:8095 -p  20805:20805 --net=${bridgename} --ip=192.168.10.106 --name ${containers[21]} --restart=always yi/centos7-jdk8u151
elif [[ "$who"x == "ali_pay_provider"x ]]; then
    docker stop ${containers[22]}
    docker rm ${containers[22]]}
    docker run -d -p 8097:8097 -p  20808:20808 --net=${bridgename} --ip=192.168.10.107 --name ${containers[22]} --restart=always yi/centos7-jdk8u151

elif [[ "$who"x == "goods_consumer"x ]]; then
    docker stop ${containers[23]}
    docker rm ${containers[23]]}
    docker run -d -p 8083:8083 --net=${bridgename} --ip=192.168.10.108 --name ${containers[23]} --restart=always yi/centos7-jdk8u151
elif [[ "$who"x == "order_consumer"x ]]; then
    docker stop ${containers[24]}
    docker rm ${containers[24]]}
    docker run -d -p 8084:8084 --net=${bridgename} --ip=192.168.10.109 --name ${containers[24]} --restart=always yi/centos7-jdk8u151
elif [[ "$who"x == "ali_pay_consumer"x ]]; then
    docker stop ${containers[25]}
    docker rm ${containers[25]]}
    docker run -d -p 8087:8087 --net=${bridgename} --ip=192.168.10.113 --name ${containers[25]} --restart=always yi/centos7-jdk8u151
elif [[ "$who"x == "user_consumer"x ]]; then
    docker stop ${containers[26]}
    docker rm ${containers[26]]}
    docker run -d -p 8082:8082 --net=${bridgename} --ip=192.168.10.111 --name ${containers[26]} --restart=always yi/centos7-jdk8u151
elif [[ "$who"x == "shop_pre"x ]]; then
    docker stop ${containers[27]}
    docker rm ${containers[27]]}
    docker run -d -p 8888:8888 --net=${bridgename} --ip=192.168.10.112 --name ${containers[27]} --restart=always yi/centos7-jdk8u151
else
	echo "Sorry,no any service."
fi

