package patterns.oops.compositePattern.menus

class Waitress(allMenus: MenuComponent) {
  
    def printMenu(): Unit = {
        allMenus.print()
    }
}
