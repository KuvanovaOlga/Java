package kuvanova.Lab7.RoadEx;

import java.util.Random;

public class Car extends Thread
{
	public long getCarNumber()
	{
		return carNumber;
	}
	private boolean carSide = false;
	private long carNumber;
	private static long carsCounter = 0;

	public boolean isMoveSide()
	{
		return moveSide;
	}

	private boolean moveSide;

	public Car()
	{
		this.carNumber = carsCounter++;
		if((carsCounter + 1) % 3 == 0) carSide = !carSide;
		this.moveSide = carSide;
	}

	private void printStatus(String status)
	{
		System.out.println("Машина №" + this.carNumber + " " + status);
	}

	@Override
	public void run()
	{
		//printStatus("приехала");
		Random random = new Random();
		while (true)
		{
			if (Road.tryDrive(this.moveSide, this.carNumber))
			{
				printStatus("едет " + (!this.moveSide ? "вправо" : "влево"));
				try
				{
					Thread.sleep(random.nextInt(3000) + 3000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				printStatus("проехала");
				Road.DriveEnd(this.moveSide, this.carNumber);
				break;
			}
		}
	}
}
