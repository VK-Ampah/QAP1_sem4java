# Suggestion Engine Project

This repository implements a simple suggestion engine and includes unit tests to ensure its functionality. Additionally, GitHub Actions is set up to build the project and run tests whenever code is pushed to the `main` branch or a pull request (PR) is made to the `main` branch. Branch protection rules are also configured to require PR approvals and status checks before allowing merges into the `main` branch.

## Test class
 1: Test case one: Test load dictionary data `testLoadDictionaryData`
  Check that the dictionary has been loaded with the expected number of words



2: Test case two: test generate suggestions, test for words in the dictionary `testGenerateSuggestionsForCorrectWord`

3: Test case three: test generate suggestions, test for misspelled words `testGenerateSuggestionsForMisspelledWord`
Assuming "abandon" is in the dictionary, "abandno" should suggest "abandon"
   

## GitHub Actions

The GitHub Actions workflow is triggered by:
- Push events to the `main` branch.
- Pull requests targeting the `main` branch.

The workflow performs the following steps:
1. Checks out the repository code.
2. Sets up JDK 22 using the `actions/setup-java` action.
3. Builds the project and runs the unit tests using Maven.
