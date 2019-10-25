/**
 * Methods for asteroids (Greeks).
 */
public class AsteroidGreek extends Asteroid {
    /**
     * Constructs the asteroid (Greeks) object.
     *
     * @param   ss      the solar system the planet will be added to
     */
    public AsteroidGreek(SolarSystem ss) {
        super(ss);
        dist = calc_display_dist(Math.random() * 200 + 720) + 140;
        ang = 0.08403;
        current_ang = Math.random() * 70 + 110;
    }
}