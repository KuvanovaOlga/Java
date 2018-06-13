package magazine;
import edition.Edition;

public class Magazine extends Edition{
    private int circulation;

    public int getСirculation()
    {
        return circulation;
    }
    public void setCirculation(int circulation)
    {
        this.circulation = circulation;
    }

    public Magazine(String name, String author, int year, int number_of_pages, int cost, int circulation)
    {
        super(name, author, year, number_of_pages, cost);
        this.circulation = circulation;
    }

    public Magazine(){super();}

    @Override
    public String toString() {
        return "Журнал " + getName() + ", издатель " + getAuthor() + ", количество страниц " + getNumber_of_pages()
                + ", год выпуска  " + getYear() + ", стоимость: " + getCost() + ";тираж: " + getСirculation();
    }
}
