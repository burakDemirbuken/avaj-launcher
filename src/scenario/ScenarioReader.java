package scenario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import exceptions.InvalidScenarioException;

public class ScenarioReader
{
	private ArrayList<ScenarioAirCraftFormat> scenarios;
	private int aircraftCount;
	private int simulationCount;

	public ScenarioReader(ArrayList<ScenarioAirCraftFormat> scenarios, int aircraftCount, int simulationCount)
	{
		this.scenarios = scenarios;
		this.aircraftCount = aircraftCount;
		this.simulationCount = simulationCount;
	}

	public static ScenarioReader readScenario(String filePath)
	{
		ArrayList<ScenarioAirCraftFormat> scenarios;
		int aircraftCount;
		int simulationCount;

		scenarios = new ArrayList<>();
		aircraftCount = 0;
		simulationCount = 0;
		if (filePath == null)
			throw new InvalidScenarioException("File path cannot be null");

		if (filePath.trim().isEmpty())
			throw new InvalidScenarioException("File path cannot be empty");

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
				ScenarioAirCraftFormat scenario = ScenarioAirCraftFormat.isValidScenarioFormat(line);
				scenarios.add(scenario);
				aircraftCount++;
			}
			if (aircraftCount == 0)
				throw new InvalidScenarioException("No scenarios found in the file");
		}
		catch (java.io.FileNotFoundException e)
		{
			throw new InvalidScenarioException("Scenario file not found: " + filePath);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			throw new InvalidScenarioException("Unexpected error occurred while reading scenario file");
		}

		return new ScenarioReader(scenarios, aircraftCount, simulationCount);
	}

	public int getAircraftCount()
	{
		return aircraftCount;
	}
	public ArrayList<ScenarioAirCraftFormat> getScenarios()
	{
		return scenarios;
	}
	public int getSimulationCount()
	{
		return simulationCount;
	}
}
