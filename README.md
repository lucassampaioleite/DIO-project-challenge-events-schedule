# DIO-project-challenge-events-schedule

### Descrição ###

Esta API foi desenvolvida para gerenciamentos de eventos, provendo serviços de CRUD com busca de endereço por CEP via consumo da API https://viacep.com.br/.

### Tecnologias e dependências utilizadas ###

* Spring Boot 3.1.5 com Maven
* JAVA 17
* Spring data JPA 
* Spring boot starter web (Tomcat embarcado)
* Spring cloud starter openfeign
* Spring doc OpenAPI
* Banco de dados MySQL


## Exemplos de uso da API ##

#### Buscar todos os eventos ####

* http GET - http://localhost:8080/api/event

* retorna http 200 com todos os eventos

```
#!json
[
  {
    "id": 1,
    "description": "string",
    "instant": "2023-10-23T14:05:35.372Z",
    "address": {
      "cep": "string",
      "logradouro": "string",
      "complemento": "string",
      "bairro": "string",
      "localidade": "string",
      "uf": "string",
      "ibge": "string",
      "gia": "string",
      "ddd": "string",
      "siafi": "string"
    }
  }
]
```


#### Buscar um evento pelo id ####

* http GET - http://localhost:8080/api/event/1

* retorna http 200 com o evento.
```
#!json
{
  "id": 1,
  "description": "string",
  "instant": "YYYY-MM-DD'T'hh:mm:ss.SSSZ",
  "address": {
    "cep": "string",
    "logradouro": "string",
    "complemento": "string",
    "bairro": "string",
    "localidade": "string",
    "uf": "string",
    "ibge": "string",
    "gia": "string",
    "ddd": "string",
    "siafi": "string"
  }
}
```
* retorna http 404 se não encontrar evento para o id.
* retorna http 400 se id for inválido

#### Criar um novo evento ####

* http POST - http://localhost:8080/api/event
* Json body:
```
#!json
{
    "description": "String",
    "instant": "YYYY-MM-DD'T'hh:mm:ss.SSSZ",
    "address": {
        "cep": "DDDDD-DDD"
    }
}
```
* retorna http 201 com o endereço criado:
```
#!json
{
  {
    "id": 103,
    "description": "Festa ao ar livre",
    "instant": "2023-10-23T15:30:00Z",
    "address": {
        "cep": "50030-040",
        "logradouro": "Rua da Moeda",
        "complemento": "",
        "bairro": "Recife",
        "localidade": "Recife",
        "uf": "PE",
        "ibge": "2611606",
        "gia": "",
        "ddd": "81",
        "siafi": "2531"
    }
}
```
* retorna http 400 se o body da requisição não for fornecido.


### Atualizar um evento existente ###

* http PUT - http://localhost:8080/api/event/1
* Json body:
```
#!json
{
  "id": 1,
  "description": "string",
  "instant": "2023-10-23T13:59:27.028Z",
  "address": {
    "cep": "string",
    "logradouro": "string",
    "complemento": "string",
    "bairro": "string",
    "localidade": "string",
    "uf": "string",
    "ibge": "string",
    "gia": "string",
    "ddd": "string",
    "siafi": "string"
  }
}
```
* retorna http 200 com o endereço atualizado
```
#!json
{
    "id": 103,
    "description": "Festa ao ar livre",
    "instant": "2023-10-24T15:30:00Z",
    "address": {
        "cep": "50030-040",
        "logradouro": "Rua da Moeda",
        "complemento": "",
        "bairro": "Recife",
        "localidade": "Recife",
        "uf": "PE",
        "ibge": "2611606",
        "gia": "",
        "ddd": "81",
        "siafi": "2531"
    }
}
```
* retorna http 400 se o body da requisição não for fornecido.
* retorna http 404 se não encontrar evento para o id.

### Excluir um evento ###

* http DELETE - http://localhost:8080/api/event/1

* returna http 204 em caso de sucesso.
* retorna http 404 se não encontrar evento para o id.

## Acesso a api-docs OpenAPI e interface do swagger

```
http://localhost:8080/v3/api-docs
http://localhost:8080/swagger-ui/index.html
```