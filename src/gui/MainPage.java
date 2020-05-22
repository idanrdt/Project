package gui;

import com.MHR.controller.*;
import com.MHR.model.*;
import com.MHR.view.*;

public class MainPage {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//View view = new MyCLIView(System.in, System.out);
		View view = new LoginPageView();
		
		Model model = new LoginPageModel();
		
		Controller controller = new LoginPageController(view,model);
		
		view.setController(controller);
		model.setController(controller);

		view.start();
	}
}
