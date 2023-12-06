object Brace {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5)
//    list.map(_+1).foreach(println)
//
//    val func = (a:Int) => {
//      println("i")
//      1+a
//    }

//    list.map(x=>func(x)).foreach(println)

    list.map{ //最后返回的一定要式map中需要的类型
      println("hi")
      _ + 1
    }.foreach(println)
  }

}
