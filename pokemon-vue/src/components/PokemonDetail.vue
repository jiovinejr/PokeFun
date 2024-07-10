<template>
  <div>

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
            pokemon: {}
        }
    },
    created(){
        service.getPokemonDetail(this.id)
        .then ((response) => {
            this.pokemon = response.data
        })
    }
}
</script>

<style>

</style>