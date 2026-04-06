package simulation;

import java.util.ArrayList;

import simulation.Scenario.ScenarioAirCraftFormat;
import simulation.Scenario.ScenarioReader;
import simulation.Tower.Tower;
import simulation.Tower.WeatherTower;
import simulation.vehicles.AircraftFactory;
import simulation.vehicles.Flyable;

public class Simulator
{

	String scenarioFile;

	public Simulator(String scenarioFile)
	{
		this.scenarioFile = scenarioFile;
	}

	public void run()
	{
		ScenarioReader scenarioReader = null;
		try
		{
			scenarioReader = ScenarioReader.readScenario(scenarioFile);	
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}

		WeatherTower weatherTower = new WeatherTower();

		int aircraftCount = scenarioReader.getAircraftCount();
		int simulationCount = scenarioReader.getSimulationCount();
		ArrayList<ScenarioAirCraftFormat> scenarios = scenarioReader.getScenarios();
		for (int i = 0; i < aircraftCount; i++)
		{
			try
			{
				ScenarioAirCraftFormat	scenarioAircraft = scenarios.get(i);

				Flyable aircraft = AircraftFactory.getInstance().newAircraft(
															scenarioAircraft.Type,
															scenarioAircraft.Name,
															scenarioAircraft.Longitude,
															scenarioAircraft.Latitude,
															scenarioAircraft.Height);

				weatherTower.register(aircraft);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		for (int i = 0; i < simulationCount; i++)
		{
			weatherTower.changeWeather();
		}
	}

}