# CSC 1060 Practice 10
The purpose of this practice assignment is to build your skill manipulating 2D arrays.

## Task
Complete the static methods in the `MatrixManipulator` class. The JavaDoc tells you what the behavior of the method should be and what it returns.

There is no driver class. You may choose to write one to manually test your code.

### New Skill: Throwing Exceptions
Notice that the JavaDoc for these methods states that it potentially throws an `IllegalArgumentException`. Developers can throw this exception when the arguments the method receives do not meet preconditions. 

To throw the exception, use the following syntax.

```java
if ( some check that fails ) {
    throw new IllegalArgumentException("A useful error message.");
}
```

## Unit Tests
Ensure that the unit pass by running the file in `/src/test/java`.