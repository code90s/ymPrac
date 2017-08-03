package com.ymPrac.scala

/**
  * Trait 特征
  * Created by Yan Meng on 2017/8/3.
  */
trait TraitTest {

  def isEqual(x: Any): Boolean
  def isNotEqual(x: Any): Boolean = !isEqual(x)
}

class TraitPoint(xc: Int, yc: Int) extends TraitTest {
  var x: Int = xc
  var y: Int = yc
  def isEqual(obj: Any): Boolean =
    obj.isInstanceOf[Point] &&
      obj.asInstanceOf[Point].x == x
}

object Test {
  def main(args: Array[String]) {
    val p1 = new TraitPoint(2, 3)
    val p2 = new TraitPoint(2, 4)
    val p3 = new TraitPoint(3, 3)

    println(p1.isNotEqual(p2))
    println(p1.isNotEqual(p3))
    println(p1.isNotEqual(2))
  }
}