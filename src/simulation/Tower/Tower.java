package simulation.Tower;

import java.util.ArrayList;
import java.util.List;
import simulation.vehicles.Flyable;

public class Tower
{

	List<Flyable> observers;


	public Tower()
	{
		observers = new ArrayList<Flyable>();
	}

	public void register(Flyable p_flyable)
	{
		observers.add(p_flyable);
		System.out.println("Tower says: " + p_flyable + " registered to weather tower.");
	}

	public void unregister(Flyable p_flyable)
	{
		observers.remove(p_flyable);
		System.out.println("Tower says: " + p_flyable + " unregistered from weather tower.");
	}
	 
	protected void conditionsChanged()
	{
		for (Flyable flyable : observers)
		{
			flyable.updateConditions();
			flyable.registerTower((WeatherTower)this);
		}
	}
	
}