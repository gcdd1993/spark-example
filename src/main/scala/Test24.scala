/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test24 {

  class Person

  case class Teacher(name: String, subject: String) extends Person

  case class Student(name: String, classroom: String) extends Person

  def judgeIdentify(p: Person): Unit = {
    p match {
      case Teacher(name, subject) => println("Teacher, name is " + name + ", subject is " + subject)
      case Student(name, classroom) => println("Student, name is " + name + ", classroom is " + classroom)
      case _ => println("Illegal access, please go out of the school!")
    }
  }

  def main(args: Array[String]): Unit = {
    val s = Student("leo", "A")
    judgeIdentify(s)
  }
}
