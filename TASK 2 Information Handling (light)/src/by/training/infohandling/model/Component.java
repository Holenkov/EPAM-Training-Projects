package by.training.infohandling.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {
	protected List<Component> components = new ArrayList<>();
	private Components composite; 
	
	public void add(Component component) {
		components.add(component);		
	}
	
	public void remove(Component component) {
		components.remove(component);
	}
	
	public Component getChild(int index) {
		Component child = components.get(index);
		return child;
	}
	
	public void setChild(int index, Component component) {
		components.set(index, component);
	}
	
	public int returnSize() {
		return components.size();
	}

	public Components getComposite() {
		return composite;
	}

	public void setComposite(Components composite) {
		this.composite = composite;
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
		result = prime * result + ((composite == null) ? 0 : composite.hashCode());
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
		if (composite != other.composite)
			return false;
		return true;
	}

	
	
	
	
}
