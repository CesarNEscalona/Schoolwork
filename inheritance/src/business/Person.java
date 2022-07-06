package business;

// cannot construct a person directly
public abstract class Person implements Comparable<Person>, Printable {
    // fields
    protected String firstName;
    protected String lastName;

    public Person(){
        // call Person(f,l)
        this("Unknown","Unknown");
    }
    public Person(String f, String l){
        firstName = f;
        lastName = l;
    }

    @Override
    public void printInfo() {
        System.out.println(firstName);
    }

    @Override
    public int compareTo(Person other) {
        // thisobj.compareTo(otherobj)
        // if thisobj should come before otherobj
        // return a negative value
        // if thisobj should come after otherobj
        // return a postive value
        // if thisobj equals otherobj
        // return zero
        return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
    }

    public abstract String getFullName();

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
