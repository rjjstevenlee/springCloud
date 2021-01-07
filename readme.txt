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


git command

git push origin master

git add *
git add .
git add --all

git reset HEAD fillname

git checkout -- file

git commit --amend


alias:

git config --global alias.co checkout
git config --global alias.br branch
git config --global alias.ci commit
git config --global alias.st status

git config --global alias.unstage 'reset HEAD --'

git unstage fileA
git reset HEAD --fileA

git config --global alias.last 'log -1 HEAD'


外部命令而非git系统命令：加！号
git config --global alias.visual '!gitk'

create branch

git branch name

git checkout name





标签创建：

git tag

git tag -l "v1.2*"

git tag -a v1.0 -m "my first version"

git show v1.0

git log --pretty=oneline

git tag -a v1.2 9fceb02

git show v1.2




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


YZVR7WDLV8-eyJsaWNlbnNlSWQiOiJZWlZSN1dETFY4IiwibGljZW5zZWVOYW1lIjoiamV0YnJhaW5zIGpzIiwiYXNzaWduZWVOYW1lIjoiIiwiYXNzaWduZWVFbWFpbCI6IiIsImxpY2Vuc2VSZXN0cmljdGlvbiI6IkZvciBlZHVjYXRpb25hbCB1c2Ugb25seSIsImNoZWNrQ29uY3VycmVudFVzZSI6ZmFsc2UsInByb2R1Y3RzIjpbeyJjb2RlIjoiSUkiLCJwYWlkVXBUbyI6IjIwMTktMTEtMjYifSx7ImNvZGUiOiJBQyIsInBhaWRVcFRvIjoiMjAxOS0xMS0yNiJ9LHsiY29kZSI6IkRQTiIsInBhaWRVcFRvIjoiMjAxOS0xMS0yNiJ9LHsiY29kZSI6IlBTIiwicGFpZFVwVG8iOiIyMDE5LTExLTI2In0seyJjb2RlIjoiR08iLCJwYWlkVXBUbyI6IjIwMTktMTEtMjYifSx7ImNvZGUiOiJETSIsInBhaWRVcFRvIjoiMjAxOS0xMS0yNiJ9LHsiY29kZSI6IkNMIiwicGFpZFVwVG8iOiIyMDE5LTExLTI2In0seyJjb2RlIjoiUlMwIiwicGFpZFVwVG8iOiIyMDE5LTExLTI2In0seyJjb2RlIjoiUkMiLCJwYWlkVXBUbyI6IjIwMTktMTEtMjYifSx7ImNvZGUiOiJSRCIsInBhaWRVcFRvIjoiMjAxOS0xMS0yNiJ9LHsiY29kZSI6IlBDIiwicGFpZFVwVG8iOiIyMDE5LTExLTI2In0seyJjb2RlIjoiUk0iLCJwYWlkVXBUbyI6IjIwMTktMTEtMjYifSx7ImNvZGUiOiJXUyIsInBhaWRVcFRvIjoiMjAxOS0xMS0yNiJ9LHsiY29kZSI6IkRCIiwicGFpZFVwVG8iOiIyMDE5LTExLTI2In0seyJjb2RlIjoiREMiLCJwYWlkVXBUbyI6IjIwMTktMTEtMjYifSx7ImNvZGUiOiJSU1UiLCJwYWlkVXBUbyI6IjIwMTktMTEtMjYifV0sImhhc2giOiIxMTA1NzI3NC8wIiwiZ3JhY2VQZXJpb2REYXlzIjowLCJhdXRvUHJvbG9uZ2F0ZWQiOmZhbHNlLCJpc0F1dG9Qcm9sb25nYXRlZCI6ZmFsc2V9-rsJR5mlJcjibqRu1gQAMUCngMe8i+AOWIi+JZkNFYPET2G1ONcLPcIzoATTRi6ofkDm5l+3Y4HXjBPjVU6bHDdMBAzCnUqpXKsCknwSYyPSU0Y5pzuLvw6O9aPlQ46UBoTEC2BL5W6f11S7NlAq7tTbDuvFUynqSGAmTEfuZtKmzRmp20ejTPuMlSO7UqSkZvkg6YvSTrax1d2K+P9SAmVGZ9iC7AzBs4AwTf84QB9qHvE/Nh0oELSHWGG9hsZZ7sVghI/39/jPQFTp8GLFsl36ZPybPhGDam721zxS9H++/eJk23Jz3nxaRluE4dWmpHrDg1qBHp8qVpSFejg2QYw==-MIIElTCCAn2gAwIBAgIBCTANBgkqhkiG9w0BAQsFADAYMRYwFAYDVQQDDA1KZXRQcm9maWxlIENBMB4XDTE4MTEwMTEyMjk0NloXDTIwMTEwMjEyMjk0NlowaDELMAkGA1UEBhMCQ1oxDjAMBgNVBAgMBU51c2xlMQ8wDQYDVQQHDAZQcmFndWUxGTAXBgNVBAoMEEpldEJyYWlucyBzLnIuby4xHTAbBgNVBAMMFHByb2QzeS1mcm9tLTIwMTgxMTAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxcQkq+zdxlR2mmRYBPzGbUNdMN6OaXiXzxIWtMEkrJMO/5oUfQJbLLuMSMK0QHFmaI37WShyxZcfRCidwXjot4zmNBKnlyHodDij/78TmVqFl8nOeD5+07B8VEaIu7c3E1N+e1doC6wht4I4+IEmtsPAdoaj5WCQVQbrI8KeT8M9VcBIWX7fD0fhexfg3ZRt0xqwMcXGNp3DdJHiO0rCdU+Itv7EmtnSVq9jBG1usMSFvMowR25mju2JcPFp1+I4ZI+FqgR8gyG8oiNDyNEoAbsR3lOpI7grUYSvkB/xVy/VoklPCK2h0f0GJxFjnye8NT1PAywoyl7RmiAVRE/EKwIDAQABo4GZMIGWMAkGA1UdEwQCMAAwHQYDVR0OBBYEFGEpG9oZGcfLMGNBkY7SgHiMGgTcMEgGA1UdIwRBMD+AFKOetkhnQhI2Qb1t4Lm0oFKLl/GzoRykGjAYMRYwFAYDVQQDDA1KZXRQcm9maWxlIENBggkA0myxg7KDeeEwEwYDVR0lBAwwCgYIKwYBBQUHAwEwCwYDVR0PBAQDAgWgMA0GCSqGSIb3DQEBCwUAA4ICAQAF8uc+YJOHHwOFcPzmbjcxNDuGoOUIP+2h1R75Lecswb7ru2LWWSUMtXVKQzChLNPn/72W0k+oI056tgiwuG7M49LXp4zQVlQnFmWU1wwGvVhq5R63Rpjx1zjGUhcXgayu7+9zMUW596Lbomsg8qVve6euqsrFicYkIIuUu4zYPndJwfe0YkS5nY72SHnNdbPhEnN8wcB2Kz+OIG0lih3yz5EqFhld03bGp222ZQCIghCTVL6QBNadGsiN/lWLl4JdR3lJkZzlpFdiHijoVRdWeSWqM4y0t23c92HXKrgppoSV18XMxrWVdoSM3nuMHwxGhFyde05OdDtLpCv+jlWf5REAHHA201pAU6bJSZINyHDUTB+Beo28rRXSwSh3OUIvYwKNVeoBY+KwOJ7WnuTCUq1meE6GkKc4D/cXmgpOyW/1SmBz3XjVIi/zprZ0zf3qH5mkphtg6ksjKgKjmx1cXfZAAX6wcDBNaCL+Ortep1Dh8xDUbqbBVNBL4jbiL3i3xsfNiyJgaZ5sX7i8tmStEpLbPwvHcByuf59qJhV/bZOl8KqJBETCDJcY6O2aqhTUy+9x93ThKs1GKrRPePrWPluud7ttlgtRveit/pcBrnQcXOl1rHq7ByB8CFAxNotRUYL9IF5n3wJOgkPojMy6jetQA5Ogc8Sm7RG6vg1yow==


