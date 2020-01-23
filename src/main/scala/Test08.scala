/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test08 {

  trait Logger {
    println("Logger's constructor!")
  }

  trait MyLogger extends Logger {
    println("MyLogger's constructor!")
  }

  trait TimeLogger extends Logger {
    println("TimeLogger's constructor!")
  }

  class Person {
    println("Person's constructor!")
  }

  class Student extends Person with MyLogger with TimeLogger {
    println("Student's constructor!")
  }

  def main(args: Array[String]): Unit = {
    val s = new Student
  }

}
