import java.util.Random;

public class Recuit {
	@SuppressWarnings("unused")
	private static float f1(final float x) {
		return (x * x);
	}

	private static float f2(final float x) {
		return (x - 1) * (x - 2) * (x - 3) * (x - 5);
	}

	// Algo qui ne va pas vers l'avant
	public static String recuitSimuleMinF2(final float x0, final float pas,
			final float T0, final float Tmin, final float k,
			final int maxPaliers, final int maxIter) {
		// !!x0 en random

		// Pas constant
		// T0 : température (brulante) de départ
		// xtemp : position actuelle
		// xprime : nouvelle position (augmenté du pas)
		// xopt : position optimale partielle
		float p = 0;
		int nbIter = 0;
		int nbPaliers = 0;
		float xtemp = x0;
		float xopt = x0;
		float xprime = 0;
		float Df = 0;
		float Ttemp = T0;
		final Random rand = new Random();

		while ((nbPaliers < maxPaliers) && (Ttemp > Tmin)) {
			nbIter = 0;
			while (nbIter < maxIter) {
				nbIter++;
				xprime = xtemp + pas;
				Df = f2(xprime) - f2(xtemp);
				// Si la solution est améliorante
				if (Df < 0) {
					xtemp = xprime;
					if (f2(xtemp) < f2(xopt)) {
						xopt = xtemp;
					}
				}
				// si elle n'est pas améliorante, on autorise une remontée
				else {
					p = rand.nextFloat();

					if (p <= (Math.exp(-Df / Ttemp))) {
						xtemp = xprime;
					}
				}
			}
			Ttemp = Ttemp * k;
			nbPaliers++;
		}
		return new String("Resultat en partant de x = " + x0 + " : " + xopt
				+ "(" + nbIter + ")");
	}

	public static String recuitSimuleVDC(final float x0, final float pas,
			final float T0, final float Tmin, final float k,
			final int maxPaliers, final int maxIter) {
		// !!x0 en random

		// Pas constant
		// T0 : température (brulante) de départ
		// xtemp : position actuelle
		// xprime : nouvelle position (augmenté du pas)
		// xopt : position optimale partielle
		float p = 0;
		int nbIter = 0;
		int nbPaliers = 0;
		float xtemp = x0;
		float xopt = x0;
		float xprime = 0;
		float Df = 0;
		float Ttemp = T0;
		final Random rand = new Random();

		while ((nbPaliers < maxPaliers) && (Ttemp > Tmin)) {
			nbIter = 0;
			while (nbIter < maxIter) {
				nbIter++;
				xprime = xtemp + pas;
				Df = f2(xprime) - f2(xtemp);
				// Si la solution est améliorante
				if (Df < 0) {
					xtemp = xprime;
					if (f2(xtemp) < f2(xopt)) {
						xopt = xtemp;
					}
				}
				// si elle n'est pas améliorante, on autorise une remontée
				else {
					p = rand.nextFloat();

					if (p <= (Math.exp(-Df / Ttemp))) {
						xtemp = xprime;
					}
				}
			}
			Ttemp = Ttemp * k;
			nbPaliers++;
		}
		return new String("Resultat en partant de x = " + x0 + " : " + xopt
				+ "(" + nbIter + ")");
	}
}