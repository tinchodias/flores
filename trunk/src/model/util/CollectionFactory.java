package model.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionFactory {

	public static <T> Set<T> newSet() {
		return new HashSet<T>();
	}

	public static <K, V> Map<K, V> newMap() {
		return new HashMap<K, V>();
	}

}
