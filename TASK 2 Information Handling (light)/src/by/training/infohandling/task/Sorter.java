package by.training.infohandling.task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.training.infohandling.comparator.ParagraphBySentenceComparator;
import by.training.infohandling.comparator.SentenñeBySymbolCompatator;
import by.training.infohandling.comparator.WordsByLengthComparator;
import by.training.infohandling.model.Component;

public class Sorter implements AbstractSorter{
	
	
	@Override
	public <T extends Comparator<Component>>  void sort(Component component, T comparator) {
		 sort(component, comparator);				
	}
	
	public void sort(Component component, SentenñeBySymbolCompatator comparator) {
		sort(component, comparator, 1);	
	}
	
	public void sort(Component component, ParagraphBySentenceComparator comparator) {
		sort(component, comparator, 0);	
	}
	
	public void sort(Component component, WordsByLengthComparator comparator) {
		sort(component, comparator, 2);	
	}
	
	public void sort(Component component, Comparator<Component> comparator, int level) {
		if (level == 0) {
			List<Component> components = new ArrayList<>();
			int size = component.returnSize();
			for(int i = 0; i < size; i++) {
				components.add(component.getChild(i));
			}
			components.sort(comparator);
			for(int i = 0; i < size; i++) {
				component.setChild(i, components.get(i));
			}		
		} else {
			int size = component.returnSize();
			for(int i = 0; i < size; i++) {
				sort(component.getChild(i), comparator, level-1);
			}
		}
		
	}
	
	


	

	

}
