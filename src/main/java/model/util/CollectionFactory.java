package model.util;

import java.util.List;
import java.util.Map;

import persistence.ModelPersistence;

public class CollectionFactory {

	public static <V> List<V> newList() {
		return ModelPersistence.instance().newList();
	}

	public static <K, V> Map<K, V> newMap() {
		return ModelPersistence.instance().newMap();
	}

	public static <K, V> Map<K, V> newIdentityMap() {
		return ModelPersistence.instance().newIdentityMap();
	}
	
}
