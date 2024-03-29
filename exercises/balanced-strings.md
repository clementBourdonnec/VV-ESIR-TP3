# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written so far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

The code used to answer to these questions are in [tp3-balanced-strings](../code/tp3-balanced-strings).  

1. The first test we did was the test with an empty string in order to test the fact that if it is not needed, we don't enter in any statement. Then, we will try to test every statement present in the function by testing all sorts of grouping symbols (`{}[]()`) simply first and then with imbriqued grouping symbols (ex:`{()}`). Finaly, we are testing that if there are other characters in the string, it don't infer in the proper functing of the function. After checking if the function is working well, we must test that the function detects well if there are not proper grouping symbols.  
2. After evaluating the statement coverage, we noticed that there are some statement that were not tested. It was concerning one statement that was checking if there is a wrong closing grouping symbol, so we added a test to cover that statement.
3. All the predicates used in the function has at most 2 boolean operators and every boolean operator has been tested so no change is needed.
4. To better check whether our tests are efficient enough, to check the quality of the tests, we used PIT on the project (by adding the plugin using maven). PIT is used to veryfy the mutation score of the tests. Here is the result we get :  

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<h1>Pit Test Coverage Report</h1>

<h3>Project Summary</h3>
<table>
    <thead>
        <tr>
            <th>Number of Classes</th>
            <th>Line Coverage</th>
            <th>Mutation Coverage</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>100% <div class="coverage_bar"><div class="coverage_complete width-100"></div><div class="coverage_legend">15/15</div></div></td>
            <td>96% <div class="coverage_bar"><div class="coverage_complete width-96"></div><div class="coverage_legend">22/23</div></div></td>
        </tr>
    </tbody>
</table>


<h3>Breakdown by Package</h3>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Number of Classes</th>
            <th>Line Coverage</th>
            <th>Mutation Coverage</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><a href="./fr.istic.vv/index.html">fr.istic.vv</a></td>
            <td>1</td>
            <td><div class="coverage_percentage">100% </div><div class="coverage_bar"><div class="coverage_complete width-100"></div><div class="coverage_legend">15/15</div></div></td>
            <td><div class="coverage_percentage">96% </div><div class="coverage_bar"><div class="coverage_complete width-96"></div><div class="coverage_legend">22/23</div></div></td>
        </tr>
     </tbody>
</table>
<br/>



<hr/>

Report generated by <a href='http://pitest.org'>PIT</a> 1.5.2

</body>
</html>

As we can see, we obtained a score of 96 % (22/23) mutations used in our tests that is a good score so we didn't changed the tests we had.
