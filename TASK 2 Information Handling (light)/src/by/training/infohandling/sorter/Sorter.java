package by.training.infohandling.sorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import by.training.infohandling.model.Component;
import by.training.infohandling.sorter.comparator.ParagraphBySentenceComparator;
import by.training.infohandling.sorter.comparator.SentenñeBySymbolComparator;
import by.training.infohandling.sorter.comparator.WordsByLengthComparator;

public class Sorter implements AbstractSorter {


	@Override
	public <T extends Comparator<Component>>  void sort(final Component component, final T comparator) {
	}

	public void sort(final Component component, final SentenñeBySymbolComparator comparator) {
		sort(component, comparator, 1);
	}

	public void sort(final Component component, final ParagraphBySentenceComparator comparator) {
		sort(component, comparator, 0);
	}

	public void sort(final Component component, final WordsByLengthComparator comparator) {
		sort(component, comparator, 2);
	}

	private void sort(final Component component, final Comparator<Component> comparator, final int level) {
		if (level == 0) {
			List<Component> components = new ArrayList<>();
			int size = component.returnSize();
			for (int i = 0; i < size; i++) {
				components.add(component.getChild(i));
			}
			components.sort(comparator);
			for (int i = 0; i < size; i++) {
				component.setChild(i, components.get(i));
			}
		} else {
			int size = component.returnSize();
			for (int i = 0; i < size; i++) {
				sort(component.getChild(i), comparator, level - 1);
			}
		}

	}

}
