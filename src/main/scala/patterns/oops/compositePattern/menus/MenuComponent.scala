package patterns.oops.compositePattern.menus

trait MenuComponent {
  
    def add(value: MenuComponent): Unit = {
        throw new UnsupportedOperationException
    }

    def remove(value: MenuComponent): Unit = {
        throw new UnsupportedOperationException
    }

    def getChild(i: Int): MenuComponent = {
        throw new UnsupportedOperationException
    }

    def name: String = {
        throw new UnsupportedOperationException
    }

    def description: String = {
        throw new UnsupportedOperationException
    }

    def price: Double = {
        throw new UnsupportedOperationException
    }

    def isVegetarian: Boolean = {
        throw new UnsupportedOperationException
    }

    def print(): Unit = {
        throw new UnsupportedOperationException
    }
}
