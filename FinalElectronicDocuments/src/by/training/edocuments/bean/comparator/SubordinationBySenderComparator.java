package by.training.edocuments.bean.comparator;

import java.util.Comparator;

import by.training.edocuments.bean.Subordination;

public class SubordinationBySenderComparator implements Comparator<Subordination>{

	@Override
	public int compare(Subordination o1, Subordination o2) {
		return (o1.getSender().getLastName()).compareTo(o2.getSender().getLastName());
	}

}
