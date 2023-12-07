public class Planet{
    public static final double G = 6.67E-11;

    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet p){
        double distance;
        distance = Math.sqrt(Math.pow(p.xxPos - this.xxPos, 2) + Math.pow(p.yyPos - this.yyPos, 2));
        return distance;
    }

    public double calcForceExertedBy(Planet p){
        double mass_mul = this.mass * p.mass;
        double dis = this.calcDistance(p);
        double dis_pow = Math.pow(dis, 2);
        double force = G * mass_mul / dis_pow;
        return force;
    }

    public double calcForceExertedByX(Planet p){
        double force = this.calcForceExertedBy(p);
        double distance = this.calcDistance(p);
        double delX = p.xxPos - this.xxPos;
        return force * delX / distance;
    }

    public double calcForceExertedByY(Planet p){
        double force = this.calcForceExertedBy(p);
        double distance = this.calcDistance(p);
        double delY = p.yyPos - this.yyPos;
        return force * delY / distance;
    }

    public double calcNetForceExertedByX(Planet[] Ps){
        double forceX = 0;
        for(Planet p : Ps){
            if(p.equals(this)){
                continue;
            }
            forceX += this.calcForceExertedByX(p);
        }
        return forceX;
    }

    public double calcNetForceExertedByY(Planet[] Ps){
        double forceY = 0;
        for(Planet p : Ps){
            if(p.equals(this)){
                continue;
            }
            forceY += this.calcForceExertedByY(p);
        }
        return forceY;
    }

    public void update(double dt, double fX, double fY){
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel = this.xxVel + dt * aX;
        this.yyVel = this.yyVel + dt * aY;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }
}