package vo;

import java.awt.Color;


import po.PointPO;

public class PointVO {


	public PointVO(int x, int y, Color c, int type, int border) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.type = type;
		this.border = border;
	}

	//点的横坐标，纵坐标
	int x;
	int y;

	//颜色  可用来对图形类型进行标注
	Color c;

	/**
	 * 此点所处的工具类型
	 * 0 － 画笔
	 * 1 －	橡皮
	 * 2 － 清除
	 * 3 — 直线
	 * 4 － 圆
	 * 5 － 矩形
	 * 7 - 三角形
	 * 8 －截取框
	 */
	int type;

	//宽度
	int border;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getBorder() {
		return border;
	}

	public void setBorder(int border) {
		this.border = border;
	}

	public PointPO voTopo(){
		return new PointPO(this.x,this.y,this.c,this.type,this.border);
	}


}
