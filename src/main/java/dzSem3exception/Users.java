package dzSem3exception;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Users {

    private String userData;
    private String[] userDataParts;
    private String surname;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int phoneNumber;
    private char gender;

    Scanner scanner = new Scanner(System.in);


    public void enterData() throws Exception {

        System.out.println("Введите через пробел фамилию, имя, отчество, дату рождения в формате дд.мм.гггг," +
                "номер телефона в формате 123456789, пол латинскими буквами мужской - m, женский - .f");
        userData = scanner.nextLine();
        userDataParts = userData.split(" ");
        if (userDataParts.length < 6) {
            throw new LengthDataException("Введены не все данные");
        }
        if (userDataParts.length > 6) {
            throw new LengthDataException("Введено больше данных");
        }
    }

    public void parseSurname() throws Exception{
        surname = userDataParts[0];
        Pattern alphaBet = Pattern.compile("^[а-яА-Я]*$");
        boolean lastNameValidator = alphaBet.matcher(surname).find();
        if (!lastNameValidator){
            throw new SurnameNameException("Фамимлия написана не корректно");
        }
    }

    public void parseFirstName() throws Exception {
        firstName = userDataParts[1];
        Pattern alphaBet = Pattern.compile("^[а-яА-Я]*$");
        boolean firstNameValidator = alphaBet.matcher(firstName).find();
        if (!firstNameValidator) {
            throw new FirstNameException("Имя написано не корректно");
        }
    }

    public void parseLastName() throws Exception{
        lastName = userDataParts[2];
        Pattern alphaBet = Pattern.compile("^[а-яА-Я]*$");
        boolean lastNameValidator = alphaBet.matcher(lastName).find();
        if (!lastNameValidator){
            throw new LastNameException("Отчество написана не корректно");
        }
    }
    public void parseDateOfBirth() throws Exception{
        dateOfBirth = userDataParts[3];
        Pattern DATE_FORMAT_PATTERN = Pattern.compile("^\\d{2}.\\d{2}.\\d{4}$");
        boolean dateFormatValidator = DATE_FORMAT_PATTERN.matcher(dateOfBirth).matches();

        if(!dateFormatValidator){
            throw new DateOfBirthException("Дата рождения введена в неверном формате");
        }
    }


    public void parsePhoneNumber() throws Exception {

        try {
            phoneNumber = Integer.parseInt(userDataParts[4]);
        } catch (NumberFormatException e) {
            throw new PhoneNumberException("Не корректно введенный номер телефона");
        }
    }


    public void parseGender() throws Exception {

        gender = userDataParts[5].charAt(0);
        if (gender != 'm' & gender != 'f') {

            throw new Exception("Не корректно введенный пол.");
        }
    }

    public void writeFile() {
        try(FileWriter writer = new FileWriter(surname + ".txt", true)){
            writer.write("<" + surname + ">" + "<" + firstName + ">" + "<" + surname +  ">" +
                    "<" + dateOfBirth +">" + "<" + phoneNumber + ">" + "<" + gender + ">");
            writer.write("\n");
            writer.flush();
        }
        catch (IOException e){
            System.out.println("Ошибка записи в файл" + e.getMessage());
            e.printStackTrace();
        }
    }

}
