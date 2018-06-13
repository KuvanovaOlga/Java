package kuvanova.Lab7.RoadEx;

import java.util.Random;

public class RoadMain
{
	public static void main(String[] args) throws Exception
	{
		final int studCount = 20;
		Random random = new Random();
		for (int i = 0; i < studCount; i++)
		{
			Car car = new Car();
			Road.AddCar(car.isMoveSide(), car.getCarNumber());
			car.start();
			Thread.sleep(random.nextInt(1000) + 500);
		}
		//Road.PrintRoad();
	}
}
