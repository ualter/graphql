```bash
yarn init -y
yarn add graphql-yoga
```


# Test via Curl
```bash
curl -sX POST -H "Content-Type: application/json" -d "{\"query\": \"{ users { id, name }}\"}" http://localhost:4000 | jq .
```

# Via graphql UI
```bash
http://localhost:4000
```
