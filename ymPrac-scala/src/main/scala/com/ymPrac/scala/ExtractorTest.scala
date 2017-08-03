package com.ymPrac.scala

/**
  * Extractor 提取器
  * Created by Yan Meng on 2017/8/3.
  */
object ExtractorTest {

  def main(args: Array[String]) {
    println("Apply 方法 : " + apply("Zara", "gmail.com"));
    println("Unapply 方法 : " + unapply("Zara@gmail.com"));
    println("Unapply 方法 : " + unapply("Zara Ali"));
  }

  // 注入方法 (可选)
  def apply(user: String, domain: String): String = {
    user + "@" + domain
  }

  // 提取方法（必选）
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) {
      Some(parts(0), parts(1))
    } else {
      None
    }
  }
}
