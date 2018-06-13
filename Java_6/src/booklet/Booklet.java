package booklet;
import edition.Edition;

import java.util.ArrayList;

public class Booklet extends Edition{
    public Booklet(String name, String author, int year, int number_of_pages, int cost)
    {
        super(name, author, year, number_of_pages, cost);

    }

    public Booklet(){
        super();
    }

    ArrayList<Booklet> obj=new ArrayList<Booklet>();

    public Booklet(String logname) {
    }

    public ArrayList<Booklet> getObj() {
        return obj;
    }

    @Override
    public String toString() {
        return "Буклет " + getName() + ", автор " + getAuthor()
                + ", год выпуска  " + getYear() + ", количество страниц: " + getNumber_of_pages() + ", стоимость: " + getCost();
    }
}
