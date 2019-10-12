/**
 * Properties and methods for moons.
 */
public class Moon extends SolarObject {
    private double dist_offset;
    private Planet planet;

    /**
     * Setting up the moon object.
     *
     * @param   ss      the solar system the planet will be added to
     * @param   dist    distance between the moon and the planet (in million km)
     * @param   dist_offset the distance offset (due to different scaling ratio between distance and diameter of solar objects,
     * a moon can be rendered inside a planet, thus this offset value) (in pixels)
     * @param   dia     diameter of the moon (in million km)
     * @param   col     color of the moon
     * @param   ang     angle to add per move
     * @param   planet  the planet the moon is revolving around
     */
    public Moon(SolarSystem ss, double dist, double dist_offset, double dia, String col, double ang, Planet planet) {
        this.ss = ss;
        this.dist = calc_display_dist(dist) + dist_offset;
        this.dist_offset = dist_offset;
        this.dia = calc_display_dia(dia);
        this.col = col;
        this.current_ang = 90;
        this.ang = ang;
        this.planet = planet;
    }

    /**
     * Triggers the moon to move 1 step foward
     */
    public void move() {
        current_ang = calc_new_ang(current_ang, ang);
        ss.drawSolarObjectAbout(dist, current_ang, dia, col, planet.get_dist(), planet.get_ang());
    }
}
