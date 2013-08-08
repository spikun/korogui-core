package ee.korogui.core.resourceBundler;

import java.io.File;
import java.util.Map;

public class PropertieFile {
    Map<String,String> messages;
    File file;

    public PropertieFile(Map<String, String> messages, File file) {
        this.messages = messages;
        this.file = file;
    }
}
