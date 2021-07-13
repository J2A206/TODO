package model;

import java.util.Comparator;

public class TodoComparator implements Comparator<Todo> {
	@Override
	public int compare(Todo t1, Todo t2) {
		return Integer.parseInt(t1.getPriority()) > Integer.parseInt(t2.getPriority()) ? -1 : 1;
	}
}