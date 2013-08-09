/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.korogui.core.resourceBundler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

/**
 *
 * @author DEV
 */
public class PropertieFileLoaderTest extends TestCase {

    private BufferedWriter writer;
    private File file = new File("C:\\test\\messages.properties");
    
    public PropertieFileLoaderTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        System.out.println("load");
        if(!file.exists()){
            file.delete();
            file.createNewFile();
        }
        Charset charset = Charset.forName("UTF-8");
        writer = Files.newBufferedWriter(file.toPath(), charset);
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testLoadHappyDay() throws Exception {
        writeMessageToFile("code=teste");
        
        PropertieFile result = PropertieFileLoader.load(file);
        
        assertTrue("code", result.messages.containsKey("code"));
        assertTrue("code", result.messages.get("code").equals("teste"));
    }
    
    public void testLoad2Messages() throws Exception {
        writeMessageToFile("code=teste");
        PropertieFile result = PropertieFileLoader.load(file);
        
        assertEquals(result.messages.size(), 1);
        assertTrue("code", result.messages.containsKey("code"));
        assertTrue("code", result.messages.get("code").equals("teste"));
        
        writeMessageToFile("general.save=save");
        result = PropertieFileLoader.load(file);
        
        assertEquals(result.messages.size(), 2);
        assertTrue("code", result.messages.containsKey("general.save"));
        assertTrue("code", result.messages.get("general.save").equals("save"));
    }

    private void writeMessageToFile(String message) throws IOException {
        writer.write(message, 0, message.length());
        writer.newLine();
        writer.flush();
    }
}
