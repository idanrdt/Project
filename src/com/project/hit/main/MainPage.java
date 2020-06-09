package com.project.hit.main;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.orderSystem.Order;
import com.project.hit.model.orderSystem.OrderSystem;
import com.project.hit.model.supplierSystem.MangeSupplier;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierExistsException;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

import java.io.IOException;
import java.util.ArrayList;

public class MainPage {

	/**
	 * Launch the application - main function.
	 */
	public static void main(String[] args) {


		Supplier supplier = Supplier.builder().CompanyName("test").SupplierNumber("test").build();
		Order order = new Order(supplier,500,"test");

		try {
			MangeSupplier mangeSupplier = MangeSupplier.getMangeSupplierSinglton();
			OrderSystem orderSystem = OrderSystem.getOrderSystem();

			mangeSupplier.addSupplier(supplier);
			orderSystem.createOrder(order);
		} catch (EnumNameNotFoundException | IOException | ClassNotFoundException | SupplierNotFoundException  e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}



		/*try {
			ViewSwitcher.changeView(ViewSelect.LOGIN_VIEW);
		}
		catch(NavigationFailedException n) {
			System.out.println(n.getMessage());
		}*/
	}
}