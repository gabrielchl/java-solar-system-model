public class SolarObject {
    public SolarSystem ss;
    public double dist;
    public double dia;
    public String col;
    public double ang;
    public double current_ang;

    public double calc_display_dist(double dist) {
        return ((dist / TheSolarSystem.solar_system_width) * TheSolarSystem.width) / 2.5;
    }

    public double calc_display_dia(double dia) {
        dia = (dia / TheSolarSystem.solar_system_width) * TheSolarSystem.width * 500;
        dia = (dia < 4) ? dia = 4 : dia;
        return dia;
    }

    public double calc_new_ang(double current_ang, double ang) {
        current_ang = current_ang + ang * TheSolarSystem.speed_multiplier;
        while (current_ang > 360) {
            current_ang -= 360;
        }
        return current_ang;
    }
}