# Book sharing system

Sharing books is the most basic form of sharing knowledge. A platform that can allow you to
share books and find wanted books from user’s book’s collections. The system provides
access for any user, who has a book that is unwanted or reeded and would like to share it with
another user that may have the need for it. This system enables to find books, register
unwanted or reeded books and the system also shows if the book can be exchanged.

### The functionality I'm going to implement in this project:
In this project I will have basically two profiles: `Admin` and `User`.

Functionality that will have the `User`:
* Login and Registration;
* User can register books to share it;
* User can find books and rent it;
* User can see books by specific location;
* User can add rented books to the new table;
* User can see where is his book
* User can see this book available or not

Functionality that will have the `Admin`:
* Login and Registration;
* Get users profile;
* Edit users profile;
* Delete users profile;
* Admin can get exchanged books history;

To implement this functionality, I used `Java Spring`, for the database `Postgresql`, for JMS I used `ActiveMQ` and other tools.

Endpoints:
* http://localhost:8080/login
* http://localhost:8080/logout
* http://localhost:8080/profile
* http://localhost:8080/index
* http://localhost:8080/book
* http://localhost:8080/book/showAllBooks
* http://localhost:8080/book/showPublishedBookByMe
* http://localhost:8080/book/showMyBooksThatExchanged
* http://localhost:8080/book/showBooksThatIRanted
* http://localhost:8080/book/findBook
* http://localhost:8080/book/findBookByTitle
* http://localhost:8080/book/findBookByAuthor
* http://localhost:8080/book/findBookByGenre
* http://localhost:8080/book/saveBook
* http://localhost:8080/book/rentBook