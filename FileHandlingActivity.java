import java.io.*;
import java.nio.file.*;

public class FileHandlingActivity {
    public static void main(String[] args) {
        // a. Create main directory
        File dir = new File("JavaFileSystem");
        dir.mkdir();
        // b. Create three text files
        Path filePath1 = Paths.get("JavaFileSystem/notes.txt"); 
        Path filePath2 = Paths.get("JavaFileSystem/data.txt"); 
        Path filePath3 = Paths.get("JavaFileSystem/logs.txt"); 
   
        //notes.createNewFile();
        try {
            // Create the new file
            Files.createFile(filePath1); 
            Files.createFile(filePath2);
            Files.createFile(filePath3);
        } catch (IOException e) {
            // Handle potential exceptions, e.g., if the file already exists or permissions are insufficient
            System.err.println("Error creating file: " + e.getMessage());
        }
        // c. Write messages to files
        String message = new String("HELP HELP HELP");
        Files.write(Paths.get("JavaFileSystem/notes.txt"), message.getBytes());
        // d. Read and display file contents
        
        // e. Create backup directory
        
        // f. Copy contents to backup file
        
        // g. List all files in both directories
    }
}