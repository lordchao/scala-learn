import CrustSize._
import CrustType._
import PizzaService._
import Topping._

object Try {
  def pizzaPrice(p: Pizza): Double = p match {
    case Pizza(crustSize, crustType, toppings) => {
      val base = 6.00
      val crust = crustPrice(crustSize, crustType)
      val tops = toppings.map(toppingPrice).sum
      base + crust + tops
    }
  }

  def crustPrice(s: CrustSize, t: CrustType): Double =
    (s, t) match {
      // if the crust size is small or medium,
      // the type is not important
      case (Small | Medium, _) => 0.25
      case (Large, Thin) => 0.50
      case (Large, Regular) => 0.75
      case (Large, Thick) => 1.00
    }

  def toppingPrice(t: Topping): Double = t match {
    case Cheese | Onions => 0.5
    case Pepperoni | BlackOlives | GreenOlives => 0.75
  }

  def implicitDemo = {
    implicit def toInt(num:Long):Int = {
      num.toInt
    }
    val a:Int = 100L
    println(a)
  }

  def demo[String, Int](char:String, input:Int) = {
    println(input+2.toString+char)
  }


  def main(args: Array[String]): Unit = {
    val string = "ad_selector_selection_v2"
    val initial = string.
      split("_").
      drop(1).
      map(x => {if (x.startsWith("v"))
        x
      else x.charAt(0)
      }).mkString
    println(initial)

    val result = string.split('_')
    println(result(1))

    val circle = new Circle(4)
    println(circle.area)

    val myPizza = Pizza(Small, Regular, Seq(Cheese, Pepperoni))
    println(myPizza.price)
    println(pizzaPrice(myPizza))
    myPizza.removeAllToppings
    println(myPizza.price)

    val l = List(1,2,3)
    val l1 = l +: List(4,5)
    val l2 = l :+ List(4,5)
    println(l1)
    println(l2)

    val v = Vector(1,2,3)
    val v1 = v :+ 4
    val v2 = v ++ Vector(4,5)
    println(v1)
    println(v2)

    val option:Option[Int] = Some(1)
    println(option.get)

    implicitDemo
    demo("a",2)
  }
}
