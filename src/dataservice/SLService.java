package dataservice;

import java.awt.FileDialog;
import java.util.ArrayList;

import po.PointPO;

public interface SLService {
	/**
	 * 保存 点信息
	 * @param info
	 * @param savePicture
	 */
	public void save(ArrayList<PointPO>  info, FileDialog savePicture);

	/**
	 * 打开历史文件
	 * @param openPicture
	 * @return
	 */
	public ArrayList<PointPO> open( FileDialog openPicture);

}
