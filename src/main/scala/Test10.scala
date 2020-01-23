/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test10 {

  def main(args: Array[String]): Unit = {
    //    def sayHello(name: String): Unit = {
    //      println("Hello, " + name)
    //    }
    //
    //    val sayHelloFunc = sayHello _
    //    sayHelloFunc("leo")

    val sayHelloFunc = (name: String) => println("Hello, " + name)
    sayHelloFunc("leo")
  }
}
