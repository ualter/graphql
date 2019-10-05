clear
echo **************************************
echo
echo " Wait... loading data for testing..."
echo
echo **************************************
echo
echo

echo "Creating Borrowers"
echo "#1 Borrower"
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newBorrower(eyeColor: \"brown\", name: \"Jeff Gates\", gender: \"male\") {id company email phone address registered}}"}' http://localhost:8080/graphql | jq .
echo "#2 Borrower"
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newBorrower(eyeColor: \"brown\", name: \"Bill Bezoz\", gender: \"male\") {id company email phone address registered}}"}' http://localhost:8080/graphql | jq .
echo
echo

# New Lenders
echo "Creating Lenders"
echo "#1 Lender"
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLender(name:\"Banc Sabadell\",isBank:true){id}}"}' http://localhost:8080/graphql | jq .
echo "#2 Lender"
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLender(name:\"Bankiadell\",isBank:true){id}}"}' http://localhost:8080/graphql | jq .
echo "#3 Lender"
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLender(name:\"Richard Gazques\",isBank:false){id}}"}' http://localhost:8080/graphql | jq .
echo "#4 Lender"
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLender(name:\"Kitt Tchezvkoy\",isBank:false){id}}"}' http://localhost:8080/graphql | jq .

# New Loans
echo "#1 Loan"
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLoan(credit:23434.34,interest:30,foreignCurrency:\"euro\",borrower_id:\"1\",lenders:[{id:\"4\"},{id:\"5\"},{id:\"6\"}]){id}}"}' http://localhost:8080/graphql | jq .
echo "#2 Loan"
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLoan(credit:350021,interest:22,foreignCurrency:\"euro\",borrower_id:\"1\",lenders:[{id:\"3\"},{id:\"4\"},{id:\"5\"}]){id}}"}' http://localhost:8080/graphql | jq .
echo "#3 Loan"
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLoan(credit:18500,interest:10,foreignCurrency:\"euro\",borrower_id:\"2\",lenders:[{id:\"3\"},{id:\"5\"}]){id}}"}' http://localhost:8080/graphql | jq .
echo "#4 Loan"
curl -sX POST -H "Content-Type: application/json" -d '{"query":"mutation{newLoan(credit:180000000,interest:30,foreignCurrency:\"dolar\",borrower_id:\"2\",lenders:[{id:\"3\"}]){id}}"}' http://localhost:8080/graphql | jq .