package calculator;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends JFrame {
    private JLabel equation;
    private JLabel result;

    Functions functions = new Functions();
    private boolean evaluatedEquation = false;

    public Calculator() {
        initWindow();
        setVisible(true);
    }

    private void initWindow() {
        setWindowProperties();
        setEquationLabel();
        setResultLabel();
        for (Buttons button : Buttons.values()) {
            add(createButton(button));
        }
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
    private void setEquationLabel() {
        equation = new JLabel();
        equation.setName("EquationLabel");
        equation.setBounds(10, 95, 230, 30);
        equation.setHorizontalAlignment(SwingConstants.RIGHT);
        equation.setBorder(new CompoundBorder(new LineBorder(Color.BLACK, 1),
                new EmptyBorder(5, 5, 5, 5)));
        equation.setBackground(Color.WHITE);
        equation.setOpaque(true);
        this.add(equation);
    }

    private void setResultLabel() {
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

    private JButton createButton(Buttons button) {
        JButton jButton = new JButton();
        jButton.setName(button.getName());
        jButton.setText(button.getText());
        jButton.setBounds(button.getX(), button.getY(),
                button.getWidth(), button.getHeight());
        jButton.addActionListener(new ButtonAction());
        return jButton;
    }

    class ButtonAction extends AbstractAction {
        private final String operatorSymbols = "[\\u002B\\u002D\\u00D7\\u00F7]";
        private final Pattern operators = Pattern.compile(operatorSymbols);

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String pressed = actionEvent.getActionCommand();

            if (evaluatedEquation) {
                equation.setText("");
                evaluatedEquation = false;
            }

            if (operators.matcher(pressed).find()) {
                processOperator(pressed);
            }

            if (pressed.matches("[\\d\\.]")) {
                equation.setText(equation.getText() + pressed);
            }

            if (pressed.equals("Del")) {
                equation.setText(getToLastCharOfString(equation.getText()));
            }

            if (pressed.equals("C")) {
                equation.setText("");
            }

            if (pressed.equals("=")) {
                equation.setText(fixDanglingPeriods(equation.getText()));
                validateEquation();
            }
        }

        /**
         * When an operator has been keyed, ensure it's not the first character of the equation. Also, if two operators
         * are keyed in a row, replace the previous operator with the new operator.
         *
         * @param operator - keyed operator symbol
         */
        private void processOperator(final String operator) {
            String text = equation.getText();

            if (text.length() != 0) {
                if (operators.matcher(text.substring(text.length() - 1)).find()) {  // is last char an operator?
                    text = getToLastCharOfString(text);
                }
                text += operator;
            }

            equation.setText(fixDanglingPeriods(text));
        }

        /**
         * When equals has been pressed, validate the equation before evaluating it to ensure:
         * 1. That the equation doesn't end in an operator
         * 2. It doesn't contain a division by zero anywhere (won't catch a division by zero if zero is the result of an
         *      operation however)
         */
        private void validateEquation() {
            Pattern validEquation = Pattern.compile(operatorSymbols + "$|\\u00F70" + operatorSymbols + "|\\u00F70$");
            // equation end with an operator or have a divide by zero?
            if (validEquation.matcher(equation.getText()).find()) {
                equation.setForeground(Color.RED.darker());
            } else {
                equation.setForeground(Color.BLACK);
                result.setText(functions.parseEquation(equation.getText()));
                evaluatedEquation = true;
            }
        }

        private String getToLastCharOfString(final String text) {
            return text.substring(0, text.length() - 1);
        }

        /**
         * Fix any dangling periods entered by the user. A dangling period is when the user enters a decimal number and
         * leaves off either the leading or trailing zero. (i.e. .65 should be 0.65; 2. should be 2.0)
         * @param equation the text from the equation field to parse
         * @return the fixed String with any dangling periods fixed
         */
        private String fixDanglingPeriods(final String equation) {
            String fixed = equation;

            Matcher danglingPeriod = Pattern.compile("(?<leading>^\\.|" + operatorSymbols + "\\.\\d)|(?<trailing>\\d\\." + operatorSymbols + "|\\d\\.$)").matcher(fixed);
            if (danglingPeriod.find()) {
                if (danglingPeriod.group("leading") != null) {
                    fixed = fixed.substring(0, danglingPeriod.start("leading"))
                            + danglingPeriod.group("leading").replace(".", "0.")
                            + fixed.substring(danglingPeriod.end("leading"));
                }
                
                if (danglingPeriod.group("trailing") != null) {
                    fixed = fixed.substring(0, danglingPeriod.start("trailing"))
                            + danglingPeriod.group("trailing").replace(".", ".0")
                            + fixed.substring(danglingPeriod.end("trailing"));
                }
            }

            return fixed;
        }
    }
}
