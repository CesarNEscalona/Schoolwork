package functions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterProcess
{
    public void register()
    {
        // get inputs, register and save
        Registration registration = generateRegistration();
        registrationValidation(registration);
        saveRegistration(registration);
        sendConfirmationEmail(registration);
    }

    private Registration generateRegistration(){
        String name = readString("First name: ");
        String phone = readString("Phone: ");
        return new Registration(name, phone);
    }

    private void registrationValidation(Registration registration){
        //should match 333-444-5555
        validateField("\\d{3}-\\d{3}-\\d{4}", registration.getPhone(),
                "Phone must be the following format: 333-444-5555");
    }

    private void validateField(String pattern, String field, String errorMessage){
        Pattern check = Pattern.compile(pattern);
        Matcher matcher = check.matcher(field);
        if (!matcher.matches())
        {
            throw new IllegalStateException(errorMessage);
        }
    }

    private void sendConfirmationEmail(Registration registration){
        String htmlSubject = "New Registration: " + registration.getName();
        String htmlBody = "Id: " + getGenerateRegistrationId() +
                registration.toString();

        sendEmail(htmlSubject, htmlBody);
    }



    private void sendEmail(String htmlSubject, String htmlBody)
    {
        //do something...
    }

    private String getGenerateRegistrationId()
    {
        return null; //do something...
    }

    private void saveRegistration(Registration registration)
    {
        //do something...
    }

    private String readString(String s)
    {
        return null; //do something...
    }
}