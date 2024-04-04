# ToDo App - API

## Sobre o projeto
Esse projeto foi desenvolvido com o intuito de praticar Spring Boot, utilizando JPA, Hibernate e PostgreSQL, sendo meu primeiro projeto oficialmente utilizando essas tecnologias. Além disso, essa API foi desenvolvida com o intuito de ser consumida pelo Frontend Mobile já desenvolvido. Você pode acessar [o repositório por aqui](https://github.com/marysclair/FrontendMentor-AppToDo).

## Execução do projeto
1. Clone o projeto atráves do `git clone https://github.com/marysclair/ToDoApp-API.git` ou baixe em formato zip para descompactar.
2. Crie o banco de dados no PostgreSQL e altere a URL de conexão do banco de dados com o nome do banco criado no arquivo `application.properties`. Adicione as suas informações privadas (nome do usuário e senha do Postgre).
3. Inicie o projeto.
Você pode utilizar o Frontend Mobile já desenvolvido ou consumir sua API através de outro Frontend ou por interfaces como Insomnia.

 ## Documentação
ToDos
URL	| Método | Descrição
------|------------|-----
/todos |	POST |	Recurso de criação de ToDos. Recebe um title string como corpo de requisição
/todos	| GET |	Recurso de exibição de dados de todos os ToDos cadastrados
/todos/:id |	PATCH	| Recurso de atualização parcial das informações do ToDo, espera um checked booleano no corpo da requisição e recebe o id do ToDo como parâmetro
/todos/:id	| DELETE |	Recurso de exclusão de ToDo que recebe um id como parâmetro
