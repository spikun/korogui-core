package ee.korogui.core.resourceBundler;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class PropertieFileLoader {

    public static PropertieFile load(File file) throws Exception {
        PropertieFileReader reader = new PropertieFileReader(file);
        
        Map<String,String> messages = new HashMap<String, String>();
        String line;
        
        while ((line = reader.nextLine()) != null) {
            String[] array = line.trim().split("=", 2);
            if(array.length == 2)
                messages.put(array[0], array[1]);
        }

        return new PropertieFile(messages);
    }

    public static PropertieFile load(InputStream file) throws Exception {
        PropertieFileReader reader = new PropertieFileReader(file);
        
        Map<String,String> messages = new HashMap<String, String>();
        String line;
        
        while ((line = reader.nextLine()) != null) {
            String[] array = line.trim().split("=", 2);
            if(array.length == 2)
                messages.put(array[0], array[1]);
        }

        return new PropertieFile(messages);
    }
}
