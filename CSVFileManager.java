import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * This class is responsible for reading and writing to CSV files.
 */
public class CSVFileManager {
    /**
     * This method creates a CSV file if it does not exist.
     * @param fileName The name of the CSV file.
     * @return 0 if the file was created successfully, 1 if the file was not created successfully and -1 for any other error.
     */
    public static int createCSVFile(String fileName) {
        try {
            File csvFile = new File(fileName);
            if (csvFile.exists()) {
                return 1;
            } 
            if (csvFile.createNewFile()) {
                return 0;
            } else {
                return -1;
            }
        } catch (IOException e) {
            System.out.println("An error occurred"); // Maybe remove this line?
            return -1;
        }
    }

    /**
     * This method adds a line to a CSV file.
     * @param fileName The name of the CSV file.
     * @param line The line to be added to the CSV file.
     * @return 0 if the line was added successfully, 1 if the line was not added successfully and -1 for any other error.
     */
    public static int addLineToCSVFile(String fileName, String line) {
        try {
            File csvFile = new File(fileName);
            if (!csvFile.exists()) {
                if (createCSVFile(fileName) != 0) {
                    return 1;
                }
            }
            FileWriter csvWriter = new FileWriter(fileName, true);
            csvWriter.write(line + "\n");
            csvWriter.close();
            return 0;
        } catch (IOException e) {
            System.out.println("An error occurred"); // Maybe remove this line?
            return -1;
        }
    }

    /**
     * This method checks if a line exists in a CSV file.
     * @param fileName The name of the CSV file.
     * @param int The id number of the line to be checked.
     * @return true if the line exists in the CSV file, false for any other error / reason.
     */
    public static boolean checkIfLineExistsInCSVFile(String fileName, int idNumber) {
        try {
            File csvFile = new File(fileName);
            if (!csvFile.exists()) {
                    return false;
            }
            Scanner fileReader = new Scanner(csvFile);
            if (fileReader.hasNextLine()) {
                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    String[] parts = line.split(",");
                    int idNumberCheck = Integer.parseInt(parts[0].trim());
                    if (idNumber == idNumberCheck) {
                        fileReader.close();
                        return true;
                    }
                }
            }
            fileReader.close();
            return false;
        } catch (IOException e) {
            System.out.println("An error occurred"); // Maybe remove this line?
            return false;
        }
    }

    /**
     * This method checks if a line exists in a CSV file.
     * @param fileName The name of the CSV file.
     * @param String The id of the line to be checked.
     * @return true if the line exists in the CSV file, false for any other error / reason.
     */
    public static boolean checkIfLineExistsInCSVFile(String fileName, String id) {
        try {
            File csvFile = new File(fileName);
            if (!csvFile.exists()) {
                    return false;
            }
            Scanner fileReader = new Scanner(csvFile);
            if (fileReader.hasNextLine()) {
                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    String[] parts = line.split(",");
                    String idNumberCheck = parts[0].trim();
                    if (id.equals(idNumberCheck)) {
                        fileReader.close();
                        return true;
                    }
                }
            }
            fileReader.close();
            return false;
        } catch (IOException e) {
            System.out.println("An error occurred"); // Maybe remove this line?
            return false;
        }
    }

    /**
     * This method gets a line from a CSV file.
     * @param fileName The name of the CSV file.
     * @param int The id number of the line to be retrieved.
     * @return The line if it exists in the CSV file, null for any other error / reason.
     */
    public static String[] getLineFromCSVFile(String fileName, int idNumber) {
        try {
            File csvFile = new File(fileName);
            if (!csvFile.exists()) {
                    return null;
            }
            Scanner fileReader = new Scanner(csvFile);
            if (fileReader.hasNextLine()) {
                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    String[] parts = line.split(",");
                    int idNumberCheck = Integer.parseInt(parts[0].trim());
                    if (idNumber == idNumberCheck) {
                        fileReader.close();
                        return parts;
                    }
                }
            }
            fileReader.close();
            return null;
        } catch (IOException e) {
            System.out.println("An error occurred"); // Maybe remove this line?
            return null;
        }
    }

    //TODO : add methode to remove line from csv file
    //TODO : add methode to update line from csv file
    //TODO : add methode to read line from csv file
    //TODO : add methode to read all lines from csv file
}
