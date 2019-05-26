package by.training.infohandling.collector;

import by.training.infohandling.model.Component;

/**
 * Public class with method String collectText(Component component).
 */
public class TextCollector {
	/**
	 * Public method collect text from Composite and return it as String.
	 * @param component Composite with text.
	 * @return collected text as String.
	 */
	public String collectText(final Component component) {
		String text = component.toString();
		return text;
	}

}
