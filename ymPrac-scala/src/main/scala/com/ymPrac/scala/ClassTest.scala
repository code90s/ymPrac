package com.ymPrac.scala

/**
  *  类和对象
  * Created by Yan Meng on 2017/8/3.
  */
class ClassTestDemo(xc: Int, yc: Int) {

  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println ("x 的坐标点: " + x);
    println ("y 的坐标点: " + y);
  }
}

object ClassTest {
  def main(args: Array[String]): Unit = {
    var a = new ClassTestDemo(2, 3);
    a.move(4, 5)

    val loc = new Location(10, 20, 15);
    // 移到一个新的位置
    loc.move(10, 10, 5);

    var fred = new Employee
    fred.name = "Fred"
    fred.salary = 50000
    println(fred)
  }
}

class Point(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc
  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println ("x 的坐标点 : " + x);
    println ("y 的坐标点 : " + y);
  }
}

class Location(override val xc: Int, override val yc: Int,
               val zc :Int) extends Point(xc, yc){
  var z: Int = zc
  def move(dx: Int, dy: Int, dz: Int) {
    x = x + dx
    y = y + dy
    z = z + dz
    println ("x 的坐标点 : " + x);
    println ("y 的坐标点 : " + y);
    println ("z 的坐标点 : " + z);
  }
}


// 重写非抽象方法
class Person {
  var name = ""
  override def toString = getClass.getName + "[name=" + name + "]"
}

class Employee extends Person {
  var salary = 0.0
  override def toString = super.toString + "[salary=" + salary + "]"
}


