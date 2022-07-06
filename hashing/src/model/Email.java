package model;

public class Email
{
    private String message;
    private String sender;

    public Email(String message, String sender)
    {
        this.message = message;
        this.sender = sender;
    }

    public String getMessage()
    {
        return message;
    }

    public String getSender()
    {
        return sender;
    }

    @Override
    public int hashCode()
    {
        return 1;
    }

    @Override
    public String toString()
    {
        return "Email{" +
                "message='" + message + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}