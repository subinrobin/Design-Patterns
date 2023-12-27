package patterns.oops.compositePattern.menus

case class MenuItem(
    override val name: String,
    override val description: String,
    override val isVegetarian: Boolean,
    override val price: Double
) extends MenuComponent {

    override def print(): Unit = {
        println(name)
        if(isVegetarian) printf("(v)")
        println(price)
        println(description)
    }

}
