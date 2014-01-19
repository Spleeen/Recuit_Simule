import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Trajet {

	private ArrayList<Ville> _villes = new ArrayList<Ville>();

	public Trajet() {
		super();
	}

	public Trajet(Trajet other) {
		super();
		_villes = new ArrayList<Ville>(other.get_villes());
	}

	public void printTrajet() {
		System.out.println("Le voyageur passera par :");

		for (Ville ville : _villes) {
			System.out.println(" - La ville N°" + ville.get_ID()
					+ " situé en (" + ville.get_coords().x + ","
					+ ville.get_coords().y + ")");
		}

		System.out.println("Distance réalisée : " + calcDistance());
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

	public float calcDistance() {
		float distanceTrajet = 0;

		for (int i = 0 ; i<_villes.size()-1 ; i++) {
			final Coords A = _villes.get(i).get_coords();
			final Coords B = _villes.get(i+1).get_coords();
			distanceTrajet += Math.sqrt(Math.pow(B.x - A.x, 2)
					+ Math.pow(B.y - A.y, 2));

		}

		if(_villes.size() > 1)
		{
			final Coords A = _villes.get(_villes.size()-1).get_coords();
			final Coords B = _villes.get(0).get_coords();
			distanceTrajet += Math.sqrt(Math.pow(B.x - A.x, 2) + Math.pow(B.y - A.y, 2));
		}

		return distanceTrajet;
	}

	public int nbVilles() {
		return get_villes().size();
	}

	public boolean replaceVille(Ville ville1, Ville ville2) {

		for (int i = 0; i < _villes.size(); i++) {
			if (_villes.get(i).get_ID() == ville1.get_ID()) {
				_villes.set(i, ville2);
				return true;
			}
		}

		return false;
	}

	public static Trajet permuteRandom(Trajet traj) {
		if(traj.nbVilles() <= 1)
			new Trajet(traj);

		Random rand = new Random();
		Trajet tempTraj = new Trajet(traj);
		int posRandA = 0;
		int posRandB = 0;

		while (posRandA == posRandB) {
			posRandA = rand.nextInt(tempTraj.nbVilles());
			posRandB = rand.nextInt(tempTraj.nbVilles());
		}

		Ville villeA = tempTraj.get_villes().get(posRandA);
		tempTraj.replaceVille(villeA, tempTraj.get_villes().get(posRandB));
		tempTraj.replaceVille(tempTraj.get_villes().get(posRandB), villeA);

		return tempTraj;
	}

	public static void main(String[] args) {

		Random rand = new Random();
		Trajet trajet = new Trajet();

		for (int i = 0; i < 20; i++) {
			Ville nouvelleVille = new Ville(i, new Coords(Math.abs(rand.nextLong()%1000),
					Math.abs(rand.nextLong()%1000)));
			trajet.addVille(nouvelleVille);
		}

		Recuit.recuitSimuleVDC(trajet, 0.01f, 80, 5, 0.99f, 1000, 1000);
	}
}
