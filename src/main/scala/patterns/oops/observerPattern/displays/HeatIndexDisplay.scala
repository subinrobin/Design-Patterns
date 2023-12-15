package patterns.oops.observerPattern.displays

import patterns.oops.observerPattern.subject.WeatherData
import patterns.oops.observerPattern.observer.Observer

class HeatIndexDisplay(weatherData: WeatherData)
    extends Observer
    with DisplayElement {
    private var temperature: Float = _
    private var humidity: Float = _

    weatherData.registerObserver(this)

    def update(temperature: Float, humidity: Float, pressure: Float): Unit = {
        this.temperature = temperature
        this.humidity = humidity
        display()
    }

    def display(): Unit = {
        val heatIndex = computeHeatIndex(temperature, humidity)
        println(s"Heat index is $heatIndex")
    }

    private def computeHeatIndex(t: Float, rh: Float): Float = {
        val index = ((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
            (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
            (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
            (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
            (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
            0.000000000843296 * (t * t * rh * rh * rh)) -
            (0.0000000000481975 * (t * t * t * rh * rh * rh))).asInstanceOf[Float]
        index
    }
}
