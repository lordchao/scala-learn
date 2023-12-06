package implict

object ImplicitClass {
  //隐式类在底层会生成类
  implicit class db(val m:String) {
    def addSuffix():String = m + " park"
  }

  def main(args: Array[String]): Unit = {
  //编译器会自动创建隐式类的实例然后返回
    val s:String = "ni"
    // 使用返回的实例的方法，将s传入
    println(s.addSuffix())
  }

}
