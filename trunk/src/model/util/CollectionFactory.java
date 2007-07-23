package model.util;

import java.util.List;
import java.util.Map;

import persistence.ModelPersistence;

public class CollectionFactory {

	public static <V> List newList() {
		return ModelPersistence.instance().newList();
//		return new ArrayList();
	}

	public static <K, V> Map newMap() {
		return ModelPersistence.instance().newMap();
//		return new HashMap();
	}

}
