import simulator.Simulator;

public class Main
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Usage: java Simulator <scenario file>");
			return;
		}

		Simulator simulator = new Simulator(args[0]);
		simulator.run();
	}
}
