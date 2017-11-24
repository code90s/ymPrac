package com.ymPrac.scala

import scala.util.matching.Regex

/**
  * 正则表达式
  * Created by Yan Meng on 2017/8/3.
  */
object RegexTest {

  def main(args: Array[String]): Unit = {
    val pattern = "Scala".r
    val str = "Scala is Scalable and cool"
    println(pattern findFirstIn str)

    val pattern2 = new Regex("(S|s)cala")  // 首字母可以是大写 S 或小写 s
    val str2 = "Scala is scalable and cool"
    println((pattern2 findAllIn str2).mkString(","))   // 使用逗号 , 连接返回结果
  }


}
