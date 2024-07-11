<template>
    <div>
        <h1>Pokemon Detail for {{ pokemon.name }}</h1>
        <p>Height: {{ pokemon.height }}  Weight: {{ pokemon.weight }}</p>
        <img :src="frontImg" />
        <br>
        <img :src="backImg" alt="">
    </div>
</template>

<script>
import service from '../services/PokemonService';

export default {
    props: {
        id: String
    },
    data (){
        return {
            pokemon: {},
            frontImg: "",
            backImg: ""
        }
    },
    created() {
        service.getPokemonDetail(this.id)
        .then ((response) => {
            this.pokemon = response.data;
            this.frontImg = response.data.sprites.front_default;
            this.backImg = response.data.sprites.back_default;
        })
    }
}
</script>

<style scoped>
img {
    width: 200px;
    height: auto;
}
</style>