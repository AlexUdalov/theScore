# README

### What is this repository for?

This repo includes all of the test automation code. It is a maven modules style application and can include multiple
sub-projects.


### How do I get set up?

1. Install java 11 and Maven (recommended via brew)
2. Install Appium
3. Clone this repo
4. Run `mvn clean install -DskipTests=true` (this needs to be run at least once on the entire project)
5. Change folder for apk in  [CapabilitiesManager.java](src%2Ftest%2Fjava%2FCapabilitiesManager.java)
6. Put the apk in this folder
7. Run `mvn test`
