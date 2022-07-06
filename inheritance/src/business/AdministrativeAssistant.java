package business;

public class AdministrativeAssistant extends Employee {

    public AdministrativeAssistant(String f, String l) {
        super(f, l);
    }

    // override the getHours (allows polymorphism to happen)
    public int getHours() {
        return super.getHours() + 5;
    }

    // AdministrativeAssistant adds the takeDictation method.
    public void takeDictation(String text) {
        System.out.println("Taking dictation of text: " + text);
    }


}
