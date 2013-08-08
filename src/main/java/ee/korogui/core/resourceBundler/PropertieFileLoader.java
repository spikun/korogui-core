package ee.korogui.core.resourceBundler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class PropertieFileLoader {

    public static PropertieFile load(File file) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        BufferedReader reader = Files.newBufferedReader(file.toPath(), charset);
        
        Map<String,String> messages = new HashMap<String, String>();
        String line;
        
        while ((line = reader.readLine()) != null) {
            String[] array = line.trim().split("=", 2);
            messages.put(array[0], array[1]);
        }

        return new PropertieFile(messages, file);
    }
}
