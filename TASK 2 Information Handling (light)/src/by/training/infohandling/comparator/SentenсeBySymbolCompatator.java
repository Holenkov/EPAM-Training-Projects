package by.training.infohandling.comparator;

import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.infohandling.model.Component;
import by.training.infohandling.model.Letter;

public class SentenñeBySymbolCompatator implements Comparator<Component> {
	private String keySymbol;
	
	private static final Logger LOGGER = LogManager.getRootLogger();

	public SentenñeBySymbolCompatator(char keySymbol) {
		super();
		this.keySymbol = String.valueOf(keySymbol);
	}

	@Override
	public int compare(Component o1, Component o2) {
		return count(o1, 0) - count(o2, 0);
	}

	private int count(Component component, int counter) {
		if (!(component instanceof Letter)) {
			int size = component.returnSize();
			for (int i = 0; i < size; i++) {
				counter = count(component.getChild(i), counter);
			}
		} else {
			if (((Letter) component).getLetter().equals(keySymbol)) {
			counter++;
	//		System.out.println(((Letter) component).getLetter() + "   " + counter);
		}
		}
		
		return counter;

		/*
		 * if (level == 0) { if
		 * (((Letter)component).getLetter().equals(keySymbol)) { counter++; } }
		 * else { int size = component.returnSize(); for(int i = 0; i < size;
		 * i++) { count(component.getChild(i), level-1); } }
		 */

	}
}
