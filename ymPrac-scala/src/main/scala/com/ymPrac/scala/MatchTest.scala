package com.ymPrac.scala

/**
  * Created by Yan Meng on 2017/8/3.
  */
object MatchTest {

  def main(args: Array[String]): Unit = {
    println(matchTest("two"))
    println(matchTest("test"))
    println(matchTest(1))
    println(matchTest(6))

    def matchTest(x: Any): Any = x match {
      case 1 => "one"
      case "two" => 2
      case y: Int => "scala.Int"
      case _ => "many"
    }

    val alice = new PersonMatch("Alice", 25)
    val bob = new PersonMatch("Bob", 32)
    val charlie = new PersonMatch("Charlie", 32)

    for (person <- List(alice, bob, charlie)) {
      person match {
        case PersonMatch("Alice", 25) => println("Hi Alice!")
        case PersonMatch("Bob", 32) => println("Hi Bob!")
        case PersonMatch(name, age) =>
          println("Age: " + age + " year, name: " + name + "?")
      }
    }
  }
}

// 样例类
case class PersonMatch(name: String, age: Int)