Y9MXSIF79G-eyJsaWNlbnNlSWQiOiJZOU1YU0lGNzlHIiwibGljZW5zZWVOYW1lIjoiSkJGYW1pbHkgQ2hpbmEiLCJhc3NpZ25lZU5hbWUiOiIiLCJhc3NpZ25lZUVtYWlsIjoiIiwibGljZW5zZVJlc3RyaWN0aW9uIjoiIiwiY2hlY2tDb25jdXJyZW50VXNlIjpmYWxzZSwicHJvZHVjdHMiOlt7ImNvZGUiOiJJSSIsImZhbGxiYWNrRGF0ZSI6IjIwMTktMDctMjYiLCJwYWlkVXBUbyI6IjIwMjAtMDctMjUifSx7ImNvZGUiOiJBQyIsImZhbGxiYWNrRGF0ZSI6IjIwMTktMDctMjYiLCJwYWlkVXBUbyI6IjIwMjAtMDctMjUifSx7ImNvZGUiOiJEUE4iLCJmYWxsYmFja0RhdGUiOiIyMDE5LTA3LTI2IiwicGFpZFVwVG8iOiIyMDIwLTA3LTI1In0seyJjb2RlIjoiUFMiLCJmYWxsYmFja0RhdGUiOiIyMDE5LTA3LTI2IiwicGFpZFVwVG8iOiIyMDIwLTA3LTI1In0seyJjb2RlIjoiR08iLCJmYWxsYmFja0RhdGUiOiIyMDE5LTA3LTI2IiwicGFpZFVwVG8iOiIyMDIwLTA3LTI1In0seyJjb2RlIjoiRE0iLCJmYWxsYmFja0RhdGUiOiIyMDE5LTA3LTI2IiwicGFpZFVwVG8iOiIyMDIwLTA3LTI1In0seyJjb2RlIjoiQ0wiLCJmYWxsYmFja0RhdGUiOiIyMDE5LTA3LTI2IiwicGFpZFVwVG8iOiIyMDIwLTA3LTI1In0seyJjb2RlIjoiUlMwIiwiZmFsbGJhY2tEYXRlIjoiMjAxOS0wNy0yNiIsInBhaWRVcFRvIjoiMjAyMC0wNy0yNSJ9LHsiY29kZSI6IlJDIiwiZmFsbGJhY2tEYXRlIjoiMjAxOS0wNy0yNiIsInBhaWRVcFRvIjoiMjAyMC0wNy0yNSJ9LHsiY29kZSI6IlJEIiwiZmFsbGJhY2tEYXRlIjoiMjAxOS0wNy0yNiIsInBhaWRVcFRvIjoiMjAyMC0wNy0yNSJ9LHsiY29kZSI6IlBDIiwiZmFsbGJhY2tEYXRlIjoiMjAxOS0wNy0yNiIsInBhaWRVcFRvIjoiMjAyMC0wNy0yNSJ9LHsiY29kZSI6IlJNIiwiZmFsbGJhY2tEYXRlIjoiMjAxOS0wNy0yNiIsInBhaWRVcFRvIjoiMjAyMC0wNy0yNSJ9LHsiY29kZSI6IldTIiwiZmFsbGJhY2tEYXRlIjoiMjAxOS0wNy0yNiIsInBhaWRVcFRvIjoiMjAyMC0wNy0yNSJ9LHsiY29kZSI6IkRCIiwiZmFsbGJhY2tEYXRlIjoiMjAxOS0wNy0yNiIsInBhaWRVcFRvIjoiMjAyMC0wNy0yNSJ9LHsiY29kZSI6IkRDIiwiZmFsbGJhY2tEYXRlIjoiMjAxOS0wNy0yNiIsInBhaWRVcFRvIjoiMjAyMC0wNy0yNSJ9LHsiY29kZSI6IlJTVSIsImZhbGxiYWNrRGF0ZSI6IjIwMTktMDctMjYiLCJwYWlkVXBUbyI6IjIwMjAtMDctMjUifV0sImhhc2giOiIxMzgzODYyOS8wIiwiZ3JhY2VQZXJpb2REYXlzIjo3LCJhdXRvUHJvbG9uZ2F0ZWQiOmZhbHNlLCJpc0F1dG9Qcm9sb25nYXRlZCI6ZmFsc2V9-rI4et6OSKLA4gvOzxtyp48SCWtjwsOSQBJittaw6BOVJOwVBz0p31wBWDFSdIogdRPKquk2BAou7N694entEn4/Db3Ol5uotDtUd2MHuo+BBu9QcwIoX3RTrnYLwJfTlEJfRH/3TF3WtkPGQZQQcw/23hsZzdC/WJY6tmvyTijIBScUsvIOxZ+8REbWbkTQx1KliliFyrMua7hit8LThzfffZloHciaHwUP9BjxEjU0qQi+yFacSXjxEZERJT25hZrMN+bqBxcn59/4UJBrITt8YpLIlydt0+6vMSWAMawMzKpeDEDInKy0XomauTIUfxS4sbw/dSyVdSrh+IuOc7g==-MIIElTCCAn2gAwIBAgIBCTANBgkqhkiG9w0BAQsFADAYMRYwFAYDVQQDDA1KZXRQcm9maWxlIENBMB4XDTE4MTEwMTEyMjk0NloXDTIwMTEwMjEyMjk0NlowaDELMAkGA1UEBhMCQ1oxDjAMBgNVBAgMBU51c2xlMQ8wDQYDVQQHDAZQcmFndWUxGTAXBgNVBAoMEEpldEJyYWlucyBzLnIuby4xHTAbBgNVBAMMFHByb2QzeS1mcm9tLTIwMTgxMTAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxcQkq+zdxlR2mmRYBPzGbUNdMN6OaXiXzxIWtMEkrJMO/5oUfQJbLLuMSMK0QHFmaI37WShyxZcfRCidwXjot4zmNBKnlyHodDij/78TmVqFl8nOeD5+07B8VEaIu7c3E1N+e1doC6wht4I4+IEmtsPAdoaj5WCQVQbrI8KeT8M9VcBIWX7fD0fhexfg3ZRt0xqwMcXGNp3DdJHiO0rCdU+Itv7EmtnSVq9jBG1usMSFvMowR25mju2JcPFp1+I4ZI+FqgR8gyG8oiNDyNEoAbsR3lOpI7grUYSvkB/xVy/VoklPCK2h0f0GJxFjnye8NT1PAywoyl7RmiAVRE/EKwIDAQABo4GZMIGWMAkGA1UdEwQCMAAwHQYDVR0OBBYEFGEpG9oZGcfLMGNBkY7SgHiMGgTcMEgGA1UdIwRBMD+AFKOetkhnQhI2Qb1t4Lm0oFKLl/GzoRykGjAYMRYwFAYDVQQDDA1KZXRQcm9maWxlIENBggkA0myxg7KDeeEwEwYDVR0lBAwwCgYIKwYBBQUHAwEwCwYDVR0PBAQDAgWgMA0GCSqGSIb3DQEBCwUAA4ICAQAF8uc+YJOHHwOFcPzmbjcxNDuGoOUIP+2h1R75Lecswb7ru2LWWSUMtXVKQzChLNPn/72W0k+oI056tgiwuG7M49LXp4zQVlQnFmWU1wwGvVhq5R63Rpjx1zjGUhcXgayu7+9zMUW596Lbomsg8qVve6euqsrFicYkIIuUu4zYPndJwfe0YkS5nY72SHnNdbPhEnN8wcB2Kz+OIG0lih3yz5EqFhld03bGp222ZQCIghCTVL6QBNadGsiN/lWLl4JdR3lJkZzlpFdiHijoVRdWeSWqM4y0t23c92HXKrgppoSV18XMxrWVdoSM3nuMHwxGhFyde05OdDtLpCv+jlWf5REAHHA201pAU6bJSZINyHDUTB+Beo28rRXSwSh3OUIvYwKNVeoBY+KwOJ7WnuTCUq1meE6GkKc4D/cXmgpOyW/1SmBz3XjVIi/zprZ0zf3qH5mkphtg6ksjKgKjmx1cXfZAAX6wcDBNaCL+Ortep1Dh8xDUbqbBVNBL4jbiL3i3xsfNiyJgaZ5sX7i8tmStEpLbPwvHcByuf59qJhV/bZOl8KqJBETCDJcY6O2aqhTUy+9x93ThKs1GKrRPePrWPluud7ttlgtRveit/pcBrnQcXOl1rHq7ByB8CFAxNotRUYL9IF5n3wJOgkPojMy6jetQA5Ogc8Sm7RG6vg1yow==

