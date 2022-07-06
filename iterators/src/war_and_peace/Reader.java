package war_and_peace;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Reader implements Iterable<String> {
    // instance field for path of Strings
    private String path;

    // default parameterized constructor
    public Reader(String path) {
        this.path = path;
    }

    // implemented method override, return new Iterator
    @Override
    public Iterator<String> iterator() {
        return new StringIterator();
    }

    // Create a encapsulated Iterator that implements Iterator<Type>
    private class StringIterator implements Iterator<String> {
        // instance field scanner obj
        private Scanner reader;

        // default constructor
        private StringIterator() {
            try {
                // try reading the file using the path, using the scanner class
                reader = new Scanner(new FileInputStream(path));
            }
            // if the file is not found, throw exception
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        // override hasNext method from Iterator class
        @Override
        public boolean hasNext() {
            return reader.hasNextLine();
        }

        // override next method from Iterator class
        @Override
        public String next() {
            return reader.nextLine();
        }
    }
}
