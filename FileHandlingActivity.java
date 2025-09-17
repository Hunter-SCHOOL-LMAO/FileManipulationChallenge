import java.nio.file.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class FileHandlingActivity {
    public static void main(String[] args) {
        debugFileOperation();
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
        try{
            Files.write(filePath1, message.getBytes());
        }catch (IOException e) {
            // Handle potential exceptions, e.g., if the file already exists or permissions are insufficient
            System.err.println("Error creating file: " + e.getMessage());
        }
        // d. Read and display file contents
        try{
        System.out.println(Files.readString(filePath3));
        }catch (IOException e) {
            // Handle potential exceptions, e.g., if the file already exists or permissions are insufficient
            System.err.println("Error creating file: " + e.getMessage());
        }
        // e. Create backup directory
        File backupDir = new File("Backup");
        backupDir.mkdir();
        // f. Copy contents to backup file
        Path filePath4 = Paths.get("Backup/backup.txt");
        try{
        Files.createFile(filePath4);
        Files.write(filePath4, (Files.readString(filePath1) + Files.readString(filePath2) + Files.readString(filePath3)).getBytes());
        // g. List all files in both directories
        }catch (IOException e) {
            // Handle potential exceptions, e.g., if the file already exists or permissions are insufficient
            System.err.println("Error creating file: " + e.getMessage());
        }
        System.out.println(dir.list().toString() + backupDir.list().toString());
    }
    public static void debugFileOperation(){
        try {
    // Creating a file with an invalid name (forward slash is invalid for file names on many OS)
    File file = new File("fileName.txt");
    
    // Attempting to write to the invalid file
    FileWriter writer = new FileWriter(file);
    writer.write("Will this fail?");
    writer.close();
    } catch (IOException e) {
        System.out.println("An error occurred: " + e.getMessage());
        e.printStackTrace(); 
    }
    }
}