package kuvanova.sokets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

class ServerThread extends Thread
{
	private PrintStream os;  //  передача
	private BufferedReader is;  //  прием
	private InetAddress addr;  //  адрес  клиента

	public boolean isMainPlayer()
	{
		return isMainPlayer;
	}

	private boolean isMainPlayer;

	public int getClientId()
	{
		return clientId;
	}

	private int clientId;
	private static int CLIENTS_COUNT = 0;

	public ServerThread(Socket s) throws IOException
	{
		os = new PrintStream(s.getOutputStream());
		is = new BufferedReader(new InputStreamReader(s.getInputStream()));
		addr = s.getInetAddress();
		clientId = CLIENTS_COUNT++;
	}

	public void setMainPlayer(boolean mainPlayer)
	{
		isMainPlayer = mainPlayer;
	}

	public void run()
	{
		int i = 0;
		int num = 0;
		int yourNum = -1;
		String str = null;
		try
		{
			while(true)
			{
				if (NetServerThread.getIsFirstGamer())
				{
					os.println("setNewNumber");
					NetServerThread.setIsFirstGamer(false);
					NetServerThread.setNumber(Integer.parseInt(is.readLine()));
					os.println("succesfull");
					boolean cheb = NetServerThread.getIsFirstGamer();
					isMainPlayer = true;
					NetServerThread.setMainPlayerId(clientId);
				}
				if ((str = is.readLine()) != null)
				{


					if (!isMainPlayer)
					{
						num = NetServerThread.getNumber();
						yourNum = Integer.parseInt(str);
						if (num == yourNum)
						{
							NetServerThread.DropMain();
							os.println("Gamer №" + clientId + " guessed number");
							os.println("setNewNumber");
							NetServerThread.setNumber(Integer.parseInt(is.readLine()));
							os.println("setThisMain");
							NetServerThread.setMainPlayerId(clientId);
							os.println("succesfull");
							isMainPlayer = true;
						}
						else
						{
							os.println("Gamer №" + clientId + " did not guess number " + str + (yourNum > num ? " >" : " <") + " x");
						}
					}
				}
			}
		} catch (IOException e)
		{//  если  клиент  не  отвечает,  соединение  с  ним  разрывается
			System.err.println("Disconnect");
		} finally
		{
			NetServerThread.RemoveClient(clientId);
			disconnect();    //  уничтожение  потока
		}
	}

	public void PrintClientObject()
	{
		System.out.println("Client №" + clientId);
	}

	public void DropthisMain()
	{
		isMainPlayer = false;
		os.println("dropMain");
	}

	public void RecieveMessage(String message)
	{
		os.println(message);
	}

	public void disconnect()
	{
		try
		{
			if (os != null)
			{
				os.close();
			}
			if (is != null)
			{
				is.close();
			}
			System.out.println(addr.getHostName() + "  disconnecting");
		} catch (IOException ex)
		{
			ex.printStackTrace();
		} finally
		{
			this.interrupt();
		}
	}
}



