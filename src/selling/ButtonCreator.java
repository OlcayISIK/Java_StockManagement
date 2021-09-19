package selling;

import java.awt.Color;

import javax.swing.JButton;

public interface ButtonCreator {
	void draw(JButton Button);
}

class Button implements ButtonCreator {
	@Override
	public void draw(JButton Button) {
		Button.setBackground(Color.green);
	}
}

abstract class ButtonDecorator implements ButtonCreator {
	protected ButtonCreator decoratedButton;

	public ButtonDecorator(ButtonCreator decoratedButton) {
		this.decoratedButton = decoratedButton;
	}

	public void draw(JButton Button) {
		decoratedButton.draw(Button);
	}
}

class RedButtonDecorator extends ButtonDecorator {

	public RedButtonDecorator(ButtonCreator decoratedButton) {
		super(decoratedButton);
	}

	@Override
	public void draw(JButton Button) {
		setRedBorder(Button);
	}

	private void setRedBorder(JButton Button) {
		Button.setBackground(Color.red);
	}
}
