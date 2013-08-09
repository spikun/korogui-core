package ee.korogui.core.resourceBundler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class PropertieFileReader {

    private byte[] bytes;
    private int position;
    private final char NEW_LINEN = '\n';
    private final char NEW_LINER = '\r';

    public PropertieFileReader(File file) throws Exception {
        FileInputStream fin = new FileInputStream(file);

        bytes = new byte[fin.available()];
        fin.read(bytes);
        
        fin.close();
        
        position = 0;
    }

    public PropertieFileReader(InputStream file) throws Exception {
        bytes = new byte[file.available()];
        
        file.read(bytes);
        
        position = 0;
    }

    public String nextLine() {
        String line = "";
        
        while(position < bytes.length) {
            char c = (char) bytes[position++];
            
            if(c == NEW_LINEN || c == NEW_LINER || position == bytes.length)
                return line;
            
            line += c;
        }
        
        return null;
    }
    
    public void setInitialPosition(){
        position = 0;
    }
}
