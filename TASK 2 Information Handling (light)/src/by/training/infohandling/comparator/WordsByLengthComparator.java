package by.training.infohandling.comparator;

import java.util.Comparator;
import by.training.infohandling.model.Component;

public class WordsByLengthComparator implements Comparator<Component>{

	@Override
	public int compare(Component o1, Component o2) {
		return o1.getChild(0).returnSize()-o2.getChild(0).returnSize();
	}



}
