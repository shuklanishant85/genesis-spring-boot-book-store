# genesis-spring-boot-book-store
A book store project to explore the steps of bootstrapping a spring boot application.

## Modules:
1. Adding Starters to pom.
2. Configuring project for bootsrtaping.
3. Setting up properties in application properties.
4. Creating controllers for rest endpoints.
5. Adding in-built security.
6. Creating presistence layer for Storage using Crud API.
7. Setting DataBase for storage.
8. Adding Exception handling layers.
9. Adding test cases for testing the application.

## Notes: 
Spring-boot-bootstrap.txt file is present in the root direcory as\
a cheat-code file for remembering the basic steps.

## Rest endpoints:
| Request Mappings             | Method |  Endpoints          |
| ---------------------------- | ------ | ------------------- |
| /                            | GET    | Request Home Page   |
| /api/book                    | GET    | Find All Books      |
| /api/book/title/{bookTitle}  | GET    | Find Book By Title  |
| /api/book/dummybook          | GET    | Get A Dummy Book    |
| /api/book/{id}               | GET    | Find A Book By Id   |
| /api/book                    | POST   | Add A New Book      |
| /api/book/{id}               | DELETE | Delete A Book By Id |
| /api/book/{id}               | PUT    | Update A Book By Id |
