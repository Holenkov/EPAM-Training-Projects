# EPAM-Training-Projects
Final Project.
Simple electronic documents exchange application.
Roles: USER, ADMIN, MANAGER. 
Employee (user) first should pass registration. After that he will be able to create different type documents (order, message, request etc.), view his own created documents and documents from another employees. Employee can send documents to another emloyees only according to subordination system. For example, engineer is not able to send order to CEO.
Manager can view list of all employees and edit some their data: employee position, status, name. Also manager creates subordination table.
Admin only can set Role (Admin, User, Manager).
Application has MVC architecture. MySQL data base. Use JSP, JS form validation, JSTL, Bootstrap. Logging made by Log4J2.


Task 1. Model of IT-Company.
Create hierarchy of Employees. Create few Employee objects. Create team of developers and calculate its cost. Sort employees by one or few parameters.

Pattern Repository used for store collection of employees.
For creating of employees used pattern Factory Method.
Logging made by Log4J2.
JUnit tests.

Task 2. Information handling (light).
Create app for parsing Text on Paragraphs, Sentences, Tokens, Words and single Symbols. 
Create methods for sorting Text:
1. Sort Paragraphs by number of Sentences.
2. Sort Words on Sentence by length.
3. Sort Sentences on Paragraph by number of given Symbol.

Using pattern Composite for store Text. Parsers use pattern Chain of Responsibility.
Logging made by Log4J2.
JUnit tests.

Task 3. Threads.
Create matrix NxN, 8<=N<=12, filled with integer numbers. Major diagonal initialized by zero numbers.
Create M threads, 4<=M<=6. Thread have field with unique positive integer number. Every thread should write its number to matrix diagonal.

a) Must be changed all diagonal elements.

b) Every diagonal element must be changed only one time.

c) Solution, when all elements changed by one thread - is incorrect.

Using Singletone pattern for store matrix as common resource.
Logging made by Log4J2.








