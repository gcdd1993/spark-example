import org.apache.spark.{SparkConf, SparkContext}

/**
  * 对每个班级内的学生成绩，取出前3名。（分组取topn）
  *
  * @author gaochen
  * @date 2020/2/7
  */
object GroupTop3 {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf()
      .setAppName("BroadCastVariable")
      .setMaster("local"))

    val scores = sc.textFile("score.txt")
    scores.map(line => {
      val split = line.split(" ")
      (split(0), split(1).toInt)
    }).groupByKey()
      .map(group => {
        val scores = group._2
        (group._1, sortScore(scores).take(3))
      })
      .foreach(t => println(s"${t._1} : ${t._2.mkString(",")}"))
  }

  /**
    * 倒序排序
    *
    * @param scores 分数
    * @return
    */
  def sortScore(scores: Iterable[Int]): Iterable[Int] = {
    val arr = scores.toArray
    java.util.Arrays.sort(arr)
    val res = new Array[Int](arr.length)
    for (i <- arr.indices) {
      res(i) = arr(arr.length - 1 - i)
    }
    res.toIterable
  }
}
