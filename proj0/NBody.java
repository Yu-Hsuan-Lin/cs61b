public class NBody {
	public static double readRadius(String fileName) {	
		In in = new In(fileName);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String fileName) {
		In in = new In(fileName);
		int num = in.readInt();
		Planet[] planets = new Planet[num];
		in.readDouble();
		int count = 0;
		while (count < num) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
			planets[count] = p;
			count++;
		}
		return planets;

	}


	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String fileName = args[2];
		double radius = readRadius(fileName);
		Planet[] planets = readPlanets(fileName);

		/* Set the scale */
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");


		/* Draw all the planets */
		for (int i = 0; i < planets.length; i ++) {
			planets[i].draw();
		}
		StdDraw.show();

		/* Add the animation */
		for (int t = 0; t < T; t += dt) {
			StdDraw.enableDoubleBuffering();
			StdDraw.picture(0, 0, "images/starfield.jpg");
			StdDraw.show();
			
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for (int i = 0; i < planets.length; i ++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			// Draw all the planets
			for (int i = 0; i < planets.length; i ++) {
				planets[i].draw();
				StdDraw.enableDoubleBuffering();
			}

			StdDraw.show();

			StdDraw.pause(10);
			//For all the planets not to show continuosly.
			StdDraw.clear();

		}

		// Print out the final state of all the planets
		StdOut.printf("%d\n", planets.length);  //%d for int
		StdOut.printf("%.2e\n", radius); //用科學符號表現，並小數到第二位。 %.4e：用科學符號表現，並小數到第四位 
		for (int i = 0; i < planets.length; i ++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %11s\n", 
					  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
					  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}

	}


}
