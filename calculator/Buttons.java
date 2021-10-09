package calculator;

public enum Buttons {
    ZERO ("Zero", "0", Buttons.COL_ONE, Buttons.ROW_FIVE, Buttons.B_WIDTH * 2 + Buttons.B_GAP, Buttons.B_HEIGHT),
    ONE ("One", "1", Buttons.COL_ONE, Buttons.ROW_FOUR, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    TWO ("Two", "2", Buttons.COL_TWO, Buttons.ROW_FOUR, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    THREE ("Three", "3", Buttons.COL_THREE, Buttons.ROW_FOUR, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    FOUR ("Four", "4", Buttons.COL_ONE, Buttons.ROW_THREE, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    FIVE ("Five", "5", Buttons.COL_TWO, Buttons.ROW_THREE, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    SIX ("Six", "6", Buttons.COL_THREE, Buttons.ROW_THREE, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    SEVEN ("Seven", "7", Buttons.COL_ONE, Buttons.ROW_TWO, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    EIGHT ("Eight", "8", Buttons.COL_TWO, Buttons.ROW_TWO, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    NINE ("Nine", "9", Buttons.COL_THREE, Buttons.ROW_TWO, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    ADD ("Add", "\u002B", Buttons.COL_FOUR, Buttons.ROW_FIVE, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    SUBTRACT ("Subtract", "\u002D", Buttons.COL_FOUR, Buttons.ROW_FOUR, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    MULTIPLY ("Multiply", "\u00D7", Buttons.COL_FOUR, Buttons.ROW_THREE, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    DIVIDE ("Divide", "\u00F7", Buttons.COL_FOUR, Buttons.ROW_TWO, Buttons.B_WIDTH, Buttons.B_HEIGHT),
    EQUALS ("Equals", "=", Buttons.COL_ONE, Buttons.ROW_SIX, Buttons.B_WIDTH * 4 + Buttons.B_GAP * 3, Buttons.B_HEIGHT),
    CLEAR ("Clear", "C", Buttons.COL_ONE, Buttons.ROW_ONE, Buttons.B_WIDTH * 2 + Buttons.B_GAP, Buttons.B_HEIGHT),
    DELETE ("Delete", "Del", Buttons.COL_THREE, Buttons.ROW_ONE, Buttons.B_WIDTH * 2 + Buttons.B_GAP, Buttons.B_HEIGHT),
    DOT ("Dot", ".", Buttons.COL_THREE, Buttons.ROW_FIVE, Buttons.B_WIDTH, Buttons.B_HEIGHT);

    private static final int B_HEIGHT = 50;
    private static final int B_WIDTH  = 50;
    private static final int B_GAP    = 10;

    private static final int COL_ONE = 10;
    private static final int COL_TWO = COL_ONE + B_WIDTH + B_GAP;
    private static final int COL_THREE = COL_TWO + B_WIDTH + B_GAP;
    private static final int COL_FOUR = COL_THREE + B_WIDTH + B_GAP;

    private static final int ROW_ONE = 155;
    private static final int ROW_TWO = ROW_ONE + B_HEIGHT + B_GAP;
    private static final int ROW_THREE = ROW_TWO + B_HEIGHT + B_GAP;
    private static final int ROW_FOUR = ROW_THREE + B_HEIGHT + B_GAP;
    private static final int ROW_FIVE = ROW_FOUR + B_HEIGHT + B_GAP;
    private static final int ROW_SIX = ROW_FIVE + B_HEIGHT + B_GAP;

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
