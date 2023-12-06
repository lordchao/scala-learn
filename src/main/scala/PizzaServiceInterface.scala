trait PizzaServiceInterface {
  def price(p: Pizza): Double

  def addTopping(p: Pizza, t: Topping): Pizza

  def removeAllToppings(p: Pizza): Pizza

  def updateCrustSize(p: Pizza, cs: CrustSize): Pizza

  def updateCrustType(p: Pizza, ct: CrustType): Pizza
}
