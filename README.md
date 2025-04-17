# Docker Spring Lab

## Visão Geral

O **Docker Spring Lab** é um projeto Java com Spring Boot desenvolvido com fins didáticos, voltado para estudos de integração entre aplicações backend e ambientes Dockerizados. A aplicação expõe uma API REST para cadastro e gerenciamento de dados com os atributos nome e idade, utilizando PostgreSQL como sistema gerenciador de banco de dados (SGBD), totalmente containerizado via Docker. O projeto fornece endpoints para operações básicas de CRUD, além de um endpoint de teste para validação do ambiente e da comunicação entre os serviços.

## 🚀 Tecnologias Utilizadas

- **Java 17** – Linguagem principal
- **Spring Boot 3.4.4** – Framework de desenvolvimento
- **Spring Data JPA** – Persistência de dados
- **Lombok** – Redução de boilerplate
- **PostgreSQL** – Banco de dados relacional
- **pgAdmin** – Interface gráfica para PostgreSQL
- **Docker e Docker Compose** – Containers para aplicação e banco
- **Maven** – Gerenciador de dependências
- **Postman** – Testes de API

## ⚙️ Perfis de Execução

O projeto suporta múltiplos **profiles** configurados via `application.properties`:

- `application-local.properties` → para rodar localmente
- `application-docker.properties` → para rodar em container

### 🔁 Como trocar o profile:

- No terminal (local):
  mvn spring-boot:run -Dspring-boot.run.profiles=local

- No Docker:
  docker run -e SPRING_PROFILES_ACTIVE=docker ...

- Via IntelliJ:
  Edit Configurations > Program arguments:
  --spring.profiles.active=local

## 🐳 Execução com Docker

### 1. Iniciar o Docker
- **WSL2**:
  sudo service docker start
- **Windows**:
  Abrir Docker Desktop

### 2. Acessar o projeto
cd /mnt/c/Users/WESLEY/WorkSpace-Java/docker-spring-lab

### 3. Subir PostgreSQL e pgAdmin
docker-compose up -d

### 4. Acessar o pgAdmin
- Navegador: http://localhost:16543  
- E-mail: admin@admin.com  
- Senha: admin

### 5. Build da imagem
docker build -t docker-spring-lab .

### 6. Subir a aplicação
docker run -d   --name docker-spring-lab-app   --network docker-spring-lab_default   -p 8080:8080   -e SPRING_PROFILES_ACTIVE=docker   docker-spring-lab

## 📬 Testes no Postman

### 🔹 Testar conexão
- GET
- URL: http://localhost:8080/docker/teste

### 🔹 Listar todas as entidades
- GET
- URL: http://localhost:8080/docker

### 🔹 Buscar por ID
- GET
- URL: http://localhost:8080/docker/1

### 🔹 Criar novo registro
- POST
- URL: http://localhost:8080/docker
- Body:
{
  "nome": "João da Silva",
  "idade": 28
}

### 🔹 Atualizar registro
- PUT
- URL: http://localhost:8080/docker/1
- Body:
{
  "nome": "João Atualizado",
  "idade": 30
}

### 🔹 Deletar registro
- DELETE
- URL: http://localhost:8080/docker/1

## 🧼 Comandos Docker úteis

docker ps                # Ver containers ativos
docker ps -a             # Todos os containers
docker stop <nome>       # Parar container
docker rm <nome>         # Remover container
docker-compose down -v   # Derrubar tudo

## 💾 Persistência de dados

Os dados persistem mesmo após desligamento/reinício do sistema, pois o Docker utiliza volumes:

docker volume ls

## ✍️ Autor

- **Wesley Martins Rosa**  
- 📧 wesleymrosa@gmail.com  
- 🔗 [linkedin.com/in/wesley-martins-rosa-5118aa15a](https://www.linkedin.com/in/wesley-martins-rosa-5118aa15a)

## 📌 Considerações Finais

O projeto **Docker Spring Lab** demonstra, de forma objetiva e funcional, a criação de uma API REST Java com Spring Boot, utilizando PostgreSQL em um ambiente containerizado, com arquitetura clara e separação de camadas, ideal para estudos e expansão futura.
