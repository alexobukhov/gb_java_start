package ru.gb.core_1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {

    private JTextField inputField;

    public ApplicationForm() throws HeadlessException {
        super.setTitle("Calculator v 1.0");
        setBounds(500, 500, 250, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setJMenuBar(createMenu());

        setLayout(new BorderLayout());

        add(createTop(), BorderLayout.NORTH);
        add(createBottom(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        menu.add(new JMenuItem("Clear"));
        JMenuItem exit = menu.add(new JMenuItem("Exit"));
        exit.addActionListener(new ExitButtonListener());

        return menuBar;
    }

    private JPanel createTop() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);

        return top;
    }

    private JPanel createBottom() {
        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        //DIGITS
        JPanel digitsPanel = new JPanel();

        digitsPanel.setLayout(new GridLayout(4, 3));
        ActionListener buttonListener = new ButtonListener(inputField);
        ActionListener equalButtonListener = new EqualButtonListener(inputField);

        for (int i = 1; i <= 10; i++) {
            String buttonTitle = (i == 10) ? "0" : String.valueOf(i);
            JButton btn = new JButton(buttonTitle);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);
        }

        JButton calc = new JButton("=");
        calc.addActionListener(equalButtonListener);
        digitsPanel.add(calc);

        JButton clear = new JButton("C");
        clear.addActionListener(e -> inputField.setText(""));
        digitsPanel.add(clear);

        //OPERATORS
        JPanel advPanel = new JPanel();
        advPanel.setLayout(new GridLayout(4, 1));

        JButton minus = new JButton("-");
        minus.addActionListener(buttonListener);
        advPanel.add(minus);

        JButton plus = new JButton("+");
        plus.addActionListener(buttonListener);
        advPanel.add(plus);

        JButton multiply = new JButton("*");
        multiply.addActionListener(buttonListener);
        advPanel.add(multiply);

        JButton divide = new JButton("%");
        divide.addActionListener(buttonListener);
        advPanel.add(divide);

        //Adding DIGITS and OPERATORS
        bottom.add(digitsPanel);
        bottom.add(advPanel, BorderLayout.WEST);

        return bottom;
    }
}
