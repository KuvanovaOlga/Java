package abstractfactory;

import book.Book;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import edition.Edition;
import booklet.Booklet;
import library.Library;
import magazine.Magazine;


public abstract class Factory {
    public abstract Library create(String lib);
}

