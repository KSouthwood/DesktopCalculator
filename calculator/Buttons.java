package calculator;

import javax.swing.*;

public enum Buttons {
    ZERO ("Zero", "0", 25, 300, 50, 50),
    ONE ("One", "1", 25, 225, 50, 50),
    TWO ("Two", "2", 100, 225, 50, 50),
    THREE ("Three", "3", 175, 225, 50, 50),
    FOUR ("Four", "4", 25, 150, 50, 50),
    FIVE ("Five", "5", 100, 150, 50, 50),
    SIX ("Six", "6", 175, 150, 50, 50),
    SEVEN ("Seven", "7", 25, 75, 50, 50),
    EIGHT ("Eight", "8", 100, 75, 50, 50),
    NINE ("Nine", "9", 175, 75, 50, 50),
    ADD ("Add", "+", 250, 300, 50, 50),
    SUBTRACT ("Subtract", "-", 250, 225, 50, 50),
    MULTIPLY ("Multiply", "x", 250, 150, 50, 50),
    DIVIDE ("Divide", "/", 250, 75, 50, 50),
    EQUALS ("Equals", "=", 175, 300, 50, 50);

    private final String name;
    private final String text;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    Buttons(String name, String text, int x, int y, int width, int height) {
        this.name = name;
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    JButton getButton() {
        JButton button = new JButton();
        button.setName(this.name);
        button.setText(this.text);
        button.setBounds(this.x, this.y, this.width, this.height);
        return button;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
