package patterns.oops.observerPattern

import patterns.oops.observerPattern.subject.WeatherData
import patterns.oops.observerPattern.displays.CurrentConditionsDisplay
import patterns.oops.observerPattern.displays.StatisticsDisplay
import patterns.oops.observerPattern.displays.HeatIndexDisplay

object WeatherStation {
    def main(args: Array[String]): Unit = {
        val weatherData = new WeatherData

        val currentDisplay = new CurrentConditionsDisplay(weatherData)
        val statisticsDisplay = new StatisticsDisplay(weatherData)
        val heatIndexDisplay = new HeatIndexDisplay(weatherData)

        weatherData.setMeasurements(80, 65, 30.4f)
        weatherData.setMeasurements(82, 70, 29.2f)
    }
}
