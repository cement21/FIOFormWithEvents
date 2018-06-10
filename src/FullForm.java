import javax.swing.*;

public class FullForm extends Form{
    private JPanel rootPanel;

    private JLabel labelSurname;
    private JLabel labelFirstName;
    private JLabel labelPatronymic;

    private JTextField textFieldSurname;
    private JTextField textFieldFirstName;
    private JTextField textFieldPatronymic;

    private JButton buttonOk;

    private Person person = new Person();

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JTextField getTextFieldSurname() {
        return textFieldSurname;
    }

    public JTextField getTextFieldFirstName() {
        return textFieldFirstName;
    }

    public JTextField getTextFieldPatronymic() {
        return textFieldPatronymic;
    }

    public JButton getButtonOk() {
        return buttonOk;
    }
    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public void setPersonFromTextField(){
        getPerson().setSurname(getTextFieldSurname().getText());
        getPerson().setFirstName(getTextFieldFirstName().getText());
        getPerson().setPatronymic(getTextFieldPatronymic().getText());
    }

    @Override
    public void setPerson(Person person) {
        getPerson().setSurname(person.getSurname());
        getPerson().setFirstName(person.getFirstName());
        getPerson().setPatronymic(person.getPatronymic());
    }

    @Override
    public void fillFormFields() {
        getTextFieldSurname().setText(getPerson().getSurname());
        getTextFieldFirstName().setText(getPerson().getFirstName());
        getTextFieldPatronymic().setText(getPerson().getPatronymic());
    }

    public boolean isFieldsFilledCorrectly(){
        if (getTextFieldFirstName().getText().length() != 0 && getTextFieldSurname().getText().length() != 0){
            if (getTextFieldPatronymic().getText().length() !=0 ) {
                return true;
            } else {
                int option = JOptionPane.showConfirmDialog(
                        getRootPanel(),
                        "Продолжить без отчества",
                        "Warning",
                        JOptionPane.YES_NO_OPTION);
                   return option == JOptionPane.YES_OPTION;
            }
        } else {
            JOptionPane.showMessageDialog(getRootPanel(),
                    "Необходимо ввести фамилию и имя",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

}
