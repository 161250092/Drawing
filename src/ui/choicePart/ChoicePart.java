package ui.choicePart;

import java.awt.Choice;


public class ChoicePart {


	Choice colChoice,sizeChoice,rubberChoice;


	public ChoicePart(){



		// 画笔大小选择
		sizeChoice = new Choice();
		sizeChoice.add("1号");
		sizeChoice.add("2号");
		sizeChoice.add("3号");
		sizeChoice.add("4号");
		sizeChoice.add("5号");

		// 橡皮大小选择
		rubberChoice = new Choice();
		rubberChoice.add("5");
		rubberChoice.add("9");
		rubberChoice.add("13");
		rubberChoice.add("17");


	}



	public Choice getcolChoice() {
		return colChoice;
	}

	public void setcolChoice(Choice colChoice) {
		this.colChoice = colChoice;
	}

	public Choice getsizeChoice() {
		return sizeChoice;
	}

	public void setsizeChoice(Choice sizeChoice) {
		this.sizeChoice = sizeChoice;
	}

	public Choice getrubberChoice() {
		return rubberChoice;
	}

	public void setrubberChoice(Choice rubberChoice) {
		this.rubberChoice = rubberChoice;
	}




}
