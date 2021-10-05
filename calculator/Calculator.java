package calculator;

import javax.swing.*;

public class Calculator extends JFrame {
    JTextField equationField;
    JButton solveButton;
    Functions functions = new Functions();

    public Calculator() {
        initWindow();
        setVisible(true);
    }

    private void initWindow() {
        setWindowProperties();
        add(equationField());
        add(solveButton());
    }

    /**
     * Set properties for the JFrame
     */
    private void setWindowProperties() {
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }

    /**
     * Set properties for the JTextField
     *
     * @return JTextField for the equations
     */
    private JTextField equationField() {
        equationField = new JTextField();
        int width = 200;
        int height = 25;

        equationField.setName("EquationTextField");
        equationField.setBounds(centerComponent(width), 50, width, height);
        equationField.setHorizontalAlignment(JTextField.CENTER);

        return equationField;
    }

    /**
     * Set properties for the JButton
     *
     * @return JButton to solve the entered equation
     */
    private JButton solveButton() {
        solveButton = new JButton();
        int width = 75;
        int height = 30;

        solveButton.setName("Solve");
        solveButton.setBounds(centerComponent(width), this.getHeight() - 75, width, height);
        solveButton.setText("Solve");

        solveButton.addActionListener(e -> equationField.setText(
                functions.parseEquation(equationField.getText())
        ));

        return solveButton;
    }

    private int centerComponent(int width) {
        return (this.getWidth() - width) / 2;
    }

}
