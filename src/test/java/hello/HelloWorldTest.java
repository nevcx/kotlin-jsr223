package example1;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import org.testng.annotations.*;
import static org.testng.AssertJUnit.*;
 
public class HelloWorldTest {
 
    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }
 
    @Test
    public void kotlinTest() {
        try
        {
            String scriptcode = "\n\nthrow Exception()";
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByExtension("kts");
            engine.eval(scriptcode);
        }
        catch(ScriptException se)
        {
            assertEquals(3, se.getLineNumber());
        }
    }

    @Test
    public void javascriptTest() {
        try
        {
            String scriptcode = "\n\nthrow 'Exception'";
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByExtension("js");
            engine.eval(scriptcode);
        }
        catch(ScriptException se)
        {
            assertEquals(3, se.getLineNumber());
        }
    }
}
