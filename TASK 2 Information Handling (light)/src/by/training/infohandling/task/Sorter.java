package by.training.infohandling.task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.training.infohandling.comparator.ParagraphBySentenceComparator;
import by.training.infohandling.comparator.WordsByLengthComparator;
import by.training.infohandling.model.Component;

public class Sorter implements AbstractSorter{
	private Logger rootLogger = LogManager.getRootLogger();
	
	
	@Override
	public <T extends Comparator<Component>>  void sort(Component component, T comparator) {
		 sort(component, comparator);				
	}
	
	public void sort(Component component, ParagraphBySentenceComparator comparator) {
	//	rootLogger.info("ParagraphBySentenceComparator");
		sort(component, comparator, 0);	
	}
	
	public void sort(Component component, WordsByLengthComparator comparator) {
	//	rootLogger.info("WordsByLengthComparator");
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
