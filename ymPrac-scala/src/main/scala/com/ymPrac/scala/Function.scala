package com.ymPrac.scala

/**
  * Created by Yan Meng on 2017/8/1.
  */
object Function {

  def main(args: Array[String]) {
    println( "muliplier(1) value = " +  multiplier(1) )
    println( "muliplier(2) value = " +  multiplier(2) )

    println( apply( layout, 10) )
    println( errorFunc(args))
  }

  var factor = 3
  val multiplier: (Int) => Int = (i: Int) => i * factor

  // 函数 f 和 值 v 作为参数，而函数 f 又调用了参数 v
  def apply(f: Int => String, v: Int): String = f;(v)

  def layout[A](x: A): String = "[" + x.toString + "]"

  def errorFunc(i: Array[String]): Array[String] = i
}
