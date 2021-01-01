# SeleniumFramework

GUI Run:
`Run testng.xml`

Command Line Run:
`mvn test -Dusername=mngr301491 -Dpassword=savYvuq`
OR
`mvn clean test -DsuiteXmlFile=testng.xml -Dusername=mngr301491 -Dpassword=savYvuq`


Issues and Solutions:
1. TestNG by default disables loading DTD from unsecured Urls. If you need to explicitly load the DTD from a http url, please do so by using the JVM argument [-Dtestng.dtd.http=true]
Solutions:Right Click on the class, select Run--> Run configuration
          By default one testNg class will be generated with same class name under testng option
          Select that class and go to Arguments tab
          In the VM arguments provide -Dtestng.dtd.http=true
          
          To set the JVM arguments in intelliJ, choose Run > Edit Configurations, and add this JVM argument in the VM options section after -ea (which would be there by default.
          
          For more information on editing configurations, please refer to the official documentation here
          
          Added screenshot for easy to find in Intellij
          
          Argument value
          
          -ea -Dtestng.dtd.http=true

