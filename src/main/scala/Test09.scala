/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test09 {

  trait SayHello {
    val msg: String
    println(msg.toString)
  }

  class Person

  def main(args: Array[String]): Unit = {
    val p = new {
      val msg:String = "init"
    } with Person with SayHello

  }

}
