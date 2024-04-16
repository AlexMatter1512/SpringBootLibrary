# Library Spring Boot Demo

## Description
This is a simple Spring Boot application that demonstrates the use of Spring Boot and Spring Data JPA. 

The application is a simple library management system that allows admins to add, view, and delete books from the library; and users to view, borrow and return books.


The application uses mySQL database to store the books.

## Specifications
### Book Attributes

_`Admin available:`_
- Id
- Copie disponibili
- Copie totali
- _`User available:`_
    - Title
    - Year of Production
    - Author

### Author Attributes

_`Admin available:`_
- Id
- _`User available:`_
    - Name
    - Surname
    - Date of Birth

Giving users access to the entities id would be an improvement to the application, since it is the parameter used to interact with the entities.

## Requests
([postman](https://www.postman.com/) collection is available in the root directory)

The application has the following endpoints:

### Admin
- **Add Book**
  - Method: POST
  - URL: ```/api/private/libri```
  - Request Body: 
    ```json
    {
      "titolo": "Il nome del vento",
      "annoProduzione": 2007,
      "autore": {
        "nome": "Patrick",
        "cognome": "Rothfuss",
        "dataNascita": "1973-06-06"
      }
    }
    ```
    

- **Add Author**
  - Method: POST
  - URL: ```/api/private/autori```
  - Request Body: 
    ```json
    {
      "nome": "Patrick",
      "cognome": "Rothfuss",
      "dataNascita": "1973-06-06"
    }
    ```

    
- **List Books**
  - Method: GET
  - URL: ```/api/private/libri```


- **List Authors**
  - Method: GET
  - URL: ```/api/private/autori```


- **Delete Book**
  - Method: DELETE
  - URL: ```/api/private/libri/{id}```

### User
- **List Books**
  - Method: GET
  - URL: ```/api/users/libri```


- **Borrow Book**
  - Method: GET
  - URL: ```/api/users/libri/reserve```
  - Request GET Params: 
    - Id: id of the book to borrow


- **Return Book**
  - Method: GET
  - URL: ```/api/users/libri/return```
  - Request GET Params: 
    - Id: id of the book to return