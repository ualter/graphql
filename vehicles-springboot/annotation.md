### The Java Library
https://www.graphql-java.com/

### URL Browser
```bash
http://localhost:8080/graphiql

# H2 Console
# jdbc:h2:mem:testdb   user: sa
http://localhost:8080/h2-console/login.jsp
```

### Query for creation
```bash
mutation {
  createVehicle(type: "car", modelCode: "XYZ0192", brandName: "XYZ", launchDate: "2016-08-16") 
  {
    id
  }
}
```


### GraphQL Endpoint Server
```bash
# Query
curl -sX POST -H "Content-Type: application/json" -d '{"query":"{vehicles(count: 10) {brandName modelCode}}"}' http://localhost:8080/graphql | jq .

# Mutation
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation {createVehicle(type: \"car\", modelCode: \"01F7BA\", brandName: \"Ford\", launchDate: \"2016-08-16\") {id}}","variables":null}' http://localhost:8080/graphql  | jq .

curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation {deleteVehicle(id: \"3\")}","variables":null}' http://localhost:8080/graphql
``` 