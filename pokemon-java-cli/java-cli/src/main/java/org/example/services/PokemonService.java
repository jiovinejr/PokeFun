package org.example.services;

import org.example.models.Pokemon;
import org.example.models.Results;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PokemonService {
    private RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "https://pokeapi.co/api/v2/pokemon";

    public List<Pokemon> getAllPokemon(int startVal) {
        Results rs = restTemplate.getForObject(
                API_URL + "?offset=" + startVal + "&limit=20",
                Results.class
        );
        List<Pokemon> list = rs.getResults();
        for (Pokemon p: list) {
            String url = p.getUrl();

            int pokemonIndex = url.indexOf("pokemon");
            String pokemonStr = url.substring(pokemonIndex); // pokemon/3/
            int slashIndex = pokemonStr.indexOf("/");
            String idStr =  pokemonStr.substring(slashIndex + 1, pokemonStr.length() - 1);
            p.setId(Integer.parseInt(idStr));
        }
        return list;
    }

}
