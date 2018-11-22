package bussinesslogicservice;

import java.util.ArrayList;

import vo.PointVO;

public interface RestoreShapeService {

	/**
	 *
	 * @param pointInfo
	 * @param p1
	 * @param p2
	 */
		public void  restoreShape(ArrayList<PointVO> pointInfo,PointVO p1,PointVO p2);

}