Ctrl+Shift + Enter，语句完成
“！”，否定完成，输入表达式时按 “！”键
Ctrl+E，最近的文件
Ctrl+Shift+E，最近更改的文件
Shift+Click，可以关闭文件
Ctrl+[ OR ]，可以跑到大括号的开头与结尾
Ctrl+F12，可以显示当前文件的结构
Ctrl+F7，可以查询当前元素在当前文件中的引用，然后按 F3 可以选择
Ctrl+N，可以快速打开类
Ctrl+Shift+N，可以快速打开文件
Alt+Q，可以看到当前方法的声明
Ctrl+P，可以显示参数信息
Ctrl+Shift+Insert，可以选择剪贴板内容并插入
Alt+Insert，可以生成构造器/Getter/Setter等
Ctrl+Alt+V，可以引入变量。例如：new String(); 自动导入变量定义
Ctrl+Alt+T，可以把代码包在一个块内，例如：try/catch
Ctrl+Enter，导入包，自动修正
Ctrl+Alt+L，格式化代码
Ctrl+Alt+I，将选中的代码进行自动缩进编排，这个功能在编辑 JSP 文件时也可以工作
Ctrl+Alt+O，优化导入的类和包
Ctrl+R，替换文本
Ctrl+F，查找文本
Ctrl+Shift+Space，自动补全代码
Ctrl+空格，代码提示（与系统输入法快捷键冲突）
Ctrl+Shift+Alt+N，查找类中的方法或变量
Alt+Shift+C，最近的更改
Alt+Shift+Up/Down，上/下移一行
Shift+F6，重构 – 重命名
Ctrl+X，删除行
Ctrl+D，复制行
Ctrl+/或Ctrl+Shift+/，注释（//或者/**/）
Ctrl+J，自动代码（例如：serr）
Ctrl+Alt+J，用动态模板环绕
Ctrl+H，显示类结构图（类的继承层次）
Ctrl+Q，显示注释文档
Alt+F1，查找代码所在位置
Alt+1，快速打开或隐藏工程面板
Ctrl+Alt+left/right，返回至上次浏览的位置
Alt+left/right，切换代码视图
Alt+Up/Down，在方法间快速移动定位
Ctrl+Shift+Up/Down，向上/下移动语句
F2 或 Shift+F2，高亮错误或警告快速定位
Tab，代码标签输入完成后，按 Tab，生成代码
Ctrl+Shift+F7，高亮显示所有该文本，按 Esc 高亮消失
Alt+F3，逐个往下查找相同文本，并高亮显示
Ctrl+Up/Down，光标中转到第一行或最后一行下
Ctrl+B/Ctrl+Click，快速打开光标处的类或方法（跳转到定义处）
Ctrl+Alt+B，跳转到方法实现处
Ctrl+Shift+Backspace，跳转到上次编辑的地方
Ctrl+O，重写方法
Ctrl+Alt+Space，类名自动完成
Ctrl+Alt+Up/Down，快速跳转搜索结果
Ctrl+Shift+J，整合两行
Alt+F8，计算变量值
Ctrl+Shift+V，可以将最近使用的剪贴板内容选择插入到文本
Ctrl+Alt+Shift+V，简单粘贴
Shift+Esc，不仅可以把焦点移到编辑器上，而且还可以隐藏当前（或最后活动的）工具窗口
F12，把焦点从编辑器移到最近使用的工具窗口
Shift+F1，要打开编辑器光标字符处使用的类或者方法 Java 文档的浏览器
Ctrl+W，可以选择单词继而语句继而行继而函数
Ctrl+Shift+W，取消选择光标所在词
Alt+F7，查找整个工程中使用地某一个类、方法或者变量的位置
Ctrl+I，实现方法
Ctrl+Shift+U，大小写转化
Ctrl+Y，删除当前行


