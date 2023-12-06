object MethodAndFunction {
  def method(s:String, i: Int) = {
    println("this is a method " + s)
  }
// 函数参数多余1个就只能使用小括号,原因就是大括号包裹的式一个block，block中
  //式若干expression，block最后一行式整个block的返回值，也就是整个block最后只能
  //返回一个值
  val function = (s:String) => println("this is a function " + s)
  //val func2 = (s:String)() => {println("i")} //函数不能有多个列表

  def method2(a:Int)(b:Int) = {
    a+b
  }

  def main(args: Array[String]): Unit = {
    val s = "hi"
    val i = 1
    method(s, i)
    // method{s, i}
    function(s)
    function{s}
//返回了一个函数
    val intToInt = method2(1) _
    //相当于于分步调用了
    println(intToInt(8))
  }
}
