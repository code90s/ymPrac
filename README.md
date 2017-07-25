# ymPrac
本项目是我个人练习使用的项目，在所难免的是代码的零散。
***

所涉及的内容包括但不限于：
* java core，
* 书籍源代码 eg：《effective java》、《hadoop实战》……
* 入手项目 startup eg：spring boot、storm、kafka、hbase ……
* 个人心得
* ……

子项目明细：
* ymPrac-web & ymPrac-biz & ymPrac-service & ymPrac-common;
   spring boot 项目基本框架，整合了mybatis；依赖关系为：web -> biz -> service 同时各子项目依赖common；
* ymPrac-dubbo dubbo的基础代码，三种方法同spring boot整合：API/XML/properties;
* ymPrac-mq active mq 基础代码，已经整合spring boot;
* ymPrac-netty & ymPrac-mina  netty &  mina 的基础API；
*  ymPrac-reflect & ymPrac-concurrent 反射、并发等jdk 基础；
* ymPrac-effective 《effective java》随书源码；
* ymPrac-script java嵌入动态语言（python，grovy等），可以用来作为规则引擎的基础；
* ymPrac-storm storm 示例，兼容 jstorm， heron

codeReview:
ninja https://app.review.ninja/
