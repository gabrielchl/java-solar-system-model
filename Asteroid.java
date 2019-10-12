public class Asteroid extends SolarObject {
    private SolarSystem ss;
    private double dist;
    private double ang;
    private double current_ang;
    private double dia;
    private String col;

    public Asteroid(SolarSystem ss) {
        this.ss = ss;

        double asteroid_type = Math.random();

        if (asteroid_type < 0.7) { // asteroid belt
            dist = calc_display_dist(Math.random() * 200 + 250) + 140;
            ang = Math.random() * 0.3 + 0.5;
            current_ang = Math.random() * 360;
        } else if (asteroid_type < 0.85) { // greeks
            dist = calc_display_dist(Math.random() * 200 + 720) + 140;
            ang = 0.08403;
            current_ang = Math.random() * 70 + 110;
        } else { // trojans
            dist = calc_display_dist(Math.random() * 200 + 720) + 140;
            ang = 0.08403;
            current_ang = Math.random() * 70;
        }

        dia = 2;
        col = "#444444";
    }

    public void move() {
        current_ang = calc_new_ang(current_ang, ang);
        ss.drawSolarObject(dist, current_ang, dia, col);
    }
}