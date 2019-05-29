package by.training.infohandling.model;

/**
 * Public class extends of TextComposite.
 * Contains ArrayList of Letter Components.
 */

public class WordComposite extends TextComposite {

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
		return stringBuilder.toString();
	}
}
