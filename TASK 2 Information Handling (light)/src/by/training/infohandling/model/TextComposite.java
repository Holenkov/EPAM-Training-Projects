package by.training.infohandling.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Public class implements Component, part of Composite. Parent class for other classes.
 * Contains ArrayList of Paragraph Components.
 */

public class TextComposite implements Component {
	/** Field for store Components of next level of Composite hierarchy. */
	protected List<Component> components = new ArrayList<>();

	/** Adds Component to class field List<Component>.
	* @param component needed to add.
	*/
	public void add(final Component component) {
		components.add(component);
	}

	/** Remove Component to class field List{@code<Component>}.
	 * @param component needed to remove.
	 */
	public void remove(final Component component) {
		components.remove(component);
	}

	/** Return Component with index from class field List{@code<Component>}.
	 * @param index of Component;
	 * @return Component with given index.
	 */
	public Component getChild(final int index) {
		return components.get(index);
	}
	
	/** Put Component with index index to class field List{@code<Component>}.
	 * @param component needed to put on List with index.
	 * @param index of Component in List.
	*/
	public void setChild(final int index, final Component component) {
		components.set(index, component);
	}

	/** Return size of List class field List{@code<Component>}.
	 * @return size of List with Child Components.
	 */
	public int returnSize() {
		return components.size();
	}

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
