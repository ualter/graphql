### The Java Library
https://www.graphql-java.com/

### URL Browser
```bash
# IDE
http://localhost:8080/graphiql
# Endpoint execute 
http://localhost:8080/graphql
# Schema
http://localhost:8080/graphql/schema.json

# H2 Console
# jdbc:h2:mem:testdb   user: sa
http://localhost:8080/h2-console/login.jsp
```


### Mutation
mutation {
  newAuthor(firstName: "Joe", lastName: "Ramone") {
    id
  }
}

mutation {
  newBook(title: "Ocean", isbn:"123", pageCount: 300, author: "1") {
    id
    title
  }
}

### Query 
query {
  findAllAuthors{
    firstName
  }
}

### GraphQL Endpoint Server
curl -sX POST -H "Content-Type: application/json" -d '{"query":"{findAllBooks { id title author {firstName} } }"}' http://localhost:8080/graphql | jq .

curl -sX POST -H "Content-Type: application/json" -d '{"query":"{findAllAuthors { id firstName lastName } }"}' http://localhost:8080/graphql | jq .

curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newAuthor(firstName: \"Joe\", lastName:\"Ramone\") {id}}"}' http://localhost:8080/graphql | jq .

curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newAuthor(firstName: \"J.R.R.\", lastName:\"Tolkien\") {id}}"}' http://localhost:8080/graphql | jq .

curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newAuthor(firstName: \"Freddy\", lastName:\"Mercury\") {id}}"}' http://localhost:8080/graphql | jq .

curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newBook(title: \"Ocean\", isbn:\"123\", pageCount: 300, author: \"1\") {id title}}"}' http://localhost:8080/graphql | jq .

curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newBook(title: \"Lord of Rings\", isbn:\"345\", pageCount: 990, author: \"2\") {id title}}"}' http://localhost:8080/graphql | jq .

curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newBook(title: \"I want to break free\", isbn:\"02023\", pageCount: 187, author: \"3\") {id title}}"}' http://localhost:8080/graphql | jq .

