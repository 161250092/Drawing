package data;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import dataservice.SLService;
import po.PointPO;

public class SLImpl implements SLService{
//
//	FileInputStream picIn;
//	FileOutputStream picOut;
//
//	ObjectInputStream VIn;
//	ObjectOutputStream VOut;

	@Override
	public void save(ArrayList<PointPO> info, FileDialog savePicture) {

		if(info.size() == 0)
			return;

		savePicture.setVisible(true);

		try {
			File fileOut = new File(savePicture.getDirectory(),savePicture.getFile());

			FileOutputStream picOut = null ;
			ObjectOutputStream VOut  = null ;

			picOut = new FileOutputStream(fileOut);
			VOut = new ObjectOutputStream(picOut);

			VOut.writeObject(info);
			VOut.close();

			} catch (IOException IOe) {
			System.out.println("不能写数据");
			}
	}


	@Override
	public ArrayList<PointPO> open(FileDialog openPicture) {
			System.out.println("data层 open");
			
			FileInputStream picIn;
			ObjectInputStream VIn;

			try {
			File fileIn = new File(openPicture.getDirectory(),openPicture.getFile());

			picIn = new FileInputStream(fileIn);
			VIn = new ObjectInputStream( picIn );

			@SuppressWarnings("unchecked")
			ArrayList<PointPO> infoPO = (ArrayList<PointPO> ) VIn.readObject();

			VIn.close();
			return infoPO;

			}catch (ClassNotFoundException IOe2) {
				System.out.println("读不到对象");
			}
			catch (IOException IOe) {
				System.out.println("读不到文件");
			}
			return null;

	}

}
