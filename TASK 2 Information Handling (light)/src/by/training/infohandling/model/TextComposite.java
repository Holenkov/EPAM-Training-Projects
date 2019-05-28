package by.training.infohandling.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Public class implements Component, part of Composite. Parent class for other classes.
 * Contains ArrayList of Paragraph Components.
 */

public class TextComposite implements Component{
	/** Field for store Components of next level of Composite hierarchy. */
	protected List<Component> components = new ArrayList<>();

	/** Adds Component to class field List<Component>. */
	public void add(final Component component) {
		components.add(component);		
	}
	/** Remove Component to class field List{@code<Component>}. */
	public void remove(final Component component) {
		components.remove(component);
	}

	/** Return Component with index index from class field List{@code<Component>}. */
	public Component getChild(final int index) {
		return components.get(index);
	}

	/** Put Component with index index to class field List{@code<Component>}. */
	public void setChild(final int index, final Component component) {
		components.set(index, component);
	}

	/** Return size of List class field List{@code<Component>}. */
	public int returnSize() {
		return components.size();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Component component : components) {
			stringBuilder.append(component.toString());
		}
		return stringBuilder.toString();
	}
}
