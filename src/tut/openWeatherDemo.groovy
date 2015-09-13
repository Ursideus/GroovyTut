package tut

import com.google.gson.Gson

class OpenWheather {
  String base = 'http://api.openweathermap.org/data/2.5/weather?q='
  Gson gson = new Gson()

  String getWeather(city='Marlborough', state='CT') {    // set default param values if not provided
    String jsonTxt = $/$base$city$,$state/$.toURL().text
    gson.fromJson(jsonTxt, Model).toString()             // pass in the class name Model
  }
}


class Model {
  Long dt
  Long id
  String name
  Integer cod

  Coordinates coord
  Main main
  Wind wind
  Clouds clouds
  Weather[] weather
}
