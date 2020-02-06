package example29

import org.apache.spark.{SparkConf, SparkContext}

/**
  * TODO
  *
  * @author gaochen
  * @date 2020/2/6
  */
object LineCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("LineCount")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val rdd = sc.textFile("hello.txt")
    rdd.map((_, 1))
      .reduceByKey(_ + _)
      .foreach(count => println(s"${count._1} : ${count._2}"))
  }
}
