public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	/**
	 * return the distance between two planets
	 * */
	public double calcDistance(Planet p) {
		return Math.pow(Math.pow((xxPos - p.xxPos), 2) + Math.pow((yyPos - p.yyPos), 2), 0.5);
	}

	/**
	 * return F
	 * */
	public double calcForceExertedBy(Planet p) {
		double dx = p.xxPos - xxPos;
		double dy = p.yyPos - yyPos;
		double r = Math.pow(dx*dx + dy*dy, 0.5);
		final double G = 6.67 * Math.pow(10, -11);
		return (G * mass * p.mass)/(r*r);
	}

	/**
	 * return Fx
	 * */
	public double calcForceExertedByX(Planet p) {
		double dx = p.xxPos - xxPos;
		double dy = p.yyPos - yyPos;
		double r = Math.pow(dx*dx + dy*dy, 0.5);
		return (calcForceExertedBy(p) * dx)/r;
	}

	/**
	 * return Fy
	 * */
	public double calcForceExertedByY(Planet p) {
		double dx = p.xxPos - xxPos;
		double dy = p.yyPos - yyPos;
		double r = Math.pow(dx*dx + dy*dy, 0.5);
		return (calcForceExertedBy(p) * dy)/r;
	}

	public double calcNetForceExertedByX(Planet[] ps) {
		double ans = 0;
		for (int i = 0; i < ps.length; i ++) {
			if (! ps[i].equals(this)) {
				ans += calcForceExertedByX(ps[i]);
			}
		}
		return ans;
	}

	public double calcNetForceExertedByY(Planet[] ps) {
		double ans = 0;
		for (int i = 0; i < ps.length; i ++) {
			if (! ps[i].equals(this)) {
				ans += calcForceExertedByY(ps[i]);
			}
		}
		return ans;
	}

	public void update(double dt, double fX, double fY) {
		double ax = fX/mass;
		double ay = fY/mass;

		xxVel = xxVel + dt * ax;
		yyVel = yyVel + dt * ay;

		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}

	public void draw() {
		String name = "images/" + imgFileName;
		StdDraw.picture(xxPos, yyPos, name);
	}



}