/**
  * Manifest Context Bounds
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test29 {

  class Meat(val name: String)

  class Vegetable(val name: String)

  def packageFood[T: Manifest](food: T*): Array[T] = {
    val foodPackage = new Array[T](food.length)
    for (i <- 0 until food.length) foodPackage(i) = food(i)
    foodPackage
  }

  def main(args: Array[String]): Unit = {
    val meat = new Meat("猪肉")
    val vegetable1 = new Vegetable("青菜")
    val vegetable2 = new Vegetable("菠菜")

    val arr = packageFood(meat, vegetable1, vegetable2)
    println(arr.mkString(","))
  }
}
