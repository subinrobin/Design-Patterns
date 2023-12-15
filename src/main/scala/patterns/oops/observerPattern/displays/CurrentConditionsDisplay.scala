package patterns.oops.observerPattern.displays

import patterns.oops.observerPattern.observer.Observer
import patterns.oops.observerPattern.subject.WeatherData

class CurrentConditionsDisplay(weatherData: WeatherData)
    extends Observer
    with DisplayElement {
    private var temperature: Float = _
    private var humidity: Float = _

    weatherData.registerObserver(this)

    def update(): Unit = {
        this.temperature = weatherData.temperature
        this.humidity = weatherData.humidity
        display()
    }

    def display(): Unit = {
        println(s"Current conditions: ${temperature}F degrees and ${humidity}% humidity")
    }
}
