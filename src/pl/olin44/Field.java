package pl.olin44;

public class Field {
    private final int row;
    private final int column;
    private final String value;

    public Field(int row, int column, String value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Field{" +
                "row=" + row +
                ", column=" + column +
                ", value='" + value + '\'' +
                '}';
    }
}
