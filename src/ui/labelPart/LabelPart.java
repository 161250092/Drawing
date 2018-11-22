package ui.labelPart;

import java.awt.Label;

public class LabelPart {
	Label  lineColor,lineSize,rubberSize;



	public  LabelPart(){
	lineColor = new Label("线条颜色", Label.CENTER);
	lineSize = new Label("线条粗细",Label.CENTER);
	rubberSize = new Label("橡皮大小",Label.CENTER);
	}



	public Label getLineColor() {
		return lineColor;
	}



	public void setLineColor(Label lineColor) {
		this.lineColor = lineColor;
	}



	public Label getLineSize() {
		return lineSize;
	}



	public void setLineSize(Label lineSize) {
		this.lineSize = lineSize;
	}



	public Label getRubberSize() {
		return rubberSize;
	}



	public void setRubberSize(Label rubberSize) {
		this.rubberSize = rubberSize;
	}




}
