package src.simulator.Scenario;

import src.simulator.excaptions.InvalidScenarioException;

public class ScenarioFormat
{
	public String Type;
	public String Name;
	public int Longitude;
	public int Latitude;
	public int Height;

	public ScenarioFormat(String type, String name, int longitude, int latitude, int height)
	{
		Type = type;
		Name = name;
		Longitude = longitude;
		Latitude = latitude;
		Height = height;
	}

	public static ScenarioFormat isValidScenarioFormat(String line)
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

		return new ScenarioFormat(type, name, longitude, latitude, height);
	}	
}
