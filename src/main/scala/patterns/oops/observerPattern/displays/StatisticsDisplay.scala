package patterns.oops.observerPattern.displays

import patterns.oops.observerPattern.subject.WeatherData
import patterns.oops.observerPattern.observer.Observer

class StatisticsDisplay(weatherData: WeatherData)
    extends Observer
    with DisplayElement {
    private var temperature: Float = _
    private var humidity: Float = _

    private var readings: Int = 0
    private var sumOfTemperatures: Float = 0
    private var maxTemperature: Float = Int.MinValue
    private var minTemperature: Float = Int.MaxValue
    private var averageTemperature: Float = 0

    weatherData.registerObserver(this)

    def update(temperature: Float, humidity: Float, pressure: Float): Unit = {
        this.temperature = temperature
        this.humidity = humidity
        updateStatistics()
        display()
    }

    def display(): Unit = {
        println(s"Avg/Max/Min temperature = ${averageTemperature}/${maxTemperature}/${minTemperature}")
    }

    def updateStatistics() = {
        readings += 1
        sumOfTemperatures += temperature
        averageTemperature = sumOfTemperatures / readings
        minTemperature = minTemperature.min(temperature)
        maxTemperature = maxTemperature.max(temperature)
    }
}
