package tower;

import vehicles.Coordinates;

public class WeatherTower extends Tower
{

	public String getWeather(Coordinates p_Coordinates)
	{
		return WeatherProvider.getProvider().getCurrentWeather(p_Coordinates);
	}

	public void changeWeather()
	{
		this.conditionsChanged();
	}
}
