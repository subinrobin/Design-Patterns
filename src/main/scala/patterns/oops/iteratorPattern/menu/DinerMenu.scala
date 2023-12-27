package patterns.oops.iteratorPattern.menu

class DinerMenu extends Menu {

    val MAX_ITEMS = 4
    var numberOfItems = 0

    val _menuItems = Array.ofDim[MenuItem](MAX_ITEMS)

    private def menuItems = _menuItems

    def createIterator() = menuItems.iterator

    addItem(
      "Vegetarian BLT",
      "(Fakin') Bacon with lettuce & tomato on whole wheat",
      true,
      2.99
    )
    addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99)
    addItem(
      "Soup of the day",
      "Soup of the day, with a side of potato salad",
      false,
      3.29
    )
    addItem(
      "Hotdog",
      "A hot dog, with sauerkraut, relish, onions, topped with cheese",
      false,
      3.05
    )

    def addItem(
        name: String,
        description: String,
        isVegetarian: Boolean,
        price: Double
    ) = {
        val menuItem = MenuItem(name, description, isVegetarian, price)
        if (numberOfItems >= MAX_ITEMS) {
            println("Sorry, menu is full! Can't add item to menu")
        } else {
            menuItems(numberOfItems) = menuItem
            numberOfItems += 1
        }
    }
}
