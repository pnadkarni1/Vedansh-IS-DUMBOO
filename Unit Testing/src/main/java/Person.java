public class Person {

    private String firstName;
    private String middleName;
    private String lastName;

    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public boolean hasFullName () {

        return middleName != null && !middleName.equals("") && !middleName.equals(" ");
    }

    private String createFullName () {

        boolean hasFullName = hasFullName();

        if (hasFullName) {

            return String.format("%s %s %s", firstName, middleName, lastName);

        }

        return String.format("%s %s", firstName, lastName);

    }

    public String fullName (){

        return createFullName();

    }

}
