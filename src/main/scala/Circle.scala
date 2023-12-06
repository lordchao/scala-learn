import scala.math._

class Circle(val radius: Double) {

  def area: Double = Circle.calculateArea(radius)

}

/**
 * A companion class or object can access the private members of its companion.
 * Companion objects are used for methods and values that are not specific to instances of the companion class.
Companion objects can be used for several purposes:

As shown, they can be used to group “static” methods under a namespace
These methods can be public or private
If calculateArea was public, it would be accessed as Circle.calculateArea
They can contain apply methods, which—thanks to some syntactic sugar—work as factory methods to construct new instances
They can contain unapply methods, which are used to deconstruct objects, such as with pattern matching

 */
object Circle {
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2)
}
