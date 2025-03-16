import java.io.*;

public class FileRead {
    public static void main(String[] args) {
        String fileName = "test.txt"; // File to read

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Reading file content:");
            while ((line = reader.readLine()) != null) { // Read line by line
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred.");
        }
    }
}
