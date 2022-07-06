package colors;

import java.util.Iterator;

public class RgbColor implements Iterable<Integer>{

    private int red;
    private int green;
    private int blue;

    public RgbColor() {
    }

    public RgbColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RgbIterator();
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    @Override
    public String toString() {
        return "{" + red + green + blue + '}';
    }

    private class RgbIterator implements Iterator<Integer> {
        private static final int TOTAL_COMPONENTS = 3;
        private int componentsReturned = 0;

        @Override
        public boolean hasNext() {
            return componentsReturned < TOTAL_COMPONENTS;
        }

        @Override
        public Integer next() {
            if(componentsReturned == 0){
                componentsReturned++;
                return red;
            }
            else if(componentsReturned == 1){
                componentsReturned++;
                return green;
            }
            else if(componentsReturned == 2) {
                componentsReturned++;
                return blue;
            }
            else{
                throw new IllegalStateException(
                        "There are no more components to return");
            }
        }
    }
}
