package leetcode

object Minimum {
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    points.sortBy(_(1))
      .foreach(x => println(x(0).toString+x(1).toString))
    1
  }

  def main(args: Array[String]): Unit = {
    findMinArrowShots(Array(Array(1,4), Array(2,2)))
  }
}
