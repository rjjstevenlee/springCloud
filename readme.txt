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

https://www.jianshu.com/p/a9bcd9cbefc8

Jenkins 持续集成 Pipeline 简易入门教程

为什么选择 Jeknkins Pipeline ？
团队目前使用 Jekinks 进行项目 sdk 库的发布，但是如果要修改 Jenkins 项目配置完成对工程编译的配置的时候，学习曲线瞬间变得陡峭。相关同学可能配置过再弄一次又得复习了。再者我们在新建新的工程的时候需要复制相关配置信息，配置相关脚本也是一个相对麻烦的工作。 这时Pipeline入了咱们的法眼，之前已经有了配置 GitLabCI的经验。所以多次讨论考虑后决定使用 Pipeline 进行对原来 Jenkins项目的管理进行升级。

 两种配置风格
 旧的Jenkins项目

 1.创建一个Freestyle

 2.配置它

如果需要多分支管理我们需要装下如下插件
Multi-Branch+Project+Plugin

Pipleline 项目创建与配置
我们点击 jenkins 里面的 new item

配置现有项目支持 Pipeline
添加代码来源，点击Git添加

-DskipTests，不执行测试用例，但编译测试用例类生成相应的class文件至target/test-classes下。
-Dmaven.test.skip=true，不执行测试用例，也不编译测试用例类。
一 使用maven.test.skip，不但跳过单元测试的运行，也跳过测试代码的编译。
mvn package -Dmaven.test.skip=true

修改代码来源配置

taskkill /f /t /im java.exe

#!/usr/bin/env bash

#编译+部署order站点

#需要配置如下参数
# 项目路径, 在Execute Shell中配置项目路径, pwd 就可以获得该项目路径
# export PROJ_PATH=这个jenkins任务在部署机器上的路径

# 输入你的环境上tomcat的全路径
# export TOMCAT_APP_PATH=tomcat在部署机器上的路径

### base 函数
killTomcat()
{
    pid=`ps -ef|grep tomcat|grep java|awk '{print $2}'`
    echo "tomcat Id list :$pid"
    if [ "$pid" = "" ]
    then
      echo "no tomcat pid alive"
    else
      kill -9 $pid
    fi
}
cd $PROJ_PATH/order
mvn clean install

# 停tomcat
killTomcat

# 删除原有工程
rm -rf $TOMCAT_APP_PATH/webapps/ROOT
rm -f $TOMCAT_APP_PATH/webapps/ROOT.war
rm -f $TOMCAT_APP_PATH/webapps/order.war

# 复制新的工程
cp $PROJ_PATH/order/target/order.war $TOMCAT_APP_PATH/webapps/

cd $TOMCAT_APP_PATH/webapps/
mv order.war ROOT.war

# 启动Tomcat
cd $TOMCAT_APP_PATH/
sh bin/startup.sh


https://blog.csdn.net/qq_29519041/article/details/85238270


https://blog.csdn.net/qq_29519041/article/details/85238270

