trait GreetingService {
  def translate(text: String): String
  def sayHello = translate("Hello")
}

trait TranslationService {
  def translate(text: String): String = "..."
}

trait ComposedService extends GreetingService with TranslationService {
  def hello = println("hello")
}

class Service extends ComposedService {
  override def hello = println("override")
}