Test!

6cdca49d4a2fa55c105e13ce0bf950efd6942bb5


docker run -d --name jenkins -u root -p 14639:8080 -p 50000:50000 --privileged=true  -v /var/jenkins_home:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock jenkinsci/blueocean



472d66109d1a48d0b2498f00890747bd



#set Maven environment
export MAVEN_HOME=/usr/local/apache-maven-3.3.9
export PATH=$MAVEN_HOME/bin:$PATH



<mirror>
	<id>alimaven</id>
	<name>aliyun maven</name>
	<url>http://maven.aliyun.com/nexus/content/groups/public/</url>
	<mirrorOf>central</mirrorOf>
</mirror>


/usr/local/apache-maven-3.3.9/conf/settings.xml



#!/bin/bash
result=$(docker ps| grep "springCloudService")
if [[ "$result" != "" ]]
then
echo "================docker stop springCloudService================"
docker stop springCloudService
fi
result1=$(docker ps -a | grep "springCloudService")
if [[ "$result1" != "" ]]
then
echo "================docker rm springCloudService================"
docker rm springCloudService
fi
result2=$(docker images | grep "springCloudService:0.0.1")
if [[ "$result2" != "" ]]
then
echo "================docker rmi springCloudService:0.0.1================"
docker rmi springCloudService:0.0.1
fi








#运行容器
docker run -d --name springCloudService -p 12025:8080 springCloudService:0.0.1
echo '================ 运行容器日志信息 ================'
#打印容器的运行日志
docker logs -f springCloudService

向GitHub提交代码时触发Jenkins自动构建

https://blog.csdn.net/boling_cavalry/article/details/78943061

