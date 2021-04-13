package pl.olin44;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSV {
    private final String outputFileName;
    private final String outputSeparator;
    private final String inputSeparator;
    private final String inputFileName;
    private final List<Field> fields;
    private int rowsCount;

    public CSV(String inputFileName, String inputSeparator, String outputFileName, String outputSeparator) throws IOException {
        this.outputFileName = outputFileName;
        this.outputSeparator = outputSeparator;
        this.inputSeparator = inputSeparator;
        this.inputFileName = inputFileName;
        this.fields = new ArrayList<>();
    }

    public void read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        List<String> lines = reader.lines().collect(Collectors.toList());
        this.rowsCount = lines.size();
        for(int i = 0; i < lines.size(); i++){
            String[] fieldValues = lines.get(i).split(inputSeparator);
            for(int j = 0; j < fieldValues.length; j++){
                fields.add(new Field(i, j, fieldValues[j]));
            }
        }
        reader.close();
    }

    public void write() throws IOException {
        FileWriter writer = new FileWriter(outputFileName);
        for(int i = 0; i < rowsCount; i++ ){
            int finalI = i;
            String row = fields.stream()
                    .filter(x -> x.getRow() == finalI)
                    .map(Field::getValue)
                    .collect(Collectors.joining(outputSeparator));
            row += "\r\n";
            writer.write(row);
        }
        writer.close();
    }

    public String getValue(int row, int column) throws Exception {
        Field field = fields.stream()
                .filter(x -> x.getColumn() == column && x.getRow() == row)
                .findFirst()
                .orElseThrow(() -> new Exception("Not found value on row " + row + " and column " + column));
        return field.getValue();
    }

}
