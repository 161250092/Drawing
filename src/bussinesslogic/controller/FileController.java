package bussinesslogic.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import data.SLImpl;
import dataservice.SLService;
import po.PointPO;
import ui.mainUI.MainUI;
import vo.PointVO;



public class FileController {

	MainUI mainUI;
	SLService sl;

	public FileController (MainUI ui){
		this.mainUI = ui;
		sl = new SLImpl();

		slWindows(ui);

		ui.getMenuPart().getOpenMenuItem().addActionListener(new OpenListener());

		ui.getMenuPart().getSaveMenuItem().addActionListener(new SaveListener());

	}


	class SaveListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			sl.save( vListTopList( mainUI.getPointInfo() ), mainUI.getDialog().getSavePicture());
		}
	}



	class OpenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				mainUI.getDialog().getOpenPicture().setVisible(true);
				if (mainUI.getDialog().getOpenPicture().getFile() != null)
				{
					int tempflag;
					tempflag = mainUI.getInfo().getToolType();
					mainUI.getInfo().setToolType(2);
					mainUI.repaint();

					mainUI.getInfo().getPointInfo().clear();

					ArrayList<PointPO> content = sl.open(mainUI.getDialog().getOpenPicture());

					mainUI.setPointInfo(  pListTovList(content) );
					mainUI.repaint();
					mainUI.getInfo().setToolType(tempflag);
				}
				else
					System.out.println("无保存文件");
		}


	}


	//打开文件，保存文件
	public void slWindows(MainUI ui){

		ui.getOpenDialog().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ui.getOpenDialog().setVisible(false);
			}
			});


			ui.getSaveDialog().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ui.getSaveDialog().setVisible(false);
			}
			});


			ui.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			System.exit(0);
			}
			});
	}



	//po的数组转vo数组
	public ArrayList<PointVO> pListTovList(ArrayList<PointPO> poList){

			ArrayList<PointVO> result =  new ArrayList<PointVO>();
			for (int i=0;i<poList.size();i++){
				result.add( poList.get(i).poTovo());
			}
			return result;
	}

	//vo数组转po数组
	public ArrayList<PointPO>  vListTopList(ArrayList<PointVO> voList){
		ArrayList<PointPO> result =  new ArrayList<PointPO>();
		for (int i=0;i<voList.size();i++){
			result.add( voList.get(i).voTopo());
		}
		return result;
	}



}

