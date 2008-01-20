package persistence.util;

import persistence.ModelFixture;
import persistence.ModelPersistence;
import query.QueryFactory;
import query.implementation.natives.NativeQueryFactory;

public class ModelPersistenceFixture {

	public static void mockWithSimpleModel() {
		ModelPersistence.instance(new ModelPersistenceMock(ModelFixture.simpleModel()));
		QueryFactory.instance(new NativeQueryFactory());
	}

	public static void mockWithSimpleModelAndEmptyStore() {
		ModelPersistence.instance(new ModelPersistenceMock(ModelFixture.simpleModelWithEmptyStore()));
		QueryFactory.instance(new NativeQueryFactory());
	}

}
