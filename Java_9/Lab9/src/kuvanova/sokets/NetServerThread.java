package kuvanova.sokets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class NetServerThread
{
	public synchronized static int getNumber()
	{
		return number;
	}

	public synchronized static void setNumber(int number)
	{
		System.out.println(number);
		NetServerThread.number = number;
	}

	private static int number;

	public synchronized static boolean getIsFirstGamer()
	{
		return isFirstGamer;
	}

	public synchronized static void setIsFirstGamer(boolean isFirstGamer)
	{
		NetServerThread.isFirstGamer = isFirstGamer;
	}

	private static boolean isFirstGamer = true;

	public synchronized static boolean isMainGamerChanged()
	{
		return mainGamerChanged;
	}

	public synchronized static void setMainGamerChanged(boolean mainGamerChanged)
	{
		NetServerThread.mainGamerChanged = mainGamerChanged;
	}

	private static boolean mainGamerChanged;
	private static int mainPlayerId;

	public static int getMainPlayerId()
	{
		return mainPlayerId;
	}

	public static void setMainPlayerId(int mainPlayerId)
	{
		NetServerThread.mainPlayerId = mainPlayerId;
	}

	private static List<ServerThread> list = null;

	public static void main(String[] args)
	{
		try
		{
			ServerSocket server = new ServerSocket(3230);
			System.out.println("initialized");
			list = new ArrayList<>();
			while(true)
			{
				Socket socket = server.accept();
				System.out.println(socket.getInetAddress().getHostAddress() + "  connected");
				/**  создание  отдельного  потока  для  обмена  данными*  с  соединившимся  клиентом*/
				ServerThread thread = new ServerThread(socket);//  запуск  потока
				list.add(thread);
				for (ServerThread co : list)
				{
					co.PrintClientObject();
				}
				thread.start();
			}
		} catch (IOException e)
		{
			System.err.println(e);
		}
	}

	public static void SendMessage(String message, int id)
	{
		for(ServerThread thread : list)
		{
			if(thread.getClientId() != id)
			{
				thread.RecieveMessage(message);
			}
		}
	}

	public static void RemoveClient(int id)
	{
		list.removeIf(n -> n.getClientId() == id);
	}

	public static void DropMain()
	{
		for(ServerThread thread : list)
		{
			if(thread.getClientId() == mainPlayerId)
			{
				thread.DropthisMain();
				System.out.println(mainPlayerId + " dropped");
				break;
			}
		}
	}

}