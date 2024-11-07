USE CASE 1: Find Number of People Speaking Specific Languages (Order by Population)
Goal in Context: As a user, I want to find the number of people who speak specific languages (Chinese, English, Hindi, Spanish, Arabic) and order them from largest to smallest, including the percentage of the world population, so that I can understand the distribution of language speakers globally.

Scope: Population Reporting System.

Level: Primary task.

Preconditions:

SQL database with language and population data is available.
Success End Condition:

A report is generated showing the number of speakers for the specified languages, ordered by population size, with the percentage of the world population displayed.
Failed End Condition:

The report fails to generate due to missing or incomplete data.
Primary Actor: Organization end-user.

Trigger:

A user requests a report on the number of people speaking specific languages.
Main Success Scenario:

The user specifies the languages they want to analyze (Chinese, English, Hindi, Spanish, Arabic).
The system retrieves the population data for each language.
The system calculates the total number of speakers and the percentage of the world population for each language.
The system sorts the languages by the number of speakers from largest to smallest.
The system displays the data, including the total number of speakers and the percentage of the world population for each language.
Extensions:

Data Unavailable: The system informs the user if data for any language is missing or inaccessible.
Sub-Variations:

Report may include additional languages or allow for user-specified languages.
Schedule: Due Date: Final Deployment.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

USE CASE 2: View Population of a City
Goal in Context: As a user, I want to view the population of a city so that I can assess its size and urban density.

Scope: Population Reporting System.

Level: Primary task.

Preconditions:

SQL database with city population data is available.
Success End Condition:

The population of the specified city is displayed.
Failed End Condition:

The population data for the city is not available or the city cannot be found.
Primary Actor: Organization end-user.

Trigger:

A user requests the population of a specific city.
Main Success Scenario:

The user specifies the city they want to view.
The system retrieves the population data for the city from the database.
The system displays the population of the city.
Extensions:

City Not Found: If the city cannot be found in the database, the system informs the user of the error.
Sub-Variations:

The user may request population data for multiple cities at once.
Schedule: Due Date: Final Deployment.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

USE CASE 3: View Population of a District
Goal in Context: As a user, I want to view the population of a district to understand its demographic size.

Scope: Population Reporting System.

Level: Primary task.

Preconditions:

SQL database with district population data is available.
Success End Condition:

The population of the specified district is displayed.
Failed End Condition:

The population data for the district is not available or the district cannot be found.
Primary Actor: Organization end-user.

Trigger:

A user requests the population of a specific district.
Main Success Scenario:

The user specifies the district they want to view.
The system retrieves the population data for the district.
The system displays the population of the district.
Extensions:

District Not Found: If the district cannot be found in the database, the system informs the user of the error.
Sub-Variations:

The user may request population data for multiple districts at once.
Schedule: Due Date: Final Deployment.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

USE CASE 4: View Population of a Country
Goal in Context: As a user, I want to view the population of a country so that I can understand the country’s overall size.

Scope: Population Reporting System.

Level: Primary task.

Preconditions:

SQL database with country population data is available.
Success End Condition:

The population of the specified country is displayed.
Failed End Condition:

The population data for the country is not available or the country cannot be found.
Primary Actor: Organization end-user.

Trigger:

A user requests the population of a specific country.
Main Success Scenario:

The user specifies the country they want to view.
The system retrieves the population data for the country.
The system displays the population of the country.
Extensions:

Country Not Found: If the country cannot be found, the system informs the user.
Sub-Variations:

The user can request population data for multiple countries.
Schedule: Due Date: Final Deployment.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

USE CASE 5: View Population of a Region
Goal in Context: As a user, I want to see the population of a region to evaluate its demographic characteristics.

Scope: Population Reporting System.

Level: Primary task.

Preconditions:

SQL database with regional population data is available.
Success End Condition:

The population of the specified region is displayed.
Failed End Condition:

The population data for the region is unavailable or the region is not found.
Primary Actor: Organization end-user.

Trigger:

A user requests the population of a specific region.
Main Success Scenario:

The user specifies the region they wish to view.
The system retrieves the population data for the region.
The system displays the population of the region.
Extensions:

Region Not Found: The system notifies the user if the region is not found in the database.
Sub-Variations:

The user can request population data for multiple regions.
Schedule: Due Date: Final Deployment.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

USE CASE 6: View Population of a Continent
Goal in Context: As a user, I want to view the population of a continent to understand its overall demographic size.

Scope: Population Reporting System.

Level: Primary task.

Preconditions:

SQL database with continent population data is available.
Success End Condition:

The population of the specified continent is displayed.
Failed End Condition:

The population data for the continent is not available or the continent cannot be found.
Primary Actor: Organization end-user.

Trigger:

A user requests the population of a specific continent.
Main Success Scenario:

The user specifies the continent they wish to view.
The system retrieves the population data for the continent.
The system displays the population of the continent.
Extensions:

Continent Not Found: If the continent cannot be found, the system informs the user of the issue.
Sub-Variations:

The user can request population data for multiple continents.
Schedule: Due Date: Final Deployment.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

USE CASE 7: View Population of the World
Goal in Context: As a user, I want to view the total population of the world so that I can understand the global population size.

Scope: Population Reporting System.

Level: Primary task.

Preconditions:

SQL database with global population data is available.
Success End Condition:

The total world population is displayed.
Failed End Condition:

The total world population data is unavailable.
Primary Actor: Organization end-user.

Trigger:

A user requests the population of the world.
Main Success Scenario:

The user requests the total world population.
The system retrieves the world population data.
The system displays the total world population.
Extensions:

Data Unavailable: If the world population data is unavailable, the system informs the user.
Sub-Variations:

The user may request related statistics, such as the percentage of people living in cities.
Schedule: Due Date: Final Deployment.

SCHEDULE
DUE DATE: Each code review deadline.
