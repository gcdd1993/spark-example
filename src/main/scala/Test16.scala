/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test16 {

  def main(args: Array[String]): Unit = {
    def greeting(name: String) = {
      def sayHello(name: String): String = {
        "Hello, " + name
      }

      sayHello(name)
    }

    println(greeting("leo"))
  }
}
