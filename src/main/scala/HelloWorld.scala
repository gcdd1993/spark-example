/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/22
  */
class HelloWorld {
  private var myName = "leo"

  def name = "your name is " + myName

  def name_=(newName: String): Unit = {
    println("you can not edit your name")
  }

}
