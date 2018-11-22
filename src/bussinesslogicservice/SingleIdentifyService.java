package bussinesslogicservice;

import java.util.ArrayList;

import vo.PointVO;

public interface SingleIdentifyService {

		/**
		 * 简易版识别图片
		 * 	识别类型有
		 *   直线
		 *   圆
		 *   三角形
		 *   矩形
		 * 缺点
		 * 	面板上只能有一个等待识别的图形
		 */

		public void  identifyShape(ArrayList<PointVO> pointInfo);


		/**
		 * 高级版识别图片类型
		 *
		 */







}
