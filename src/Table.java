import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Table<E> {

    private LinkedList<LinkedList<E>> lol;  // list of lists

    public Table(int height, int width) {
        lol = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            LinkedList<E> l = list_null(width);
            lol.add(l);
        }
    }

    public LinkedList<E> list_null(int n) {
        LinkedList<E> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(null);
        }
        return list;
    }

    /**
     * parse from file
     * @param filename
     */
    public Table(String filename) {
        lol = new LinkedList<>();
        File f = new File(filename);
        try {
            Scanner rdr = new Scanner(f);
            int i = 0;
            while (rdr.hasNextLine()) {
                lol.add( new LinkedList<E>());
                String[] tkns = tokenize(rdr.nextLine());
                for (int j = 0; j < tkns.length; j++) {
                    set(i,j,(E) tkns[j]);                // Assume String!!! Change if expecting numbers!!
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println("Ahhhhhh");
        }
    }

    String[] tokenize(String s) {
        return s.split(" ");
    }

    public void set(int i, int j, E data) {
        if (lol.size() <= i)
            return; // check height
        if (lol.get(i).size() < j)
            return; // check width
        if (j == lol.get(i).size())
            lol.get(i).add(data);
        else
            lol.get(i).set(j, data);
    }

    public void setList(int i, LinkedList data) {
        if (lol.size() <= i)
            return; // check height
        if (lol.get(i).size() != data.size())
            return; // check width

        lol.set(i, data);
    }

    public E get(int i, int j) {
        if (i < 0 || j < 0) return null;
        if (lol.size() <= i) return null; // check height
        if (lol.get(i).size() <= j) return null; // check width
        return lol.get(i).get(j);
    }

    public LinkedList<LinkedList<E>> getLol() {
        return lol;
    }

    public static boolean exists(Object o) { return o != null; }

    public void print() {
        for (int i = 0; i < lol.size(); i++) {
            for (int j = 0; j < lol.get(0).size(); j++) {
                Pr.prr(get(i,j) + " ");
            }
            Pr.pr("");
        }
    }

    public void print_asStateTable() {
        Pr.pr("PRINT (" + lol.size() + "x" + lol.get(0).size() + "):\n");
        for (int i = 0; i < lol.size(); i++) {
            for (int j = 0; j < lol.get(0).size(); j++) {
                if (get(i,j) != null)
                    Pr.prr(((State) get(i,j)).get()+" ");
                else Pr.prr("_ ");
            }
            Pr.pr("");
        }
    }

}
