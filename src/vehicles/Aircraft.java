package vehicles;

public class Aircraft extends Flyable
{
	protected long		id;
	protected String		name;
	protected Coordinates	coordinates;

	public void updateConditions()
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}

	protected Aircraft(Long p_id, String p_name, Coordinates p_coordinates)
	{
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")";
	}

}
