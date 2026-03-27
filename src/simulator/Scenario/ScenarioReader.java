package src.simulator.Scenario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import src.simulator.excaptions.InvalidScenarioException;

public class ScenarioReader
{
	public ArrayList<ScenarioFormat> scenarios;
	public int scenarioCount;
	public int simulationCount;

	public ScenarioReader(ArrayList<ScenarioFormat> scenarios, int scenarioCount, int simulationCount)
	{
		this.scenarios = scenarios;
		this.scenarioCount = scenarioCount;
		this.simulationCount = simulationCount;
	}

	public static void readScenario(String filePath)
	{
		ArrayList<ScenarioFormat> scenarios;
		int scenarioCount;
		int simulationCount;

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


			}
		}
		catch (InvalidScenarioException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			throw new InvalidScenarioException("Unexpected error occurred while reading scenario file");
		}
	}	
}
