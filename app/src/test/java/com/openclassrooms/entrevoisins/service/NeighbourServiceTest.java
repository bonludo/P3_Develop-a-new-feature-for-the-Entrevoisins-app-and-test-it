package com.openclassrooms.entrevoisins.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourRepository service;

    @Before
    public void setup() {
        service = DI.getNewInstanceRepository();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void addNeighbourButDontFavoriteWithSuccess() {
        //Given

        Neighbour testNeighbour = new Neighbour(1000,
            "JohnDoe",
            "avatarUrl",
            "11 route des ombres",
            "0644164286",
            "JohnDoe@facebook.fr",
            "j'aime tous qu'on ne comprend pas",
            false
        );


        // When
        service.createNeighbour(testNeighbour);

        //Then
        assertTrue(service.getNeighbours().contains(testNeighbour));
        assertFalse(service.getFavorites().contains(testNeighbour));
        assertEquals(testNeighbour, service.getNeighbours().get(service.getNeighbours().size() - 1));
    }

    @Test
    public void addFavoriteNeighbourWithSuccess() {
        Neighbour neighbourFavorite = service.getNeighbours().get(0);

        service.setFavorite(neighbourFavorite, true);

        assertTrue(service.getFavorites().contains(neighbourFavorite));
        assertEquals(1, service.getFavorites().size());
    }


    @Test
    public void removeNeighbourFromFavoriteWithSuccess() {
        Neighbour neighbourFavorite = service.getNeighbours().get(0);
        service.setFavorite(neighbourFavorite, true);

        service.setFavorite(neighbourFavorite, false);

        assertFalse(service.getFavorites().contains(neighbourFavorite));
        assertEquals(0, service.getFavorites().size());
        assertTrue(service.getNeighbours().contains(neighbourFavorite));
    }
}
