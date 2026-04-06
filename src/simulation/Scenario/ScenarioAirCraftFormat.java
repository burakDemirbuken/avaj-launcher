package simulation.Scenario;

import simulation.exceptions.InvalidScenarioException;

public class ScenarioAirCraftFormat
{
	public String Type;
	public String Name;
	public int Longitude;
	public int Latitude;
	public int Height;

	public ScenarioAirCraftFormat(String type, String name, int longitude, int latitude, int height)
	{
		Type = type;
		Name = name;
		Longitude = longitude;
		Latitude = latitude;
		Height = height;
		if (this.isValid() == false)
			throw new InvalidScenarioException("Invalid scenario format: " + type + " " + name + " " + longitude + " " + latitude + " " + height);
	}

	public static ScenarioAirCraftFormat isValidScenarioFormat(String line)
	{
		String[] parts = line.split("\\s+");

		if (parts.length != 5)
			throw new InvalidScenarioException("Invalid scenario format: " + line);

		String type = parts[0];
		String name = parts[1];
		int longitude, latitude, height;
		try
		{
			longitude = Integer.parseInt(parts[2]);
			latitude = Integer.parseInt(parts[3]);
			height = Integer.parseInt(parts[4]);
		}
		catch (NumberFormatException e)
		{
			throw new InvalidScenarioException("Invalid scenario format: " + line);
		}

		return new ScenarioAirCraftFormat(type, name, longitude, latitude, height);
	}

	private boolean isValid()
	{
		if ("Balloon".equals(Type) == false && "Helicopter".equals(Type) == false && "JetPlane".equals(Type) == false)
			return false;
		if (Longitude < 0 || Latitude < 0 || Height < 0 || Height > 100)
			return false;
		return true;
	}
}
