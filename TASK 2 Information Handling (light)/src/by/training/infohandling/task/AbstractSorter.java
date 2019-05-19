package by.training.infohandling.task;

import java.util.Comparator;

import by.training.infohandling.model.Component;

public interface AbstractSorter{
	
	public <T extends Comparator<Component>> void sort(Component component, T comparator);
}