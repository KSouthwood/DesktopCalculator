package calculator;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Calculator extends JFrame {
    private JLabel equation;
    private JLabel result;

    Functions functions = new Functions();

    public Calculator() {
        initWindow();
        setVisible(true);
    }

    private void initWindow() {
        setWindowProperties();
        setLabels();
        addButtons();
    }

    /**
     * Set properties for the JFrame
     */
    private void setWindowProperties() {
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250, 535);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }

    /**
     * Set properties for the JLabel's
     */
    private void setLabels() {
        equation = new JLabel();
        equation.setName("EquationLabel");
        equation.setBounds(10, 95, 230, 30);
        equation.setHorizontalAlignment(SwingConstants.RIGHT);
        equation.setBorder(new CompoundBorder(new LineBorder(Color.BLACK, 1),
                new EmptyBorder(5, 5, 5, 5)));
        equation.setBackground(Color.WHITE);
        equation.setOpaque(true);
        this.add(equation);

        result = new JLabel();
        result.setName("ResultLabel");
        result.setText("0");
        result.setBounds(10, 10, 230, 75);
        result.setHorizontalAlignment(SwingConstants.RIGHT);
        result.setBorder(new CompoundBorder(new LineBorder(Color.BLACK, 2),
                new EmptyBorder(5, 5, 5, 5)));
        result.setBackground(Color.YELLOW);
        result.setFont(new Font("MONOSPACED", Font.BOLD, 30));
        result.setOpaque(true);
        this.add(result);
    }

    private void addButtons() {
        JButton zero = createButton(Buttons.ZERO);
        add(zero);

        JButton one = createButton(Buttons.ONE);
        add(one);

        JButton two = createButton(Buttons.TWO);
        add(two);

        JButton three = createButton(Buttons.THREE);
        add(three);

        JButton four = createButton(Buttons.FOUR);
        add(four);

        JButton five = createButton(Buttons.FIVE);
        add(five);

        JButton six = createButton(Buttons.SIX);
        add(six);

        JButton seven = createButton(Buttons.SEVEN);
        add(seven);

        JButton eight = createButton(Buttons.EIGHT);
        add(eight);

        JButton nine = createButton(Buttons.NINE);
        add(nine);

        JButton add = createButton(Buttons.ADD);
        add(add);

        JButton sub = createButton(Buttons.SUBTRACT);
        add(sub);

        JButton div = createButton(Buttons.DIVIDE);
        add(div);

        JButton mul = createButton(Buttons.MULTIPLY);
        add(mul);

        JButton dot = createButton(Buttons.DOT);
        add(dot);

        JButton equals = createButton(Buttons.EQUALS);
        equals.addActionListener(e ->
                result.setText(functions.parseEquation(equation.getText())));
        add(equals);

        JButton clear = createButton(Buttons.CLEAR);
        clear.addActionListener(e -> equation.setText(""));
        add(clear);

        JButton delete = createButton(Buttons.DELETE);
        delete.addActionListener(e -> equation
                .setText(equation.getText()
                        .substring(0, equation.getText().length() - 1)));
        add(delete);
    }

    private JButton createButton(Buttons button) {
        JButton jButton = new JButton();
        jButton.setName(button.getName());
        jButton.setText(button.getText());
        jButton.setBounds(button.getX(), button.getY(),
                button.getWidth(), button.getHeight());
        jButton.addActionListener(e -> equation.setText(
                equation.getText() + button.getValue()));
        return jButton;
    }

}
