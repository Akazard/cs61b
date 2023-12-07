public class TestPlanet {
    public static void main(String[] args){
        Planet p1 = new Planet(0, 0, 1, 1, 1, null);
        Planet p2 = new Planet(5, 0, 5, 1, 5, null);
        double force = p1.calcForceExertedBy(p2);
        System.out.println(force);
    }
}
