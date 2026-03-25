# API Lista de Compras

Projeto Spring Boot criado para o tema **Lista de Compras**, atendendo aos requisitos:

- API REST com Spring
- CRUD completo de pelo menos duas entidades
- Tipos de dados variados
- Spring Data JPA
- Banco H2
- Lombok
- Endpoint de health check

## Entidades

### ListaCompra
- id (Long)
- nome (String)
- mercado (String)
- dataCriacao (LocalDate)
- ativa (Boolean)
- orcamento (BigDecimal)

### ItemCompra
- id (Long)
- nomeProduto (String)
- quantidade (Integer)
- precoEstimado (BigDecimal)
- categoria (String)
- comprado (Boolean)
- observacao (String)

## Rotas

### Listas de compras
- `GET /listas`
- `GET /listas/{id}`
- `POST /listas`
- `PUT /listas/{id}`
- `DELETE /listas/{id}`

### Itens de compra
- `GET /itens`
- `GET /itens/{id}`
- `POST /itens`
- `PUT /itens/{id}`
- `DELETE /itens/{id}`

### Health check
- `GET /health`

## Porta
A aplicação está configurada para rodar em:

```bash
http://localhost:8081
```

## H2 Console

```bash
http://localhost:8081/h2-console
```

Use:

- JDBC URL: `jdbc:h2:mem:listacomprasdb`
- User: `sa`
- Password: *(vazia)*

## Exemplo de JSON

### POST /listas
```json
{
  "nome": "Compras do mês",
  "mercado": "Supermercado Central",
  "dataCriacao": "2026-03-25",
  "ativa": true,
  "orcamento": 450.00
}
```

### POST /itens
```json
{
  "nomeProduto": "Arroz",
  "quantidade": 2,
  "precoEstimado": 28.90,
  "categoria": "Alimentos",
  "comprado": false,
  "observacao": "Pacote de 5kg"
}
```
