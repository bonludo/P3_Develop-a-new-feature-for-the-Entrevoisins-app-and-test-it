package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourRepository {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    List<Neighbour> getFavorites();
    //todo add to favorite // toggle

   void addFavorite(Neighbour neighbour, boolean favorite);

}
/* Interface public (accessible partout) qui dit ce que fait l'application
l'interface est implémenté dans la classe DummyNeighbourRepopsitory
- Affichage de la liste [List<Neighbour> getNeighbours();]
- Suppression d'un utilisateur [void deleteNeighbour(Neighbour neighbour);]
- Creer un utilisateur [void createNeighbour(Neighbour neighbour);]
- Ajoute un favori[List<Neighbour> getFavorites();]
 */