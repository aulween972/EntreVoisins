package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


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
     *
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public void setFavoriteNeighbour(Neighbour neighbour) {
        int index = 0;
        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i) == neighbour) {
                index = i;
            }

        }

        Neighbour newNeighbour = neighbour;

        if (neighbour.getIsFavorite()) {
            newNeighbour.setIsFavorite(false);

        } else {
            newNeighbour.setIsFavorite(true);
        }


        neighbours.set(index, newNeighbour);

    }

    @Override
    public List<Neighbour> getFavoriteNeighbours() {

        List<Neighbour> favoriteList = new ArrayList<>();
        for (int i = 0; i < neighbours.size(); i++) {

            Neighbour mNeighbour = neighbours.get(i);

            if (mNeighbour.getIsFavorite()) {
                favoriteList.add(mNeighbour);
            }

        }

        return favoriteList;

    }
}
