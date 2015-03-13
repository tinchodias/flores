
```
mvn install assembly:single
```
  1. Create a sample model file:
```
ModelPersistence.instance().open();
ModelPersistence.instance().save(ModelFixture.simpleModel());
ModelPersistence.instance().close();
```
  1. Run from command-line:
```
java -classpath flores-1.2-SNAPSHOT-jar-with-dependencies.jar;flores-1.2-SNAPSHOT.jar ui.MainApplication
```