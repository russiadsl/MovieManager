package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movies;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class MovieManager {

    private Movies[] movies = new Movies[0];
    private int newResultLength = 10;

    public void add(Movies movie) {
        int length = movies.length + 1;
        Movies[] tmp = new Movies[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movies[] getAll() {
        Movies[] result = new Movies[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movies[] tmp = new Movies[length];
        int index = 0;
        for (Movies movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public Movies[] lastAddedMovies() {
        int resultLength;

        if (newResultLength < movies.length) {
            resultLength = this.newResultLength;
        } else {
            resultLength = movies.length; }

        Movies[] result = new Movies[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
