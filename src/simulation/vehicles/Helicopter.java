package simulation.vehicles;

import simulation.Logger;

public class Helicopter extends Aircraft
{
	Helicopter(Long p_id, String p_name, Coordinates p_coordinates)
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
				coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
				Logger.println("This is hot.");
				break;
			case "RAIN":
				coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
				Logger.println("It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
				Logger.println("Can't see anything in this fog.");
				break;
			case "SNOW":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
				Logger.println("My rotor is going to freeze!");
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