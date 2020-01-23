/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test13 {

  def main(args: Array[String]): Unit = {
    Array(1, 2, 3, 4, 5).map(2 * _)

    (1 to 9).map("*" * _).foreach(println)

    println((1 to 9).product)

    def getGreetingFUnc(msg: String) = (name: String) => println(msg + ", " + name)

    val greetingFuncHello = getGreetingFUnc("hello")
    val greetingFuncHi = getGreetingFUnc("hi")

    greetingFuncHello("leo")
    greetingFuncHi("leo")
  }
}
