package bussinesslogic.identify;

import java.awt.Color;
import java.util.ArrayList;


import bussinesslogicservice.SingleIdentifyService;
import vo.PointVO;

public class SingleIdentifyServiceImpl implements SingleIdentifyService{
	double pi = 3.14;

	@Override
	public void identifyShape(ArrayList<PointVO> pointInfo) {
		switch(  countEndPointNum(pointInfo)  ){

			//	有三个截断点是 矩形
			case  3:
				this.changeColor(pointInfo, new Color(255,0,0));
				System.out.println("这是矩形");
				break;
			//  有两个截断点是	 三角形
			case  2:
				this.changeColor(pointInfo, new Color(0,255,0));
				System.out.println("这是三角形");
				break;
			//   有一个截断点可能是直线或者是圆
			case  1:
				double startToEnd = this.calculateDistance(pointInfo.get(0), pointInfo.get(  pointInfo.size()-2 )    );
				double perimete  =  this.getPerimete(pointInfo);
				if(  perimete/startToEnd <=(pi/2) )
				{
					this.changeColor(pointInfo, new Color(0,0,255));
					System.out.println("这是直线");
					break;
				}
				else
				{
					this.changeColor(pointInfo, new Color(255,255,0));
					System.out.println( "这是圆");
					break;
				}

			default:
				System.out.println("识别失败");
				break;
		}

	}


	public int countEndPointNum(ArrayList<PointVO> pointInfo){
		int result = 0;

		for(PointVO p:pointInfo){
			if(p.getX() == -1)
				result++;
		}
		return result;
	}

	//改变点的颜色
	public void changeColor(ArrayList<PointVO> pointInfo,Color c){
		for (PointVO p:pointInfo){
			p.setC(c);
		}
		return;
	}

	//计算周长
	public double getPerimete(ArrayList<PointVO> pointInfo){
		double result = 0;
		for(int i=0;i<pointInfo.size()-1;i++){
			result += this.calculateDistance(pointInfo.get(i), pointInfo.get(i+1));
		}
		return result;
	}

	public double calculateDistance(PointVO p1,PointVO p2){
		double result = 0;
		result = Math.pow(  p1.getX()-p2.getX(),2) + Math.pow(  p1.getY()-p2.getY() , 2);
		return Math.sqrt(result);
	}



}
