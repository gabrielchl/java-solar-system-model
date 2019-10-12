public class Planet extends SolarObject {

    public Planet(SolarSystem ss, double dist, double dia, String col, double ang) {
        this.ss = ss;
        this.dist = calc_display_dist(dist) + 140;
        this.dia = calc_display_dia(dia);
        this.col = col;
        this.current_ang = 90;
        this.ang = ang;
    }

    public double get_dist() {
        return dist;
    }

    public double get_ang() {
        return current_ang;
    }

    public void move() {
        current_ang = calc_new_ang(current_ang, ang);
        ss.drawSolarObject(dist, current_ang, dia, col);
    }
}
