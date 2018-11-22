package ui.mainUI;



import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import bussinesslogic.controller.mainController;
import ui.buttonPart.ButtonPart;
import ui.choicePart.ChoicePart;
import ui.dialogPart.DialogPart;
import ui.labelPart.LabelPart;
import ui.menuPart.MenuPart;
import vo.BoardInfoVO;
import vo.PointVO;



public class MainUI  extends Frame implements  MouseMotionListener,
MouseListener{

	/**
	 *主框类，包含
	 *面板，面板含有
	 	*标签
	 	*按钮
	 *对话框，对话框有打开和保存文件
	 *面板里的点 信息
	 *菜单
	 	*保存,打开
	 */
	private static final long serialVersionUID = 1L;

	Panel  toolPanel;

	MenuPart menuPart;

	LabelPart labelPart;

	ButtonPart buttonPart;

	ChoicePart choicePart;

	DialogPart dialog;

	BoardInfoVO info;


	public MainUI(){
		addMouseMotionListener(this);
		addMouseListener(this);

		//初始化各个组件
		toolPanel = new Panel ();
		menuPart = new MenuPart();

		labelPart = new LabelPart();
		buttonPart = new ButtonPart();
		choicePart = new ChoicePart();
		dialog = new DialogPart(this);

		info = new BoardInfoVO();

		this.setMenuBar( menuPart.getMenuBar() );

		panelAddAWT();


		add(toolPanel, BorderLayout.NORTH);
		setBounds(250, 80, 1200, 800);
		setVisible(true);
		validate();

		new mainController(this);


	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 * 重写paint 方法，当调用repaint()方法时由虚拟机调用该paint()方法
	 */
		public void paint(Graphics g){

			System.out.println("调用paint");
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;

			PointVO p1,p2;

			int pointNum = this.info.getPointInfo().size();

			//清除画板
			if(info.getToolType() == 2)
				g2d.clearRect(0, 0, getSize().width - 100, getSize().height - 100);

			//绘制图形
			for(int i=0; i<pointNum -1 ; i++){
				p1 = info.getPointInfo().get(i);
				p2 = info.getPointInfo().get(i+1);

				info.setLineSizeNum(p1.getBorder());
				g2d.setColor(p1.getC());
				g2d.setStroke(info.getLineSize());

				/**选择工具并做图
				 * 以截断点分割各个图形
				 *
				 */
				if(p1.getType() == p2.getType()  )
					i = i + selectToolAndDrawing(g,g2d,p1,p2,i);//i=1代表跳过截断点
			}

//			for(int i=0;i<pointNum;i++){
//				System.out.println( "("+info.getPointInfo().get(i).getX()+","+ info.getPointInfo().get(i).getY() +")" +" "+ info.getPointInfo().get(i).getType() );
//			}

		}

		//画三角
		public void  drawTriangle(Graphics2D g2d,PointVO p0,PointVO p1,PointVO p2){
			int[] xPoints = { p0.getX(),p1.getX(),p2.getX() };
			int[] yPoints = { p0.getY(),p1.getY(),p2.getY() };
			int nPoints = 3;
			g2d.drawPolygon(xPoints, yPoints, nPoints);
			//g2d.dispose();

		}

		//画笔，橡皮，直线，圆，矩形
		public  int  selectToolAndDrawing(Graphics g,Graphics2D g2d,PointVO p1,PointVO p2,int index){
			int result = 0;
			switch(p1.getType())
			{
			/**
			 * 工具类型
			 * 0 － 画笔
			 * 1 －	橡皮
			 * 2 － 清除
			 * 3 — 直线
			 * 4 － 圆 or 椭圆
			 * 5 － 矩形
			 	* 6 － 截断点
			 * 7 － 三角
			 * 8 － 截图用的矩形框
			 */

			case 0:
				Line2D line = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
				g2d.draw(line);
				break;

			case 1:
				g.clearRect(p1.getX(), p1.getY(), info.getRubberSize(), info.getRubberSize() );
				break;

			case 3:
				Line2D line1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
				g2d.draw(line1);
				break;

			case 4:
				Ellipse2D ellipse = new Ellipse2D.Double(p1.getX(), p1.getY(),
						Math.abs(p2.getX() - p1.getX()), Math.abs(p2.getY() - p1.getY()));
						g2d.draw(ellipse);
						break;
			case 5:
				Rectangle2D rect  = new  Rectangle2D.Double(p1.getX(),p1.getY(),
						Math.abs(p2.getX() - p1.getX()), Math.abs(p2.getY() - p1.getY()));
						g2d.draw(rect);
						break;
			case 6:
				result = 1;
				break;



			case 7:
				if ( index < info.getPointInfo().size()-2)
				{
					PointVO p0 = info.getPointInfo().get(index+2);
					if (p0.getType()  == p1.getType())
						this.drawTriangle(g2d, p0, p1, p2);
				}
				break;

				//截取图形的矩形框
			case 8:
				Rectangle2D cutRect  = new  Rectangle2D.Double(p1.getX(),p1.getY(),
						Math.abs(p2.getX() - p1.getX()), Math.abs(p2.getY() - p1.getY()));
						g2d.draw(cutRect);
						break;

			default:
				;
			}
			return result;
		}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}



	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("mousePressed");
		switch (info.getToolType()) {
			case 3:// 直线
				this.addNewPoint((int) e.getX(), (int) e.getY());
				break;
			case 4: // 圆
				this.addNewPoint((int) e.getX(), (int) e.getY());
				break;
			case 5: // 矩形
				this.addNewPoint((int) e.getX(), (int) e.getY());
				break;
			case  7://三角形
				this.addNewPoint((int) e.getX(), (int) e.getY());
				break;
			case 8:// 矩形截取框
				this.addNewPoint((int) e.getX(), (int) e.getY());
				break;
			default:
		}
	}

	public void addNewPoint(int x,int y){
		PointVO p;
		//System.out.println("("+x+","+ y+")" );
		p = new PointVO(x,y, info.getPointColor(), info.getToolType(), info.getLineSizeNum());
		info.getPointInfo().add(p);
	}


	@Override
	public void mouseDragged(MouseEvent e) {

		//System.out.println("mouseDragged");

		switch (this.info.getToolType()) {
		case 0:// 画笔
			this.addNewPoint((int) e.getX(), (int) e.getY());
			repaint();
			break;

		case 1:// 橡皮
			this.addNewPoint((int) e.getX(), (int) e.getY());
			repaint();
			break;
		case 5://矩形
			this.addNewPoint((int) e.getX(), (int) e.getY());
			this.update(this.getGraphics());

			this.removeNewPoint();
			this.update(this.getGraphics());
			break;
		case 3:// 圆
			this.addNewPoint((int) e.getX(), (int) e.getY());
			this.update(this.getGraphics());

			this.removeNewPoint();
			this.update(this.getGraphics());
			break;

		case 8://矩形截取框
			this.addNewPoint((int) e.getX(), (int) e.getY());
			this.update(this.getGraphics());

			this.removeNewPoint();
			this.update(this.getGraphics());
			break;

		default:
			break;
		}
	}




	@Override
	public void mouseReleased(MouseEvent e) {

			//System.out.println("mouseReleased");

			switch (info.getToolType() ) {
			// 画笔
			case 0:

				this.addNewPoint((int) e.getX(), (int) e.getY());
				info.addEndPoint();
				repaint();
				break;

			//橡皮
			case 1:
				info.addEndPoint();
				break;


			case 3: // 直线
				this.addNewPoint((int) e.getX(), (int) e.getY());
				info.addEndPoint();
				repaint();
				break;


			case 4: // 圆
				this.addNewPoint((int) e.getX(), (int) e.getY());
				info.addEndPoint();
				repaint();
				break;

			case 5: // 矩形
				this.addNewPoint((int) e.getX(), (int) e.getY());
				info.addEndPoint();
				repaint();
				break;

			case 7: //三角形
				int n = info.getPointInfo().size()-1;
				if(n >=2){
					PointVO tA = info.getPointInfo().get(n);
					PointVO tB = info.getPointInfo().get(n-1);
					PointVO tC = info.getPointInfo().get(n-2);

					if(tA.getType() == tB.getType() && tA.getType() == tC.getType() && tA.getType() == 7)
						info.addEndPoint();;
						repaint();
				}
				break;

			case 8:
				this.addNewPoint((int) e.getX(), (int) e.getY());
				//info.addEndPoint();
				repaint();
				break;
			default:
			}
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}



	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void update(Graphics g){
		super.update(g);
		System.out.println("update");
		paint(g);
	}


	//将组件添加到面板
	public void panelAddAWT(){

		toolPanel.add(buttonPart.getCut());
		toolPanel.add(buttonPart.getIdentify());

		toolPanel.add(buttonPart.getPen());
		toolPanel.add(buttonPart.getLine());
		toolPanel.add(buttonPart.getTriangle());
		toolPanel.add(buttonPart.getCircle());
		toolPanel.add(buttonPart.getRectangle());
		/**
		 * 本版将修改颜色的功能删去
		 * 颜色将用来表示图形类别
		 */

		toolPanel.add(labelPart.getLineSize());
		toolPanel.add(choicePart.getsizeChoice());


		toolPanel.add(labelPart.getRubberSize());
		toolPanel.add(choicePart.getrubberChoice());

		toolPanel.add(buttonPart.getRubber());
		toolPanel.add(buttonPart.getClear());


	}

	public void removeNewPoint(){
		System.out.println("删除最新点");
		this.info.removeNewPoint();
	}


	public void setPointInfo(ArrayList<PointVO> info){
		this.info.setPointInfo(info);
	}

	public ArrayList<PointVO>  getPointInfo(){
		return this.info.getPointInfo();
	}

	public FileDialog getSaveDialog(){
		return this.dialog.getSavePicture();
	}

	public FileDialog getOpenDialog(){
		return this.dialog.getOpenPicture();
	}

	/**
	 * 以下是成员变量的getter,setter
	 * @return
	 */

	public Panel getToolPanel() {
		return toolPanel;
	}


	public void setToolPanel(Panel toolPanel) {
		this.toolPanel = toolPanel;
	}


	public MenuPart getMenuPart() {
		return menuPart;
	}


	public void setMenuPart(MenuPart menuPart) {
		this.menuPart = menuPart;
	}


	public LabelPart getLabelPart() {
		return labelPart;
	}


	public void setLabelPart(LabelPart labelPart) {
		this.labelPart = labelPart;
	}


	public ButtonPart getButtonPart() {
		return buttonPart;
	}


	public void setButtonPart(ButtonPart buttonPart) {
		this.buttonPart = buttonPart;
	}


	public ChoicePart getChoicePart() {
		return choicePart;
	}


	public void setChoicePart(ChoicePart choicePart) {
		this.choicePart = choicePart;
	}


	public DialogPart getDialog() {
		return dialog;
	}


	public void setDialog(DialogPart dialog) {
		this.dialog = dialog;
	}


	public BoardInfoVO getInfo() {
		return info;
	}


	public void setInfo(BoardInfoVO info) {
		this.info = info;
	}


}
