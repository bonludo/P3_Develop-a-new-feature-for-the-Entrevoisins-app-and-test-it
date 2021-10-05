package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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

        List<Neighbour> startNeighbourSize = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;

        Neighbour TestNeighbour = new Neighbour
                (1000,
              "JohnDoe",
              "avatarUrl",
              "11 route des ombres",
              "0644164286",
              "JohnDoe@facebook.fr",
              "j'aime tous qu'on ne comprend pas",
              false);


      // When
        service.createNeighbour(TestNeighbour);

        //Then
        assertTrue(service.getNeighbours().contains(TestNeighbour));
        assertFalse(service.getFavorites().contains(TestNeighbour));
        assertEquals(TestNeighbour,service.getNeighbours().get(service.getNeighbours().size()-1));
        assertNotEquals(startNeighbourSize.size(),service.getNeighbours().size());
    }

    @Test
    public void addFaroviteNeighbourWithSuccess() {
        Neighbour neighbourFavorite = service.getNeighbours().get(0);

        service.setFavorite(neighbourFavorite,true);

        assertTrue(service.getFavorites().contains(neighbourFavorite));
        assertEquals(1,service.getFavorites().size());
    }


    @Test
    public void removeNeighbourFromFavoriteWithSuccess() {
        Neighbour neighbourFavorite = service.getNeighbours().get(0);
        service.setFavorite(neighbourFavorite,true);
        assertTrue(service.getFavorites().contains(neighbourFavorite));
        assertEquals(1,service.getFavorites().size());

        service.setFavorite(neighbourFavorite,false);

        assertFalse(service.getFavorites().contains(neighbourFavorite));
        assertEquals(0,service.getFavorites().size());
    }
}
