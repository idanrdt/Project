package gui;

import com.MHR.view.*;

public class MainPage {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//View view = new MyCLIView(System.in, System.out);
		View view = new LoginPageView();

		view.start();
	}
}
