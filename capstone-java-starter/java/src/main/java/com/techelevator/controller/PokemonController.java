package com.techelevator.controller;

import com.techelevator.dao.PokemonDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.PokemonDetail;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PokemonController {
    private PokemonDao pokemonDao;
    private UserDao userDao;

    public PokemonController(PokemonDao pokemonDao, UserDao userDao) {
        this.pokemonDao = pokemonDao;
        this.userDao = userDao;
    }

    @PostMapping("/favorite")
    public PokemonDetail saveFavorite(@RequestBody PokemonDetail pokemonDetail, Principal principal) {
        User user = userDao.getUserByUsername(principal.getName());
        return pokemonDao.saveFavorites(pokemonDetail, user.getId());
    }

    @GetMapping("/favorites")
    public List<PokemonDetail> listFavorites(Principal principal) {
        User user = userDao.getUserByUsername(principal.getName());
        return pokemonDao.getAllFavorites(user.getId());
    }


}
