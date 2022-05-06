const pokémon = Object.freeze([
    { "id": 1,   "name": "Bulbasaur",  "types": ["poison", "grass"] },
    { "id": 5,   "name": "Charmeleon", "types": ["fire"] },
    { "id": 9,   "name": "Blastoise",  "types": ["water"] },
    { "id": 12,  "name": "Butterfree", "types": ["bug", "flying"] },
    { "id": 16,  "name": "Pidgey",     "types": ["normal", "flying"] },
    { "id": 23,  "name": "Ekans",      "types": ["poison"] },
    { "id": 24,  "name": "Arbok",      "types": ["poison"] },
    { "id": 25,  "name": "Pikachu",    "types": ["electric"] },
    { "id": 37,  "name": "Vulpix",     "types": ["fire"] },
    { "id": 52,  "name": "Meowth",     "types": ["normal"] },
    { "id": 63,  "name": "Abra",       "types": ["psychic"] },
    { "id": 67,  "name": "Machamp",    "types": ["fighting"] },
    { "id": 72,  "name": "Tentacool",  "types": ["water", "poison"] },
    { "id": 74,  "name": "Geodude",    "types": ["rock", "ground"] },
    { "id": 87,  "name": "Dewgong",    "types": ["water", "ice"] },
    { "id": 98,  "name": "Krabby",     "types": ["water"] },
    { "id": 115, "name": "Kangaskhan", "types": ["normal"] },
    { "id": 122, "name": "Mr. Mime",   "types": ["psychic"] },
    { "id": 133, "name": "Eevee",      "types": ["normal"] },
    { "id": 144, "name": "Articuno",   "types": ["ice", "flying"] },
    { "id": 145, "name": "Zapdos",     "types": ["electric", "flying"] },
    { "id": 146, "name": "Moltres",    "types": ["fire", "flying"] },
    { "id": 148, "name": "Dragonair",  "types": ["dragon"] }
]);

// Arran of pokémon objects where the id is evenly divisible by 3
const pokeDivIdBy3 = pokémon.filter( val => val.id % 3 === 0 );
console.log(pokeDivIdBy3);

// Array of pokémon objects that are "fire" type
const pokeFireType = pokémon.filter( val => val.types.includes("fire"));
console.log(pokeFireType);

// Array of pokémon objects that have more than one type
const pokeMutiType = pokémon.filter( val => val.types.length > 1);
console.log(pokeMutiType);

// Array with just the names of the pokémon
const pokeName = pokémon.map(val => val.name);
console.log(pokeName);

// // Array with just the names of pokémon with an id greater than 99
const pokeName99 = pokémon.filter(val => val.id > 99).map(val => val.name);
console.log(pokeName99);

// // Array with just the names of the pokémon whose only type is poison
const pokeNamePoison = pokémon.filter(val => val.types.length == 1 && val.types[0] === "poison").map(val => val.name);
console.log(pokeNamePoison);

// // Array containing just the first type of all the pokémon whose second type is "flying"
const poke1stType2ndFlying = pokémon.filter(val => val.types[1] === "flying").map(val => val.types[0]);
console.log(poke1stType2ndFlying);

// Array containing just the first type of all the pokémon whose second type is "flying"
const pokeCount = pokémon.filter( val => val.types.includes("normal")).length;
console.log(pokeCount);