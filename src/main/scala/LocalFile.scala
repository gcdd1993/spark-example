import org.apache.spark.{SparkConf, SparkContext}

/**
  * 本地文件创建RDD
  *
  * @author gaochen
  * @date 2020/2/6
  */
object LocalFile {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("LocalFile")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val rdd = sc.textFile("spark.txt")
    val count = rdd.map(_.length)
      .reduce(_ + _)

    println(s"length : $count ")
  }
}
