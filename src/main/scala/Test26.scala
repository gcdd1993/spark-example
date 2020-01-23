/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test26 {

  class Person(val name: String) {
    def sayHello(): Unit = println("Hello, I'm " + name)

    def makeFriends(p: Person) {
      sayHello()
      p.sayHello()
    }
  }

  class Student(name: String) extends Person(name)

  class Party[T <: Person](p1: T, p2: T) {
    def play(): Unit = p1.makeFriends(p2)
  }

  def main(args: Array[String]): Unit = {
    val p1 = new Student("leo")
    val p2 = new Student("marry")
    val p = new Party[Student](p1, p2)
    p.play()
  }

}
