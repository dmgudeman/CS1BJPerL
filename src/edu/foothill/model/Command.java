package edu.foothill.model;

/**
 * enumerator class to hold the different command types and
 * make a String for each enum
 * Gudeman
 */

public enum Command {

	ADD ("Add"), DELETE("delete"), PRINT("print"), SAVE("save");
	
  private final String type;
	
	private Command(final String type){
		this.type = type;
	}
	@Override
	public String toString() {
		return type;
	}
}
