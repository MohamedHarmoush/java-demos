package com.harmoush.demo.comparing_objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareExamples {


    public static void main(String[] args) {
        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie("Movie 1", 8.5, 2010));
        movieList.add(new Movie("Movie 2", 8.7, 2001));
        movieList.add(new Movie("Movie 3", 6.3, 2005));
        movieList.add(new Movie("Movie 4", 4.7, 2017));
        movieList.add(new Movie("Movie 5", 6.6, 2021));
        movieList.add(new Movie("Movie 6", 6.8, 2003));
        movieList.add(new Movie("Movie 7", 9.1, 2018));
        movieList.add(new Movie("Movie 8", 5.5, 2019));

        Collections.sort(movieList); // natural ordering sort by year
        System.out.println("natural ordering sort by year");
        printMovies(movieList);
        System.out.println("**********************\n");


        movieList.sort(new RatingCompare()); // sort by Rating
        System.out.println("sort by rating");
        printMovies(movieList);
        System.out.println("**********************\n");

        movieList.sort(new NameCompare());  // sort by Name
        System.out.println("sort by name");
        printMovies(movieList);
    }

    private static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }


    public static class RatingCompare implements Comparator<Movie> {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Double.compare(o1.getRating(), o2.getRating());
        }
    }

    public static class NameCompare implements Comparator<Movie> {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
