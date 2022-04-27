package activities;

import java.util.Scanner;

public class Activity3 {

    public static void main(String[] args) {
        //double seconds = 1000000000;
        double EarthSeconds = 31557600;
        double MercurySeconds = 0.2408467;
        double VenusSeconds = 0.61519726;
        double MarsSeconds = 1.8808158;
        double JupiterSeconds = 11.862615;
        double SaturnSeconds = 29.447498;
        double UranusSeconds = 84.016846;
        double NeptuneSeconds = 164.79132;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Your age in seconds: ");
        double age = sc.nextDouble();

        System.out.println("Age on Mercury: " + age / EarthSeconds / MercurySeconds);
        System.out.println("Age on Venus: " + age / EarthSeconds / VenusSeconds);
        System.out.println("Age on Earth: " + age / EarthSeconds);
        System.out.println("Age on Mars: " + age / EarthSeconds / MarsSeconds);
        System.out.println("Age on Jupiter: " + age / EarthSeconds / JupiterSeconds);
        System.out.println("Age on Saturn: " + age/ EarthSeconds / SaturnSeconds);
        System.out.println("Age on Uranus: " + age / EarthSeconds / UranusSeconds);
        System.out.println("Age on Neptune: " + age / EarthSeconds / NeptuneSeconds);
    }
}
