### URL Browser
```bash
http://localhost:8080/graphiql
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
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation {createVehicle(type: \"car\", modelCode: \"Ualter\", brandName: \"XYZ\", launchDate: \"2016-08-16\") {id}}","variables":null}' http://localhost:8080/graphql  | jq .
``` 