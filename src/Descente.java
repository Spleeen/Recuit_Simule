
public class Descente {

	private static float f4(final float x) {
		return ((x - 1) * (x - 2) * (x - 3) * (x - 5));
	}

	public static void main(final String[] args) {

		System.out.println(solvef1(-4));
		System.out.println(solvef1(6));

		System.out.println(solvef2(0));
		System.out.println(solvef2(6));

		System.out.println(solvef3(-2, -6));
		System.out.println(solvef3(6, 1));

		System.out.println(Recuit.recuitSimuleMinF2(0, 0.01f, 80, 5, 0.99f,
				1000, 1000));

	}

	private static String solvef1(final float x) {
		float precision, eta;
		final float orig = x;
		float x0, x1;
		eta = (float) 0.01;
		precision = (float) 0.001;
		x0 = x1 = orig;
		while (Math.abs(2 * x0) > precision) {
			x0 = x1;
			x1 = x0 - (eta * (2 * x0));
		}
		return new String("f1: Résultat en partant de x : " + orig + " : " + x1);
	}

	private static String solvef2(final float x) {
		float x0, x1, precision, eta;
		final float orig = x;
		eta = 0.01f;
		precision = 0.001f;
		x0 = x1 = orig;
		while (Math
				.abs(((((4 * (x0 * x0 * x0)) - (33 * (x0 * x0))) + (82 * x0)) - 61)) > precision) {
			x0 = x1;
			x1 = x0
					- (eta * ((((4 * (x0 * x0 * x0)) - (33 * (x0 * x0))) + (82 * x0)) - 61));
		}
		return new String("f2 : Résultat en partant de x = " + orig + " : "
				+ x1 + " Pour un cout de : " + f4(x1));
	}

	private static String solvef3(float x, float y) {
		float precision, eta;
		final float origX = x, origY = y;
		eta = 0.01f;
		precision = 0.001f;
		while ((Math.abs((2 * x) - 3) > precision)
				|| (Math.abs((2 * y) + 7) > precision)) {
			if (Math.abs((2 * x) - 3) > precision) {
				x = x - (eta * ((2 * x) - 3));
			}
			if (Math.abs((2 * y) + 7) > precision) {
				y = y - (eta * ((2 * y) + 7));
			}
		}
		return new String("Résultat en partant de x = " + origX + " et y = "
				+ origY + " : " + x + "," + y);
	}
}