Shift+Enter，向下插入新行
psvm/sout，main/System.out.println(); Ctrl+J，查看更多
Ctrl+Shift+F，全局查找
Ctrl+F，查找/Shift+F3，向上查找/F3，向下查找
Ctrl+Shift+S，高级搜索
Ctrl+U，转到父类
Ctrl+Alt+S，打开设置对话框
Alt+Shift+Inert，开启/关闭列选择模式
Ctrl+Alt+Shift+S，打开当前项目/模块属性
Ctrl+G，定位行
Alt+Home，跳转到导航栏
Ctrl+Enter，上插一行
Ctrl+Backspace，按单词删除
Ctrl+”+/-”，当前方法展开、折叠
Ctrl+Shift+”+/-”，全部展开、折叠
【调试部分、编译】
Ctrl+F2，停止
Alt+Shift+F9，选择 Debug
Alt+Shift+F10，选择 Run
Ctrl+Shift+F9，编译
Ctrl+Shift+F10，运行
Ctrl+Shift+F8，查看断点
F8，步过
F7，步入
Shift+F7，智能步入
Shift+F8，步出
Alt+Shift+F8，强制步过
Alt+Shift+F7，强制步入
Alt+F9，运行至光标处
Ctrl+Alt+F9，强制运行至光标处
F9，恢复程序
Alt+F10，定位到断点
Ctrl+F8，切换行断点
Ctrl+F9，生成项目
Alt+1，项目
Alt+2，收藏
Alt+6，TODO
Alt+7，结构
Ctrl+Shift+C，复制路径
Ctrl+Alt+Shift+C，复制引用，必须选择类名
Ctrl+Alt+Y，同步
Ctrl+~，快速切换方案（界面外观、代码风格、快捷键映射等菜单）
Shift+F12，还原默认布局
Ctrl+Shift+F12，隐藏/恢复所有窗口
Ctrl+F4，关闭
Ctrl+Shift+F4，关闭活动选项卡
Ctrl+Tab，转到下一个拆分器
Ctrl+Shift+Tab，转到上一个拆分器
【重构】
Ctrl+Alt+Shift+T，弹出重构菜单
Shift+F6，重命名
F6，移动
F5，复制
Alt+Delete，安全删除
Ctrl+Alt+N，内联
【查找】
Ctrl+F，查找
Ctrl+R，替换
F3，查找下一个
Shift+F3，查找上一个
Ctrl+Shift+F，在路径中查找
Ctrl+Shift+R，在路径中替换
Ctrl+Shift+S，搜索结构
Ctrl+Shift+M，替换结构
Alt+F7，查找用法
Ctrl+Alt+F7，显示用法
Ctrl+F7，在文件中查找用法
Ctrl+Shift+F7，在文件中高亮显示用法
