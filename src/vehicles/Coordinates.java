package vehicles;

public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height)
	{
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public static Coordinates createCoordinates(int longitude, int latitude, int height)
	{
		return new Coordinates(longitude, latitude, height);
	}
}
