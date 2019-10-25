/**
 * Methods for asteroids (belt).
 */
public class AsteroidBelt extends Asteroid {
    /**
     * Constructs the asteroid (belt) object.
     *
     * @param   ss      the solar system the planet will be added to
     */
    public AsteroidBelt(SolarSystem ss) {
        super(ss);
        dist = calc_display_dist(Math.random() * 200 + 250) + 140;
        ang = Math.random() * 0.3 + 0.5;
        current_ang = Math.random() * 360;
    }
}