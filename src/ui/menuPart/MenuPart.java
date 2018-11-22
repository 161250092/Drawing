package ui.menuPart;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;





public class MenuPart {
		Menu menu;
		MenuItem openMenuItem;
		MenuItem saveMenuItem;
		MenuBar menuBar;

		public MenuPart(){
			menu = new Menu("文件");
			openMenuItem  = new MenuItem("打开");
			saveMenuItem = new MenuItem("保存");
			menuBar = new MenuBar();
			menu.add(openMenuItem);
			menu.add(saveMenuItem);
			menuBar.add(menu);

			//listener
		}



		public Menu getMenu() {
			return menu;
		}

		public void setMenu(Menu menu) {
			this.menu = menu;
		}

		public MenuItem getOpenMenuItem() {
			return openMenuItem;
		}

		public void setOpenMenuItem(MenuItem openMenuItem) {
			this.openMenuItem = openMenuItem;
		}

		public MenuItem getSaveMenuItem() {
			return saveMenuItem;
		}

		public void setSaveMenuItem(MenuItem saveMenuItem) {
			this.saveMenuItem = saveMenuItem;
		}

		public MenuBar getMenuBar() {
			return menuBar;
		}

		public void setMenuBar(MenuBar menuBar) {
			this.menuBar = menuBar;
		}



}
