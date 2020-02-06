import org.apache.spark.{SparkConf, SparkContext}

/**
  * Rdd持久化
  *
  * @author gaochen
  * @date 2020/2/7
  */
object RddPersist {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf()
      .setAppName("RddPersist")
      .setMaster("local"))

    val lines = sc.textFile("spark1.txt")
    //    val lines = sc.textFile("spark1.txt").cache()
    val beginTime = System.currentTimeMillis()
    println(s"count1: ${lines.count()}")
    val endTime = System.currentTimeMillis()
    println(s"cost ${endTime - beginTime} milliseconds.")

    val beginTime1 = System.currentTimeMillis()
    println(s"count2: ${lines.count()}")
    val endTime1 = System.currentTimeMillis()
    println(s"cost ${endTime1 - beginTime1} milliseconds.")

  }
}
