# Desafio Star Wars
## Contexto
Nossos associados são aficionados por Star Wars e com isso, queremos criar um jogo com algumas informações da franquia.
 
Para possibilitar a equipe de front criar essa aplicação, queremos desenvolver uma API que contenha os dados dos planetas.
 
## Requisitos
- A API deve ser REST
- Para cada planeta, os seguintes dados devem ser obtidos do banco de dados da aplicação, sendo inserido manualmente:
   - Nome
   - Clima
   - Terreno 

- Para cada planeta também devemos ter a quantidade de aparições em filmes, que podem ser obtidas pela API pública do Star Wars: https://swapi.dev/about
 
## Funcionalidades desejadas
 
- Adicionar um planeta (com nome, clima e terreno)
- Listar planetas
- Buscar por nome
- Buscar por ID
- Remover planeta

Bancos que usamos: MongoDB, Cassandra, DynamoDB, Datomic, ELK.
E lembre-se! Um bom software é um software bem testado.

## Desenvolvimento
### Ferramentas
- Java 11
- Spring Boot
- Spring Data
- MongoDB
- JUnit
- Lombok
- Docker

### Estrutura do projeto
- backup-db -> backup da collection planeta
- docker-mongodb -> docker compose para subir o banco MongoDB e o Mongo Express
- docs -> documento de requisitos
- src/main -> pasta principal da API
- src/test -> pasta para teste de unidade e integração. Utilizei TDD :D
