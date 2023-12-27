package patterns.oops.iteratorPattern.menu

trait Iterator {
  
    def hasNext(): Boolean

    def next(): MenuItem
}
