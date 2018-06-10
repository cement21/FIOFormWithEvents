public class Person {
    private String surname;
    private String firstName;
    private String patronymic;

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    void clearPerson(){
        setSurname(null);
        setFirstName(null);
        setPatronymic(null);
    }
}
