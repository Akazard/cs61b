import java.util.Scanner;

public class NBody {
    public static double readRadius(String s) {
        In in = new In(s);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String s){
        In in = new In(s);
        Planet[] Planets = new Planet[in.readInt()];
        in.readDouble();
        for(int i = 0; i < Planets.length; i++){
            Planet planet = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
            Planets[i] = planet;
        }
        return Planets;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double T = Double.parseDouble(scanner.next());
        double dt = Double.parseDouble(scanner.next());
        String filename = scanner.next();
        double radius = readRadius(filename);
        Planet[] Planets = readPlanets(filename);
        StdDraw.setXscale(-2.50e+11, 2.50e+11);
        StdDraw.setYscale(-2.50e+11, 2.50e+11);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        StdDraw.show();
        for (int i = 0; i < Planets.length; i++){
            Planets[i].draw();
        }
        StdDraw.show();
        double timestep = 0;
        double[] xForces = new double[Planets.length];
        double[] yForces = new double[Planets.length];
        while(timestep <= T){
            for(int i = 0; i < Planets.length; i++){
                xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForces[i] = Planets[i].calcNetForceExertedByY(Planets);
            }
            for(int i = 0; i < Planets.length; i++){
                Planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < Planets.length; i++){
            Planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            timestep += dt;
        }
        scanner.close();
    }
}
