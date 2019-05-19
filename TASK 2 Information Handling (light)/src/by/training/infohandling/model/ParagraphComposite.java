package by.training.infohandling.model;


public class ParagraphComposite extends TextComposite{
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Component component : components) {
			stringBuilder.append(component.toString());
		}
		//when sort paragraphs by number of sentences.
//		return stringBuilder.toString() + System.lineSeparator() + System.lineSeparator();
		
		
		return stringBuilder.toString() + System.lineSeparator();
	}
	
	
	



}
