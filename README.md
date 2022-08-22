# Why?
Aproveitando para ver o que há de novo no spring boot com java 17 decidi fazer o projeto proposto pela Alura Challenge Backend. #alurachallengebackend4

## Estrutura básica

O projeto utiliza uma base de dados `PostgreSQL`. Então se preferir rodar o Banco de dados local, utilizando o Docker, pode executar:

```shell
docker run -itd -e POSTGRES_USER=root -e POSTGRES_PASSWORD=toor -p 5432:5432 -v /data/docker-volumes:/var/lib/postgresql/data --name postgresql_14_4 postgres:14.4
```

Se preferir ainda pode subir uma instância do PgAdmin4. Para tal basta executar:

```shell
docker run --name pgadmin -p 5051:80 -e "PGADMIN_DEFAULT_EMAIL=user@seuemail.com" -e "PGADMIN_DEFAULT_PASSWORD=toor" -d dpage/pgadmin4
```

Para utilizar o PgAdmin acesse no seu broswer http://localhost:5051
O login será o valor que você colocou como `PGADMIN_DEFAULT_EMAIL` e a senha o valor de `PGADMIN_DEFAULT_PASSWORD`.
