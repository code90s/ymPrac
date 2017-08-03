package com.ymPrac.scala

/**
  * 半生对象
  * Created by Yan Meng on 2017/8/3.
  */
class ObjectTes(val color:String) {
  println("创建" + this)
  override def toString: String = "颜色标记："+ color
}

object ObjectTes {

  private val markers: Map[String, ObjectTes] = Map(
    "red" -> new ObjectTes("red"),
    "blue" -> new ObjectTes("blue"),
    "green" -> new ObjectTes("green")
  )

  def apply(color:String): ObjectTes = {
    if(markers.contains(color)) markers(color) else null
  }

  def getMarker(color:String): ObjectTes = {
    if(markers.contains(color)) markers(color) else null
  }

  def main(args: Array[String]) {
    println(markers("red"))
    // 单例函数调用，省略了.(点)符号
    println(ObjectTes getMarker "blue")
  }
}
