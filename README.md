# String Calculator – TDD Kata (Java)

This repository contains a Java implementation of the classic **String Calculator Kata**, developed using **Test-Driven Development (TDD)**. Each feature was implemented step-by-step, starting from a failing test and following the Red-Green-Refactor cycle.

---

## ✅ Features Implemented

- Return 0 for an empty string: `"" → 0`
- Add 1 or 2 comma-separated numbers: `"1,2" → 3`
- Handle an unknown number of inputs
- Support newline `\n` as a delimiter: `"1\n2,3" → 6`
- Support custom delimiters: `"//;\n1;2" → 3`
- Throw exception for negative numbers: `"1,-2" → Exception: negatives not allowed: [-2]`
- Show all negative numbers in the exception
- Ignore numbers greater than 1000: `"2,1001" → 2`
- Support delimiters of any length: `"//[***]\n1***2***3" → 6`
- Support multiple custom delimiters: `"//[*][%]\n1*2%3" → 6`
- Support multi-character delimiters: `"//[**][%%]\n1**2%%3" → 6`
- Track number of times `add()` is called via `getCalledCount()`

---

## 🧪 Tech Stack

- Java 17+
- JUnit 5
- Maven (build & dependency management)

---

## 📂 Project Structure

string-calculator/
├── src/
│ ├── main/java/com/incubyte/StringCalculator.java
│ └── test/java/com/incubyte/StringCalculatorTest.java
└── pom.xml

Each feature was added incrementally by:

Writing a failing test (Red)

Writing just enough code to pass (Green)

Refactoring for clarity and reuse (Refactor)

🧑‍💻 Author
This project was developed for learning and demonstration purposes based on the String Calculator Kata, and mirrors the approach used in TDD assessments such as those by Incubyte.

📄 License
This project is licensed under the MIT License – see the LICENSE file for details.
