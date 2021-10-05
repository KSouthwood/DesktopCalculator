package calculator;

import java.util.Arrays;

public class Functions {
    String parseEquation(String equation) {
        var array = Arrays.stream(equation.split("\\+"))
                .mapToInt(Integer::parseInt).toArray();

        return String.format("%s=%d", equation, sum(array));
    }

    int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
