# 🎬 Desafio DSMovie RestAssured

## 📌 Sobre o desafio
Este projeto faz parte de um **desafio de testes automatizados de API**, cujo objetivo é implementar todos os testes solicitados utilizando **RestAssured** para o sistema **DSMovie**.

O foco do desafio é validar corretamente os endpoints REST, garantindo o comportamento esperado da aplicação em diferentes cenários, incluindo regras de negócio, autenticação, autorização e validações.

---

## 🎥 Sobre o projeto DSMovie
O **DSMovie** é um sistema de **filmes e avaliações**, onde:

- 📖 A visualização dos filmes é **pública** (não exige autenticação);
- 🔐 As operações de **inserir, atualizar e deletar filmes** são permitidas apenas para usuários com perfil **ADMIN**;
- ⭐ As avaliações de filmes podem ser realizadas por usuários logados **CLIENT** ou **ADMIN**;
- 🧮 Cada avaliação gera um **Score** entre **0 e 5**;
- 📊 Sempre que uma nova avaliação é registrada:
  - A média das notas é recalculada;
  - A média (**score**) e a contagem de votos (**count**) são armazenadas na entidade **Movie**.

---

## 🧪 Objetivo dos testes
Garantir que a API:

- Retorne os **status HTTP corretos**;
- Aplique corretamente as **regras de negócio**;
- Respeite as **permissões por perfil de usuário**;
- Valide corretamente os **dados de entrada**;
- Trate adequadamente **erros e exceções**.

---

## 🛠️ Tecnologias utilizadas

- Java  
- RestAssured  
- JUnit  
- Spring Boot  
- Maven  

---

## 🔎 Testes implementados

### 🎬 MovieControllerRA

- `findAllShouldReturnOkWhenMovieNoArgumentsGiven`
- `findAllShouldReturnPagedMoviesWhenMovieTitleParamIsNotEmpty`
- `findByIdShouldReturnMovieWhenIdExists`
- `findByIdShouldReturnNotFoundWhenIdDoesNotExist`
- `insertShouldReturnUnprocessableEntityWhenAdminLoggedAndBlankTitle`
- `insertShouldReturnForbiddenWhenClientLogged`
- `insertShouldReturnUnauthorizedWhenInvalidToken`

---

### ⭐ ScoreControllerRA

- `saveScoreShouldReturnNotFoundWhenMovieIdDoesNotExist`
- `saveScoreShouldReturnUnprocessableEntityWhenMissingMovieId`
- `saveScoreShouldReturnUnprocessableEntityWhenScoreIsLessThanZero`

---

## 🚀 Como executar os testes

1. Certifique-se de que a API do **DSMovie** esteja em execução;
2. Clone o repositório:

```bash
git clone https://github.com/Andre-Proenca/Desafio-DSMovie-RestAssured