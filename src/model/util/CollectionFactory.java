package model.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionFactory {

	public static List newList() {
//		return ModelPersistence.instance().newList();
		return new ArrayList();
	}

	public static Map newMap() {
//		return ModelPersistence.instance().newMap();
		return new HashMap();
	}

}
