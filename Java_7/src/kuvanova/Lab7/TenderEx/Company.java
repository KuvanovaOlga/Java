package kuvanova.Lab7.TenderEx;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Company extends Thread
{
	private Integer bidId;
	private int price;
	private CyclicBarrier barrier;
	private int attemptsCount;

	public Company(int id, int price, CyclicBarrier barrier)
	{
		this.bidId = id;
		this.price = price;
		this.barrier = barrier; //ждет пока все потоки пройдут, а потом выпол опред действие
		this.attemptsCount = new Random().nextInt(3) + 1;
	}

	public Integer getBidId()
	{
		return bidId;
	}

	public int getPrice()
	{
		return price;
	}

	@Override
	public void run()
	{
		try
		{
			System.out.println("Компания " + this.bidId + " определяет заявку.");
			for (int i = 0; i < attemptsCount; i++)
			{
				Thread.sleep(new Random().nextInt(3000)); // время на раздумье // определение уровня повышения цены
				int delta = new Random().nextInt(100);
				price -= delta;
				if(i > 0) System.out.println("Компания " + this.bidId + " переопределяет заявку.");
				System.out.println("Заявка " + this.bidId + " : " + price);
			}
			this.barrier.await(); //   остановка  у  барьера
			//System.out.println("Подождите..."); // проверить кто выиграл // и оплатить в случае победы ставки
		} catch (BrokenBarrierException e)
		{
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
