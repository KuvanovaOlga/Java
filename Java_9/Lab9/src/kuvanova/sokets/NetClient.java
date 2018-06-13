package kuvanova.sokets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NetClient
{
	private static boolean isMainGamer = false;
	static Socket socket = null;
	static BufferedReader br = null;
	static PrintStream ps = null;
	private static boolean isFirstEnter = true;
	static Scanner scanner = null;

	private static void runRecieveMethod()
	{
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				while (true)
				{
					try
					{
						String response = br.readLine();
						if (response.equals("setNewNumber"))
						{
							System.out.println("Enter new number");
						}
						else if(response.equals("setThisMain"))
						{
							isMainGamer = true;
						}
						else if (response.equals("dropMain"))
						{
							isMainGamer = false;
						}
						else System.out.println(response);
						//System.out.println();
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public static void main(String[] args)
	{
		try
		{//  установка  соединения  с  сервером
			//NetServerThread.CreateSocket();
			socket = new Socket(InetAddress.getLocalHost(), 3230);
			ps = new PrintStream(socket.getOutputStream());
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			scanner = new Scanner(System.in);
			String response = null;
			runRecieveMethod();
			while (true)
			{
				if (!isMainGamer || isFirstEnter)
				{
					System.out.println("Enter number");
					int message = scanner.nextInt();
					ps.println(message);
					isFirstEnter = false;
				}
			}
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}