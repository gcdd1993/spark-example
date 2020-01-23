/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test11 {

  def main(args: Array[String]): Unit = {
    val sayHelloFunc = (name: String) => println("Hello, " + name)

    def greeting(func: String => Unit, name: String): Unit = {
      func(name)
    }

    Array(1, 2, 3, 4, 5).map((num: Int) => num * num)

    greeting(sayHelloFunc, "leo")
  }
}
