
public class Ville {

	private Coords _coords;
	private int _id = 0;
	private String _name = new String();

	public Coords get_coords() {
		return this._coords;
	}

	public Ville(int id, String name, Coords coord) {
		super();
		_coords = coord;
		_id = id;
		set_name(name);
	}

	public Ville(int id, Coords coord) {
		super();
		_coords = coord;
		_id = id;
	}

	public Ville(String name, Coords coord) {
		super();
		_coords = coord;
		set_name(name);
	}

	public Ville(Coords coord) {
		super();
		_coords = coord;
	}

	public void set_coords(final Coords _coords) {
		this._coords = _coords;
	}

	public int get_ID() {
		return _id;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

}
