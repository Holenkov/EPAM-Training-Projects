package by.training.infohandling.comparator;

import java.util.Comparator;

import by.training.infohandling.model.Component;

public class ParagraphBySentenceComparator  implements Comparator<Component>{

	@Override
	public int compare(Component o1, Component o2) {
		return o1.returnSize()-o2.returnSize();
	}



}
