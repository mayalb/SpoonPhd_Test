# SPOON framework for tranforming java code

this a java program that uses Spoon Framework to transform an  arbitrary piece
of Java code to a new one with the relational and logical operators at IF statements reversed.

# Configuration
 In this program, Java@11 is used with Apashe Maven 3.6.3, Spoon, Junit, cucumber and other dependencies are added with maven.
# MainClass
In the main Class, we put XYDataItem as an input in "/src/main/java/XYDataItem", it transforms the input code using 
the reverse function in Reverse Class and print the transformed code.
# Tests
In this part:

    1. Unit tests:  Are in the folder "src/main/java/Tests.unitTest", are used to verify that
     individual units or components of reverse function perform as expected: 
     unitTest0: to test different part of the code (simple if statement with one operator, 
     coumpound and complex if statement).
     unitTest1: to test the code given in the task (XYDataItem).

    2. Cucumber tests: Are in the folder "src/test/java", allow to write automated tests in 
    a human-readable, domain-specific language, using the Gherkin syntax in .feature file 
    where describing the process of the test, ScenarioSteps: Each step in a Gherkin scenario
    is associated with a step definition, which is implemented in code. And, TestRunner to  
    lunch the cucumber tests:
          a. Scenario1Steps: defines a simple test of AND operator.
          b. Scenario2Steps: defines a test of the given code in the task.
        


