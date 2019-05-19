package by.training.infohandling.model;

public class WordComposite extends TextComposite {
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Component component : components) {
			stringBuilder.append(component.toString());
		}
		return stringBuilder.toString();
	}

	
	
}
