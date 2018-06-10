import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

public class ShortForm extends Form{

    private JPanel rootPanel;
    private JLabel labelFIO;
    private JTextField textFieldFIO;
    private JButton buttonOk;
    private JProgressBar progressBar;
    private Person person = new Person();

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JTextField getTextFieldFIO() {
        return textFieldFIO;
    }

    public JButton getButtonOk() {
        return buttonOk;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public void setPersonFromTextField(){
        String[] fio = splitTextField(getTextFieldFIO().getText());
            getPerson().setSurname(fio[0]);
        if (fio.length >= 2)
            getPerson().setFirstName(fio[1]);
        if (fio.length >=3 )
            getPerson().setPatronymic(fio[2]);
    }

    @Override
    public void setPerson(Person person) {
        getPerson().setSurname(person.getSurname());
        getPerson().setFirstName(person.getFirstName());
        getPerson().setPatronymic(person.getPatronymic());
    }

    @Override
    public void fillFormFields() {
        getTextFieldFIO().setText(getPerson().getSurname() + " "
                + getPerson().getFirstName() + " " + getPerson().getPatronymic());
    }

    private String[] splitTextField (String string){
        String[] fragment = Pattern.compile("[^A-Za-zА-ЯЁа-яё\\-']").split(string.trim());
            return fragment;
    }

    public void setProgressBarValue(int value){
        getProgressBar().setValue(value);
    }

    public int getProgressBarValue(){
        return getProgressBar().getValue();
    }

    public void addKeyListenerForChangeProgressBarValue(KeyAdapter keyAdapter){
        getTextFieldFIO().addKeyListener(keyAdapter);
    }

    public int countWordInTextField(){
        return splitTextField(getTextFieldFIO().getText()).length;
    }


}
