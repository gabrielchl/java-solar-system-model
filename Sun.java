public class Sun extends SolarObject {
    public Sun(SolarSystem ss, double dist, double dia, String col) {
        this.ss = ss;
        this.dist = dist;
        this.dia = calc_display_dia(dia);
        this.col = col;
    }

    public void move() {
        ss.drawSolarObject(dist, 0, dia, col);
    }
}
