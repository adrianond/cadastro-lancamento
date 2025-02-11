# proposta-credito-api

# imagem docker oracle : docker run -d -p 1521:1521 -e ORACLE_PASSWORD=admin gvenzl/oracle-xe

# docker-compose.yml: executa imagens oracle, zookeeper, kafka e kafkadrop

# JSON CADASTRO DE PROPOSTA DE CREDITO

{
"clientePropostaCreditoDto":{
"cpf":"83393494066",
"dataNascimento":"09/04/1997",
"enderecoPropostaCreditoDto":{
"bairro":"Tatuape",
"cep":"03081003",
"cidade":"São Paulo",
"complemento":"casa 01",
"endereco":"Rua Tuiuti",
"numero":10,
"uf":"SP"
},
"nome":"Carlos Teste",
"rg":"289556417",
"telefonePropostaCreditoDtoList":[
{
"ddd":"11",
"numero":"999999999",
"tipo":"celular"
}
]
},
"produto":"Emprestimo Consignado",
"status":"Preenchimento",
"valor":50.000
}