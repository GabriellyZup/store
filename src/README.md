[
{
"name": "cliente1 cliente",
"cpf": "11223344551",
"email": "cliente1@email.com"
},
{
"name": "cliente2 cliente",
"cpf": "11223344552",
"email": "cliente2@email.com"
},
{
"name": "cliente3 cliente",
"cpf": "11223344553",
"email": "cliente3@email.com"
},
{
"name": "cliente4 cliente",
"cpf": "11223344554",
"email": "cliente4@email.com"
},
{
"name": "cliente5 cliente",
"cpf": "11223344555",
"email": "cliente5@email.com"
}
]

[
{
"name": "Produto1",
"price": 10.0,
"quantity": 0
},
{
"name": "Produto2",
"price": 15.0,
"quantity": 0
},
{
"name": "Produto3",
"price": 20.0,
"quantity": 0
},
{
"name": "Produto4",
"price": 25.0,
"quantity": 10
},
{
"name": "Produto5",
"price": 30.0,
"quantity": 5
},
{
"name": "Produto6",
"price": 35.0,
"quantity": 8
},
{
"name": "Produto 7",
"price": 40.0,
"quantity": 12
},
{
"name": "Produto 8",
"price": 45.0,
"quantity": 7
},
{
"name": "Produto 9",
"price": 50.0,
"quantity": 6
},
{
"name": "Produto 10",
"price": 55.0,
"quantity": 9
}
]

[
{
"cpf": "11223344551",
"produtos": [
{
"nome": "Produto 4"
},
{
"nome": "Produto 5"
}
]
},
{
"cpf": "11223344552",
"produtos": [
{
"nome": "Produto 6"
},
{
"nome": "Produto 7"
}
]
},
{
"cpf": "11223344553",
"produtos": [
{
"nome": "Produto 8"
},
{
"nome": "Produto 9"
}
]
},
{
"cpf": "11223344554",
"produtos": [
{
"nome": "Produto 10"
},
{
"nome": "Produto 4"
}
]
},
{
"cpf": "11223344555",
"produtos": [
{
"nome": "Produto 5"
},
{
"nome": "Produto 6"
}
]
},
{
"cpf": "11223344551",
"produtos": [
{
"nome": "Produto 1"
},
{
"nome": "Produto 4"
}
]
},
{
"cpf": "11223344552",
"produtos": [
{
"nome": "Produto 1"
},
{
"nome": "Produto 2"
}
]
}
]







Invalidos

[
{
"name": "cliente6 cliente",
"cpf": "1122334455", // CPF com menos de 11 dígitos
"email": "cliente6@email.com"
},
{
"name": "cliente7 cliente",
"cpf": "11223344556",
"email": "cliente7email.com" // Email inválido
},
{
"name": "cliente8 cliente",
"cpf": "11223344abc", // CPF inválido
"email": "cliente8email" // Email inválido
}
]