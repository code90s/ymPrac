package com.ymPrac.scala

import java.util.Date

/**
  * 偏应用函数
  * Created by Yan Meng on 2017/8/3.
  */
object Function2 {

  def main(args: Array[String]): Unit = {
    var date = new Date();
    var newLog = logInfo(date, _: String)

    newLog("hello")
  }

  def logInfo(date: Date, msg: String) = {
    println(date + "=======" + msg);
  }
}
