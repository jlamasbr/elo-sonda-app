# elo-sonda-app

##Dúvidas
1. Poderá existir mais de uma sonda em uma mesma coordenada ?

2. No caso da entrada conter uma coordenada que não existe, por exemplo coordenada 6,6 em um planalto de 5,5. Neste caso, se houver algum movimento incorreto na rota de entrada, posso descartar todos os movimentos pois não seria uma rota valida ?

## Instruções
Existe duas opções para subir a api:

1- ) Através do maven, dentro do projeto sonda-api com o comando mvn spring-boot:run

2- ) Pela IDE executando a classe SondaApiApplication.java

A api responde pela url http://localhost:8080/platform

## Exemplos de requisição

As requisições devem ser feitas via POST na url http://localhost:8080/platform

{  
   "platform":{  
      "maxCoordinate":{  
         "longitude":5,
         "latitude":5
      }
   },
   "spaceProbes":[  
      {  
         "position":{  
            "coordinate":{  
               "longitude":1,
               "latitude":2
            },
            "direction":"N"
         },
         "commands":[  
            "L",
            "M",
            "L",
            "M",
            "L",
            "M",
            "L",
            "M",
            "M"
         ]
      },
  {  
         "position":{  
            "coordinate":{  
               "longitude":3,
               "latitude":3
            },
            "direction":"E"
         },
         "commands":[  
            "M",
            "M",
            "R",
            "M",
            "M",
            "R",
            "M",
            "R",
            "R",
            "M"
         ]
      }
   ]
}

##TODO
1- ) Incluir JPA para persistir as sondas na plataforma para posteriormente serem consultas via api (GET).
