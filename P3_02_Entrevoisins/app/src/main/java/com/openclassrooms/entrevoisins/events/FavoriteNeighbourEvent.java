package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user deletes a Neighbour
 */
public class FavoriteNeighbourEvent {

    /**
     * Neighbour to change statut favorite
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public FavoriteNeighbourEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }
}