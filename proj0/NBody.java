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
        
        scanner.close();
    }
}
