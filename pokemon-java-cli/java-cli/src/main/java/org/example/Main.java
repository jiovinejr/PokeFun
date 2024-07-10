package org.example;

import org.example.models.Pokemon;
import org.example.services.PokemonService;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PokemonService service = new PokemonService();
        List<Pokemon> pokemonList = new ArrayList<>();
        int choice = 0;
        do {
            System.out.println("Let's catch some Pokemon");
            System.out.println("1. Get First 20");
            System.out.println("2. Get Second 20");
            System.out.println("3. Get Third 20");
            System.out.println("3. Quit");
            System.out.print("Enter Choice: ");

            choice = Integer.parseInt(input.nextLine());

            switch (choice){
                case 1:
                    pokemonList = service.getAllPokemon(0);
                    printPoke(pokemonList);
                    break;
                case 2:
                    pokemonList = service.getAllPokemon(20);
                    printPoke(pokemonList);
                    break;
                case 3:
                    pokemonList = service.getAllPokemon(40);
                    printPoke(pokemonList);
                    break;
            }
        } while(choice != 4);

    }

    public static void printPoke(List<Pokemon> pokemonList){
        for (Pokemon p: pokemonList) {
            System.out.println(p.getId() + " - " + p.getName());
        }
    }
}