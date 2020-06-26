#!/bin/bash



#	if [ "$who"x == ""x ] || [ "$del"x == ""x ] ; then
#		echo "Sorry, you must input who and del..."
#	elif [ "$del"x == "yes"x ] || [ "$del"x == "no"x ] || [ "$del"x == "y"x ] || [ "$del"x == "n"x ] ; then
#		if [ "$del"x == "yes"x ] || [ "$del"x == "y"x ] ; then
#			echo "Running [${who}] starting, is del [yes]..."
#		else
#			echo "Running [${who}] starting, is del [no]..."
#		fi	
#	else
#		echo "Sorry, del Failed [${del}]..."
#	fi

# color:echo  "\033[40;31m ME \033[0m"


# who : image name [all | imageName]
# del : isn't del image by name [y | n | yes | no]
who=$1
del=$2
dockerfilepath=$3

# base image : centos
images[0]="yi/centos7-ssh"
paths[0]="../src/centos7/"

images[1]="yi/centos7-jdk8u151"
paths[1]="../src/jdk8u151/"

images[2]="yi/centos7-redis"
paths[2]="../src/redis4.0.2/"


images[3]="yi/centos7-ssh-tengine-local"
paths[3]="../src/Nginx-Tengine-2.2.1/local.com/"

images[4]="yi/centos7-ssh-tengine"
paths[4]="../src/Nginx-Tengine-2.2.1/"

images[5]="yi/centos7-mysql5.6.38"
paths[5]="../src/mysql5.6/"

images[6]="yi/centos7-zookeeper3.4.11"
paths[6]="../src/zookeeper3.4.11/"

images[7]="yi/centos7-activemq5.15.2"
paths[7]="../src/activeMQ5.15.2/"

images[8]="yi/centos7-confluence"
paths[8]="../src/Confluence6.3.1/"

images[9]="yi/centos7-jira"
paths[9]="../src/JIRA7.3.8/"

images[10]="yi/centos7-mycat1.6"
paths[10]="../src/mycat1.6/"

images[11]="yi/centos7-tomcat7"
paths[11]="../src/tomcat7/"

images[12]="yi/centos7-dubboadmin284"
paths[12]="../src/dubboadmin284/"

images[13]="yi/centos7-jenkins"
paths[13]="../src/jenkins2.73.3/"

images[17]="yi/centos7-kong"
paths[17]="../src/kong0.11.2.el7.noarch/"

images[15]="yi/centos7-postgresql9.6"
paths[15]="../src/postgresql9.6/"

images[16]="yi/centos7-nodejs"
paths[16]="../src/nodejs/"

images[14]="yi/centos7-eureka"
paths[14]="../src/eureka/"

images[15]="yi/centos7-konga"
paths[15]="../src/konga/"

images[16]="yi/centos7-nexus"
paths[16]="../src/nexus2.11.2-03/"




if [ "$who"x == ""x ] || [ "$del"x == ""x ] ; then
	echo "Sorry, you must input who and del..."
else
	# all
	if [ "$who"x == "all"x ]; then
		if [ "$del"x == "yes"x ] || [ "$del"x == "no"x ] || [ "$del"x == "y"x ] || [ "$del"x == "n"x ] ; then
			echo "images size: [\033[40;35;1m ${#images[*]} \033[0m]"
			for index in "${!images[@]}"; do
				echo "[\033[40;35;1m ${img} \033[0m]"
				if [ "$del"x == "yes"x ] || [ "$del"x == "y"x ] ; then
					echo "[\033[40;32;1m ${index} \033[0m] Running [\033[40;32;1m ${images[index]} \033[0m] starting, path is [\033[40;32;1m ${paths[index]} \033[0m],is del [\033[40;35;1m yes \033[0m]..."
					echo "(1)docker rmi ${images[index]}"
					docker rmi ${images[index]}
					echo "(2)docker build -t '${images[index]}' ${paths[index]}"
					docker build -t "${images[index]}" ${paths[index]}
				else
					echo "[\033[40;32;1m ${index} \033[0m] Running [\033[40;32;1m ${images[index]} \033[0m] starting, path is [\033[40;32;1m ${paths[index]} \033[0m],is del [\033[40;35;1m no \033[0m]..."
					echo "(1)docker build -t '${images[index]}' ${paths[index]}"
					docker build -t "${images[index]}" ${paths[index]}
				fi
			done

		else
			echo "Sorry, del Failed [${del}]..."
		fi
	else
		if  [ "$dockerfilepath"x == ""x ] ; then
			echo "Sorry, dockerfilepath is none [${dockerfilepath}]..."
			else
				if [ "$del"x == "yes"x ] || [ "$del"x == "no"x ] || [ "$del"x == "y"x ] || [ "$del"x == "n"x ] ; then
				if [ "$del"x == "yes"x ] || [ "$del"x == "y"x ] ; then
					echo "Running [\033[40;35;1m ${who} \033[0m] starting, is del [\033[40;35;1m yes \033[0m]..."
					docker rmi ${del}
					docker build -t "${who}" $dockerfilepath
				else
					echo "Running [\033[40;35;1m ${who} \033[0m] starting, is del [\033[40;35;1m no \033[0m]"
					docker build -t "${who}" $dockerfilepath
				fi	
			else
				echo "Sorry, del Failed [${del}]..."
			fi
		fi	
	fi
fi





