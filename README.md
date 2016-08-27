# josephProblem

This project is a solution to the  counting out problem. 
In these problems, you are in a circle.  From some starting point, X you count k people.  
If you are standing in that kth spot, you are ‘out’.  The counting continues until there is one person standing.  
A concrete, but morbid, example of this is the Josephus Problem (https://en.wikipedia.org/wiki/Josephus_problem).

It is written in scala, uses sbt as its build system and uses spec2 for unit testing.
As the codebase is so small I have refrained from writing any BDD tests.

To run use the command ' sbt “run n k” ' from the root directory of the project.  

The main class of the application is ACountingProblem.
ACounting problem has a main, and two other methods.
The two other methods are findBestSpotToStandInternal and findBestSpotToStand
they return the ideal place to stand in the circle based on 0 being the starting position and 1 being the starting position respectively. 

All parameter parsing and validation is handled in the class CommandLineParametersParsingUtility.


Both these classes are unit tested separately. 
The convention used for naming the unit testing classes was {className}Spec. 

## Algorithm
The basic problem is described here https://en.wikipedia.org/wiki/Josephus_problem.

it can be written programmatically as: 
f = the function to return the best place to stand
n = number of ppl
k = step count. 
e.g.
f(n,k) = answer

One approach would be to iteratively remove people from the list, 
however on wikipedia they have a more concise method of finding the answer.
 
The answer is relies on finding a base case and a generic approach for every other case, assuming we know the answer for the following round.
Here is a very simple explanation of the approach I took. 
https://www.quora.com/Can-someone-explain-the-Josephus-Problem-in-simpler-terms-Is-there-an-equation-to-solve-the-Josephus-Problem





                                  
                                  