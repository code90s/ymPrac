package com.ymPrac.scala

/** \
  * 函数柯里化(Currying)
  * 内敛函数
  * Created by Yan Meng on 2017/8/3.
  */
object Function3 {

  def main(args: Array[String]): Unit = {
    println(cycFunc(1, 2))

    println(cycFunc2(1)(2))

    // 内敛函数
    factorial(2)

    def factorial(i: Int): Int = {
      def fact(i: Int, accumulator: Int): Int = {
        if (i <= 1)
          accumulator
        else
          fact(i - 1, i * accumulator)
      }
      fact(i, 1)
    }

    // 默认函数值
    println("返回值 : " + addInt())

    def addInt(a: Int = 0, b: Int = 2): Int = {
      a + b
    }

    // 匿名函数
    var anonFunc = (i: Int, j: Int) => {
      var c = i + j
      c + c + c + c
    }
    println(anonFunc(1, 2))

    // 可变参数
    variableFunc("aaa", "aasdf", "bbb", "ccc")
    def variableFunc(args: String* ): Unit = {
      for (arg <- args) {
        println(arg)
      }
    }
  }

  def cycFunc(a: Int, b: Int): Int = {
    a + b
  }

  def cycFunc2(a: Int)(b: Int): Int = {
    a + b
  }
}
