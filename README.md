# Group-10-Assignment-2

Calculator web app developed as part of a CSU33012 Software Engineering group assignment in Trinty College Dublin. 
-------

### Group Members
* Adam Beatty
* Kevin Morley
* Austeja (AJ) Pakulyte
* Zehao Yu

### Member contributions 
* Adam - Unit testing, Maven intergration
* Kevin - Repo owner, calculator functions
* AJ - Calculator functions, debugging, repo management
* Zehao - Docker CD, Web application process



# Configuration for running this web app

1. Download

 * Download Tomcat web server
    https://dlcdn.apache.org/tomcat/tomcat-10/v10.0.27/bin/apache-tomcat-10.0.27.exe

 * Download IntelliJ IDEA
    https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows

  * Download  JDK
     https://download.oracle.com/java/19/latest/jdk-19_windows-x64_bin.exe

2. Configure environment variables

 * JAVA_HOME = ...\...\jdk-19
 * Add    " %JAVA_HOME%\bin"   to PATH
 * CATALINA_HOME = ...\...\apache-tomcat-10.0.12
 * Add    " %CATALINA_HOME%\bin"   to PATH

3. Open this web app project in IntelliJ IDEA

4. Edit Configurations (on the right side of the 'Build Project' button)

    * Clik 'Add New Configuration' -> Clik 'Tomcat server'  -> Clik 'local'
    * Then choose JDK-19 for JRE. 
    * Clik 'Deployment'  -> clik '+' and choose Group-10-Assignment-2\out\artifacts\Web_Calculator_war_exploded
    * Then clik 'ok' and run the web app
    * Search 'http://localhost:8080/Web_Calculator_war_exploded/' in the web 