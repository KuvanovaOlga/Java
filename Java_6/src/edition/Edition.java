package edition;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public abstract class Edition{
    private String name;
    private String author;
    private int year;
    private int number_of_pages;
    private int cost;

    public int getCost()
    {
        return cost;
    }
    public void seCost(int cost)
    {
        this.cost = cost;
    }

    public int getNumber_of_pages()
    {
        return number_of_pages;
    }
    public void setNumber_of_pages(int number_of_pages)
    {
        this.number_of_pages = number_of_pages;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return name;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year = year;
    }

    public Edition(String name, String author, int year, int number_of_pages, int cost)
    {
        this.name = name;
        this.author = author;
        this.year = year;
        this.number_of_pages = number_of_pages;
        this.cost = cost;
    }

    public Edition(){}
}
