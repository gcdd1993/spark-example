import org.apache.spark.{SparkConf, SparkContext}

/**
  * 广播变量
  *
  * @author gaochen
  * @date 2020/2/7
  */
object BroadCastVariable {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf()
      .setAppName("BroadCastVariable")
      .setMaster("local"))

    val arr = 1 to 100

    val numbers = sc.parallelize(arr)

    val factor = 3
    // 每个节点拷贝一份，更大的用处是优化性能，减少网络传输以及内存消耗
    val factorBroadCast = sc.broadcast(factor)

    numbers.map(_ * factorBroadCast.value)
      .foreach(println(_))
  }
}
