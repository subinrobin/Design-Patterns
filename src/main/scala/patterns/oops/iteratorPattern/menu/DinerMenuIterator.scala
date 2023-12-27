package patterns.oops.iteratorPattern.menu

class DinerMenuIterator(items: Array[MenuItem]) extends Iterator {
    
    private var position = 0

    def hasNext(): Boolean = {
        position < items.length && items(position) != null
    }
    
    def next(): MenuItem = {
        val menuItem = items(position)
        position += 1
        menuItem
    }
    
}
