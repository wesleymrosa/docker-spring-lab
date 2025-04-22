# Docker Spring Lab

## 📖 Visão Geral

O **Docker Spring Lab** é um projeto Java com Spring Boot desenvolvido com fins didáticos, voltado para estudos de integração entre aplicações backend e ambientes Dockerizados. A aplicação expõe uma API REST para cadastro e gerenciamento de dados com os atributos `nome` e `idade`, utilizando **PostgreSQL** como SGBD, tudo containerizado via **Docker CLI**. O projeto oferece operações CRUD completas e um endpoint de teste para validação do ambiente.

---

## 🚀 Tecnologias Utilizadas

- **Java 17** – Linguagem principal  
- **Spring Boot 3.4.4** – Framework de desenvolvimento  
- **Spring Data JPA** – Persistência com ORM  
- **Lombok** – Redução de código boilerplate  
- **PostgreSQL** – Banco de dados relacional  
- **pgAdmin** – Interface de administração do PostgreSQL  
- **Docker & Docker Compose (via CLI)** – Ambiente containerizado  
- **Maven** – Gerenciamento de dependências  
- **Postman** – Testes de API  

---

## ⚙️ Perfis de Execução

O projeto suporta múltiplos **profiles** configurados via `application.properties`:

- `application-local.properties` → para rodar localmente  
- `application-docker.properties` → para rodar em container  

### 🔁 Como trocar o profile:

- **Via terminal (local):**  
  `mvn spring-boot:run -Dspring-boot.run.profiles=local`

- **Via Docker CLI (modo container):**  
  `-e SPRING_PROFILES_ACTIVE=docker`

- **Via IntelliJ IDEA:**  
  `Edit Configurations > Program arguments > --spring.profiles.active=local`

---

## 🐳 Execução via Docker CLI

### 1. Iniciar o serviço Docker (caso use WSL2)
```bash
sudo service docker start
```

### 2. Navegar até o diretório do projeto
```bash
cd /mnt/c/Users/WESLEY/WorkSpace-Java/docker-spring-lab
```

### 3. Subir containers do banco e pgAdmin
```bash
docker-compose up -d
```

### 4. Acessar o pgAdmin
- URL: [http://localhost:16543](http://localhost:16543)  
- E-mail: `admin@admin.com`  
- Senha: `admin`  

### 5. Build da imagem da aplicação Java
```bash
docker build -t docker-spring-lab .
```

### 6. Subir o container da aplicação
```bash
docker run -d \
  --name docker-spring-lab-app \
  --network docker-spring-lab_default \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=docker \
  docker-spring-lab
```

---

## 📬 Testes via Postman

### 🔹 Testar conexão
- **GET** → `http://localhost:8080/docker/teste`

### 🔹 Listar todos os registros
- **GET** → `http://localhost:8080/docker`

### 🔹 Buscar por ID
- **GET** → `http://localhost:8080/docker/1`

### 🔹 Criar novo registro
- **POST** → `http://localhost:8080/docker`  
  **Body:**
```json
{
  "nome": "João da Silva",
  "idade": 28
}
```

### 🔹 Atualizar registro
- **PUT** → `http://localhost:8080/docker/1`  
  **Body:**
```json
{
  "nome": "João Atualizado",
  "idade": 30
}
```

### 🔹 Deletar registro
- **DELETE** → `http://localhost:8080/docker/1`

---

## 🧼 Comandos Docker Úteis

```bash
docker ps                      # Ver containers ativos
docker ps -a                  # Ver todos os containers
docker stop <nome_container>  # Parar container
docker rm <nome_container>    # Remover container
docker-compose down -v        # Derrubar tudo, incluindo volumes
```

---

## 💾 Persistência de Dados

Os dados persistem mesmo após reiniciar o sistema, pois os volumes são gerenciados automaticamente pelo Docker Compose:

```bash
docker volume ls
```

---

## ✍️ Autor

**Wesley Martins Rosa**  
📧 wesleymrosa@gmail.com  
🔗 [linkedin.com/in/wesley-martins-rosa-5118aa15a](https://linkedin.com/in/wesley-martins-rosa-5118aa15a)

---

## 📌 Considerações Finais

Este projeto demonstra, de forma prática, a criação de uma API REST com Java e Spring Boot em ambiente Dockerizado. A arquitetura segue boas práticas com separação em camadas, uso de `DTO`, `Entity`, `Repository`, `Service` e `Controller`, sendo ideal para estudo, testes e expansão com microserviços.
