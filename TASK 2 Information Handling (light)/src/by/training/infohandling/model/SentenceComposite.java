package by.training.infohandling.model;

/**
 * Public class extends of TextComposite.
 * Contains ArrayList of Token Components.
 */
public class SentenceComposite extends TextComposite {

	/**
	 Overrided from superclass method.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Component component : components) {
			stringBuilder.append(component.toString());
		}
		//when sort paragraphs by number of sentences.
		//return stringBuilder.toString() + System.lineSeparator();

		//when sort sentences by words length.
		// return stringBuilder.toString() + "     ";
		return stringBuilder.toString();
	}
}
