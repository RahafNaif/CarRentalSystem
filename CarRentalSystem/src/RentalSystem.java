import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class RentalSystem {

	private JFrame frmCarRentalSystem;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JRadioButton rdbtnVip;
	private JRadioButton rdbtnEconomy;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextArea textArea;
	private JTextField textField_4;
	private JTextField textField_5;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentalSystem window = new RentalSystem();
					window.frmCarRentalSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RentalSystem() {
		initialize();
		
	}

	
	private void initialize() {
		
		CarRental cr=new CarRental(100);
		
		frmCarRentalSystem =new JFrame();
		frmCarRentalSystem.setBackground(Color.LIGHT_GRAY);
		frmCarRentalSystem.setTitle("Car Rental System");
		frmCarRentalSystem.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmCarRentalSystem.getContentPane().setLayout(null);
		frmCarRentalSystem.setResizable(false);
		
		try {
			cr.loadFromFile();
		}catch(FileNotFoundException ex) {
			
		}catch (ClassNotFoundException | IOException ex) {

			JOptionPane.showMessageDialog(null,ex.getMessage()+" in load file");
		}
		
		frmCarRentalSystem.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				
				int x=JOptionPane.showConfirmDialog(null, "Did you want to save All changes on File ?","save and exit",JOptionPane.YES_NO_OPTION);
				
				if(x==JOptionPane.YES_OPTION)
					try {
						cr.saveToFile();
						JOptionPane.showMessageDialog(null, "Thank you for use CAR RENTAL SYSTEM ,ALL CHANGES IS SAVED");
						
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null,ex.getMessage()+"in save file");
					}
				
				if(x==JOptionPane.NO_OPTION) 
					JOptionPane.showMessageDialog(null, "Thank you for use CAR RENTAL SYSTEM ,ALL CHANGES NOT SAVED");
						
			}
		});
		
		
		JLabel lblCarRentalSystem = new JLabel("CAR RENTAL SYSTEM");
		lblCarRentalSystem.setBounds(244, 6, 406, 32);
		lblCarRentalSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarRentalSystem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCarRentalSystem.setVerticalAlignment(SwingConstants.TOP);
		frmCarRentalSystem.getContentPane().add(lblCarRentalSystem);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Add New Car", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(19, 36, 481, 323);
		frmCarRentalSystem.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAddNewCar = new JButton("Add new car");
		btnAddNewCar.setBounds(149, 277, 117, 29);
		panel_1.add(btnAddNewCar);
		
		JLabel lblPlateno = new JLabel("plateNo :");
		lblPlateno.setBounds(17, 39, 61, 16);
		panel_1.add(lblPlateno);
		
		JLabel lblModel = new JLabel("model :");
		lblModel.setBounds(17, 94, 113, 32);
		panel_1.add(lblModel);
		
		JLabel lblColor = new JLabel("color :");
		lblColor.setBounds(16, 133, 61, 16);
		panel_1.add(lblColor);
		
		textField = new JTextField();
		textField.setBounds(120, 33, 130, 26);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 64, 130, 26);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(120, 97, 130, 26);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		rdbtnEconomy = new JRadioButton("Economy");
		rdbtnEconomy.setBounds(26, 192, 141, 23);
		panel_1.add(rdbtnEconomy);
		
		rdbtnVip = new JRadioButton("VIP");
		rdbtnVip.setBounds(26, 219, 141, 23);
		panel_1.add(rdbtnVip);
		
		textField_3 = new JTextField();
		textField_3.setBounds(121, 127, 130, 26);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPriceperday = new JLabel("pricePerDay :");
		lblPriceperday.setBounds(16, 59, 113, 32);
		panel_1.add(lblPriceperday);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "driver", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(198, 165, 214, 104);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblId = new JLabel("id :");
		lblId.setBounds(16, 29, 61, 16);
		panel_2.add(lblId);
		
		JLabel lblName = new JLabel("name :");
		lblName.setBounds(16, 57, 61, 16);
		panel_2.add(lblName);
		
		textField_4 = new JTextField();
		textField_4.setBounds(65, 24, 130, 26);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(65, 52, 130, 26);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		rdbtnVip.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(rdbtnVip.isSelected()) {
					panel_2.setEnabled(true);
					lblName.setEnabled(true);
					lblId.setEnabled(true);
					textField_4.setEnabled(true);
					textField_5.setEnabled(true);
					rdbtnEconomy.setSelected(false);
					
					
				}
					
			}
			
		});
		rdbtnEconomy.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(rdbtnEconomy.isSelected()) {
					panel_2.setEnabled(false);
					lblName.setEnabled(false);
					lblId.setEnabled(false);
					textField_4.setEnabled(false);
					textField_5.setEnabled(false);
					rdbtnVip.setSelected(false);
						
				}	
			}
			
		});
		btnAddNewCar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String plateNo,model,color,name;
					double price;
					int id;
					
					if(textField.getText().isEmpty() || textField_1.getText().isEmpty() ||textField_2.getText().isEmpty() || textField_3.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Empty input! please full it all");
						return;}
					plateNo=textField.getText();
					price=Double.parseDouble(textField_1.getText());
					model=textField_2.getText();
					color=textField_3.getText();
					
					if(price<=0)
						throw new NegtiveOrZeroNumberException();
					
					if(rdbtnVip.isSelected() && cr.getCar(plateNo)==null) {
						
						if(textField_4.getText().isEmpty() || textField_5.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Empty input! please full it all");
							return;
						}
							
						id=Integer.parseInt(textField_4.getText());
						name=textField_5.getText();
						
						if(id<0)
							throw new NegtiveOrZeroNumberException();
						
						Driver d=new Driver(id,name);
						cr.addCar(new VIP(plateNo,price,model,color,d));
					}			
					else if(rdbtnEconomy.isSelected() && cr.getCar(plateNo)==null)
						cr.addCar(new Economy(plateNo,price,model,color));
					else
						JOptionPane.showMessageDialog(null, "Can't add this car already in the list!");
					
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "invalid input! please enter it again ");
				}catch(NegtiveOrZeroNumberException ex) {
					JOptionPane.showMessageDialog(null, "invalid input! please enter it again ");
				}finally {
				
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
				
				}
						
				
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Show information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(13, 370, 487, 257);
		frmCarRentalSystem.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnShowAllAvailable = new JButton("show all available Economy");
		btnShowAllAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(""); 
				
				Economy[] economy=cr.searchAvailableEconomy();
			     
				if(economy.length==0){
					JOptionPane.showMessageDialog(null,"there is no avaliable Economy  car");
			        return;
			    }
			    else
			    	{
			        for(int i=0;i<economy.length;i++) {
			        	textArea.append(economy[i].toString());
			            textArea.append("\n ________________________________________________________");
			         }           
			    }
				
			}
		});
		btnShowAllAvailable.setBounds(16, 18, 222, 29);
		panel_3.add(btnShowAllAvailable);
		
		JButton btnShowAllAvailable_1 = new JButton("show all available VIP");
		btnShowAllAvailable_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(""); 
				 VIP[] vip=cr.searchAvailableVIP(); 
			     if(vip.length==0){
			    	 JOptionPane.showMessageDialog(null,"there is no avaliable VIP car");
			         return;
			     }
			     else
			    	 for(int i=0;i<vip.length;i++) {
			    		 textArea.append(vip[i].toString());
			             textArea.append("\n _______________________________________________________");
			            } 
			    
			}
		});
		btnShowAllAvailable_1.setBounds(250, 18, 220, 29);
		panel_3.add(btnShowAllAvailable_1);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		textArea.setBounds(16, 48, 454, 191);
		panel_3.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(16, 48, 454, 191);
		panel_3.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("car2.jpg")));
		Image img1 = img.getImage();
		ImageIcon i = new ImageIcon(img1);
		lblNewLabel.setIcon(i);

		lblNewLabel.setBounds(512, 40, 373, 163);
		frmCarRentalSystem.getContentPane().add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Rent Car", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(512, 215, 373, 287);
		frmCarRentalSystem.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblPlateno_1 = new JLabel("plateNo :");
		lblPlateno_1.setBounds(27, 38, 61, 16);
		panel_4.add(lblPlateno_1);
		
		JLabel lblNoOfDays = new JLabel("No. of days :");
		lblNoOfDays.setBounds(27, 66, 94, 16);
		panel_4.add(lblNoOfDays);
		
		textField_6 = new JTextField();
		textField_6.setBounds(121, 33, 130, 26);
		panel_4.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(121, 61, 130, 26);
		panel_4.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "customer information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(37, 108, 278, 138);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblId_1 = new JLabel("id :");
		lblId_1.setBounds(23, 32, 61, 16);
		panel_5.add(lblId_1);
		
		JLabel lblName_1 = new JLabel("name :");
		lblName_1.setBounds(23, 56, 61, 16);
		panel_5.add(lblName_1);
		
		JLabel lblPhone = new JLabel("phone :");
		lblPhone.setBounds(23, 84, 61, 16);
		panel_5.add(lblPhone);
		
		textField_8 = new JTextField();
		textField_8.setBounds(86, 27, 130, 26);
		panel_5.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(86, 51, 130, 26);
		panel_5.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(86, 79, 130, 26);
		panel_5.add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnRent = new JButton("Rent");
		btnRent.setBounds(121, 252, 117, 29);
		panel_4.add(btnRent);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Return Car", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(512, 517, 373, 113);
		frmCarRentalSystem.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblPlateno_2 = new JLabel("plateNo :");
		lblPlateno_2.setBounds(31, 39, 61, 16);
		panel_6.add(lblPlateno_2);
		
		textField_11 = new JTextField();
		textField_11.setBounds(111, 34, 130, 26);
		panel_6.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnReturnCar = new JButton("Return car");
		btnReturnCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String plateNo="";
			       
			       if(textField_11.getText().isEmpty()) {
			             JOptionPane.showMessageDialog(null,"enter all fields");   }
			       else{
			               plateNo=textField_11.getText();
			               
			               }
			       cr.returnCar(plateNo);
			       textField_11.setText("");
				
			}
		});
		btnReturnCar.setBounds(121, 72, 117, 29);
		panel_6.add(btnReturnCar);
		frmCarRentalSystem.setBounds(100, 100, 903, 690);
		frmCarRentalSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnRent.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String plateNo,name;
				int numOfDay,id;
				long phone;
				
				if(textField_6.getText().isEmpty() || textField_7.getText().isEmpty() || textField_8.getText().isEmpty() || textField_9.getText().isEmpty() || textField_10.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Empty input! please full it all");
					return;
				}
				plateNo=textField_6.getText();
				numOfDay=Integer.parseInt(textField_7.getText());
				
				try {
					id=Integer.parseInt(textField_8.getText());
					name=textField_9.getText();
					phone=Long.parseLong(textField_10.getText());
					
					if(id<0)
						throw new NegtiveOrZeroNumberException();
					
					Customer c=new Customer(id,name,phone);
					
					try {
						cr.rentCar(plateNo, c, numOfDay);
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null,ex.getMessage());
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "invalid input! please enter enter it again ");
				}catch(NegtiveOrZeroNumberException ex) {
					JOptionPane.showMessageDialog(null, "invalid input! please enter enter it again ");
				}finally {
				
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					textField_9.setText("");
					textField_10.setText("");
					
				}
				
			}
		});
	}
}
