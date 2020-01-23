import scala.collection.mutable.ArrayBuffer

/**
  * 算法案例：移除第一个负数之后的所有负数
  *
  * @author gaochen
  **/
object Test01 {

  def main(args: Array[String]): Unit = {
//    val a = ArrayBuffer[Int]()
//    a += (1, 2, 3, 4, 5, -1, -3, -5, -9)
//    // 每发现一个第一个负数之后的负数，就进行移除，性能较差，多次移动数组
//    var foundFirstNegative = false
//    var arrayLength = a.length
//    var index = 0
//    while (index < arrayLength) {
//      if (a(index) >= 0) {
//        index += 1
//      } else {
//        if (!foundFirstNegative) {
//          foundFirstNegative = true
//          index += 1
//        } else {
//          a.remove(index)
//          arrayLength -= 1
//        }
//      }
//    }
//    println(a.mkString(","))
    println(Test03.getName)

  }
}
