package steele;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * SalesListWindow is a GUI application that allows users to create a sales list
 * by adding items with their name, cost, and quantity. It displays the list of
 * items and the total price.
 */
public class SalesListWindow {

	private JFrame frame;
	private JTextField itemField;
	private JTextField costField;
	private JLabel quantityLabel;
	private JTextField quantityField;
	private JButton addBtn;
	private SalesSlip list;
	private JScrollPane scrollPane;
	private JTextArea listTextArea;
	private JLabel totalLabel;
	private JTextArea totalTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesListWindow window = new SalesListWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SalesListWindow() {
		initialize();
		createEvents();
		list = new SalesSlip();
	}

	/**
	 * Create the event listeners for the buttons.
	 */
	public void createEvents() {
		addBtn.addActionListener(new ActionListener() {
			/**
			 * Handle the Add Item button click event. Reads input from text fields, creates
			 * a SalesItem, adds it to the SalesSlip
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String itemName = itemField.getText();
				double itemCost = Double.parseDouble(costField.getText());
				int itemQuantity = Integer.parseInt(quantityField.getText());

				SalesItem item = new SalesItem(itemName, itemCost, itemQuantity);
				list.addItem(item);
				listTextArea.setText(list.toString());
				totalTextArea.setText("$" + list.getTotalPrice());
				itemField.setText("");
				costField.setText("");
				quantityField.setText("");
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setSize(600, 450);
		frame.setTitle("Sales List Application");
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);

		// Center the window on the screen
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int xPos = (screenWidth - frame.getWidth()) / 2;
		int yPos = (screenHeight - frame.getHeight()) / 2;
		
		frame.setLocation(xPos, yPos);
		frame.setResizable(false);
		frame.setVisible(true);

		JLabel titleLabel = new JLabel("Sales List");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		titleLabel.setBounds(205, 19, 168, 30);
		frame.getContentPane().add(titleLabel);

		JLabel itemLabel = new JLabel("Item:");
		itemLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		itemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemLabel.setBounds(143, 77, 71, 16);
		frame.getContentPane().add(itemLabel);

		itemField = new JTextField();
		itemField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		itemField.setBounds(242, 72, 220, 26);
		frame.getContentPane().add(itemField);
		itemField.setColumns(10);

		costField = new JTextField();
		costField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		costField.setBounds(242, 118, 220, 26);
		frame.getContentPane().add(costField);
		costField.setColumns(10);

		JLabel costLabel = new JLabel("Cost:");
		costLabel.setHorizontalAlignment(SwingConstants.CENTER);
		costLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		costLabel.setBounds(143, 120, 71, 16);
		frame.getContentPane().add(costLabel);

		quantityLabel = new JLabel("Quantity:");
		quantityLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		quantityLabel.setBounds(135, 158, 95, 30);
		frame.getContentPane().add(quantityLabel);

		quantityField = new JTextField();
		quantityField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		quantityField.setColumns(10);
		quantityField.setBounds(242, 163, 220, 26);
		frame.getContentPane().add(quantityField);

		addBtn = new JButton("Add Item");
		addBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		addBtn.setBounds(240, 217, 133, 43);
		frame.getContentPane().add(addBtn);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 264, 376, 85);
		frame.getContentPane().add(scrollPane);

		listTextArea = new JTextArea();
		scrollPane.setViewportView(listTextArea);

		totalLabel = new JLabel("Total:");
		totalLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalLabel.setBounds(183, 376, 71, 30);
		frame.getContentPane().add(totalLabel);

		totalTextArea = new JTextArea();
		totalTextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		totalTextArea.setBounds(283, 379, 194, 30);
		frame.getContentPane().add(totalTextArea);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
