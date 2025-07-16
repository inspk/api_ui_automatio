----------------------
INSTRUCTION
----------------------

----------------------
Run test using maven and custom parameters
----------------------

This method can be used to run all tests described in TestNG.xml using commandline or Jenkins job.

```
mvn "-Dinternal.user.email=internal.user.dyp+cd@gmail.com" "-Dinternal.user.password=Internaluser1!" "-Denvironment.url=https://sit-dyp.hhstechgroup.com" "-Dprovider.email.prefix=provider.dyp" "-Dbrowser=chrome" "-Dhub.url=http://172.31.8.228:4444/wd/hub" clean test
```

Possible values for "browser" parameter:
chrome firefox chromeHeadless - Chore in headless mode remote - Test will be executed on remote Selenium Grid

----------------------
Run test project as test suite.
----------------------

-Add class names in TestNG.xml.

-Right click of mouse on TestNG.xml and click 'Run'.

----------------------
Run test class.
----------------------

-Right click of mouse on class and click 'Run'.

----------------------
Run one test case (method).
----------------------

-Open class.

-Click green arrow on near specific test.

----------------------
Settings:
----------------------
-Java JDK (not less than 8).

-VPN connection.

-Latest version of Chrome.

----------------------
Reports:
----------------------
-reports folder (folder with timestamp). Extent report (HTML format + screenshots).

-video folder (only for failed test cases).

//Sanity Tests (main pre-conditions)

1) Check manual access to email wyoming.sit2@gmail.com Password: Emirates@2019 manually or add other email to enrollment
   test

2) Add png "medicaid" file to "Downloads" local folder for uploading files in enrollments and Appeal tests

3) Verify stability of Get public providers in applications in Swagger:

- Enrollment test uses always verification that NPI is not exist in DB.
- Group affiliation test gets unique NPI from DB.
- Revalidation test gets provider id from DB.

