package patterns.oops.iteratorPattern

import patterns.oops.iteratorPattern.menu.PancakeHouseMenu
import patterns.oops.iteratorPattern.menu.DinerMenu
import patterns.oops.iteratorPattern.menu.Waitress
import patterns.oops.iteratorPattern.menu.CafeMenu

object MenuTestDrive {
  
    def main(args: Array[String]): Unit = {
        val pancakeHouseMenu = new PancakeHouseMenu
        val dinerMenu = new DinerMenu
        val cafeMenu = new CafeMenu

        val waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu)

        waitress.printMenu()
    }
}
