package functions;

public class Registration
{
    private String name;
    private String phone;

    public Registration(String name, String phone)
    {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}