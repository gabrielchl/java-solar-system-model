/**
 * Properties and methods for asteroids.
 */
public class Asteroid extends SolarObject {
    private SolarSystem ss;
    private double dist;
    private double ang;
    private double current_ang;
    private double dia;
    private String col;

    /**
     * Constructs the asteroid object.
     * Upon construction, it will decide what type of asteroid will it be,
     * and set its properties according to the type.
     *
     * @param   ss      the solar system the planet will be added to
     */
    public Asteroid(SolarSystem ss) {
        this.ss = ss;

        double asteroid_type = Math.random();

        if (asteroid_type < 0.7) { // asteroid belt
            dist = calc_display_dist(Math.random() * 200 + 250) + 140;
            ang = Math.random() * 0.3 + 0.5;
            current_ang = Math.random() * 360;
        } else { // trojans
            dist = calc_display_dist(Math.random() * 200 + 720) + 140;
            ang = 0.08403;
            current_ang = Math.random() * 70;
            if (current_ang < 20) current_ang += Math.random() * 20;
            if (current_ang > 50) current_ang -= Math.random() * 20;
        }

        if (asteroid_type >= 0.7 && asteroid_type < 0.85) { // greeks
            current_ang += 110;
        }

        dia = 2;
        col = "#444444"; // so that it's not hundreds of bright objects on the screen
    }

    /**
     * Triggers the planet to move 1 step foward
     */
    public void move() {
        current_ang = calc_new_ang(current_ang, ang);
        ss.drawSolarObject(dist, current_ang, dia, col);
    }
}
