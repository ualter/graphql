const { GraphQLServer } = require('graphql-yoga')
const { prisma } = require('./generated/prisma-client')

const resolvers = {
    Query: {
        users: () => users_sampleData,
        user: (parent, args) => retrieveUser(args.id)
    },
    Mutation: {
        createUser: (parent, args, context) => {
            console.log(context.prisma);
            return prisma.createUser({name: args.name});
        },
        updateUser: (parent, args) => updateUser(parent, args),
        deleteUser: (parent, args) => deleteUser(parent, args)
    },
    User: {
        id: (parent) => parent.id,
        name: (parent) => parent.name
    }
}

const server = new GraphQLServer({
    typeDefs: './src/schema.graphql',
    resolvers,
})  
server.start(() => console.log('Server is running on http://localhost:4000'))

function retrieveUser(id) {
    return findUser(id);
}
function updateUser(parent, args) {
    let user = findUser(args.id);    
    user.name = args.name;
    return user;
}
function deleteUser(parent, args) {
    let index = users_sampleData.findIndex(u => u.id === args.id);
    if ( index > 0 && index < users_sampleData.length ) {
        console.log(index);
        users_sampleData.splice(index,1);
        return true;
    } else {
        return false;
    }
}
function findUser(id) {
    let userFound = null;
    userFound = users_sampleData.find((u) => u.id === id );
    return userFound;
}

function generateId(length) {
    var result           = '';
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
       result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
 }

let users_sampleData = [
    {id: generateId(8),name: 'John'},
    {id: generateId(8),name: 'Mary'},
    {id: generateId(8),name: 'Michael'}
]