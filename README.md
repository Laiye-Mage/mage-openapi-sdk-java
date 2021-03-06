
<p align="center">
	<a href="https://www.laiye.com"><img src="https://www.laiye.com/static/official-website/logo.png"></a>
</p>

<h1 align="center">Mage Openapi SDK for Java</h1>

<p align="center">

[![Maven Central](https://img.shields.io/maven-central/v/com.laiye.mage.javasdk/mageSDK.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.laiye.mage.javasdk%22%20AND%20a:%22mageSDK%22)
[![build status](https://travis-ci.org/laiye-ai/mage-openapi-sdk-java.svg?branch=develop)](https://travis-ci.org/laiye-ai/mage-openapi-sdk-java)
[![codecov](https://codecov.io/gh/zuiyuqingfeng/mage-openapi-sdk-java/branch/master/graph/badge.svg)](https://codecov.io/gh/zuiyuqingfeng/mage-openapi-sdk-java)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7f135c2b356542fb86de1a96fe16ffa4)](https://www.codacy.com/manual/zuiyuqingfeng/mage-openapi-sdk-java?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=zuiyuqingfeng/mage-openapi-sdk-java&amp;utm_campaign=Badge_Grade)

</p>

欢迎使用 Mage Openapi SDK for Java。

## 环境要求
- 您的系统需要安装JDK 1.8 的运行环境 

## 快速使用
在您开始之前，您需要注册帐户并获取您的[凭证](https://openapi.wul.ai/docs/latest/saas.openapi.v2/openapi.v2.html#section/%E9%89%B4%E6%9D%83%E8%AE%A4%E8%AF%81)。

### 创建 com.MageClient 客户端
```java

import com.MageClient;
public class Test {

    public static void MageDemo(String[] args) throws ClientException, ServerException {

        //为避免泄漏公钥密钥等信息，建议将相关配置写到环境变量后使用System类的getenv方法获取环境变量。
        //默认使用https://openapi.wul.ai ,从环境变量获取 pubkey 和 secret
        MageClient mageClient=new MageClient();


    }
}

```

### 使用通用方法processCommonRequest发送请求
```
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("user_id", "laiye@test");

    JSONObject jsonObject1 = mageClient.processCommonRequest("/user/create", jsonObject);
    System.out.println(jsonObject1.toString());
        
```
### 使用Mage Java API发送请求
```
// 创建创建用户接口
    String userId = "laiye@test";
    CreateUser createUser = new CreateUser();
    createUser.setUserId(userId);
    createUser.setNickname("laiye_sdktest");
    int code = createUser.request(mageClient);
    if (200 != code) {
        throw new ServerException("1", "createuser error", 1);
    }
    
// 创建获取机器人回复对象
    String userId="laiye@test";
    String question="怀孕适合去哪里旅游";
    GetBotResponse getBotResponse = new GetBotResponse();
    getBotResponse.setUserId(userId);
    getBotResponse.setMsgBody(new MsgBody(new Text(question)));
//调用request方法获取返回结果        
    BotResponse botResponse = getBotResponse.request(mageClient);
```
### 启用日志功能
SDK默认提供了slf4j对象，在maven中添加相关依赖即可实现日志功能，例如
```xml
<dependencies>
    ...
    <dependency>
       <groupId>org.slf4j</groupId>
       <artifactId>slf4j-api</artifactId>
       <version>1.7.28</version>
    </dependency>
   <dependency>
       <groupId>log4j</groupId>
       <artifactId>log4j</artifactId>
       <version>1.2.17</version>
   </dependency>
   <dependency>
       <groupId>org.slf4j</groupId>
       <artifactId>slf4j-log4j12</artifactId>
       <version> 1.7.25</version>
   </dependency>
</dependencies>
```


### 协议说明
```text
网络协议: HTTP

请求方式: POST

请求、响应数据格式: JSON
```
