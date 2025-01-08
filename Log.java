import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static Log instance;
    private StringBuilder log;
    
    private Log() {
        log = new StringBuilder();
    }
    
    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }
    
    public void addEntry(String entry) {
        log.append(entry).append("\n");
    }
    
    @Override
    public String toString() {
        return log.toString();
    }
    
    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(log.toString());
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
