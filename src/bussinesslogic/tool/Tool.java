package bussinesslogic.tool;

import java.awt.Color;
import java.util.ArrayList;

import vo.PointVO;

public class Tool {

	//判断p是否在框内
	public boolean whetherInFrame(PointVO p,PointVO p1, PointVO p2){
		int highX = 0;
		int lowX = 0;

		int  highY = 0;
		int lowY  = 0;


		if(p1.getX() >p2.getY()  ){
			highX = p1.getX();
			lowX = p2.getX();
		}
		else{
			highX = p2.getX();
			lowX = p1.getX();
		}

		if (p1.getY() >p2.getY()){
			highY = p1.getY();
			lowY = p2.getY();
		}
		else{
			highY = p2.getY();
			lowY = p1.getY();
		}

		if (p.getX()<highX && p.getX()>lowX && p.getY()<highY && p.getY()>lowY)
			return true;
		return false;
	}

	//根据  图形类型 改变框内 图形颜色
	public void changeColorInFrame(ArrayList<PointVO> pointInfo, PointVO p1, PointVO p2,Color c){
			for(PointVO p:pointInfo){
				if(this.whetherInFrame(p, p1, p2) && p.getType()!=8){
					p.setC(c);
				}
			}

	}
	//计算周长
	public double getPerimete(ArrayList<PointVO> pointInfo){
		double result = 0;
		for(int i=0;i<pointInfo.size()-1;i++){
			result += this.calculateDistance(pointInfo.get(i), pointInfo.get(i+1));
		}
		return result;
	}

	//计算两点间的距离
	public double calculateDistance(PointVO p1,PointVO p2){
		double result = 0;
		result = Math.pow(  p1.getX()-p2.getX(),2) + Math.pow(  p1.getY()-p2.getY() , 2);
		return Math.sqrt(result);
	}

		
}
