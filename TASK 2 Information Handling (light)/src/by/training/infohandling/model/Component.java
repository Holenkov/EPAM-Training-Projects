package by.training.infohandling.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class.
 * Field: List<Component> components
 * Methods: add(Component component), remove(Component component), 
 * 			getChild(int index), setChild(int index, Component component), 
 * 			returnSize();
 */

public abstract class Component {
	protected List<Component> components = new ArrayList<>();
	
	/** Adds Component to class field List<Component> */
	public void add(Component component) {
		components.add(component);		
	}
	/** Remove Component to class field List{@code<Component>} */
	public void remove(Component component) {
		components.remove(component);
	}
	
	/** Return Component with index index from class field List{@code<Component>} */
	public Component getChild(int index) {
		Component child = components.get(index);
		return child;
	}
	
	/** Put Component with index index to class field List{@code<Component>} */
	public void setChild(int index, Component component) {
		components.set(index, component);
	}
	
	/** Return size of List class field List{@code<Component>} */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((components == null) ? 0 : components.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Component other = (Component) obj;
		if (components == null) {
			if (other.components != null)
				return false;
		} else if (!components.equals(other.components))
			return false;
		return true;
	}

	
	
	
	
}
