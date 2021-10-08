package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {
    String parseEquation(final String equation) {
        Matcher operatorMatcher = Pattern.compile("[-+x\\/]").matcher(equation);
        var operands = getOperands(equation);
        String operator = "";
        if (operatorMatcher.find()) {
            operator = operatorMatcher.group();
        }
        int result = 0;
        switch (operator) {
            case "+":
                result = add(operands);
                break;
            case "-":
                result = subtract(operands);
                break;
            case "x":
                result = multiply(operands);
                break;
            case "/":
                result = divide(operands);
                break;
            default:
                break;
        }

        return String.format("%s=%d", equation, result);
    }

    private int[] getOperands(String equation) {
        Matcher operands = Pattern.compile("\\d+").matcher(equation);
        int[] array = {0, 0};
        int index = 0;
        while (operands.find() && index < 2) {
            array[index] = Integer.parseInt(operands.group());
            index++;
        }
        return array;
    }

    private int add(final int[] arr) {
        return arr[0] + arr[1];
    }

    private int subtract(final int[] arr) {
        return arr[0] - arr[1];
    }

    private int multiply(final int[] arr) {
        return arr[0] * arr[1];
    }

    private int divide(final int[] arr) {
        return arr[0] / arr[1];
    }


}
