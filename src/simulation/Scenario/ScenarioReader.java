package simulation.Scenario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import simulation.exceptions.InvalidScenarioException;

public class ScenarioReader
{
	private ArrayList<ScenarioFormat> scenarios;
	private int scenarioCount;
	private int simulationCount;

	public ScenarioReader(ArrayList<ScenarioFormat> scenarios, int scenarioCount, int simulationCount)
	{
		this.scenarios = scenarios;
		this.scenarioCount = scenarioCount;
		this.simulationCount = simulationCount;
	}

	public static ScenarioReader readScenario(String filePath)
	{
		ArrayList<ScenarioFormat> scenarios;
		int scenarioCount;
		int simulationCount;

		scenarios = new ArrayList<>();
		scenarioCount = 0;
		simulationCount = 0;
		if (filePath == null)
			throw new InvalidScenarioException("File path cannot be null");

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
		{
			String line = reader.readLine();
			if (line == null)
				throw new InvalidScenarioException("Scenario file is empty");
			try
			{
				simulationCount = Integer.parseInt(line.trim());
			}
			catch (NumberFormatException e)
			{
				throw new InvalidScenarioException("First line must be an integer representing the number of simulations");
			}
			if (simulationCount <= 0)
				throw new InvalidScenarioException("Number of simulations must be a positive integer");
			while ((line = reader.readLine()) != null)
			{
				ScenarioFormat scenario = ScenarioFormat.isValidScenarioFormat(line);
				scenarios.add(scenario);
				scenarioCount++;
			}
			if (scenarioCount == 0)
				throw new InvalidScenarioException("No scenarios found in the file");
		}
		catch (InvalidScenarioException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			throw new InvalidScenarioException("Unexpected error occurred while reading scenario file");
		}
		return new ScenarioReader(scenarios, scenarioCount, simulationCount);
	}
	
	public int getScenarioCount()
	{
		return scenarioCount;
	}
	public ArrayList<ScenarioFormat> getScenarios()
	{
		return scenarios;
	}
	public int getSimulationCount()
	{
		return simulationCount;
	}
}
