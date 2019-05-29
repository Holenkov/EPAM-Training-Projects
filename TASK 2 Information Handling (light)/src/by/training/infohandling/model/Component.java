package by.training.infohandling.model;

/**
 * Interface for work with Composite.
 * Methods: add(Component component), remove(Component component),
 * 			Component getChild(int index), setChild(int index, Component component),
 * 			int returnSize();
 */
public interface Component {

	/** Adds Component to class field List<Component>.
	 * @param component needed to add.
	 * */
	void add(Component component);

	/** Remove Component from class field List{@code<Component>}.
	 * @param component needed to remove.
	 */
	void remove(Component component);

	/** Return Component with index from class field List{@code<Component>}.
	 * @param index of Component;
	 * @return Component with given index.
	 */
	Component getChild(int index);

	/** Put Component with given index to class field List{@code<Component>}.
	 * @param component needed to put on List with index.
	 * @param index of Component in List.
	 */
	void setChild(int index, Component component);

	/** Return size of List class field List{@code<Component>}.
	 * @return size of List with Child Components.
	 */
	int returnSize();
}
