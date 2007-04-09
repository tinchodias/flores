package model.util;

import java.util.Collection;
import java.util.HashSet;

public class CollectionFactory {

	public static <T> Collection<T> newSet() {
		return new HashSet<T>();
	}

}
