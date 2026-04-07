package simulation.Tower;

import simulation.vehicles.Coordinates;

public class WeatherProvider
{
	private static WeatherProvider weatherProvider = null;
	private static String[] weather;

	private WeatherProvider()
	{
		weather = new String[4];
		weather[0] = "SUN";
		weather[1] = "RAIN";
		weather[2] = "FOG";
		weather[3] = "SNOW";
	}

	public static WeatherProvider getProvider()
	{
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		return weather[Math.abs(coordinates.getLongitude() + coordinates.getLatitude() * 7 + coordinates.getHeight()) % 4];
	}
}