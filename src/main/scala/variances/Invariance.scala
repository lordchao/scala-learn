package variances

//默认的范型类之前没有任何从属关系
class Box[A](var content: A)


abstract class Animal {
  def name: String
}
case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

//协变的范型类之间会有跟类型本身一样的继承关系
class BoxCon[+A](val content:A)

//协变的范型类之间会有跟类型本身相反的继承关系
class BoxContra[-A](content:A)

object Invariance {
  val cat = Cat("lena")
  val dog = Dog("ander")

  val catBox = new Box[Cat](cat)
  // val animalBox:Box[Animal] = catBox 报错,如果可以赋值的话就说明dog的
  // animalBox.content就可以被Dog赋值，但是box本身是catBox，这就会造成可以从
  // catBox中取出dog

  //conAnimalBox可以被conCatBox赋值，BoxCon[Cat]是BoxCon[Animal]的sub type
  val conCatBox = new BoxCon[Cat](cat)
  val conAnimalBox:BoxCon[Animal] = conCatBox

  //contraCatBox可以被contraAnimalBox赋值，因为contraAnimalBox是contraCatBox的sub type
  val contraAnimalBox = new BoxContra[Animal](cat)
  val contraCatBox:BoxContra[Cat] = contraAnimalBox

  def main(args: Array[String]): Unit = {

  }

}
