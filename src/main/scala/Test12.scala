/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test12 {

  def main(args: Array[String]): Unit = {
    def greeting(func: String => Unit, name: String): Unit = {
      func(name)
    }

    greeting((name: String) => println("hello, " + name), "leo")
    greeting(name => print("Hello, " + name), "leo")

    def triple(func: Int => Int) = {
      func(3)
    }

    triple(3 * _)
  }
}
