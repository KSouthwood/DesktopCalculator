package calculator;

import javax.swing.*;

public class Calculator extends JFrame {
    private JTextField equationField;
    private final JButton equals = new JButton();
    private final JButton zero = new JButton();
    private final JButton one = new JButton();
    private final JButton two = new JButton();
    private final JButton three = new JButton();
    private final JButton four = new JButton();
    private final JButton five = new JButton();
    private final JButton six = new JButton();
    private final JButton seven = new JButton();
    private final JButton eight = new JButton();
    private final JButton nine = new JButton();
    private final JButton add = new JButton();
    private final JButton sub = new JButton();
    private final JButton mul = new JButton();
    private final JButton div = new JButton();

    Functions functions = new Functions();

    public Calculator() {
        initWindow();
        setVisible(true);
    }

    private void initWindow() {
        setWindowProperties();
        add(equationField());
        addButtons();
    }

    /**
     * Set properties for the JFrame
     */
    private void setWindowProperties() {
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(325, 400);
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
        int width = 275;
        int height = 25;

        equationField.setName("EquationTextField");
        equationField.setBounds(centerComponent(width), 25, width, height);
        equationField.setHorizontalAlignment(JTextField.LEFT);

        return equationField;
    }

    private void addButtons() {
        zero.setName(Buttons.ZERO.getName());
        zero.setText(Buttons.ZERO.getText());
        zero.setBounds(Buttons.ZERO.getX(), Buttons.ZERO.getY(),
                Buttons.ZERO.getWidth(), Buttons.ZERO.getHeight());
        zero.addActionListener(e -> equationField.setText(
                equationField.getText() + "0"));
        add(zero);
        
        one.setName(Buttons.ONE.getName());
        one.setText(Buttons.ONE.getText());
        one.setBounds(Buttons.ONE.getX(), Buttons.ONE.getY(),
                Buttons.ONE.getWidth(), Buttons.ONE.getHeight());
        one.addActionListener(e -> equationField.setText(
                equationField.getText() + "1"));
        add(one);
        
        two.setName(Buttons.TWO.getName());
        two.setText(Buttons.TWO.getText());
        two.setBounds(Buttons.TWO.getX(), Buttons.TWO.getY(),
                Buttons.TWO.getWidth(), Buttons.TWO.getHeight());
        two.addActionListener(e -> equationField.setText(
                equationField.getText() + "2"));
        add(two);
        
        three.setName(Buttons.THREE.getName());
        three.setText(Buttons.THREE.getText());
        three.setBounds(Buttons.THREE.getX(), Buttons.THREE.getY(),
                Buttons.THREE.getWidth(), Buttons.THREE.getHeight());
        three.addActionListener(e -> equationField.setText(
                equationField.getText() + "3"));
        add(three);
        
        four.setName(Buttons.FOUR.getName());
        four.setText(Buttons.FOUR.getText());
        four.setBounds(Buttons.FOUR.getX(), Buttons.FOUR.getY(),
                Buttons.FOUR.getWidth(), Buttons.FOUR.getHeight());
        four.addActionListener(e -> equationField.setText(
                equationField.getText() + "4"));
        add(four);
        
        five.setName(Buttons.FIVE.getName());
        five.setText(Buttons.FIVE.getText());
        five.setBounds(Buttons.FIVE.getX(), Buttons.FIVE.getY(),
                Buttons.FIVE.getWidth(), Buttons.FIVE.getHeight());
        five.addActionListener(e -> equationField.setText(
                equationField.getText() + "5"));
        add(five);
        
        six.setName(Buttons.SIX.getName());
        six.setText(Buttons.SIX.getText());
        six.setBounds(Buttons.SIX.getX(), Buttons.SIX.getY(),
                Buttons.SIX.getWidth(), Buttons.SIX.getHeight());
        six.addActionListener(e -> equationField.setText(
                equationField.getText() + "6"));
        add(six);
        
        seven.setName(Buttons.SEVEN.getName());
        seven.setText(Buttons.SEVEN.getText());
        seven.setBounds(Buttons.SEVEN.getX(), Buttons.SEVEN.getY(),
                Buttons.SEVEN.getWidth(), Buttons.SEVEN.getHeight());
        seven.addActionListener(e -> equationField.setText(
                equationField.getText() + "7"));
        add(seven);
        
        eight.setName(Buttons.EIGHT.getName());
        eight.setText(Buttons.EIGHT.getText());
        eight.setBounds(Buttons.EIGHT.getX(), Buttons.EIGHT.getY(),
                Buttons.EIGHT.getWidth(), Buttons.EIGHT.getHeight());
        eight.addActionListener(e -> equationField.setText(
                equationField.getText() + "8"));
        add(eight);
        
        nine.setName(Buttons.NINE.getName());
        nine.setText(Buttons.NINE.getText());
        nine.setBounds(Buttons.NINE.getX(), Buttons.NINE.getY(),
                Buttons.NINE.getWidth(), Buttons.NINE.getHeight());
        nine.addActionListener(e -> equationField.setText(
                equationField.getText() + "9"));
        add(nine);
        
        add.setName(Buttons.ADD.getName());
        add.setText(Buttons.ADD.getText());
        add.setBounds(Buttons.ADD.getX(), Buttons.ADD.getY(),
                Buttons.ADD.getWidth(), Buttons.ADD.getHeight());
        add.addActionListener(e -> equationField.setText(
                equationField.getText() + "+"));
        add(add);
        
        sub.setName(Buttons.SUBTRACT.getName());
        sub.setText(Buttons.SUBTRACT.getText());
        sub.setBounds(Buttons.SUBTRACT.getX(), Buttons.SUBTRACT.getY(),
                Buttons.SUBTRACT.getWidth(), Buttons.SUBTRACT.getHeight());
        sub.addActionListener(e -> equationField.setText(
                equationField.getText() + "-"));
        add(sub);
        
        div.setName(Buttons.DIVIDE.getName());
        div.setText(Buttons.DIVIDE.getText());
        div.setBounds(Buttons.DIVIDE.getX(), Buttons.DIVIDE.getY(),
                Buttons.DIVIDE.getWidth(), Buttons.DIVIDE.getHeight());
        div.addActionListener(e -> equationField.setText(
                equationField.getText() + "/"));
        add(div);

        mul.setName(Buttons.MULTIPLY.getName());
        mul.setText(Buttons.MULTIPLY.getText());
        mul.setBounds(Buttons.MULTIPLY.getX(), Buttons.MULTIPLY.getY(),
                Buttons.MULTIPLY.getWidth(), Buttons.MULTIPLY.getHeight());
        mul.addActionListener(e -> equationField.setText(
                equationField.getText() + "x"));
        add(mul);

        equals.setName(Buttons.EQUALS.getName());
        equals.setText(Buttons.EQUALS.getText());
        equals.setBounds(Buttons.EQUALS.getX(), Buttons.EQUALS.getY(),
                Buttons.EQUALS.getWidth(), Buttons.EQUALS.getHeight());
        equals.addActionListener(e -> equationField.setText(
                functions.parseEquation(equationField.getText())));
        add(equals);
    }

    private int centerComponent(int width) {
        return (this.getWidth() - width) / 2;
    }

}
