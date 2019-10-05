




const resolvers = {
    Query: {
        findAllLoans: () => {
            return db.findAllLoans();
        }
    },
    Mutation: {
        newLender: (parent, args) => {
            let lender = {name: args.name};
            return db.save(lender);
        }
    }
}




type Query {
    users: [User!]!
    user(id: ID!): User!
}