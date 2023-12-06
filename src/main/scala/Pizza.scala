import CrustSize._
import CrustType._
import Topping._

sealed abstract class CrustSize
object CrustSize {
  case object Small extends CrustSize
  case object Medium extends CrustSize
  case object Large extends CrustSize
}

sealed abstract class CrustType
object CrustType {
  case object Thin extends CrustType
  case object Thick extends CrustType
  case object Regular extends CrustType
}

sealed abstract class Topping
object Topping {
  case object Cheese extends Topping
  case object Pepperoni extends Topping
  case object BlackOlives extends Topping
  case object GreenOlives extends Topping
  case object Onions extends Topping
}

case class Pizza(
                  crustSize: CrustSize,
                  crustType: CrustType,
                  toppings: Seq[Topping]
                ) {

    private def toppingPrice(t: Topping): Double = t match {
      case Cheese | Onions => 0.5
      case Pepperoni | BlackOlives | GreenOlives => 0.75
    }

    private def crustPrice(s: CrustSize, t: CrustType): Double =
      (s, t) match {
        // if the crust size is small or medium,
        // the type is not important
        case (Small | Medium, _) => 0.25
        case (Large, Thin) => 0.50
        case (Large, Regular) => 0.75
        case (Large, Thick) => 1.00
      }

    def price: Double =
      this match {
        case Pizza(crustSize, crustType, toppings) =>
          val base = 6.00
          val crust = crustPrice(crustSize, crustType)
          val tops = toppings.map(toppingPrice).sum
          base + crust + tops
      }

    def addTopping(t: Topping): Pizza =
      this.copy(toppings = this.toppings :+ t)

    def removeAllToppings: Pizza =
      this.copy(toppings = Seq.empty)

    def updateCrustSize(cs: CrustSize): Pizza =
      this.copy(crustSize = cs)

    def updateCrustType(ct: CrustType): Pizza =
      this.copy(crustType = ct)
}

case class Address(
                    street1: String,
                    street2: Option[String],
                    city: String,
                    state: String,
                    zipCode: String
                  )

case class Customer(
                     name: String,
                     phone: String,
                     address: Address
                   )

case class Order(
                  pizzas: Seq[Pizza],
                  customer: Customer
                )