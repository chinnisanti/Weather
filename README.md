# Comparator
A test automation project that validates weather information from different sources and enables a comparison between them

**Instructions**

**Eclipse**

1. Open Eclipse and select File > Import.
2. In the import wizard, choose Maven > Existing Maven Projects, then click Next.
3. Select the java-maven-starter-project as the project root directory.
4. Click Finish to complete the import.
5. Select Project > Properties . In Java Build Path, ensure that under the Libraries tab, Modulepath is set to JRE System Library (JavaSE-8). In Java Compiler, ensure that the Use compliance from execution environment 'JavaSE-8' on the 'Java Build Path' checkbox is selected.
Right-click the project in the Project Explorer or Package Explorer and choose Run As > Maven Build.... In the Edit Configuration dialog, create a new configuration . In the Goals field, enter clean:verify  and click on Run

**Config.properties**
1. Config.properties files under src/test/resources have the following parameters defined which are used for the execution :
      - baseURL = https://www.accuweather.com
      - apiKey = ****************************
      - accuweather.api.uri = https://api.openweathermap.org/data/2.5/weather
      - cityState = Delhi,Delhi
      - variance = 6.0 
2. Update the citySate with the value of the city and state(followed by comma) for which you want to compare the temperatue.
3. Update variance with the value that is with in the permissible limit.


**Test Execution**
 - There are 2 test cases currently created
    1. compareWeatherWithinRange - Reads the variance from the config file and the range passed is in a way that it will be with in the permissible range
    2. compareWeatherOutsideRange - Reads the variance from the test method itself(just for variation) and the range passed is in a way that it will be outside the permissible range

**Test Reports**
Extent Report is implemented and it can be found under reports folder.
