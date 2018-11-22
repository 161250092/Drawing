package vo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;



public class BoardInfoVO {

	//颜色
	Color pointColor;
	//粗细数值
	int  lineSizeNum;
	//橡皮大小
	int  rubberSize;
	/**
	 * 现在画板所处的工具类型
	 * 0 － 画笔
	 * 1 －	橡皮
	 * 2 － 清除
	 * 3 — 直线
	 * 4 － 圆
	 * 5 － 矩形
	 * 7 - 三角形
	 * 8 - 截取框
	 */
	int toolType;

	/**
	 * 画板上点数组；
	 * 矩形  红色
	 * 三角  绿色
	 * 圆  	黄色
	 * 线段  蓝色
	 */
	ArrayList<PointVO>  pointInfo;


	public  BoardInfoVO(){

		lineSizeNum = 2;
		rubberSize = 5;
		//初始化为画笔
		toolType = 0;

		// 画笔颜色
		pointColor = new Color(0, 0, 0);

		//点信息
		pointInfo = new ArrayList<PointVO>();


	}


	public Color getPointColor() {
		return pointColor;
	}



	public void setPointColor(Color pointColor) {
		this.pointColor = pointColor;
	}



	public BasicStroke getLineSize() {
		return  new BasicStroke(this.lineSizeNum, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);
	}




	public int getLineSizeNum() {
		return lineSizeNum;
	}


	public void setLineSizeNum(int lineSizeNum) {
		this.lineSizeNum = lineSizeNum;
	}



	public int getRubberSize() {
		return rubberSize;
	}



	public void setRubberSize(int rubberSize) {
		this.rubberSize = rubberSize;
	}



	public int getToolType() {
		return toolType;
	}



	public void setToolType(int toolType) {
		this.toolType = toolType;
	}



	public ArrayList<PointVO> getPointInfo() {
		return pointInfo;
	}



	public void setPointInfo(ArrayList<PointVO> pointInfo) {
		this.pointInfo = pointInfo;
	}


	/**
	 * 分离 线条的标志 点
	 * PointVO( -1, -1, this.pointColor, 6, this.lineSizeNum)
	 */
	public void addEndPoint(){
		this.pointInfo.add(  new PointVO( -1, -1, this.pointColor, 6, this.lineSizeNum) );
	}

	/**
	 * 添加新的点
	 * @param p
	 */
	public void addNewPoint(PointVO p){
		this.pointInfo.add(p);
	}
	/**
	 *  删除新点
	 */
	public void removeNewPoint(){
		this.pointInfo.remove( pointInfo.size()-1);
	}


}
