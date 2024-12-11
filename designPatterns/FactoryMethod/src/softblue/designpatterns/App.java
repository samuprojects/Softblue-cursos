package softblue.designpatterns;

import softblue.designpatterns.gui.Window;
import softblue.designpatterns.shape.Shape;
import softblue.designpatterns.shape.ShapeFactory;

public class App {
	
	public static void main(String[] args) {
		
		Window window = new Window("Shapes", 300, 300);
		window.show();
		
		Shape shape = ShapeFactory.newShape();
		
		window.drawShape(shape);
	}

}
