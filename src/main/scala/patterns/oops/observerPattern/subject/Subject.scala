package patterns.oops.observerPattern.subject

import patterns.oops.observerPattern.observer.Observer

trait Subject {
    def registerObserver(observer: Observer): Unit
    def removeObserver(observer: Observer): Unit
    def notifyObservers(): Unit
}
