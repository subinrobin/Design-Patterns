package patterns.oops.observerPattern.displays

import patterns.oops.observerPattern.observer.Observer
import patterns.oops.observerPattern.subject.WeatherData

class CurrentConditionsDisplay(weatherData: WeatherData)
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
        println(
          s"Current conditions: ${temperature}F degrees and ${humidity}% humidity"
        )
    }
}
