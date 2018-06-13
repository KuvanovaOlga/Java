package kuvanova.Lab7.Canteen;

import java.util.Random;

public class Student extends Thread
{
	private static long studCount = 0;
	private long studNumber;

	Student()
	{
		studNumber = studCount;
		System.out.println("Пришёл студент номер " + studCount++);
	}
//start - запускает дочерний поток
//run - описывает действия потока
//yeild - заставляет процессоор переключиться на обработку других потоков.
//поток-демон - поток, работающий в фоновом режиме
//монитор - механизм взаимод и синхронизации прпоцессов, обеспечивающий доступ к нераздеяем ресурсам
	@Override
	public void run()
	{
		Random random = new Random();
		Canteen canteen = Canteen.getCanteen();
		while (true)
		{
			synchronized (canteen)
			{
				if (Canteen.getFreePlaces() == 0)
				{
					try
					{
						System.out.println("Студент №" + studNumber + " ждёт");
						canteen.wait(random.nextInt(6000) + 6000);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
			if (Canteen.trySetPlace())
			{
				System.out.println("Студент №" + studNumber + " занял место");
				Canteen.printCanteen();
				try
				{
					Thread.sleep(random.nextInt(6000) + 6000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				Canteen.leavePlace();
				System.out.println("Студент №" + studNumber + " ушёл");
				Canteen.printCanteen();
				synchronized (canteen)
				{
					canteen.notify();
				}
				break;
			}
		}
	}
}
