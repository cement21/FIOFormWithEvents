import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame{
    private FullForm fullForm = new FullForm();
    private ShortForm shortForm = new ShortForm();
    private int value = 0;

    public MyFrame() {
        setContentPane(fullForm.getRootPanel());
        setSize(800, 600);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        fullForm.addActionListenerForChangeForm(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fullForm.isFieldsFilledCorrectly()){
                    fullForm.getPersonFromCurrentFormAndSendTo(shortForm);
                    changeFormTo(shortForm.getRootPanel());
                }
            }
        });

        fullForm.addKeyBindingForChangeForm(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fullForm.isFieldsFilledCorrectly()) {
                    fullForm.getPersonFromCurrentFormAndSendTo(shortForm);
                    changeFormTo(shortForm.getRootPanel());
                }
            }
        });

        shortForm.addActionListenerForChangeForm(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shortForm.getPersonFromCurrentFormAndSendTo(fullForm);
                changeFormTo(fullForm.getRootPanel());
            }
        });

        shortForm.addKeyBindingForChangeForm(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shortForm.getPersonFromCurrentFormAndSendTo(fullForm);
                changeFormTo(fullForm.getRootPanel());
            }
        });

        shortForm.addKeyListenerForChangeProgressBarValue(new KeyAdapter() {
            @Override
            public void keyPressed (KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_DELETE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                    value -= 5;
                    shortForm.setProgressBarValue(value);

                }else if (e.getKeyChar() != ' ' && e.getKeyCode() != KeyEvent.VK_DELETE){
                    value += 5;
                    shortForm.setProgressBarValue(value);
                } else if (e.getKeyChar() == ' '){
                    value = shortForm.countWordInTextField() * 33;
                    shortForm.setProgressBarValue(value);
                }
            }
        });
    }

    private void changeFormTo (JPanel panel){
        setContentPane(panel);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

}