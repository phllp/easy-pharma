# Easy Pharma

Trabalho desenvolvido para a disciplina de Programação 2 do curso de Engenharia de software lecionada pelo professor Geraldo Menegazzo Varella

### Subindo o DB com Docker

```
docker run --name easy-pharma \                                                                                                                             ✔  22:20:47  
-e POSTGRES_DB=easy-pharma \
-e POSTGRES_USER=admin \   
-e POSTGRES_PASSWORD=admin \
-p 5432:5432 \
-d postgres
```