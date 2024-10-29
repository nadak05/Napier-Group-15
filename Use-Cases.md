USE CASE: 1 Generate Country Reports
CHARACTERISTIC INFORMATION

Goal in Context:
As an organization end-user, I want to generate a report listing countries by population to analyze population distributions.

Scope:
Population Reporting System.

Level:
Primary task.

Preconditions:
SQL database with country population data is accessible.

Success End Condition:
A country report is generated and ordered by population.

Failed End Condition:
Report generation fails, and no information is available.

Primary Actor:
Organization end-user.

Trigger:
A request for country population information.

MAIN SUCCESS SCENARIO
User specifies the scope of the report (e.g., all countries, by continent, or by region).
System accesses SQL database to retrieve the population data.
Data is ordered by population size and displayed in the report.

EXTENSIONS:
Data unavailable:
System informs the user that population data is not accessible.

SUB-VARIATIONS:
Report filtered by continent or region.

SCHEDULE
DUE DATE: Final Deployment
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

USE CASE: 2 Generate City Reports
CHARACTERISTIC INFORMATION

Goal in Context:
As an organization end-user, I want to generate a report listing cities by population so that I can evaluate urban population densities.

Scope:
Population Reporting System.

Level:
Primary task.

Preconditions:
SQL database with city population data is available.

Success End Condition:
City report is generated and ordered by population.

Failed End Condition:
No report is produced.

Primary Actor:
Organization end-user.

Trigger:
A request for city population information.

MAIN SUCCESS SCENARIO:
User specifies the scope of the report (e.g., all cities, by continent, region, country, or district).
System retrieves city population data from the database.
Data is ordered by population and displayed in the report.

EXTENSIONS:
Database connection error:
System notifies user of connection issue.

SUB-VARIATIONS:
Report filtered by continent, country, or district.

SCHEDULE
DUE DATE: Final Deployment

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

USE CASE: 3 Generate Custom Reports (Top N Countries or Cities)
CHARACTERISTIC INFORMATION

Goal in Context
As an organization end-user, I want to generate a report on the top N most populated countries or cities so that I can focus on highly populated areas.

Scope
Population Reporting System.

Level
Primary task.

Preconditions
SQL database with population data is accessible.

Success End Condition
A report listing the top N most populated countries or cities is generated.

Failed End Condition
No report is produced.

Primary Actor
Organization end-user.

Trigger
User request for the top N populated areas.

MAIN SUCCESS SCENARIO
User specifies the desired report (top N countries or cities) and provides a value for N.
System retrieves population data and sorts it.
System displays only the top N entries in the report.

EXTENSIONS
N exceeds data entries:
System displays all available entries.

SUB-VARIATIONS
Report generated for countries, cities, or capital cities.

SCHEDULE
DUE DATE: Final Deployment

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

USE CASE: 4 Review and Update Contribution Records
CHARACTERISTIC INFORMATION

Goal in Context
As a team member, I want to update the contribution records so that individual efforts are accurately documented for assessment.

Scope
Team Collaboration.

Level
Supporting task.

Preconditions
Team members agree on individual contributions.

Success End Condition
Contribution records are updated and submitted.

Failed End Condition
Contribution records are incomplete or inaccurate.

Primary Actor
Team member.

Trigger
Submission date for each milestone.

MAIN SUCCESS SCENARIO
Team discusses individual contributions to the current milestone.
Team records contributions in a shared spreadsheet.
Spreadsheet is submitted to Moodle with agreed contributions.

EXTENSIONS
Team disagreement on contributions:
Team consults the teaching staff to resolve issues.

SUB-VARIATIONS
Contribution percentages vary per milestone.

SCHEDULE
DUE DATE: Each code review deadline.
