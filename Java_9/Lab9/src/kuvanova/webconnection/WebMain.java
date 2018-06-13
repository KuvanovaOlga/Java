package kuvanova.webconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class WebMain
{
	public static void main(String[] args) throws UnknownHostException
	{
		URL tut = null;
		String urlName = "https://www.facebook.com";
		try
		{
			tut = new URL(urlName);
		} catch (MalformedURLException e)
		{//  некорректно  заданы  протокол,  доменное  имя  или  путь  к  файлу
			e.printStackTrace();
		}
		if (tut == null)
		{
			throw new RuntimeException();
		}
		try (BufferedReader d = new BufferedReader(new InputStreamReader(tut.openStream())))
		{
			String line = "";
			while ((line = d.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}