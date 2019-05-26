package by.training.infohandling.sorter;

import java.util.Comparator;

import by.training.infohandling.model.Component;

/**
 * Interface with method sort(Component component, T comparator).
 */
public interface AbstractSorter{
	/**
	 * Public method for sort 
	 * @param component
	 * @param comparator
	 */
	public <T extends Comparator<Component>> void sort(Component component, T comparator);
}