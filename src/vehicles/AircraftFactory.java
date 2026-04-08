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

	// TODOO: fonksiyonun sonundaki throw konusunda diğer fonksiyonlarada göz atılacak (Özellikle scenario reader)
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws InvalidAirCraftTypeException
	{
		idCounter++;
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
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
