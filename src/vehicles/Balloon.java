package vehicles;

import logger.Logger;

public class Balloon extends Aircraft
{

	public Balloon(Long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions()
	{
		String weather = weatherTower.getWeather(coordinates);
		Logger.print(this + ": ");
		switch (weather)
		{
			case "SUN":
				coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
				Logger.println("Let's enjoy the good weather and take some pics.");
				break;
			case "RAIN":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				Logger.println("Damn you rain! You messed up my balloon.");
				break;
			case "FOG":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
				Logger.println("Can't see anything in this fog.");
				break;
			case "SNOW":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
				Logger.println("It's snowing. We're gonna crash.");
				break;
		}
		if (coordinates.getHeight() <= 0)
		{
			Logger.println(this + " landing.");
			weatherTower.unregister(this);
		}
		else if (coordinates.getHeight() > 100)
			coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
	}

}
