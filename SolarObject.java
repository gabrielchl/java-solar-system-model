/**
 * Properties and methods for any solar object (planet, moon, asteroid, etc.).
 * This is an abstract class, do not create direct SolarObject objects.
 */
public abstract class SolarObject {
    public SolarSystem ss;
    public double dist;
    public double dia;
    public String col;
    public double ang;
    public double current_ang;

    /**
     * Converts actual distance into display distance.
     *
     * @param   dist    actual distance from center of rotation (in million km)
     * @return          distance for display
     */
    public double calc_display_dist(double dist) {
        return ((dist / TheSolarSystem.solar_system_width) * TheSolarSystem.width) / 2.5;
    }

    /**
     * Converts actual diameter into display diameter.
     * If the calculated diameter is too short, it will set it to 4 pixels for visibility issues.
     *
     * @param   dia     actual diameter (in million km)
     * @return          diameter for display
     */
    public double calc_display_dia(double dia) {
        dia = (dia / TheSolarSystem.solar_system_width) * TheSolarSystem.width * 500;
        dia = (dia < 4) ? dia = 4 : dia;
        return dia;
    }

    /**
     * Calculates the new angle for an solar object
     *
     * @param   current_ang current angle of the solar object
     * @param   ang         angle per movement
     * @return              new angle after movement
     */
    public double calc_new_ang(double current_ang, double ang) {
        current_ang = current_ang + ang * TheSolarSystem.speed_multiplier;
        while (current_ang > 360) {
            current_ang -= 360;
        }
        return current_ang;
    }
}
