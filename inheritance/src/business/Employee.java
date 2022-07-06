package business;

public class Employee extends Person implements Printable {

    private int hours;
    private double salary;
    private int vacayDays;
    private String formColor;

    public Employee(String f, String l){
        super(f,l);
        this.hours = 40;
        this.salary = 40_000;
        this.vacayDays = 10;
        this.formColor = "yellow";
    }

    public Employee() {
        // call its own constructor
        this("Unknown", "Unknown");

    }

    public void printInfo(){
        
    }
    public String getFullName(){
        return lastName + ", " + firstName;
    }

    public int getHours() { return hours; }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getVacayDays() {
        return vacayDays;
    }

    public void setVacayDays(int vacayDays) {
        this.vacayDays = vacayDays;
    }

    public String getFormColor() {
        return formColor;
    }

    public void setFormColor(String formColor) {
        this.formColor = formColor;
    }


}
