
package labpractical01_Stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class WriteStream {
    
    public static void main(String[] args) {
        try {
            OutputStream file = new FileOutputStream("C:\\Users\\Nishan Fernando\\Documents\\NetBeansProjects\\labsheet.txt");
            
            Writer outputwriter = new OutputStreamWriter(file);
            
            outputwriter.write("Hii. My Name is Yasitha Fernando.");
            
            System.out.println("Writing is completed");
            
            outputwriter.close();
        
        }catch (IOException e) {
           e.getStackTrace();
        }
    }
    
}
