# 🚀 ConnectService API

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![License](https://img.shields.io/badge/license-MIT-green)

API backend responsável pela intermediação entre **empregadores** e **prestadores de serviços**, permitindo criação de anúncios, matching automático e gestão de serviços.

---

# 📌 Sobre o Projeto

O **ConnectService** é uma plataforma que conecta:

* 👤 Empregadores → criam anúncios de serviços
* 🧑‍🔧 Prestadores → recebem oportunidades e aceitam serviços

Inspirado em modelos modernos de marketplace de serviços sob demanda.

---

# 🧱 Arquitetura

A aplicação segue o padrão:

```
Layered Architecture
```

```
Controller → Service → Repository → Database
```

### 🎯 Objetivos

* Separação de responsabilidades
* Escalabilidade
* Manutenção facilitada

---

# 🛠️ Tecnologias Utilizadas

* Java 21
* Spring Boot
* PostgreSQL
* Flyway
* Spring Security
* Swagger (OpenAPI)
* Docker

---

# 📦 Estrutura do Projeto

```
src/main/java/com/connectservice

config/
controller/
service/
repository/
entity/
dto/
mapper/
exception/
security/
```

---

# 🔁 Fluxo da Aplicação

```
Request → Controller → Service → Repository → Database
```

---

# 📚 Funcionalidades

### 👤 Empregador

* Criar anúncios de serviço
* Editar/cancelar anúncios
* Escolher prestador
* Avaliar prestador

### 🧑‍🔧 Prestador

* Receber notificações
* Aceitar/rejeitar serviços
* Concluir serviços
* Avaliar empregador

### 🤖 Sistema

* Matching automático
* Cálculo de valores
* Comissão da plataforma
* Prioridade para plano GOLD

---

# ⚙️ Requisitos

* Java 21
* Maven
* PostgreSQL
* Docker (opcional)

---

# 🚀 Como rodar o projeto

### 1️⃣ Clonar repositório

```bash
git clone https://github.com/seu-repo/connectservice-api.git
cd connectservice-api
```

---

### 2️⃣ Configurar banco de dados

`application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/connectservice
    username: postgres
    password: postgres

  jpa:
    hibernate:
      ddl-auto: validate

  flyway:
    enabled: true
```

---

### 3️⃣ Rodar aplicação

```bash
mvn spring-boot:run
```

---

### 4️⃣ Acessar API

```
http://localhost:8080
```

---

# 📄 Documentação da API

Swagger disponível em:

```
http://localhost:8080/swagger-ui.html
```

---

# 🔐 Autenticação

A API utiliza:

```
JWT (JSON Web Token)
```

Fluxo:

1. Login
2. Recebe token
3. Envia token nas requisições

---

# 🗄️ Banco de Dados

Gerenciado com migrations via Flyway:

```
db/migration

V1__init.sql
V2__users.sql
V3__jobs.sql
```

---

# 🧠 Roadmap

* [ ] Autenticação JWT
* [ ] CRUD de usuários
* [ ] CRUD de anúncios
* [ ] Matching de prestadores
* [ ] Integração com WhatsApp
* [ ] Sistema de pagamentos
* [ ] Notificações push

---

# 📌 Boas Práticas

* DTO Pattern
* Service Layer
* Repository Pattern
* Clean Code
* Versionamento de banco

---

# 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch (`feature/nova-feature`)
3. Commit (`git commit -m 'feat: nova feature'`)
4. Push (`git push origin feature/nova-feature`)
5. Abra um Pull Request

---

# 📄 Licença

Este projeto está sob licença MIT.

---

# 💡 Observações

Este projeto está em evolução e será expandido para:

* arquitetura modular
* alta escalabilidade
* integração com serviços externos
