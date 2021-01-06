package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favoriteList = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public List<Neighbour> getFavoriteNeighbours() {
        for (Neighbour neighbour : getNeighbours()){
            if(neighbour.isFavorite() && !favoriteList.contains(neighbour)){
                favoriteList.add(neighbour);
            }
        }
        return favoriteList;
    }

    /**
     * Add a favorite neighbour
     * {@param neighbour}
     */
    @Override
    public void addFavoriteNeighbour(Neighbour neighbour) {
        if(neighbour.isFavorite()){
            neighbour.setFavorite(false);
            favoriteList.remove(neighbour);
        }else{
            neighbour.setFavorite(true);
            favoriteList.add(neighbour);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        favoriteList.remove(neighbour);
    }
}
