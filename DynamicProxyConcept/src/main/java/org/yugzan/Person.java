package org.yugzan;


public class Person implements Player{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
	public String playGame(String value) {
    	return this.name + " play the " + value;
	}
    
}
