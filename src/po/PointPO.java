package po;

import java.awt.Color;
import java.io.Serializable;

import vo.PointVO;

public class PointPO implements  Serializable  {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
		//点的横坐标，纵坐标
		int x;
		int y;

		//颜色
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
		 * 8 － 截取框
		 */
		int type;

		//宽度
		int border;


		public PointPO(int x, int y, Color c, int type, int border) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.type = type;
			this.border = border;
		}

		public PointVO poTovo(){
			return new PointVO(this.x,this.y,this.c,this.type,this.border);
		}
}
