<template>
  <div>
    <h1>List of Pokemon:</h1>
    <button v-if="count > 0" v-on:click="getPrevious">Previous</button>
    <button v-if="count < 500" v-on:click="getNext">Next</button>
    <div class="pokeList">
        <router-link v-for="pokemon in pokemonArray" v-bind:key="pokemon.id"
            :to="{ name: 'detail', params: { id: pokemon.id } }">
            <div class="poke"> {{ pokemon.name }}</div>
        </router-link>
    </div>
  </div>
</template>

<script>
import service from '../services/pokemonService'
export default {
    data(){
        return {
            pokemonArray: [],
            count:0
        }
    },
    created() {  // life cycle hook
        service.getAllPokemon() // asynchronous communication
            .then((response) => {
                // console.log (response);
                let temp = response.data.results;
                this.pokemonArray = temp.map(this.extractPokemonId)
            })
    },
    methods: {
        extractPokemonId(item) {
            let pokemonIndex = item.url.indexOf('pokemon');
            let pokemonStr = item.url.substring(pokemonIndex);
            let slashIndex = pokemonStr.indexOf('/');
            let numberStr = pokemonStr.substring(slashIndex + 1, pokemonStr.length - 1);
            item.id = +numberStr;
            return item;
        },
        getMore() {
            service.getMorePokemon(this.count)
                .then((response) => {
                    let temp = response.data.results;
                    this.pokemonArray = temp.map(this.extractPokemonId)
                })
        },
        getNext() {
            this.count += 20;
            this.getMore();
        },
        getPrevious() {
            this.count -= 20;
            this.getMore();
        }

    }
}
</script>

<style>

</style>