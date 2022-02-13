package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {

    MovieManager movieManager = new MovieManager();

    Movies bloodShot = new Movies(1, 1, "BloodShot", "action");
    Movies onward = new Movies(2, 2, "Onward", "cartoon");
    Movies belgradHotel = new Movies(3, 3, "BelgradHotel", "comedy");
    Movies theGentlemen = new Movies(4, 4, "TheGentlemen", "action");
    Movies theInvisibleMan = new Movies(5, 5, "TheInvisibleMan", "horror");
    Movies trollsWorldTour = new Movies(6, 6, "TrollsWorldTour", "cartoon");
    Movies theNumberOne = new Movies(7, 7, "TheNumberOne", "comedy");
    Movies knivesOut = new Movies(8, 8, "Knives out", "detective");
    Movies joker = new Movies(9,9, "Joker","drama");
    Movies fordVFerrari = new Movies(10,10,"FordVFerrari","biography");
    Movies gisaengchung = new Movies(11, 11, "Gisaengchung", "drama");

    @BeforeEach

    public void setUp() {

        movieManager.add(bloodShot);
        movieManager.add(onward);
        movieManager.add(belgradHotel);
        movieManager.add(theGentlemen);
        movieManager.add(theInvisibleMan);
        movieManager.add(trollsWorldTour);
        movieManager.add(theNumberOne);

    }

    @Test
    public void addMovie() {

        Movies avengersEndgame = new Movies(8, 8, "Avengers: Endgame", "fantastic action");

        movieManager.add(avengersEndgame);

        Movies[] actual = movieManager.getAll();
        Movies[] expected = new Movies[]{avengersEndgame, theNumberOne, trollsWorldTour, theInvisibleMan, theGentlemen, belgradHotel, onward, bloodShot};

        assertArrayEquals(expected, actual);

    }

    @Test
    void getAll() {

        movieManager.getAll();

        Movies[] actual = movieManager.getAll();
        Movies[] expected = new Movies[]{theNumberOne, trollsWorldTour, theInvisibleMan, theGentlemen, belgradHotel, onward, bloodShot};

        assertArrayEquals(expected, actual);

    }

    @Test
    void removeById() {

        movieManager.removeById(2);

        Movies[] actual = movieManager.getAll();
        Movies[] expected = new Movies[]{theNumberOne, trollsWorldTour, theInvisibleMan, theGentlemen, belgradHotel, bloodShot};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void getLastAddedMovies() {

        MovieManager movieManager = new MovieManager();

        movieManager.add(bloodShot);
        movieManager.add(onward);
        movieManager.add(belgradHotel);
        movieManager.add(theGentlemen);
        movieManager.add(theInvisibleMan);
        movieManager.add(trollsWorldTour);
        movieManager.add(theNumberOne);
        movieManager.add(knivesOut);
        movieManager.add(joker);
        movieManager.add(fordVFerrari);
        movieManager.add(gisaengchung);


        Movies[] actual = movieManager.lastAddedMovies();
        Movies[] expected = new Movies[]{gisaengchung, fordVFerrari, joker, knivesOut, theNumberOne, trollsWorldTour, theInvisibleMan, theGentlemen, belgradHotel, onward};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void get5LastAddedMovies() {

        MovieManager movieManager = new MovieManager();

        movieManager.add(bloodShot);
        movieManager.add(onward);
        movieManager.add(belgradHotel);
        movieManager.add(theGentlemen);
        movieManager.add(theInvisibleMan);
        movieManager.add(trollsWorldTour);
        movieManager.add(theNumberOne);
        movieManager.add(knivesOut);
        movieManager.add(joker);
        movieManager.add(fordVFerrari);
        movieManager.add(gisaengchung);

        movieManager.setNewResultLength(5);
        Movies[] actual = movieManager.lastAddedMovies();
        Movies[] expected = new Movies[]{gisaengchung, fordVFerrari, joker, knivesOut, theNumberOne};

        assertArrayEquals(expected, actual);

    }
}