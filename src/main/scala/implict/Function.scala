package implict

object Function {
  //implicit函数会自动调用，底层会生成f1$()然后runtime把参数放进去

  implicit def toInt(v:Double) = v.toInt

  def main(args: Array[String]): Unit = {
    val i:Int = 3.1
  }

}
