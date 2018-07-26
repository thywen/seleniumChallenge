#Test Framework

A simple Framework using common patterns (like the page object and factory pattern)


To run the tests simple use `mvn test`

The standardtest uses a chromedriver however you can also run it with
`mvn test -Pchrome` or `mvn test -Pfirefox`

right now it runs in 2 parallel executions 

And it executes the integration and ui tests at the same time. 


It adds screenshots to failing tests and adds it to the Report under target/surefire-reports