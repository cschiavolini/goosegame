# GooseGame
by Cristiano Schiavolini

Be sure that Maven and Java (version 8 minimum) are installed and on your class path

## Build with Maven
From root folder execute
`mvn clean verify`

## Execute with java
From root folder `java -jar target/goosegame-1.0.0.jar`

## Bonus step
Analyze coverage with `mvn clover:clover` and open, with your favourite browser, the result available at `<root>/target/site/clover/index.html`