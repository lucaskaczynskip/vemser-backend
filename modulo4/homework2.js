// cria um novo database com o nome pokesuits e usa ele
use pokesuits

// cria collection da mochila
db.createCollection("mochila")

// insere mais de uma mochila
db.mochila.insertMany([
	{
		_id: 1,
		qtdgreatball: 0,
		qtdnetball: 12,
		qtdpokebola: 4,
		qtdmasterball: 0
	},
	{
		_id: 2,
		qtdgreatball: 8,
		qtdnetball: 1,
		qtdpokebola: 15,
		qtdmasterball: 1
	}
])

// conferir as mochilas que foram criadas
db.mochila.find()

// cria uma nova collection
db.createCollection("pokemon")

// insere varios documentos
db.pokemon.insertMany([
	{
		"dificuldade": "RARO",
		"level": 8,
		"nome": "Bulbasaur",
		"peso": 1000.00,
		"racaPokemon": "Bulbasaur",
		"raridade": "COMUM",
		"sexo": "MASCULINO",
		"tipos": [ "GRASS", "POISON" ],
		"id_mochila": 1
	},
	{
		"dificuldade": "DIFICIL",
		"level": 100,
		"nome": "Arceus",
		"peso": 120.6,
		"racaPokemon": "Arceus",
		"raridade": "SUPER_RARO",
		"sexo": "",
		"tipos": [ "NORMAL" ],
		"id_mochila": 1
	},
	{
		"dificuldade": "MEDIO",
		"level": 99,
		"nome": "Gustavo",
		"peso": 80.0,
		"racaPokemon": "Snorlax",
		"raridade": "SUPER_RARO",
		"sexo": "MASCULINO",
		"tipos": [ "NORMAL" ],
		"id_mochila": 2
	}
])

// DELETE
db.pokemon.deleteOne({ nome: "Gustavo" })
db.pokemon.deleteMany({})

// inserindo os dados novamente
db.pokemon.insertMany([
	{
		"dificuldade": "RARO",
		"level": 8,
		"nome": "Bulbasaur",
		"peso": 1000.00,
		"racaPokemon": "Bulbasaur",
		"raridade": "COMUM",
		"sexo": "MASCULINO",
		"tipos": [ "GRASS", "POISON" ],
		"id_mochila": 1
	},
	{
		"dificuldade": "DIFICIL",
		"level": 100,
		"nome": "Arceus",
		"peso": 120.6,
		"racaPokemon": "Arceus",
		"raridade": "SUPER_RARO",
		"sexo": "",
		"tipos": [ "NORMAL" ],
		"id_mochila": 1
	},
	{
		"dificuldade": "MEDIO",
		"level": 99,
		"nome": "Gustavo",
		"peso": 80.0,
		"racaPokemon": "Snorlax",
		"raridade": "SUPER_RARO",
		"sexo": "MASCULINO",
		"tipos": [ "NORMAL" ],
		"id_mochila": 2
	}
])

// FIND EQUAL

// procura todos pokemons com sexo masculino
db.pokemon.find({sexo: "MASCULINO"})
// procura pelo tipo normal
db.pokemon.find({ tipos: "NORMAL" })


// FIND AND
db.pokemon.find(
	{
		peso: { $gte: 81 },
		sexo: "MASCULINO"
	}
)
db.pokemon.find(
	{
		dificuldade: "MEDIO",
		id_mochila: 2
	}
)

// FIND AND IN/OR
db.pokemon.find({ dificuldade: { $in: ["MEDIO", "DIFICIL"] }})
db.pokemon.find(
	{
		$or: [
			{ racaPokemon: "Snorlax" },
			{ racaPokemon: "Bulbasaur" }
		],
		peso: { $lte: 100 }
	}
)

// FIND EXPRESSAO
db.pokemon.find({ nome: /G.*/})
db.pokemon.find(
	{
	    $or: [
			{nome: /G.*/}, 
			{nome: /s$/ }	
		]
	}
)
	
// UPDATE
db.pokemon.updateMany({},{$set: { dificuldade: "MEDIO" }})
db.pokemon.updateOne({ raridade: "SUPER_RARO" }, 
	{
		$set: { dificuldade: "DIFICIL" }
	}
)