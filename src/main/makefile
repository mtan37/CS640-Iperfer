all: Iperfer.class

Iperfer.class: IperferClient.java IperferServer.java Iperfer.java Manager.java ../Exceptions/InvalidArgsException.java ../Exceptions/InvalidPortNumberException.java
	javac $^

clean:
	rm *.class
	rm ../Exceptions/*.class
