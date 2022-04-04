// cria um novo database com o nome pokesuits e usa ele
use pokesuits

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
		"tipos": [ "GRASS", "POISON" ]
	},
	{
		"dificuldade": "DIFICIL",
		"level": 100,
		"nome": "Arceus",
		"peso": 120.6,
		"racaPokemon": "Arceus",
		"raridade": "SUPER_RARO",
		"sexo": "",
		"tipos": [ "NORMAL" ]
	},
	{
		"dificuldade": "MEDIO",
		"level": 99,
		"nome": "Gustavo",
		"peso": 80.0,
		"racaPokemon": "Snorlax",
		"raridade": "SUPER_RARO",
		"sexo": "MASCULINO",
		"tipos": [ "NORMAL" ]
	}
])

// busca um pokemon pelos tipos do array: NORMAL ou POISON
// busca necessariamente pokemons com peso maior ou igual a 100
db.pokemon.find(
	{
		$or: [
			{ "tipos": "NORMAL"},
			{ "tipos": "POISON"},
		],
		"peso": { $gte: 100 }
	}
)

// delete o pokemon com nome Gustavo
db.pokemon.deleteOne({ "nome": "Gustavo" })

// faz um select com todas as documents do banco
db.pokemon.find()