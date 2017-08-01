package com.ymPrac.scala

import java.util.{HashMap => JavaHashmap}

/**
  * Created by Yan Meng on 2017/8/1.
  */
object Hello {
3
  def main(args: Array[String]): Unit = {
    var foo =
      """
        |haha
        |lala
        |asjdfiasj
        |fgrgr
      """.stripMargin
    foo = "asdf"

    var myVar : String = "asedf"
    val myVal : String = "asdfsdaf"

    println("hi, scala" + foo)


    var a = 10
    var b = 20
    var c = 25
    var d = 25
    println("a + b = " + (a + b))
    println("a - b = " + (a - b))
    println("a * b = " + (a * b))
    println("b / a = " + (b / a))
    println("b % a = " + (b % a))
    println("c % a = " + (c % a))

    a = 10;
    b = 20;
    println("a == b = " + (a == b) );
    println("a != b = " + (a != b) );
    println("a > b = " + (a > b) );
    println("a < b = " + (a < b) );
    println("b >= a = " + (b >= a) );
    println("b <= a = " + (b <= a) );

    var e = true
    var f = false
    println("a && b = " + (e && f))
    println("a || b = " + (e || f))
    println("!(a && b) = " + !(e && f))
  }
}
