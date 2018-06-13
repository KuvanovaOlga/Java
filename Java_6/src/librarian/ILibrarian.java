package librarian;

import edition.Edition;
import library.*;

import java.util.ArrayList;

public interface ILibrarian{
   void sort(Library e);
   Library find(Library e, int kolvo_str);
   int totalcost(Library e);
}
