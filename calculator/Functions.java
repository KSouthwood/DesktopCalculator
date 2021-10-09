package calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {
    private final static String OPERATORS = "(?<operator>[\\u002B\\u002D\\u00D7\\u00F7])";
    private final static String OPERANDS = "(?<operand>[-+]?[0-9]*\\.?[0-9]+)";

    String parseEquation(final String equation) {
        return calculateResult(infixToPostfix(equation)).stripTrailingZeros().toPlainString();
    }

    private String infixToPostfix(final String equation) {
        Deque<String> operatorStack = new ArrayDeque<>();
        StringBuilder expression = new StringBuilder();
        Matcher parser = Pattern.compile(OPERATORS + "|" + OPERANDS).matcher(equation);

        while (parser.find()) {
            if (null != parser.group("operand")) {
                expression.append(parser.group("operand")).append(" ");
            }

            String operator = parser.group("operator");
            if (null != operator) {
                while (!operatorStack.isEmpty() && precedence(operator) <= precedence(operatorStack.peek())) {
                    expression.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(operator);
            }
        }

        while (!operatorStack.isEmpty()) {
            expression.append(operatorStack.pop()).append(" ");
        }

        return expression.toString().stripTrailing();
    }

    private int precedence(final String operator) {
        if (operator.equals("\u002B") || operator.equals("\u002D")) {
            return 1;
        }

        if (operator.equals("\u00D7") || operator.equals("\u00F7")) {
            return 2;
        }

        return -1;
    }

    private BigDecimal calculateResult(final String postfix) {
        Deque<BigDecimal> resultStack = new ArrayDeque<>();
        Pattern operator = Pattern.compile(OPERATORS);

        for (String part : postfix.split("\\s")) {
            if (operator.matcher(part).find()) {
                resultStack.push(doOperation(part, resultStack.pop(), resultStack.pop()));
            } else {
                resultStack.push(new BigDecimal(part));
            }
        }

        return resultStack.pop();
    }

    private BigDecimal doOperation(String operator, BigDecimal operand1, BigDecimal operand2) {
        switch (operator) {
            case "\u002B":
                return operand1.add(operand2);
            case "\u002D":
                return operand2.subtract(operand1);
            case "\u00D7":
                return operand1.multiply(operand2);
            case "\u00F7":
                return operand2.divide(operand1, MathContext.DECIMAL32);
            default:
                return BigDecimal.ZERO;
        }
    }

}
