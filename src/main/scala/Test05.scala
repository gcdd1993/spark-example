/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test05 {

  trait HelloTrait {
    def sayHello(name: String)
  }

  trait MakeFriendsTrait {
    def makeFriends(p: Person)
  }

  class Person(val name: String) extends HelloTrait with MakeFriendsTrait with Cloneable with Serializable {
    override def sayHello(name: String): Unit = println("Hello, " + name)

    override def makeFriends(p: Person): Unit = println("Hello, my name is " + name + ", your name is " + p.name)
  }

  def main(args: Array[String]): Unit = {
    val p = new Person("leo")
    p.sayHello("name")
  }

}
