import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public abstract class Form {
    public abstract void setPersonFromTextField();
    public abstract Person getPerson();
    public abstract void setPerson(Person person);
    public abstract void fillFormFields();
    public abstract JPanel getRootPanel();
    public abstract JButton getButtonOk();

    public void getPersonFromCurrentFormAndSendTo(Form form){
        form.getPerson().clearPerson();
        setPersonFromTextField();
        form.setPerson(getPerson());
        form.fillFormFields();
    }

    public void addKeyBindingForChangeForm (AbstractAction abstractAction){
        InputMap inputMap = getRootPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPanel().getActionMap();
        String key = "key";
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_MASK, true), key);
        actionMap.put(key, abstractAction);
    }

    public void addActionListenerForChangeForm(ActionListener actionListener){
        getButtonOk().addActionListener(actionListener);
    }
}
