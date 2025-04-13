PERSONAGENS:

{

  "nome": "Leonas",
  
  "nomeAventureiro": "SPARTANOS",
  
  "classe": "GUERREIRO",
  
  "level": 120,
  
  "listaItensMagico": [],
  
  "forca": 4,
  
  "defesa": 6
  
}

GET MAPPING - FUNCIONANDO -> path: http://localhost:8080/personagem

GET MAPPING POR ID - FUNCIONANDO -> path: http://localhost:8080/personagem/{id}

POST MAPPING - FUNCIONANDO- > path: http://localhost:8080/personagem

PUT MAPPING - FUNCIONANDO -> path: http://localhost:8080/personagem/{id}

DELETE MAPPING - FUNCIONANDO -> path: http://localhost:8080/personagem/{id}


--------------------------------------------------------------------------------------

ITEM MAGICO:

{  

  "nome": "ARCO", 
  
  "tipoItem": "ARMA",
  
  "forca": 3, 
  
  "defesa": 0
  
}


GET MAPPING - FUNCIONANDO -> path: http://localhost:8080/itemMagico

GET MAPPING POR ID - FUNCIONANDO -> path: http://localhost:8080/itemMagico/{id}

POST MAPPING - FUNCIONANDO -> path: http://localhost:8080/itemMagico

PUT MAPPING - FUNCIONANDO -> path: http://localhost:8080/itemMagico/{id}

DELETE MAPPING - FUNCIONANDO -> path: http://localhost:8080/itemMagico/{id}

--------------------------------------------------------------------------------------
ITEM MÁGICO DO PERSONAGEM

GET MAPPING - FUNCIONANDO -> http://localhost:8080/personagem/{idPersonagem}/item

POST MAPPING - FUNCIONANDO -> http://localhost:8080/personagem/{idPersonagem}/item/{idItem}

DELETE MAPPING - FUNCIONANDO -> http://localhost:8080/personagem/{idPersonagem}/item/{idItem}

--------------------------------------------------------------------------------------
AMULETO POR PERSONAGEM

GET MAPPING - FUNCIONANDO ->http://localhost:8080/personagem/{idPersonagem}/amuleto
