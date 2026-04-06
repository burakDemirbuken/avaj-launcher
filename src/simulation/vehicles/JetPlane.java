package simulation.vehicles;

import simulation.Logger;

public class JetPlane extends Aircraft
{
	JetPlane(Long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions()
	{
		String weather = this.weatherTower.getWeather(this.coordinates);
		Logger.print(this + ": ");
		switch (weather)
		{
			case "SUN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
				Logger.println("It's sunny, let's enjoy the good weather and take some pics.");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
				Logger.println("Damn you rain! You messed up my visibility.");
				break;
			case "FOG":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
				Logger.println("It's foggy, I can't see anything!");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
				Logger.println("OMG! Winter is coming!");
				break; 
			default:
				throw new UnsupportedOperationException("Unknown weather condition: " + weather);
		}
		if (this.coordinates.getHeight() <= 0)
		{
			Logger.println(this + " landing.");
			this.weatherTower.unregister(this);
		}
		else if (this.coordinates.getHeight() > 100)
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 100);
	}
}