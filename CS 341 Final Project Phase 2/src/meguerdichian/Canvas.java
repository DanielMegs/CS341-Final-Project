package meguerdichian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import javax.swing.Timer;

public class Canvas extends JComponent implements ActionListener, KeyListener {
	// DEFAULT SERIAL NUMBER
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private Timer gameLoopTimer;

	private List<GameObject> gameObjectList;
	private int highlighted = 0;

	public Canvas() {
		// TASK 1: CREATE A LIST OF CHARACTERS THAT WILL APPEAR ON THE CANVAS
		gameObjectList = new LinkedList<GameObject>();

		// TASK 2: CREATE A WINDOW FOR THE APPLICATION
		frame = new JFrame("Animation Canvas");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		// TASK 3: CONSTRUCT A TIMER FOR GAME LOOP
		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();

		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);

		// TASK 4: MAKE THE WINDOW VISIBLE
		frame.setVisible(true);
	}

	public synchronized void addGameObject(GameObject sprite) {
		gameObjectList.add(sprite);

		// Adds GameObjects to the List, which are latter added to the Canvas/
		if (sprite instanceof Type_D_GameObject) {
			highlighted = gameObjectList.size() - 1;
		}
	}

	// Draws the GameObject graphic onto the Canvas
	public synchronized void paint(Graphics g) {
		if (gameObjectList.isEmpty()) {
			return;
		}

		for (GameObject s : gameObjectList) {
			s.draw(this, g);
		}

		// Highlight the currently selected object if the list is not empty
		GameObject s = gameObjectList.get(highlighted);
		int x = s.getX();
		int y = s.getY();
		g.setColor(Color.RED);
		g.drawRect(x, y, 160, 145);
	}

	// ****************************************************
	// Canvas must implement the inherited abstract methoda//
	// ActionListener.actionPerformed(ActionEvent)
	public synchronized void actionPerformed(ActionEvent e) {
		for (GameObject gameObject : gameObjectList) {
			gameObject.move(this);
			gameObject.setImage();
		}
		repaint();
	}

	// ****************************************************
	// Canvas must implement the inherited abstract methods
	// for KeyListener

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			highlighted = highlighted + 1;
			if (highlighted == gameObjectList.size()) {
				highlighted = 0;
			}
		}
		for (int i = 0; i < gameObjectList.size(); i++) {
			GameObject temp = gameObjectList.get(i);
			temp.setHighlight(false);
		}
		GameObject s = gameObjectList.get(highlighted);
		s.setVelocity(s.getVelocity());
		s.setHighlight(true);
	}

	public int getHighlight() {
		return highlighted;
	}

	public void setHighlightedObject(Type_D_GameObject d) {
		// TODO Auto-generated method stub

	}
}