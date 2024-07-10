import axios from 'axios';

const http = axios.create({
    baseURL: 'https://pokeapi.co/api/v2/pokemon'
})

export default {
    //declare methods to call api
    getAllPokemon() {
        return http.get();
    },
    getPokemonDetail(id) {
        return http.get(`/${id}`)
    },
    getMorePokemon(count) {
        return http.get(`/?offset=${count}&limit=20`)
    }
}