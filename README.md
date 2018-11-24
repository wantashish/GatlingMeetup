This is a starter project for creating a basic performance test simulation using Gatling framework with Scala.
The application under test is: 

http://computer-database.gatling.io

There are two examples of user injections (aka. workload profiles) in this project. 
1. Injection for open workload system where there is no control on concurrent users in the system, only rate of user injection is controlled.
2. Injection for closed worload system where users are not injected if number of concurrent users has hit the limit.

Please run the tests one by one to review the comprehensive html test report Gatling can provide as well as to review the difference between the two workload profiles.
