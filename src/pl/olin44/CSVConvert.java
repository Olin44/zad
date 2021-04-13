package pl.olin44;

public class CSVConvert {

    public static void main(String[] args) throws Exception {
        String inputFileName = args[0];
        String inputSeparator = args[1];
        String outputFileName = args[2];
        String outputSeparator = args[3];

        if(!isValidFileName(outputFileName) || !isValidFileName(inputFileName)){
            throw new Exception("Invalid file format! Provided: " + outputFileName.substring(outputFileName.indexOf(".")) + " expected: .csv" );
        }

        if(args.length != 4){
            throw new Exception("Invalid args size! Provided: " + args.length + " expected: " + 4);
        }

        CSV csv = new CSV(inputFileName, inputSeparator, outputFileName, outputSeparator);
        csv.read();
        csv.write();

        System.out.println(csv.getValue(1, 2));
        System.out.println(csv.getValue(1, 1));

    }

    private static boolean isValidFileName(String fileName){
        return fileName.contains(".csv");
    }

}
