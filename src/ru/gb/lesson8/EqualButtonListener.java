package ru.gb.lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class EqualButtonListener implements ActionListener {
    private JTextField inputField;

    private ScriptEngine scriptEngine;

    private ScriptEngineManager scriptEngineManager;

    public EqualButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        scriptEngineManager = new ScriptEngineManager();
        scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        try {
            Object result = scriptEngine.eval(inputField.getText());
            inputField.setText(inputField.getText() + "=" + result);
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }
}
