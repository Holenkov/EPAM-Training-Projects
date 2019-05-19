package by.training.infohandling.model;

import java.util.ArrayList;
import java.util.List;

public class TextComposite extends Component{
protected List<Component> components = new ArrayList<>();
private Components composite;  
	
	@Override
	public void add(Component component) {
		components.add(component);		
	}
	
	@Override
	public void remove(Component component) {
		components.remove(component);
	}
	
	@Override
	public Object getChild(int index) {
		Component child = components.get(index);
		return child;
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

	

	
	
	

}
