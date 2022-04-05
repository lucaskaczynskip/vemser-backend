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

// FIND ORDENADO
db.mochila.find({
	qtdpokebola: { $gt: 2 }
}).sort("qtdpokebola")
db.pokemon.find().sort("nome")

// FIND LIMIT
db.pokemon.find().sort("nome").limit(2)

// FIND ARRAY
db.pokemon.find({ tipos: "GRASS" })

// PROJECTIONS
db.pokemon.find({ }, { nome: 1, tipos: 1 })
db.pokemon.find({ }, { dificuldade: 0 })

// AGGREGATE
db.pokemon.aggregate(
	[
		{ $match: { } },
		{ $group: { _id: "$id_mochila", qtd_pokemon: { $sum: 1 } } }
	]
)