import scala.collection.mutable.ArrayBuffer

/**
  * 算法案例：移除第一个负数之后的所有负数(优化)
  *
  * @author gaochen
  */
object Test02 {

  def main(args: Array[String]): Unit = {
    val a = ArrayBuffer[Int]()
    a += (1, 2, 3, 4, 5, -1, -3, -5, -9)
    // 每记录所有不需要移除的元素的索引，稍后一次性移除所有需要移除的元素
    // 性能较高，数组内的元素迁移只要执行一次即可
    var foundFirstNegative = false
    val keepIndexes = for (i <- a.indices if !foundFirstNegative || a(i) >= 0) yield {
      if (a(i) < 0) foundFirstNegative = true
      i
    }
    for (i <- keepIndexes.indices) {
      a(i) = a(keepIndexes(i))
    }
    a.trimEnd(a.length - keepIndexes.length)
    println(a.mkString(","))
  }
}
