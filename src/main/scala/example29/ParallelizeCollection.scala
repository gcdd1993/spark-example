package example29

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 并行化集合创建RDD
  *
  * @author gaochen
  * @date 2020/2/6
  */
object ParallelizeCollection {
  def main(args: Array[String]): Unit = {
    val arr = 1 to 10000

    val conf = new SparkConf()
      .setAppName("ParallelizeCollection")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(arr)

    val sum = rdd.reduce(_ + _)

    println(s"sum : $sum")
  }
}
