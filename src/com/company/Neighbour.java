package com.company;

/*
run a nearest neighbour on the passed in ArrayList
return the nearest neighbour result.
 */

        import java.awt.geom.Point2D;
        import java.util.ArrayList;

public class Neighbour {
    protected static ArrayList<Point2D> nearest(ArrayList<Point2D> cities) {

        ArrayList<Point2D> result = new ArrayList<>(); //holds final result.
        Point2D currentCity = cities.remove(0); //set current city to first array item.
        Point2D closestCity = cities.get(0); //set closest city to new first array item.
        Point2D possible; //for holding possible city.
        double dist; //hold current node distance.

        result.add(currentCity);

        //outside loop to iterate through array
        while (cities.size() > 0) {

            dist = Double.MAX_VALUE; //reset dist to max.

            //inner loop checks distance between current city and possible.
            for (int count = 0; count < cities.size(); count++) {
                possible = cities.get(count);
                if (currentCity.distance(possible) < dist) {
                    dist = currentCity.distance(possible);
                    closestCity = possible;
                }
            }
            /*
            once inner loop finds closest node
            set current city to closest, remove closest from cities
            and add current city to result.
             */
            currentCity = closestCity;
            cities.remove(closestCity);
            result.add(currentCity);
        }
        return result;
    }

    protected static ArrayList<Integer> nearest(float[][] cities_distance) {

        ArrayList<Integer> result = new ArrayList<>(); //holds final result.
        int currentCity = 0; //set current city to first array item.
        int closestCity = 1; //set closest city to new first array item.
        int possible; //for holding possible city.
        double dist; //hold current node distance.

        result.add(currentCity);

        //outside loop to iterate through array
        while (result.size() < cities_distance.length) {

            dist = Double.MAX_VALUE; //reset dist to max.

            //inner loop checks distance between current city and possible.
            for (int index = 0; index < cities_distance.length; index++) {
                if(!result.contains(index)){
                    possible = index;
                    float dist_tmp = cities_distance[Math.min(currentCity, possible)][Math.max(currentCity, possible)];
                    if (dist_tmp < dist) {
                        dist = dist_tmp;
                        closestCity = possible;
                    }
                }
            }
            /*
            once inner loop finds closest node
            set current city to closest, remove closest from cities
            and add current city to result.
             */
            currentCity = closestCity;
            result.add(currentCity);
        }
        return result;
    }
}

