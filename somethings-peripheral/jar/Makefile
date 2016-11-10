.PHONY: build clean run

run: target/bar.jar
	java -cp target/bar.jar foo.A

run-executable: target/bar-executable.jar
	java -jar target/bar-executable.jar

target/bar.jar: build
	cd target; jar cf bar.jar foo

target/bar-executable.jar: build
	cd target; jar cfe bar-executable.jar foo.A foo

build: src/foo/A.java src/foo/a/B.java
	javac -d target src/foo/A.java src/foo/a/B.java

clean:
	$(RM) -rf target/foo bar.jar
