package com.company;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Length {

    public static double routeLength(ArrayList<Point2D> cities) {

        //Calculate the length of a TSP route held in an ArrayList as a set of Points
        double result = 0; //Holds the route length
        Point2D prev = cities.get(cities.size() - 1);

        //Set the previous city to the last city in the ArrayList as we need to measure the length of the entire loop
        for (Point2D city : cities) {

            //Go through each city in turn
            result += city.distance(prev);

            //get distance from the previous city
            prev = city;

            //current city will be the previous city next time
        }
        return result;
    }

    public static double routeLength(float[][] cities_distance) {

        //Calculate the length of a TSP route held in an ArrayList as a set of Points
        double result = 0; //Holds the route length
        int prev = 0;

        //Set the previous city to the last city in the ArrayList as we need to measure the length of the entire loop
        for (int i=1; i < cities_distance.length; i++) {

            //Go through each city in turn
            result += cities_distance[Math.min(prev, i)][Math.max(prev, i)];

            //get distance from the previous city
            prev = i;

            //current city will be the previous city next time
        }
        return result+cities_distance[0][cities_distance.length-1];
    }

    public static double routeLength(ArrayList<Integer> cities, float[][] cities_distance) {

        //Calculate the length of a TSP route held in an ArrayList as a set of Points
        double result = 0; //Holds the route length
        int prev = 0;

        //Set the previous city to the last city in the ArrayList as we need to measure the length of the entire loop
        for (int i : cities) {

            //Go through each city in turn
            result += cities_distance[Math.min(prev, i)][Math.max(prev, i)];

            //get distance from the previous city
            prev = i;

            //current city will be the previous city next time
        }
        return result+cities_distance[0][cities.get(cities.size()-1)];
    }
}
