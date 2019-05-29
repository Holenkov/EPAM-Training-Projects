package by.training.infohandling.model;

/**
 * Public class extends of TextComposite.
 * Contains ArrayList of Word Components.
 * ArrayList contains one or two elements: index 0 - word, 1 (if available) - punctuation.
 */

public class TokenComposite extends TextComposite {

	/**
	 Overrided from superclass method.
	 @return value of class field.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Component component : components) {
			stringBuilder.append(component.toString());
		}
		return stringBuilder.toString() + " ";
	}
}
