public class Moon extends SolarObject {
    private double dist_offset;
    private Planet planet;

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

    public void move() {
        current_ang = calc_new_ang(current_ang, ang);
        ss.drawSolarObjectAbout(dist, current_ang, dia, col, planet.get_dist(), planet.get_ang());
    }
}
