package patterns.oops.iteratorPattern.menu

import scala.collection.mutable.Map
import scala.collection.Iterator

class CafeMenu extends Menu {

    private val _menuItems = Map.empty[String, MenuItem]

    private def menuItems = _menuItems

    addItem("Veggie Burger and Air Fries",
    "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
    true, 3.99)
    addItem("Soup of the day",
    "A cup of the soup of the day, with a side salad",
    false, 3.69)
    addItem("Burrito",
    "A large burrito, with whole pinto beans, salse, guacamole",
    true, 4.29)

    def addItem(
        name: String,
        description: String,
        isVegetarian: Boolean,
        price: Double
    ) = {
        val menuItem = MenuItem(name, description, isVegetarian, price)
        menuItems.put(name, menuItem)
    }

    def createIterator(): Iterator[MenuItem] = {
        menuItems.valuesIterator
    }

}
