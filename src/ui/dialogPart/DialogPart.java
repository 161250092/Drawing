package ui.dialogPart;

import java.awt.FileDialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ui.mainUI.MainUI;

public class DialogPart {

	FileDialog openPicture, savePicture;

	public DialogPart(MainUI mainUI){
		openPicture = new FileDialog(mainUI, "打开图画", FileDialog.LOAD);
		openPicture.setVisible(false);

		savePicture = new FileDialog(mainUI, "保存图画", FileDialog.SAVE);
		savePicture.setVisible(false);
		this.Window();
	}

	public FileDialog getOpenPicture() {
		return openPicture;
	}

	public void setOpenPicture(FileDialog openPicture) {
		this.openPicture = openPicture;
	}

	public FileDialog getSavePicture() {
		return savePicture;
	}

	public void setSavePicture(FileDialog savePicture) {
		this.savePicture = savePicture;
	}


	public void Window(){
		openPicture.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			openPicture.setVisible(false);
		}
		});


		savePicture.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			savePicture.setVisible(false);
		}
		});
}



}
