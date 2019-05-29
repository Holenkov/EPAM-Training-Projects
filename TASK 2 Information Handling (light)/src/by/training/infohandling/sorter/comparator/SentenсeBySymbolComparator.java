package by.training.infohandling.sorter.comparator;

import java.util.Comparator;
import by.training.infohandling.model.Component;
import by.training.infohandling.model.Symbol;

/**
 * Comparator for sort Sentences in Paragraph by number of given symbol.
 */
public class SentenñeBySymbolComparator implements Comparator<Component> {
	/** Given Symbol for sorting.*/
	private String keySymbol;


	/**
	 * Public constructor for Comparator.
	 * @param keySymbol - given Symbol for sorting.
	 */
	public SentenñeBySymbolComparator(final char keySymbol) {
		super();
		this.keySymbol = String.valueOf(keySymbol);
	}

	@Override
	public int compare(final Component o1, final Component o2) {
		return count(o1, 0) - count(o2, 0);
	}

	private int count(final Component component, int counter) {
		if (component instanceof Symbol) {
			if (((Symbol) component).getLetter().equals(keySymbol)) {
				counter++;
			}
		} else {
			int size = component.returnSize();
			for (int i = 0; i < size; i++) {
				counter = count(component.getChild(i), counter);
			}
		}
		return counter;
	}
}
