package library;

import abstractfactory.*;
import book.*;
import booklet.*;
import edition.*;
import librarian.*;
import magazine.*;

import java.util.ArrayList;

public class Library {
    ArrayList<Edition> librar = new ArrayList<>();

    public void setLibrar(ArrayList<Edition> librar) {
        if (librar == null)
            throw new NullPointerException("Null pointer");
        this.librar = librar;
    }

    public ArrayList<Edition> getLibrar() {
        return librar;
    }

    public void AddEdition(Edition ed) {
        if (ed == null)
            throw new NullPointerException("Null pointer");
        this.librar.add(ed);
    }

    String name;

    public Library(String val) {
        this.name = val;
    }

    public Library(){}
    public ArrayList<Edition> GetLibrary() {
        return this.librar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
