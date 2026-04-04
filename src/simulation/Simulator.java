package simulation;

import simulation.Scenario.ScenarioFormat;
import simulation.Scenario.ScenarioReader;
import simulation.Tower.Tower;
import simulation.vehicles.AircraftFactory;

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

		Tower weatherTower = new Tower();
		AircraftFactory aircraftFactory = AircraftFactory.getInstance();

		int scenarioCount = scenarioReader.getScenarioCount();
		int simulationCount = scenarioReader.getSimulationCount();
		// TODO: aircraftları oluşturup simülasyonu başlatıcaksın.
		for (int i = 0; i < scenarioCount; i++)
		{
			try
			{
				
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		
	}

}