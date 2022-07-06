/**
 * This is an example of a Generic class in Java
 */

package genericClass;

public class Data<T> {

    // type T field
    private T element;

    // constructor
    public Data(T element){
        this.element = element;
    }

    // setter
    public void setElement(T element) {
        this.element = element;
    }

    // getter
    public T getElement() {
        return element;
    }

    @Override
    public String toString() {
        return "Data{" +
                "element=" + element +
                '}';
    }
}
