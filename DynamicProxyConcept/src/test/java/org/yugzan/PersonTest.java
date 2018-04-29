package org.yugzan;

import org.junit.Test;
import org.yugzan.Person;
import org.yugzan.dymamic.DynamicProxy;
import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void canConstructAPersonWithAName() {
        Person person = new Person("Luice");
        assertEquals("Luice", person.getName());
    }
    
    @Test
    public void canrunPlayGameMethod() {
	    DynamicProxy dynamicProxy = new DynamicProxy( new Person("Karolin"));
	    
	    Player proxyPlayer = dynamicProxy.getProxy();

	    assertEquals("Karolin play the WWW Modified by DynamicProxy", proxyPlayer.playGame("WWW"));
    }
    

}
