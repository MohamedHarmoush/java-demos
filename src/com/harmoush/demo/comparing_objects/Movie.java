package com.harmoush.demo.comparing_objects;

public class Movie implements Comparable<Movie> {

    private String name;
    private double rating;
    private int year;

    // Constructor
    public Movie(String nm, double rt, int yr) {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    // Used to sort movies by year
    public int compareTo(Movie m) {
        return year - m.year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }
}
