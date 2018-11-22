package bussinesslogic.restore;

import java.util.ArrayList;

import bussinesslogicservice.RestoreShapeService;
import vo.PointVO;

public class RestoreShapeServiceImpl implements RestoreShapeService{

	@Override
	public void restoreShape(ArrayList<PointVO> pointInfo, PointVO p1, PointVO p2) {
		// TODO Auto-generated method stub

	}

/**
 * 求平均数
 * @param pointInfo
 * @param type
 * @return
 */
	public  double getAverage(ArrayList<PointVO> pointInfo,char type){
		double result=0;
		if(type == 'x'){
			for(PointVO p:pointInfo){
				result  += p.getX();
			}
			result /=pointInfo.size();

		}
		else if(type == 'y'){
			for(PointVO p:pointInfo){
				result  += p.getY();
			}
			result /=pointInfo.size();
		}
		else
		{
			System.out.print("type输入错误");
		}

		return result;

	}
	/**
	 * y = bx+a
	 *  获取b
	 */
	public double getB(ArrayList<PointVO> pointInfo){
		double ave_x = this.getAverage(pointInfo, 'x');
		double ave_y = this.getAverage(pointInfo, 'y');
		double x1 =0;
		double x2 =0;
		for (PointVO p:pointInfo){
			x1 += (p.getX()-ave_x)*(p.getY()-ave_y);
			x2 += Math.pow((p.getX()-ave_x),2);
		}
		return x1/x2;

	}

	/**
	 * y = bx+a
	 *  获取a
	 */
	public double getA(ArrayList<PointVO> pointInfo){
		double result = 0;
		double ave_x = this.getAverage(pointInfo, 'x');
		double ave_y = this.getAverage(pointInfo, 'y');
		double b = this.getB(pointInfo);
		result  = ave_y-b*ave_x;
		return result;
	}



}
