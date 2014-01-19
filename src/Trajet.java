import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Trajet {

	private ArrayList<Ville> _villes = new ArrayList<Ville>();

	public Trajet() {
		super();
	}

	public void printTrajet() {
		System.out.println("Le voyageur passera par :");
		for (Ville ville : _villes) {
			System.out.println(" - La ville " + ville.get_ID() + " situé en ("
					+ ville.get_coords().x + "," + ville.get_coords().y + ")");
		}
	}

	public ArrayList<Ville> get_villes() {
		return _villes;
	}

	public void addVille(final Ville ville) {

		_villes.add(ville);
	}

	public boolean deleteVille(Ville ville) {
		return _villes.remove(ville);
	}

	public int calcDistance(Trajet trajet) {

		int distanceTrajet = 0;

		for (Iterator<Ville> iterator = trajet.get_villes().iterator(); iterator
				.hasNext();) {
			Ville vA = iterator.next();
			Ville vB = iterator.next();
			Coords A = vA.get_coords();
			Coords B = vB.get_coords();
			distanceTrajet += Math.sqrt(Math.pow(B.x - A.x, 2)
					+ Math.pow(B.y - A.y, 2));

		}

		return distanceTrajet;
	}

	public static void main(String[] args) {

		Random rand = new Random();
		Trajet trajet = new Trajet();

		for (int i = 0; i < 20; i++) {
			Ville nouvelleVille = new Ville(i, new Coords(rand.nextInt(),
					rand.nextInt()));
			trajet.addVille(nouvelleVille);
		}

		Recuit.recuitSimuleVDC(0, 0.01f, 80, 5, 0.99f, 1000, 1000);
	}
}
