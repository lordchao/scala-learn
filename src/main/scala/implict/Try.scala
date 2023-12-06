package implict

object Try {
  def func[A](i:Int)(implicit j:A): Unit = {
    println(i+1)
  }

  def func1[A](i:Int)(j:Int) = {
    println(i+j)
  }

  def main(args: Array[String]): Unit = {
    func(1)

  }

}
