package patterns.oops.observerPattern.subject

import patterns.oops.observerPattern.observer.Observer
import scala.collection.mutable.ArrayBuffer

class WeatherData extends Subject {
    private var observers = ArrayBuffer.empty[Observer]
    private var temperature: Float = _
    private var humidity: Float = _
    private var pressure: Float = _

    def registerObserver(observer: Observer): Unit = {
        observers.+=(observer)
    }

    def removeObserver(observer: Observer): Unit = {
        observers.-=(observer)
    }

    def notifyObservers(): Unit = {
        observers.foreach(observer => {
            observer.update(temperature, humidity, pressure)
        })
    }

    def measurementsChanged(): Unit = {
        notifyObservers()
    }

    // simple test method to set values
    def setMeasurements(temperature: Float, humidity: Float, pressure: Float) = {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }

    // other methods if required

}
