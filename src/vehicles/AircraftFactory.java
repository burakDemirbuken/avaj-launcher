package vehicles;

import exceptions.InvalidAirCraftTypeException;

public class AircraftFactory
{
	private static AircraftFactory instance;
	Long idCounter = 0L;

	private AircraftFactory()
	{
	}

	public static AircraftFactory getInstance()
	{
		if (instance == null)
			instance = new AircraftFactory();
		return instance;
	}

	public Flyable newAircraft(String type, String name, Coordinates coordinates) throws InvalidAirCraftTypeException
	{
		idCounter++;
		switch (type)
		{
			case "Balloon":
				return new Balloon(idCounter, name, coordinates);
			case "Helicopter":
				return new Helicopter(idCounter, name, coordinates);
			case "JetPlane":
				return new JetPlane(idCounter, name, coordinates);
			default:
				throw new InvalidAirCraftTypeException(type);
		}
	}
}
