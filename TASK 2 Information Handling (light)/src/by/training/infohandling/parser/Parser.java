package by.training.infohandling.parser;


import by.training.infohandling.model.Component;

public abstract class Parser {
	protected Parser nextParcer;
	
	public abstract void parseText(String sourceText, Component component);
	

	public Parser getNextParcer() {
		return nextParcer;
	}

	public void setNextParcer(Parser nextParcer) {
		this.nextParcer = nextParcer;
	}
	
	

}
