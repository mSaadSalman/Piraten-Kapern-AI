# A1 - Piraten Karpen

  * Author: < Saad Salman >
  * Email: < 28.saadsalman@gmail.com >

## Build and Execution

  * For type of player, first cmd line argument is first player strategy, second cmd line arg is second player's strategy:
    * `Only 2 types of Strategies: random or combo` 
  * To activiate trace mode please type "trace" as you're 3rd arg of program (NO CAPS):
    * `trace`
  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < The definition of Done is when a task with certain requirements and functionality is successfully created with little to no errors along with being reflected from a set of criteria given.  >

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
|     | F01 | Roll a dice |  S | 01/01/23 | 14/01/23 |
| x   | F02 | Rol 8 dices  |  D | 12/01/23  | 15/01/23 |
| x   | F03 | Re-roll until obtaining 3 skulls | D | 12/01/23 | 15/01/23 |
| x   | F04 | Player keeping random dice at their turn  |  D  | 12/01/23  | 15/01/23 |
| x   | F05 | Create 2 players each with rolling turns | D | 13/01/23| 15/01/23 |
| x   | F06 | Count number of diamonds and golds x100  |  D  | 14/01/23  | 15/01/23 |
| x   | F07 | Keep track of players score to determine winner | D |14/01/23 | 15/01/23 |
| x   | F08 | 42 Games are played during sim | D | 14/01/23 | 15/01/23 |
| x   | F09 | Print stdout percentage of wins for each player| D |14/01/23 | 16/01/23 |
| x   | F10 | Introduce combo score points| D |20/01/23 | 23/01/23 |
| x   | F11 | New player strategy to maximize combo | D |20/01/23 | 24/01/23 |
| x   | F12 | Specify strategy type from command line | P |2/01/23 | 26/01/23 |
| x   | F13 | Introducing card before each turn and applying | D |24/01/23 | 26/01/23 |
| x   | F14 | New Player strategy to leverage battle mechanics| D |24/01/23 | 26/01/23 |
| x   | F15 | Include Monkey Business card| D |26/01/23 | 27/01/23 |

