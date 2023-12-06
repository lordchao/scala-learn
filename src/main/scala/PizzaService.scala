import CrustSize._
import CrustType._
import Topping._

object PizzaService extends PizzaServiceInterface {
  private def crustPrice(s: CrustSize, t: CrustType): Double =
    (s, t) match {
      // if the crust size is small or medium,
      // the type is not important
      case (Small | Medium, _) => 0.25
      case (Large, Thin) => 0.50
      case (Large, Regular) => 0.75
      case (Large, Thick) => 1.00
    }

  private def toppingPrice(t: Topping): Double = t match {
    case Cheese | Onions => 0.5
    case Pepperoni | BlackOlives | GreenOlives => 0.75
  }

  override def price(p: Pizza): Double = p match {
    case Pizza(crustSize, crustType, toppings) => {
      val base = 6.00
      val crust = crustPrice(crustSize, crustType)
      val tops = toppings.map(toppingPrice).sum
      base + crust + tops
    }
  }

  override def addTopping(p: Pizza, t: Topping): Pizza = p.copy(toppings = p.toppings :+ t)

  override def removeAllToppings(p: Pizza): Pizza = p.copy(toppings = Seq.empty)

  override def updateCrustSize(p: Pizza, cs: CrustSize): Pizza = p.copy(crustSize = cs)

  override def updateCrustType(p: Pizza, ct: CrustType): Pizza = p.copy(crustType = ct)
}
