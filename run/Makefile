.DEFAULT_GOAL := help

JAVA := /home/felipe/.jdks/corretto-1.8.0_352/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=40103:/opt/intellij-idea-ultimate-edition/bin -Dfile.encoding=UTF-8 -classpath /home/felipe/.jdks/corretto-1.8.0_352/jre/lib/charsets.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/ext/cldrdata.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/ext/dnsns.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/ext/jaccess.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/ext/jfxrt.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/ext/localedata.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/ext/nashorn.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/ext/sunec.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/ext/sunjce_provider.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/ext/sunpkcs11.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/ext/zipfs.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/jce.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/jfr.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/jfxswt.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/jsse.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/management-agent.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/resources.jar:/home/felipe/.jdks/corretto-1.8.0_352/jre/lib/rt.jar:/home/felipe/Documents/Facultad/Duke/duke-lucene/target/classes:/home/felipe/Documents/Facultad/Duke/duke-core/target/classes:/home/felipe/.m2/repository/org/apache/lucene/lucene-core/4.0.0/lucene-core-4.0.0.jar:/home/felipe/.m2/repository/org/apache/lucene/lucene-analyzers-common/4.0.0/lucene-analyzers-common-4.0.0.jar:/home/felipe/.m2/repository/org/apache/lucene/lucene-spatial/4.0.0/lucene-spatial-4.0.0.jar:/home/felipe/.m2/repository/com/spatial4j/spatial4j/0.3/spatial4j-0.3.jar:/home/felipe/.m2/repository/org/apache/lucene/lucene-queries/4.0.0/lucene-queries-4.0.0.jar

help:
	@echo "——————————————————————————————————————————————"
	@echo " Usage: make [options]"
	@echo " Options:"
	@echo "   help:      Show this help message and exit."
	@echo "   genetic:   Run the genetic algorithm."
	@echo "   test:      Run the test."
	@echo "   run:       Run the program."
	@echo "——————————————————————————————————————————————"

genetic:
	${JAVA} no.priv.garshol.duke.genetic.Driver --output=run/train/out.txt --testfile=run/train/train-duke.csv --threads=4 --original=5 run/config.xml

test:
	${JAVA} no.priv.garshol.duke.Duke --showmatches --linkfile=run/test/matches.txt --testfile=run/test/test-duke.csv --threads=4 run/config.xml

train:
	${JAVA} no.priv.garshol.duke.Duke --showmatches --linkfile=run/train/matches.txt --testfile=run/train/train-duke.csv --threads=4 run/config.xml

run:
	${JAVA} no.priv.garshol.duke.Duke --linkfile=matches.txt --threads=4 config.xml
