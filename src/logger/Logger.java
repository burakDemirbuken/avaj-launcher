package logger;

import java.io.FileWriter;

public class Logger
{
	private static Logger logger = null;
	FileWriter fileWriter;

	private Logger()
	{
		try
		{
			fileWriter = new FileWriter("simulation.txt");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public static Logger getLogger()
	{
		if (logger == null)
			logger = new Logger();
		return logger;
	}

	public static void print(String message)
	{
		try
		{
			getLogger().fileWriter.write(message);
			getLogger().fileWriter.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public static void println(String message)
	{
		print(message + "\n");
	}

	public static void close()
	{
		if (logger == null)
			return;
		try
		{
			getLogger().fileWriter.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
}
