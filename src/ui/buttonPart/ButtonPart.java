package ui.buttonPart;

import java.awt.Button;

public class ButtonPart {

	Button cut,identify;
	Button line,circle,rectangle,triangle;
	Button clear,pen,rubber;


	public ButtonPart(){
		cut = new Button("截取");
		identify = new Button("鉴别");

		clear = new Button("清除");
		rubber= new Button("橡皮");

		pen = new Button("画笔");
		line = new Button("直线");
		circle = new Button("圆形");
		rectangle = new Button("矩形");
		triangle = new Button("三角形");


		//colorChooser = new Button("显示调色板");
	}

	public Button getLine() {
		return line;
	}

	public void setLine(Button line) {
		this.line = line;
	}

	public Button getCircle() {
		return circle;
	}

	public void setCircle(Button circle) {
		this.circle = circle;
	}

	public Button getRectangle() {
		return rectangle;
	}

	public void setRectangle(Button rectangle) {
		this.rectangle = rectangle;
	}

	public Button getClear() {
		return clear;
	}

	public void setClear(Button clear) {
		this.clear = clear;
	}

	public Button getPen() {
		return pen;
	}

	public void setPen(Button pen) {
		this.pen = pen;
	}

	public Button getRubber() {
		return rubber;
	}

	public void setRubber(Button rubber) {
		this.rubber = rubber;
	}


	public Button getTriangle() {
		return triangle;
	}

	public void setTriangle(Button triangle) {
		this.triangle = triangle;
	}

	public Button getCut() {
		return cut;
	}

	public void setCut(Button cut) {
		this.cut = cut;
	}

	public Button getIdentify() {
		return identify;
	}

	public void setIdentify(Button identify) {
		this.identify = identify;
	}





}
