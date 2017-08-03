package com.ymPrac.scala

import Array._
/**
  * 数组
  * Created by Yan Meng on 2017/8/3.
  */
object ArrayFunc {

  def main(args: Array[String]): Unit = {
    var x = new Array[String](2)
    x(0) = "aaa"

    var y = new Array[String](3)
    var z = new Array[String](3)

    println(x.toString + y.toString + z.toString)


    //  范围
    var myList1 = range(10, 20, 2)
    var myList2 = range(10,20)

    // 输出所有数组元素
    for ( x <- myList1 ) {
      print( " " + x )
    }
    println()
    for ( x <- myList2 ) {
      print( " " + x )
    }

    //从键盘获得输入
    val n = readInt()
    val array = new Array[Int](n)
    for (i <- array.indices) {
      array(i) = (new util.Random).nextInt(n)
    }
    println(array.mkString(","))

  }
}
