package bussinesslogic.controller;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import ui.mainUI.MainUI;

public class ChoiceController {
		MainUI mainUI;

		public ChoiceController(MainUI ui){
			this.mainUI = ui ;
			ui.getChoicePart().getrubberChoice().addItemListener(new rubberListener() );
			ui.getChoicePart().getsizeChoice().addItemListener(new sizeListener() );
		}


		class sizeListener implements ItemListener{

			@Override
			public void itemStateChanged(ItemEvent e) {

						String size = mainUI.getChoicePart().getsizeChoice().getSelectedItem();

System.out.println(size);
						if (size == "1号") {
						mainUI.getInfo().setLineSizeNum(1);

						} else if (size == "2号") {
							mainUI.getInfo().setLineSizeNum(3);
						} else if (size == "3号") {
							mainUI.getInfo().setLineSizeNum(5);
						} else if (size == "4号") {
							mainUI.getInfo().setLineSizeNum(7);
						} else if (size == "5号") {
							mainUI.getInfo().setLineSizeNum(9);
						}
			}
		}

		class rubberListener implements ItemListener{

			@Override
			public void itemStateChanged(ItemEvent e) {

						String Esize = mainUI.getChoicePart().getrubberChoice().getSelectedItem();
System.out.println(Esize);
						if (Esize.equals("5") ) {
							mainUI.getInfo().setRubberSize(10);
						} else if (Esize == "9") {
							mainUI.getInfo().setRubberSize(18);
						} else if (Esize == "13") {
							mainUI.getInfo().setRubberSize(30);
						} else if (Esize == "17") {
							mainUI.getInfo().setRubberSize(50);
						}
			}

		}


}
