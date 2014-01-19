public class Ville {

	private Coords _coords;
	private int _id;

	public Coords get_coords() {
		return this._coords;
	}

	public Ville(int id, Coords coord) {
		super();
		_coords = coord;
		_id = id;
	}

	public void set_coords(final Coords _coords) {
		this._coords = _coords;
	}

	public int get_ID() {
		return _id;
	}

}
