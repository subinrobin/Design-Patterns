package patterns.oops.compositePattern

import patterns.oops.compositePattern.menus.Menu
import patterns.oops.compositePattern.menus.MenuComponent
import patterns.oops.compositePattern.menus.MenuItem
import patterns.oops.compositePattern.menus.Waitress

object MenuTestDrive {

    def main(args: Array[String]): Unit = {
        val pancakeHouseMenu: MenuComponent =
            Menu("PANCAKE HOUSE MENU", "Breakfast")
        val dinerMenu: MenuComponent = Menu("DINER MENU", "Lunch")
        val cafeMenu: MenuComponent = Menu("CAFE MENU", "Dinner")
        val dessertMenu: MenuComponent =
            Menu("DESSERT MENU", "Dessert of course!")

        val allMenus: MenuComponent = Menu("ALL MENUS", "All menus combined")

        allMenus.add(pancakeHouseMenu)
        allMenus.add(dinerMenu)
        allMenus.add(cafeMenu)

        val pancakeItem1 = MenuItem(
          "K&B's Pancake Breakfast",
          "Pancakes with scrambled eggs and toast",
          true,
          2.99
        )

        val pancakeItem2 = MenuItem(
          "Regular Pancake Breakfast",
          "Pancakes with fried eggs, sausage",
          false,
          2.99
        )

        val pancakeItem3 = MenuItem(
          "Blueberry Pancakes",
          "Pancakes made with fresh blueberries",
          true,
          3.49
        )

        val pancakeItem4 = MenuItem(
          "Waffles",
          "Waffles with your choice of blueberries or strawberries",
          true,
          3.59
        )

        pancakeHouseMenu.add(pancakeItem1)
        pancakeHouseMenu.add(pancakeItem2)
        pancakeHouseMenu.add(pancakeItem3)
        pancakeHouseMenu.add(pancakeItem4)

        val cafeItem1 =
            MenuItem(
              "Veggie Burger and Air Fries",
              "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
              true,
              3.99
            )

        val cafeItem2 = MenuItem(
          "Soup of the day",
          "A cup of the soup of the day, with a side salad",
          false,
          3.69
        )

        val cafeItem3 = MenuItem(
          "Burrito",
          "A large burrito, with whole pinto beans, salse, guacamole",
          true,
          4.29
        )

        cafeMenu.add(cafeItem1)
        cafeMenu.add(cafeItem2)
        cafeMenu.add(cafeItem3)

        val dinerItem1 = MenuItem(
          "Vegetarian BLT",
          "(Fakin') Bacon with lettuce & tomato on whole wheat",
          true,
          2.99
        )
        
        val dinerItem2 = MenuItem(
          "BLT",
          "Bacon with lettuce & tomato on whole wheat",
          false,
          2.99
        )
        
        val dinerItem3 = MenuItem(
          "Soup of the day",
          "Soup of the day, with a side of potato salad",
          false,
          3.29
        )
        
        val dinerItem4 = MenuItem(
          "Hotdog",
          "A hot dog, with sauerkraut, relish, onions, topped with cheese",
          false,
          3.05
        )
    
        dinerMenu.add(dinerItem1)
        dinerMenu.add(dinerItem2)
        dinerMenu.add(dinerItem3)
        dinerMenu.add(dinerItem4)

        dinerMenu.add(dessertMenu)

        val dessertItem1 = MenuItem("Apple Pie", 
        "Apple Pie with a flakey crust, topped with vanilla ice cream",
        true, 1.59)
        dessertMenu.add(dessertItem1)

        val waitress = new Waitress(allMenus)
        waitress.printMenu()
    }

}
