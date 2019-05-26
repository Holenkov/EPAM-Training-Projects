package by.training.infohandling.sorter.comparator;

import java.util.Comparator;
import by.training.infohandling.model.Component;

/**
 * Comparator for sort Words(Tokens) in Sentence by length.
 */

public class WordsByLengthComparator implements Comparator<Component> {

	@Override
	public int compare(final Component o1, final Component o2) {

		return o1.getChild(0).returnSize() - o2.getChild(0).returnSize();

	}
}
