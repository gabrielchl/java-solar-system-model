/**
 * Methods for planets.
 */
public class Planet extends SolarObject {
    /**
     * Setting up the planet object.
     *
     * @param   ss      the solar system the planet will be added to
     * @param   dist    distance between the planet and the center of rotation (in million km)
     * @param   dia     diameter of the planet (in million km)
     * @param   col     color of the planet
     * @param   ang     angle to add per move
     */
    public Planet(SolarSystem ss, double dist, double dia, String col, double ang) {
        this.ss = ss;
        this.dist = calc_display_dist(dist) + 140;
        this.dia = calc_display_dia(dia);
        this.col = col;
        this.current_ang = 90;
        this.ang = ang;
    }

    /**
     * Getter for {@link Planet#dist}, used especially for moons.
     *
     * @return  the dist property
     */
    public double get_dist() {
        return dist;
    }

    /**
     * Getter for {@link Planet#ang}, used especially for moons.
     *
     * @return  the ang property
     */
    public double get_ang() {
        return current_ang;
    }

    /**
     * Triggers the planet to move 1 step foward
     */
    public void move() {
        current_ang = calc_new_ang(current_ang, ang);
        ss.drawSolarObject(dist, current_ang, dia, col);
    }
}
