package librarian;

import edition.Edition;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import abstractfactory.*;
import library.*;

public class Librarian extends Factory implements ILibrarian {
    private static Librarian _instance = null;

    private Properties props = null;

    private Librarian() {}

    public synchronized static Librarian getInstance() {
        if (_instance == null)
            _instance = new Librarian();
        return _instance;
    }

    public void sort(Library e){
        ArrayList<Edition> ed = e.GetLibrary();
    Collections.sort(ed, new Comparator<Edition>() {
        @Override
        public int compare(Edition e1, Edition e2) {
            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
            return e1.getYear() > e2.getYear() ? -1 : (e1.getYear() > e2.getYear()) ? 1 : 0;
        }
    });

    }

    public Library find(Library e, int kolvo_str) {
        Library fe = new Library();
        for(Edition ed : e.GetLibrary())
        {
            if(ed.getNumber_of_pages() == kolvo_str)
            {
                fe.AddEdition(ed);
            }
        }
        return fe;
    }

    public int totalcost(Library e){
        int totalcount = 0;
        for(Edition ed : e.GetLibrary())
        {
            totalcount += ed.getCost();
        }
        return totalcount;
    }
    @Override
    public Library create(String lib)
    {
        /*if(edition == "Book")
            return new Book();
        if(edition == "Booklet")
            return new Booklet();
        if(edition == "Magazine")
            return new Magazine();*/
        return new Library(lib);

    }
}

