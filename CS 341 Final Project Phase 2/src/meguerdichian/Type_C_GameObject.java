package meguerdichian;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject implements KeyListener {

	// Constructor
	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.RIGHT);

		imageList = new LinkedList<>();
		imageList.add(new ImageIcon("images/Type_C_Left.png"));
		imageList.add(new ImageIcon("images/Type_C_Right.png"));
	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		int iconWidth = icon.getIconWidth();
		int canvasWidth = (int) c.getSize().getWidth();

		// If the object is highlighted then it moves according to the current direction
		if (getHighlight() == true) {
			switch (getDirection()) {
			case Direction.RIGHT:
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX(canvasWidth - iconWidth);
					setDirection(Direction.LEFT);
					setImage();
				}
				break;

			case Direction.LEFT:
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.RIGHT);
					setImage();
				}
				break;
			}
		} else {
			// If the object is not highlighted, keep moving automatically based on the
			// current direction
			if (getDirection() == Direction.LEFT) {
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.RIGHT);
					setImage();
				}
			} else {
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX(canvasWidth - iconWidth);
					setDirection(Direction.LEFT);
					setImage();
				}
			}
		}
	}

	@Override
	public void setImage() {
		// Update the image based on the current direction
		switch (getDirection()) {
		case Direction.NONE:
			break;
		case Direction.LEFT:
			currentImage = 0;
			break;
		case Direction.RIGHT:
			currentImage = 1;
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (getHighlight() == true) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setDirection(Direction.RIGHT);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.LEFT);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Stop movement if highlighted and not moving
		if (getHighlight() == true) {
			if (e.getKeyCode() != KeyEvent.VK_TAB) {
				setDirection(Direction.NONE);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}