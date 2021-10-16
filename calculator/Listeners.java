package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class Listeners extends AbstractAction {
    Functions functions = new Functions();

}

class OperandAction extends Listeners {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        functions.appendEquation(actionEvent.getActionCommand());
    }
}

class EditAction extends Listeners {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String pressed = actionEvent.getActionCommand();

        if (pressed.equals("C")) {
            functions.setEquation("");
        }

        if (pressed.equals(OperatorConstants.DELETE)) {
            String eq = functions.getEquation();
            int newLength = eq.length() - 1;
            functions.setEquation(eq.substring(0, newLength));
        }

        if (pressed.equals("=")) {
            functions.parseEquation();
        }
    }
}

class OperatorAction extends Listeners {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();
        String buttonText = button.getText();
        String buttonName = button.getName();

        if (buttonText.matches(OperatorConstants.OPERATORS)) {
            appendOperator(buttonText);
        }
    }

    private void appendOperator(String buttonText) {
        String equation = functions.getEquation();
        int lastIndex = equation.length() - 1;

        if (equation.isEmpty()) {   // nothing to do if the equation is blank
           return;
        }

        if (equation.substring(lastIndex).matches(OperatorConstants.OPERATORS)) {
            functions.setEquation(equation.substring(0, lastIndex));
        }

        functions.appendEquation(buttonText);
    }
}
