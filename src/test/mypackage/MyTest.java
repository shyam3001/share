package test.mypackage;

import main.mypackage.MyLogic;
import static org.junit.Assert.*; 
import org.junit.Test;  
  
public class MyTest {
  
    @Test  
    public void testHello(){  
        MyLogic myLogic = new MyLogic();
		assertEquals("hello", myLogic.sayHello());
    }  

    @Test  
    public void testValue(){  
        MyLogic myLogic = new MyLogic();
		assertEquals(10, myLogic.getValue());
    }  
}
