Coding Club Sign Up!
============
Prerequisites
----------
- Put <a href="https://github.com/jparrondo24/coding-club-signup/blob/develop/Coding-Club/src/mysql-connector-java-5.1.43-bin.jar">this jar file</a> into <your-java-home>/jre/lib/ext/
This is a simple, Java command-line program for users to sign up for the club at Club Fair
--------
Requirements
--------
1. A database to store all of the user's input
2. Two methods for checking for a valid name and Columbus email, respectively
3. A separate program for generating a .txt file with just the emails

Sample Input 1-
------------
First Name: Justin

Last Name: Parrondo

Email: jparrondo20255@columbushs.com


Sample Output 1-
-------------
(stdout):
---------
Thank you for signing up Justin!


(in emails.txt)
--------
jparrondo20255@columbushs.com


Sample Input 2
------------
First Name: lazy

Last Name: guy

Email: lazyguy@gmail.com


Sample Output 2-
----------
(stdout):

Enter your valid Columbus email please!:


*Note that the name lazy guy should be fixed to Lazy Guy before going into the database
