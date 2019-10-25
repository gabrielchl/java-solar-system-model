/**
 * Properties and methods for asteroids.
 */
public abstract class Asteroid extends SolarObject {
    /**
     * Constructs the asteroid object.
     *
     * @param   ss      the solar system the planet will be added to
     */
    public Asteroid(SolarSystem ss) {
        this.ss = ss;
        dia = 2;
        col = "#4A4A4A"; // so that it's not hundreds of bright objects on the screen
    }

    /**
     * Triggers the planet to move 1 step foward
     */
    public void move() {
        current_ang = calc_new_ang(current_ang, ang);
        ss.drawSolarObject(dist, current_ang, dia, col);
    }
}
