import org.apache.spark.{SparkConf, SparkContext}

/**
  * 累加变量
  *
  * @author gaochen
  * @date 2020/2/7
  */
object Accumulator {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf()
      .setAppName("BroadCastVariable")
      .setMaster("local"))

    val sum = sc.longAccumulator("test")

    sc.parallelize(1 to 10)
      .foreach(_ => sum.add(10))

    // 在driver程序中，可以调用Accumulator的value()方法，获取其值
    println(s"${sum.value}")

  }
}
