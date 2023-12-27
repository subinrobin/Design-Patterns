package patterns.oops.iteratorPattern.menu

import scala.collection.mutable.ListBuffer

class PancakeHouseMenu extends Menu {

    private val _menuItems = ListBuffer[MenuItem]()

    private def menuItems = _menuItems

    addItem(
      "K&B's Pancake Breakfast",
      "Pancakes with scrambled eggs and toast",
      true,
      2.99
    )

    addItem(
      "Regular Pancake Breakfast",
      "Pancakes with fried eggs, sausage",
      false,
      2.99
    )

    addItem(
      "Blueberry Pancakes",
      "Pancakes made with fresh blueberries",
      true,
      3.49
    )

    addItem(
      "Waffles",
      "Waffles with your choice of blueberries or strawberries",
      true,
      3.59
    )

    def addItem(
        name: String,
        description: String,
        isVegetarian: Boolean,
        price: Double
    ) = {
        val menuItem = MenuItem(name, description, isVegetarian, price)
        _menuItems.addOne(menuItem)
    }

    def createIterator() = {
        menuItems.iterator
    }
}
