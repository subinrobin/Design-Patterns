package patterns.oops.iteratorPattern.menu

import scala.collection.Iterator

class Waitress(pancakeHouseMenu: Menu, dinerMenu: Menu, cafeMenu: Menu) {

    def printMenu(): Unit = {
        val pancakeIterator = pancakeHouseMenu.createIterator()
        val dinerIterator = dinerMenu.createIterator()
        val cafeIterator = cafeMenu.createIterator()

        println("MENU\n----\nBREAKFAST")
        printMenu(pancakeIterator)
        println("LUNCH")
        printMenu(dinerIterator)
        println("DINNER")
        printMenu(cafeIterator)

    }

    private def printMenu(iterator: Iterator[MenuItem]) = {
        iterator.foreach(menuItem => {
            println(menuItem.name, menuItem.price, menuItem.description)
        })
    }
}
