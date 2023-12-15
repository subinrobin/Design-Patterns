package patterns.oops.observerPattern.subject

import patterns.oops.observerPattern.observer.Observer
import scala.collection.mutable.ArrayBuffer

class WeatherData extends Subject {
    private var observers = ArrayBuffer.empty[Observer]
    private var _temperature: Float = _
    private var _humidity: Float = _
    private var _pressure: Float = _

    def registerObserver(observer: Observer): Unit = {
        observers.+=(observer)
    }

    def removeObserver(observer: Observer): Unit = {
        observers.-=(observer)
    }

    def notifyObservers(): Unit = {
        observers.foreach(observer => {
            observer.update()
        })
        println("=" * 50)
    }

    def measurementsChanged(): Unit = {
        notifyObservers()
    }

    // simple test method to set values
    def setMeasurements(temperature: Float, humidity: Float, pressure: Float): Unit = {
        temperature_=(temperature)
        humidity_=(humidity)
        pressure_=(pressure)
        measurementsChanged()
    }

    def temperature: Float = _temperature

    def humidity: Float = _humidity

    def pressure: Float = _pressure

    private def temperature_=(value: Float): Unit = {
        _temperature = value
    }

    private def humidity_=(value: Float): Unit = {
        _humidity = value
    }

    private def pressure_=(value: Float): Unit = {
        _pressure = value
    }

    // other methods if required

}
