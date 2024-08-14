# Projeto Factory Method em Java

Este projeto é um exemplo prático de como implementar o padrão de design Factory Method em Java, utilizando o Spring Boot como framework e Maven para gerenciamento de dependências.


## Tecnologias Utilizadas
- [Java](https://www.java.com/): Linguagem de programação utilizada para desenvolver o projeto.
- [Spring Boot](https://spring.io/projects/spring-boot): Framework utilizado para facilitar o desenvolvimento de aplicações Java.
- [Maven](https://maven.apache.org/): Ferramenta de gerenciamento de projetos e compilação de código.
- [Docker](https://www.docker.com/): Plataforma utilizada para containerização da aplicação.
- [MySQL](https://www.mysql.com/): Sistema de gerenciamento de banco de dados utilizado.
- [Swagger](https://swagger.io/): Ferramenta para documentação de APIs.
- [JaCoCo](https://www.eclemma.org/jacoco/): Ferramenta utilizada para verificar a cobertura de código dos testes unitários.


## Como subir o projeto

Para subir o projeto, você deve ter o Docker instalado em sua máquina. Em seguida, execute o seguinte comando:

```bash
docker-compose up --build -d
```


## Documentação da API

A documentação Swagger do projeto pode ser acessada através do seguinte link quando o projeto estiver rodando: http://localhost:8080/swagger-ui/index.html#/


## Como executar os testes

Para rodar os testes unitários, execute o seguinte comando:

```bash
mvn test
```


## Coverage

O relatório de cobertura de testes pode ser encontrado na seguinte URL: [Link para o relatório de cobertura](http://localhost:63343/factory-method-in-java/attribute/target/site/jacoco/index.html)


## Contribuições

Contribuições para este projeto são bem-vindas. Por favor, abra um problema ou uma solicitação de pull se você quiser contribuir.


## Autor

Matheus Tadeu - [LinkedIn](https://www.linkedin.com/in/matheus-tadeu-482a00134/)


## Licença

Este projeto está licenciado sob os termos da licença MIT.