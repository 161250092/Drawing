package bussinesslogic.identify;

import java.awt.Color;
import java.util.ArrayList;

import bussinesslogic.tool.Tool;
import bussinesslogicservice.MultiIdentifyService;
import vo.PointVO;

public class MultiIdentifyServiceImpl	implements MultiIdentifyService {
	double pi = 3.1415;
	Tool tool =  new Tool();
	/**
	 *	先得到 所有endpoint的位置
	 * 计算在框内的 截断点数量
	 * 根据截断点数量 改变框内点的颜色
	 */
	@Override
	public int identifyShaprInFrame(ArrayList<PointVO> pointInfo, PointVO p1, PointVO p2) {
		ArrayList<PointVO>   endPointLocation = this.getEndPointLocation(pointInfo);
		int endPointNumInFrame = this.countEndPointNumInFrame(endPointLocation, p1, p2);

		switch (endPointNumInFrame){

			case  	3:
				tool.changeColorInFrame(pointInfo, p1, p2,new Color(255,0,0));
				System.out.println("这是矩形");
				return 3;


			case   2:
				tool.changeColorInFrame(pointInfo, p1, p2,new Color(0,255,0));
				System.out.println("这是三角");
				return 2;

			case   1:
				ArrayList<PointVO> lineOrCicrle = this.getPointsInFrame(pointInfo, p1, p2);
				double startToEnd = tool.calculateDistance(lineOrCicrle.get(0), lineOrCicrle.get(  lineOrCicrle.size()-1 )    );
				double perimete  =  tool.getPerimete(lineOrCicrle);


				if(  perimete/startToEnd <= (pi/2) )
				{
					tool.changeColorInFrame(pointInfo, p1, p2, new Color(0,0,255) );
					System.out.println("这是直线");
					return 1;
				}
				else
				{
					tool.changeColorInFrame(pointInfo, p1, p2, new Color(255,255,0) );
					System.out.println( "这是圆");
					return 0;
				}

			default:
				System.out.println("识别失败");
				return -1;

		}

	}

	//得到所有截断点所在位置 list
	public ArrayList<PointVO>  getEndPointLocation(ArrayList<PointVO> pointInfo){
		ArrayList<PointVO>  result = new ArrayList<PointVO>();

		for(int i =0;i<pointInfo.size();i++){
			if(pointInfo.get(i).getX() == -1)
				result.add(   pointInfo.get(i-1)  );
		}
		return result;
	}

	//计算  框内截断点数量
	public int countEndPointNumInFrame(ArrayList<PointVO> endPointInfo, PointVO p1, PointVO p2){
		int Num = 0;
		for (  PointVO p: endPointInfo){
			if(tool.whetherInFrame(p, p1, p2))
				Num++;
		}

		return Num;


	}

	//获取在框内的点
	public ArrayList<PointVO> getPointsInFrame(ArrayList<PointVO> pointInfo, PointVO p1, PointVO p2){
		ArrayList<PointVO> result = new ArrayList<PointVO>();

		for(PointVO p:pointInfo){
			if (tool.whetherInFrame(p, p1, p2))
				result.add(p);
		}
		return result;

	}


}
