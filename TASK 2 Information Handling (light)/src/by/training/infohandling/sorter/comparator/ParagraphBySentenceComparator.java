package by.training.infohandling.sorter.comparator;

import java.util.Comparator;

/**
 * Comparator for sort Paragraphs by number of Sentences.
 */

import by.training.infohandling.model.Component;

public class ParagraphBySentenceComparator  implements Comparator<Component> {

	@Override
	public int compare(final Component o1, final Component o2) {
		return o1.returnSize() - o2.returnSize();
	}



}
