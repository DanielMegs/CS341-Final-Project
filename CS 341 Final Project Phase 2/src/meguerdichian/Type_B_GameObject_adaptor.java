package meguerdichian;

public abstract class Type_B_GameObject_adaptor extends GameObject {
	public Type_B_GameObject_adaptor(int x, int y) {
		super(x, y);
	}

	public Type_B_GameObject_adaptor(GameObject gObj) {
		super(gObj.getX(), gObj.getY());
	}

	public abstract void move(Canvas c);
}
