# Gerenciador de Tarefas

API REST para gerenciar tarefas do dia a dia, construída com **Java e Spring Boot**.

Este é um projeto de estudo e também uma ferramenta de uso próprio. O objetivo principal é **aprimorar minhas habilidades com o framework Spring**, praticando arquitetura em camadas, persistência com JPA e boas práticas de desenvolvimento de APIs. O projeto vai evoluir aos poucos, incluindo novas funcionalidades e serviços da AWS.

> **Status:** em desenvolvimento 🚧

---

## Objetivos

- Praticar o desenvolvimento de APIs REST com Spring Boot
- Aplicar arquitetura em camadas (Controller, Service, Repository, DTO e Mapper)
- Usar Spring Data JPA para persistência de dados
- Construir uma ferramenta que eu realmente use na minha rotina
- Evoluir o projeto com serviços de nuvem (AWS) em etapas futuras

---

## Tecnologias

| Tecnologia | Uso |
|---|---|
| Java | Linguagem principal |
| Spring Boot | Framework da aplicação |
| Spring Web | Criação da API REST |
| Spring Data JPA | Persistência e acesso ao banco |
| H2 Database | Banco de dados (fase de desenvolvimento) |
| Lombok | Redução de código repetitivo |
| Maven | Gerenciamento de dependências |

---

## Arquitetura

O projeto segue uma arquitetura em camadas, em que cada classe tem uma responsabilidade bem definida:

```
br.com.projetos.gerenciador_de_tarefas
├── controller/   → recebe as requisições HTTP e devolve as respostas
├── service/      → regras de negócio
├── repository/   → acesso ao banco de dados
├── model/        → entidades (Tarefa)
├── enums/        → Status e Prioridade
├── dto/          → objetos de entrada e saída da API
└── mapper/       → conversão entre DTO e entidade
```

### Modelo de dados

**Tarefa**

| Campo | Tipo | Descrição |
|---|---|---|
| `id` | Long | Identificador gerado automaticamente |
| `titulo` | String | Título da tarefa (obrigatório) |
| `descricao` | String | Detalhes da tarefa (opcional) |
| `status` | Status | Situação atual da tarefa |
| `prioridade` | Prioridade | Nível de prioridade |
| `dataCriacao` | LocalDateTime | Preenchida automaticamente na criação |

---

## Endpoints

> Os endpoints abaixo representam o plano da API e podem mudar durante o desenvolvimento.

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/tarefas` | Cadastra uma nova tarefa |
| `GET` | `/tarefas` | Lista todas as tarefas |
| `GET` | `/tarefas/{id}` | Busca uma tarefa pelo id |
| `PUT` | `/tarefas/{id}` | Atualiza uma tarefa |
| `DELETE` | `/tarefas/{id}` | Exclui uma tarefa (exclusão real) |

---

## Como executar

### Pré-requisitos

- Java (JDK) instalado
- Maven (ou usar o wrapper `mvnw` do projeto)

### Passos

```bash
# Clonar o repositório
git clone https://github.com/juansouzamarques/gerenciador-de-tarefas.git

# Entrar na pasta do projeto
cd gerenciador-de-tarefas

# Executar a aplicação
./mvnw spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

### Console do H2

Com o console habilitado no `application.properties`:

```properties
spring.h2.console.enabled=true
```

acesse `http://localhost:8080/h2-console` para visualizar o banco.

---

## Roadmap

### Em andamento
- [x] Estrutura inicial do projeto (pastas `controller` e `service`)
- [x] Entidade `Tarefa` e enums `Status` e `Prioridade`
- [ ] `TarefaRepository`
- [ ] DTOs e `TarefaMapper`
- [ ] `TarefaService` com as regras de negócio
- [ ] `TarefaController` com o CRUD completo

### Próximas melhorias
- [ ] Validação de dados com Bean Validation
- [ ] Tratamento global de erros (`@RestControllerAdvice`)
- [ ] Filtros e busca (por status, prioridade e título)
- [ ] Campo de prazo (data limite) nas tarefas
- [ ] Testes automatizados (JUnit e Mockito)
- [ ] Documentação da API com Swagger/OpenAPI
- [ ] Persistência do H2 em arquivo, para manter os dados entre execuções

### Futuro: nuvem e evolução
- [ ] Migrar para um banco relacional de produção (ex.: Amazon RDS)
- [ ] Deploy da aplicação na AWS
- [ ] Explorar outros serviços AWS conforme a necessidade (ex.: S3, para anexos)
- [ ] Autenticação e controle de usuários (Spring Security)
- [ ] Front-end para consumir a API

---

## Decisões de projeto

- **H2 por enquanto:** o foco inicial é o Spring; a parte de infraestrutura na AWS fica para depois.
- **DTOs separados da entidade:** a entidade não é exposta diretamente pela API.

---

## Autor

**Juan**
GitHub: [@juansouzamarques](https://github.com/juansouzamarques)
