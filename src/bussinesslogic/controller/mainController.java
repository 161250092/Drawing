package bussinesslogic.controller;

import ui.mainUI.MainUI;

public class mainController {

	public mainController(MainUI ui ){
		
		new ButtonController(ui);
		new ChoiceController(ui);
		new FileController(ui);
	}

}
