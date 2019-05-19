package by.training.infohandling.model;

import java.util.ArrayList;
import java.util.List;

public class TextComposite extends Component{
//protected List<Component> components = new ArrayList<>();
private Components composite;  
	
	
	
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (Component component : components) {
			stringBuilder.append(component.toString());
		}
		return stringBuilder.toString();
	}

	

	
	
	

}
