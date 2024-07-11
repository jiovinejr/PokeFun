<template>
  <div>
        <h2>{{ pokemon.name }}</h2>
        <p>Height: {{ pokemon.height }}  Weight: {{ pokemon.weight }}</p>   
        <img :src="picture">
  </div>
</template>

<script>
import service from '../services/pokemonService'
export default {
    props:{
        id: String
    },
    data() {
        return{
            pokemon: {},
            picture: ""
        }
    },
    created(){
        service.getPokemonDetail(this.id)
        .then ((response) => {
            this.pokemon = response.data;
            this.picture = response.data.sprites.front_default;
        })
    }
}
</script>

<style>

</style>