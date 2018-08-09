# Demo Spring boot project
[![CircleCI](https://circleci.com/gh/malmike/DemoSpringApplication.svg?style=svg)](https://circleci.com/gh/malmike/DemoSpringApplication)
[![Maintainability](https://api.codeclimate.com/v1/badges/42560be30c5278a9c5a8/maintainability)](https://codeclimate.com/github/malmike/DemoSpringApplication/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/42560be30c5278a9c5a8/test_coverage)](https://codeclimate.com/github/malmike/DemoSpringApplication/test_coverage)

This is a demo API built with spring boot.

To run this application you will be expected to have Java jdk1.8.*
([OSX](https://www.lonecpluspluscoder.com/2017/04/27/installing-java-8-jdk-os-x-using-homebrew/),
[linux](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04),
[windows](https://www.guru99.com/install-java.html)) and maven
([OSX](https://stackoverflow.com/questions/8826881/maven-install-on-mac-os-x),
[linux](https://www.mkyong.com/maven/how-to-install-maven-in-ubuntu/),
[windows](https://www.mkyong.com/maven/how-to-install-maven-in-windows/)) installed.

To view the test coverage you would need to install sonar
([OSX](http://macappstore.org/sonar/),
[linux](https://www.digitalocean.com/community/tutorials/how-to-ensure-code-quality-with-sonarqube-on-ubuntu-16-04),
[windows](https://docs.sonarqube.org/display/SONAR/Installing+the+Server))

[Clone the project](https://github.com/malmike/DemoSpringApplication.git) and change to that directory using `cd directory_name`

You can run the project using:
- Build project `mvn clean install`/ `mvn clean package`. This will also run the tests. To view cover you have to run `mvn sonar:sonar`
- Run the application using `java -jar target/demo-0.0.1-SNAPSHOT.jar`
- To access the Swagger documentation go to `http://localhost:8081/demo_api/swagger-ui.html`