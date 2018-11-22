package bussinesslogic.controller;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import bussinesslogic.identify.MultiIdentifyServiceImpl;
import bussinesslogicservice.MultiIdentifyService;
import ui.mainUI.MainUI;
import vo.PointVO;

public class ButtonController {
	MainUI mainUI;
	MultiIdentifyService  multiIdentify;

	public  ButtonController(MainUI ui) {
		mainUI = ui;
		multiIdentify = new MultiIdentifyServiceImpl();

		ui.getButtonPart().getCut().addActionListener(new CutListener());
		ui.getButtonPart().getIdentify().addActionListener(new  IdentifyListener());

		ui.getButtonPart().getTriangle().addActionListener(new TriangleListener() );
		ui.getButtonPart().getCircle().addActionListener(new CircleListener());
		ui.getButtonPart().getClear().addActionListener(new ClearListener());
		ui.getButtonPart().getLine().addActionListener(new LineListener() );
		ui.getButtonPart().getPen().addActionListener(new PenListener() );
		ui.getButtonPart().getRectangle().addActionListener( new RectListener() );
		ui.getButtonPart().getRubber().addActionListener(new ClearSkinListener() );

	}

	class IdentifyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<PointVO>  pointInfo =  mainUI.getInfo().getPointInfo();
			for(int i=0;i<pointInfo.size()-1;i++){
				if  (pointInfo.get(i).getType() == 8 && pointInfo.get(i+1).getType() == 8 )
					multiIdentify.identifyShaprInFrame(mainUI.getInfo().getPointInfo(),pointInfo.get(i) , pointInfo.get(i+1));
			}
			mainUI.repaint();
			mainUI.getInfo().setToolType(0);;
		}

	}

	class CutListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("点击了截取");
			mainUI.getInfo().setToolType(8);
		}
	}



	class TriangleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("点击了三角形");
			mainUI.getInfo().setToolType(7);
		}

	}


	class ClearSkinListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("点击了橡皮");
			mainUI.getInfo().setToolType(1);
			mainUI.repaint();
		}

	}

	class ClearListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("点击了清除");
			mainUI.getInfo().setToolType(2);
			mainUI.getInfo().getPointInfo().clear();
			mainUI.repaint();
		}

	}


	class RectListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("点击了矩形");
			mainUI.getInfo().setToolType(5);

		}

	}

	class PenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("点击了画笔");
			mainUI.getInfo().setToolType(0);
		}

	}

	class LineListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("点击了画线");
			mainUI.getInfo().setToolType(3);

		}

	}

	class CircleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("点击了画圆");
			mainUI.getInfo().setToolType(4);
		}

	}




}
