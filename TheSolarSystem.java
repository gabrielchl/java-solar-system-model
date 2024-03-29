import javax.swing.*;
import java.awt.*;

/**
 * Main class. Creates all solar objects and controls their movement.
 */
public class TheSolarSystem extends SolarSystem {
    public final static int width = 1700;
    public final static int height = 800;
    public final static double speed_multiplier = 0.7;

    // all distances and diameters in million km
    // all angles are not really angles, just relative to earth and earth is 1

    public final static double solar_system_width = 4495.0;

    /**
     * Creates the one and only solar system. Sets global settings according to arguments.
     *
     * @param   args    user input arguments
     */
    public static void main(String[] args) {
        TheSolarSystem our_solar_system = new TheSolarSystem(1700, 800);
    }

    /**
     * Creates all solar objects and controls their movement.
     *
     * @param   width   width of the window
     * @param   height  height of the window
     */
    public TheSolarSystem(int width, int height) {
        super(width, height); // apply onto super class's constructor

        Sun sun = new Sun(this, 0, 1.391, "#F79703");

        Planet mercury = new Planet(this, 57.91, 0.004879, "#ECECEC", 4.166);

        Planet venus = new Planet(this, 108.2, 0.012104, "#EED1A0", 1.6129);

        Planet earth = new Planet(this, 149.6, 0.012742, "#40AEFB", 1);
        Moon our_lovely_moon = new Moon(this, 0.238855, 4, 0.003474, "WHITE", 13.186, earth);

        Planet mars = new Planet(this, 227.9, 0.006779, "#C05804", 0.526);

        Planet jupiter = new Planet(this, 778.5, 0.13982, "#D49142", 0.08403);
        Moon io = new Moon(this, 0.4217, 15, 0.003643, "WHITE", 206.214, jupiter);
        Moon europa = new Moon(this, 0.175, 16, 0.003122, "WHITE", 102.8169, jupiter);
        Moon ganymede = new Moon(this, 0.28, 17, 0.005262, "WHITE", 51.048951, jupiter);
        Moon callisto = new Moon(this, 0.49, 18, 0.004821, "WHITE", 21.8693, jupiter);

        Planet saturn = new Planet(this, 1434.0, 0.11646, "#ECDCAF", 0.0340136);
        Moon titan = new Moon(this, 1.221, 15, 0.0051495, "WHITE", 22.8125, saturn);

        Planet uranus = new Planet(this, 2871.0, 0.050, "#40AEFB", 0.01190476);

        Planet neptune = new Planet(this, 4495.0, 0.049244, "#2F73D4", 0.0060975);

        Asteroid[] asteroids = new Asteroid[950];
        double asteroid_type;
        for (int i = 0; i < asteroids.length; i++) {
            asteroid_type = Math.random();
            if (asteroid_type < 0.7) { // asteroid belt
                asteroids[i] = new AsteroidBelt(this);
            } else if (asteroid_type < 0.85) { //greeks
                asteroids[i] = new AsteroidGreek(this);
            } else { // trojans
                asteroids[i] = new AsteroidTrojan(this);
            }
        }

        SolarObject[] solar_objects = {mercury, venus, earth, mars, jupiter, saturn, uranus, neptune,
            our_lovely_moon, io, europa, ganymede, callisto, titan};

        while (true) { // main loop for the animation
            this.finishedDrawing();

            sun.move();
            for (SolarObject solar_object : solar_objects) solar_object.move();
            for (Asteroid asteroid : asteroids) asteroid.move();

            try {
                Thread.sleep(10);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
