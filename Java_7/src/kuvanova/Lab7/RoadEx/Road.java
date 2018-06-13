package kuvanova.Lab7.RoadEx;

import java.util.ArrayList;
import java.util.List;

public class Road
{
	public static boolean isIsRoadClear()
	{
		return isRoadClear;
	}

	private static boolean isRoadClear = true;
	private static long carCounter = 0;
	private static long leftSideCarsCount = 0;
	private static long rightSideCarsCount = 0;
	private static boolean carsMoveSide;
	private static long movingCarsCount = 0;
	private static Road road = new Road();
	private static boolean isFirstCar = true;

	public static Road getRoad()
	{
		return road;
	}

	public static synchronized void PrintRoad()
	{
		System.out.println("Машин слева: " + leftSideCarsCount + ", машин справа: " + rightSideCarsCount);
	}

	static List<Long> leftCars = new ArrayList<>();
	static List<Long> rightCars = new ArrayList<>();

	public static void AddCar(boolean Side, long number)
	{
		if (Side)
		{
			rightSideCarsCount++;
			rightCars.add(number);
		}
		else
		{
			leftSideCarsCount++;
			leftCars.add(number);
		}
	}

	private static boolean isCheckSide(boolean side)
	{
		if (side && leftSideCarsCount == 0) return true;
		else if (!side && rightSideCarsCount == 0) return true;
		else return false;
	}

	private static void checkCarsCount()
	{
		carCounter++;
		movingCarsCount++;
		if(carCounter > 2)
		{
			carCounter = 0;
			isRoadClear = false;
			carsMoveSide = !carsMoveSide;
		}
	}

	public static synchronized boolean tryDrive(boolean side, long number)
	{
		if (isFirstCar)
		{
			carsMoveSide = !side;
			isFirstCar = false;
		}
		if (side != carsMoveSide && isRoadClear)
		{
			if (side)
			{
				if (rightCars.get(0) == number)
				{
					if(carCounter == 0) PrintRoad();
					checkCarsCount();
					rightCars.remove(number);
					return true;
				}
			}
			else
			{
				if (leftCars.get(0) == number)
				{
					checkCarsCount();
					leftCars.remove(number);
					return true;
				}
			}
			return false;
		}
		else if(side == carsMoveSide && isCheckSide(side))
		{
			movingCarsCount = 0;
			carCounter = 0;
			checkCarsCount();
			//PrintRoad();
			return true;
		}
		return false;
	}

//	public static synchronized boolean tryDrive(boolean Side)
//	{
//		if (movingCarsCount > 2) return false;
//
//		else
//		{
//			if (isRoadClear && carsMoveSide == Side && carCounter < 3)
//			{
//				PrintRoad();
//				carCounter++;
//				movingCarsCount++;
//				if (carCounter == 3)
//				{
//					isRoadClear = false;
//					carsMoveSide = !carsMoveSide;
//				}
//				return true;
//			}
//			else if (carsMoveSide != Side && (isCheckSide(Side)) && carCounter < 3)
//			{
//				PrintRoad();
//				carCounter++;
//				isRoadClear = false;
//				return true;
//			}
//		}
//		return false;
//	}

	public static synchronized void DriveEnd(boolean side, long number)
	{
		movingCarsCount--;
		if(movingCarsCount == 0)
		{
			isRoadClear = true;
			PrintRoad();
		}
		if (side)
		{
			rightSideCarsCount--;
		}
		else
		{
			leftSideCarsCount--;
		}
		if (leftSideCarsCount == 0 &&  rightSideCarsCount == 0) PrintRoad();
	}
}
