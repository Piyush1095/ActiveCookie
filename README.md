# ActiveCookies

To run this program:

1. Use command cd src/main/java. Because ActiveCookie.java available at this given path.

2. Compile it with javac ActiveCookie.java.
 
3. Execute it with java ActiveCookie -f -d , where is the name of the log file to be processed and is the date in format (yyyy-MM-dd) for which the most      active cookie needs to be determined.

    ex- 'java ActiveCookie -f cookie_log.csv -d 2018-12-09'

4.  If multiple cookies meet that criteria, please return all of them on separate lines
    
    ex-'java ActiveCookie -f multi_cookie_log.csv -d 2018-12-09'

5. To run the test case use command 'mvn clean test'.



