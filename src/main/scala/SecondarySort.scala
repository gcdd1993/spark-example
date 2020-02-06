import org.apache.spark.{SparkConf, SparkContext}

/**
  * 二次排序
  * <p>
  * 1、实现自定义的key，要实现Ordered接口和Serializable接口，在key中实现自己对多个列的排序算法
  * 2、将包含文本的RDD，映射成key为自定义key，value为文本的JavaPairRDD
  * 3、使用sortByKey算子按照自定义的key进行排序
  * 4、再次映射，剔除自定义的key，只保留文本行
  *
  * @author gaochen
  * @date 2020/2/7
  */
object SecondarySort {

  class SecondarySortKey(val first: Int, val second: Int)
    extends Ordered[SecondarySortKey] with Serializable {
    override def compare(that: SecondarySortKey): Int = {
      if (this.first - that.first != 0) {
        this.first - that.first
      } else {
        this.second - that.second
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf()
      .setAppName("BroadCastVariable")
      .setMaster("local"))

    val lines = sc.textFile("sort.txt")
    lines.map(line => {
      val split = line.split(" ")
      (new SecondarySortKey(split(0).toInt, split(1).toInt), line)
    }).sortByKey()
      .map(_._2)
      .foreach(println(_))
  }

}
