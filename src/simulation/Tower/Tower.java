package simulation.Tower;

import java.util.ArrayList;
import java.util.List;
import simulation.Logger;

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
		p_flyable.registerTower((WeatherTower)this);
		Logger.println("Tower says: " + p_flyable + " registered to weather tower.");
	}

	public void unregister(Flyable p_flyable)
	{
		observers.remove(p_flyable);
		Logger.println("Tower says: " + p_flyable + " unregistered from weather tower.");
	}
	 
	protected void conditionsChanged()
	{
		List<Flyable> currentObservers = new ArrayList<>(observers);
		for (Flyable flyable : currentObservers)
		{
			flyable.updateConditions();
		}
	}
	
}