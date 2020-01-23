import scala.collection.mutable

/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test18 {

  def main(args: Array[String]): Unit = {
    val list = mutable.LinkedList(1, 2, 3, 4, 5, 6)
    var currentList = list
    while (currentList != Nil) {
      currentList.elem = currentList.elem * 2
      currentList = currentList.next
    }

    println(list.mkString(","))
  }
}
