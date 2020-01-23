/**
  * View Bounds
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test27 {

  class Person(val name: String) {
    def sayHello(): Unit = println("Hello, I'm " + name)

    def makeFriends(p: Person): Unit = {
      sayHello()
      p.sayHello()
    }
  }

  class Student(name: String) extends Person(name)

  class Dog(val name: String) {
    def sayHello(): Unit = println("Wang, Wang, I'm " + name)
  }

  class Party[T](p1: T, p2: T)(implicit p: T => Person) {
    def play(): Unit = p1.makeFriends(p2)
  }

  def main(args: Array[String]): Unit = {
    val p1 = new Student("leo")
    val p2 = new Dog("wangcai")

    //     val p = new Party[Student](p1, p2)
    //    p.play()
  }

}
