package bussinesslogicservice;

import java.util.ArrayList;

import vo.PointVO;

public interface MultiIdentifyService {

	/**
	 *筛选出在截选框内的点
	 * 判断其类别
	 * 改变颜色
	 * @param pointInfo  所有点
	 * @param p1
	 * @param p2
	 * @return
	 *返回值3是矩形，2是三角，1是线，0是圆
	 */
	public int identifyShaprInFrame(ArrayList<PointVO> pointInfo,PointVO p1,PointVO p2);
}
