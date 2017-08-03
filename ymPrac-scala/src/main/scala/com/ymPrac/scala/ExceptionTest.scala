package com.ymPrac.scala

import java.io.{FileNotFoundException, FileReader, IOException}

/**
  * 异常处理
  * Created by Yan Meng on 2017/8/3.
  */
object ExceptionTest {

  def main(args: Array[String]) {
    try {
      val f = new FileReader("heheda.txt")
    } catch {
      case ex: FileNotFoundException => {
        println("Missing file exception")
      }
      case ex: IOException => {
        println("IO Exception")
      }
    } finally {
      println("Exiting finally...")
    }
  }
}
