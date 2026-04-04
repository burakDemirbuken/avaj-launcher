package simulation.vehicles;

public class Helicopter extends Aircraft
{
	Helicopter(Long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions()
	{
		String weather = weatherTower.getWeather(coordinates);
		switch (weather)
		{
			case "SUN":
				coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
				System.out.println("Helicopter#" + name + "(" + id + "): This is hot.");
				break;
			case "RAIN":
				coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
				System.out.println("Helicopter#" + name + "(" + id + "): It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
				System.out.println("Helicopter#" + name + "(" + id + "): Can't see anything in this fog.");
				break;
			case "SNOW":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
				System.out.println("Helicopter#" + name + "(" + id + "): My rotor is going to freeze!");
				break;
		}
		if (coordinates.getHeight() <= 0)
		{
			System.out.println("Helicopter#" + name + "(" + id + "): landing.");
			weatherTower.unregister(this);
		}
		else if (coordinates.getHeight() > 100)
			coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
	}
}