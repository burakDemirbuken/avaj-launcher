package src.weather;



public class WeatherProvider
{
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider()
	{
	}

	public static String getCurrentWeather(Coordinates coordinates)
	{
		return "Şu an boş";
	}

}