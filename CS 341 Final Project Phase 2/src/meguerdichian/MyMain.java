package meguerdichian;

public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();

		// TASK 2: ADD A USER GAME OBJECT
		Type_A_GameObject a = new Type_A_GameObject(300, 100);
		Type_C_GameObject c = new Type_C_GameObject(0, 400);
		Type_D_GameObject d = new Type_D_GameObject(0, 0);
		Type_B_GameObject b = new Type_B_GameObject(d);

		// Adding the key listeners and game objects
		canvas.addKeyListener(a);
		canvas.addGameObject(a);
		a.setVelocity(10);

		canvas.addKeyListener(b);
		canvas.addGameObject(b);
		b.setVelocity(10);

		canvas.addKeyListener(c);
		canvas.addGameObject(c);
		c.setVelocity(10);

		canvas.addKeyListener(d);
		canvas.addGameObject(d);
		d.setVelocity(10);

		// Set the starting highlighted object to Type D
		canvas.setHighlightedObject(d);
	}

}
