### Initializing the project
```bash
yarn init -y
```


### Plugins installed
```bash
yarn add graphql-yoga
yarn global add prisma
```


### Prisma (Get running it)
```bash
cd prisma
docker-compose up -d 
```
### then...
```bash
prisma deploy
prisma generate
```