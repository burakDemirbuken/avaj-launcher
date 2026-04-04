package simulation.vehicles;

public class Balloon extends Aircraft
{

	public Balloon(Long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions()
	{
		String weather = weatherTower.getWeather(coordinates);
		switch (weather)
		{
			case "SUN":
				coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
				System.out.println("Balloon#" + name + "(" + id + "): Let's enjoy the good weather and take some pics.");
				break;
			case "RAIN":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				System.out.println("Balloon#" + name + "(" + id + "): Damn you rain! You messed up my balloon.");
				break;
			case "FOG":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
				System.out.println("Balloon#" + name + "(" + id + "): Can't see anything in this fog.");
				break;
			case "SNOW":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
				System.out.println("Balloon#" + name + "(" + id + "): It's snowing. We're gonna crash.");
				break;
		}
		if (coordinates.getHeight() <= 0)
		{
			System.out.println("Balloon#" + name + "(" + id + "): landing.");
			weatherTower.unregister(this);
		}
		else if (coordinates.getHeight() > 100)
			coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
	}

}