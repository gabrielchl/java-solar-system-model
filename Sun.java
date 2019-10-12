/**
 * Methods for suns.
 */
public class Sun extends SolarObject {
    /**
     * Setting up the sun object.
     *
     * @param   ss      the solar system the sun will be added to
     * @param   dist    distance between the sun and the center of rotation (in million km)
     * @param   dia     diameter of the sun (in million km)
     * @param   col     color of the sun
     */
    public Sun(SolarSystem ss, double dist, double dia, String col) {
        this.ss = ss;
        this.dist = dist;
        this.dia = calc_display_dia(dia);
        this.col = col;
    }

    /**
     * Displays the sun.
     */
    public void move() {
        ss.drawSolarObject(dist, 0, dia, col);
    }
}
