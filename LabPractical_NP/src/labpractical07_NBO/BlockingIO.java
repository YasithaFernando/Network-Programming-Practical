
package labpractical07_NBO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BlockingIO {
    
    public static void main(String[] args) {
        
        String sourceFile = "C:\\Users\\Nishan Fernando\\Documents\\NetBeansProjects\\Old.txt";
        String destinationFile = "C:\\Users\\Nishan Fernando\\Documents\\NetBeansProjects\\New01.txt";

        try {
            long startTime = System.currentTimeMillis();
            
            FileInputStream inputStream = new FileInputStream(sourceFile);
            FileOutputStream outputStream = new FileOutputStream(destinationFile);

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.out.println("File copied successfully.");
            System.out.println("Time taken: " + duration + " milliseconds");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    
