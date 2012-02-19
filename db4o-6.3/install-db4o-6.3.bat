set VERSION=6.3
call mvn install:install-file -Dfile=bloat-1.0.jar -DgroupId=bloat -DartifactId=bloat -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true 
call mvn install:install-file -Dfile=db4o-%VERSION%-java5.jar -DgroupId=db4o -DartifactId=db4o-java5 -Dversion=%VERSION% -Dpackaging=jar -DgeneratePom=true 
call mvn install:install-file -Dfile=db4o-%VERSION%-nqopt.jar -DgroupId=db4o -DartifactId=db4o-nqopt -Dversion=%VERSION% -Dpackaging=jar -DgeneratePom=true 