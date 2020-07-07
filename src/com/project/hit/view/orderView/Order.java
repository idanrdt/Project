/*

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Panel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
*/
 /*      
public class Order 
{
	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order window = new Order();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 *
	public Order() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 *
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("find");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setBounds(31, 52, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("delete");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(31, 100, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("create");
		btnNewButton_2.setAction(action_2);
		btnNewButton_2.setBounds(31, 148, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("update");
		btnNewButton_3.setAction(action_3);
		btnNewButton_3.setBounds(31, 194, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
	
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "find");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) 
		{
			JFrame frame3 = new JFrame ("order");
			frame3.setVisible(true);
			frame3.setBounds(100, 100, 451, 300);
			JButton b=new JButton("Click Here");  
			b.setBounds(280,120,95,30);  
			frame3.add(b); 
			frame3.setLayout(null);
			JLabel l1,l2,l3,l4,l5;  
		    l1=new JLabel("order number:");  
		    l1.setBounds(50,50, 100,30);
		    l2=new JLabel("price:");  
		    l2.setBounds(50,100, 100,30);  
		    l3=new JLabel("description:");  
		    l3.setBounds(50,150, 100,30);  
		    l4=new JLabel("supplier:");  
		    l4.setBounds(50,200, 100,30);
		    l5=new JLabel("date:");  
		    l5.setBounds(50,10, 100,30);  
		    frame3.add(l1);
		    frame3.add(l2);
		    frame3.add(l3);
		    frame3.add(l4);
		    frame3.add(l5);
		    final JTextField text = new JTextField();  
	        text.setBounds(150,50, 100,30); 
	        frame3.add(text);
	        final JTextField text1 = new JTextField();  
	        text1.setBounds(150,100, 100,30); 
	        frame3.add(text1); 
	        final JTextField text2 = new JTextField();  
	        text2.setBounds(150,150, 100,30); 
	        frame3.add(text2); 
	        final JTextField text3 = new JTextField();  
	        text3.setBounds(150,200, 100,30); 
	        frame3.add(text3);
	        final JTextField text4 = new JTextField();  
	        text4.setBounds(150,10, 100,30); 
	        frame3.add(text4); 
		}
	}
	
	
	
	
	
	
	
	
	
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "find");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) 
		{
			JFrame frame1 = new JFrame ("find");
			frame1.setVisible(true);
			frame1.setBounds(100, 100, 451, 300);
			JButton b=new JButton("Click Here");  
			b.setBounds(150,150,95,30); 
			b.setAction(action_4);
		    frame1.add(b); 
		    frame1.setLayout(null); 
		    JLabel l1;  
		    l1=new JLabel("order number:");  
		    l1.setBounds(50,50, 100,30);  
		    frame1.add(l1);
		    final JTextField text = new JTextField();  
	        text.setBounds(150,50, 100,30); 
	        frame1.add(text);  
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "delet");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) 
		{
			JFrame frame2 = new JFrame ("delet");
			frame2.setVisible(true);
			frame2.setBounds(100, 100, 451, 300);
			JButton b=new JButton("Click Here");  
			b.setBounds(150,150,95,30);  
			frame2.add(b); 
			frame2.setLayout(null); 
		    JLabel l1;  
		    l1=new JLabel("order number:");  
		    l1.setBounds(50,50, 100,30);  
		    frame2.add(l1);
		    final JTextField text = new JTextField();  
	        text.setBounds(150,50, 100,30); 
	        frame2.add(text);  
			
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "create");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) 
		{
			JFrame frame3 = new JFrame ("create");
			frame3.setVisible(true);
			frame3.setBounds(100, 100, 451, 300);
			JButton b=new JButton("Click Here");  
			b.setBounds(280,120,95,30);  
			frame3.add(b); 
			frame3.setLayout(null);
			JLabel l1,l2,l3,l4,l5;  
		    l1=new JLabel("order number:");  
		    l1.setBounds(50,50, 100,30);
		    l2=new JLabel("price:");  
		    l2.setBounds(50,100, 100,30);  
		    l3=new JLabel("description:");  
		    l3.setBounds(50,150, 100,30);  
		    l4=new JLabel("supplier:");  
		    l4.setBounds(50,200, 100,30);
		    l5=new JLabel("date:");  
		    l5.setBounds(50,10, 100,30);  
		    frame3.add(l1);
		    frame3.add(l2);
		    frame3.add(l3);
		    frame3.add(l4);
		    frame3.add(l5);
		    final JTextField text = new JTextField();  
	        text.setBounds(150,50, 100,30); 
	        frame3.add(text);
	        final JTextField text1 = new JTextField();  
	        text1.setBounds(150,100, 100,30); 
	        frame3.add(text1); 
	        final JTextField text2 = new JTextField();  
	        text2.setBounds(150,150, 100,30); 
	        frame3.add(text2); 
	        final JTextField text3 = new JTextField();  
	        text3.setBounds(150,200, 100,30); 
	        frame3.add(text3);
	        final JTextField text4 = new JTextField();  
	        text4.setBounds(150,10, 100,30); 
	        frame3.add(text4);
			
			
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "update");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) 
		{
			JFrame frame4 = new JFrame ("update");
			frame4.setVisible(true);
			frame4.setBounds(100, 100, 451, 300);
			JButton b=new JButton("Click Here");  
			b.setBounds(280,120,95,30);  
			frame4.add(b); 
			frame4.setLayout(null);
			JLabel l1,l2,l3,l4,l5;  
		    l1=new JLabel("order number:");  
		    l1.setBounds(50,50, 100,30);
		    l2=new JLabel("price:");  
		    l2.setBounds(50,100, 100,30);  
		    l3=new JLabel("description:");  
		    l3.setBounds(50,150, 100,30);  
		    l4=new JLabel("supplier:");  
		    l4.setBounds(50,200, 100,30);
		    l5=new JLabel("date:");  
		    l5.setBounds(50,10, 100,30);  
		    frame4.add(l1);
		    frame4.add(l2);
		    frame4.add(l3);
		    frame4.add(l4);
		    frame4.add(l5);
		    final JTextField text = new JTextField();  
	        text.setBounds(150,50, 100,30); 
	        frame4.add(text);
	        final JTextField text1 = new JTextField();  
	        text1.setBounds(150,100, 100,30); 
	        frame4.add(text1); 
	        final JTextField text2 = new JTextField();  
	        text2.setBounds(150,150, 100,30); 
	        frame4.add(text2); 
	        final JTextField text3 = new JTextField();  
	        text3.setBounds(150,200, 100,30); 
	        frame4.add(text3);
	        final JTextField text4 = new JTextField();  
	        text4.setBounds(150,10, 100,30); 
	        frame4.add(text4);
			
			
			
			
		}
	}
}
 */