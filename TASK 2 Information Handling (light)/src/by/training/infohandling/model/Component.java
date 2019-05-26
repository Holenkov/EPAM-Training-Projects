package by.training.infohandling.model;

/**
 * Interface for work with Composite.
 * Methods: add(Component component), remove(Component component),
 * 			Component getChild(int index), setChild(int index, Component component),
 * 			int returnSize();
 */

public interface Component {

	/** Adds Component to class field List<Component>. */
	void add(Component component);

	/** Remove Component from class field List{@code<Component>}. */
	void remove(Component component);

	/** Return Component with given index from class field List{@code<Component>} */
	Component getChild(int index);

	/** Put Component with given index to class field List{@code<Component>} */
	void setChild(int index, Component component);

	/** Return size of List class field List{@code<Component>} */
	int returnSize();
}
