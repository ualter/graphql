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
```bash

# Create Borrowers
mutation {
  newBorrower(eyeColor: "brown", name: "Jeff Gates", gender: "male") {
    id
    company
    email
    phone
    address
    registered
  }
}
mutation {
  newBorrower(eyeColor: "black", name: "Joe Ramone", gender: "male") {
    id
    email
    phone
    address
  }
}

# Create Lenders
mutation {
  newLender(name: "Banc Sabadell",isBank:true){
    id
  }
}

mutation {
  newLender(name: "Bankiadell",isBank:true){
    id
  }
}

mutation {
  newLender(name: "Bill Bezos",isBank:false){
    id
  }
}

# Create Loan
mutation {
  newLoan(credit:23434.34, interest: 30, foreignCurrency:"euro", borrower_id: "4",
   lenders:[{id: "1"},{id: "2"},{id: "3"}]){
    id
  }
}

```


### Query
```bash 
query {
  findAllBorrowers {
    id
    name
    eyeColor
    gender
    company
    address
    email
    phone
    registered
  }
}
```

### GraphQL Endpoint Server
```bash

# New Borrowers
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newBorrower(eyeColor: \"brown\", name: \"Jeff Gates\", gender: \"male\") {id company email phone address registered}}"}' http://localhost:8080/graphql | jq .

curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newBorrower(eyeColor: \"brown\", name: \"Bill Bezoz\", gender: \"male\") {id company email phone address registered}}"}' http://localhost:8080/graphql | jq .

# New Lenders
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLender(name:\"Banc Sabadell\",isBank:true){id}}"}' http://localhost:8080/graphql | jq .
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLender(name:\"Bankiadell\",isBank:true){id}}"}' http://localhost:8080/graphql | jq .
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLender(name:\"Richard Gazques\",isBank:false){id}}"}' http://localhost:8080/graphql | jq .
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLender(name:\"Kitt Tchezvkoy\",isBank:false){id}}"}' http://localhost:8080/graphql | jq .

# New Loans
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLoan(credit:23434.34,interest:30,foreignCurrency:\"euro\",borrower_id:\"1\",lenders:[{id:\"4\"},{id:\"5\"},{id:\"6\"}]){id}}"}' http://localhost:8080/graphql | jq .

curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLoan(credit:350021,interest:22,foreignCurrency:\"euro\",borrower_id:\"1\",lenders:[{id:\"3\"},{id:\"4\"},{id:\"5\"}]){id}}"}' http://localhost:8080/graphql | jq .

curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLoan(credit:18500,interest:10,foreignCurrency:\"euro\",borrower_id:\"2\",lenders:[{id:\"3\"},{id:\"5\"}]){id}}"}' http://localhost:8080/graphql | jq .

curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLoan(credit:180000000,interest:30,foreignCurrency:\"dolar\",borrower_id:\"2\",lenders:[{id:\"3\"}]){id}}"}' http://localhost:8080/graphql | jq .



# Queries

# All Borrowers
curl -sX POST -H "Content-Type: application/json" -d '{"query":"{findAllBorrowers{id name eyeColor gender company address email phone registered}}"}' http://localhost:8080/graphql | jq .

# All Lenders
curl -sX POST -H "Content-Type: application/json" -d '{"query":"{findAllLenders{id name}}"}' http://localhost:8080/graphql | jq .


```