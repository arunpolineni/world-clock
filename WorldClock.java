import java.awt.EventQueue;
import java.awt.Font;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TreeSet;
import java.lang.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class WorldClock extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorldClock frame = new WorldClock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	ZonedDateTime zdt;
	String zoneId = "Asia/Calcutta";
	TreeSet<String> ts;

	public WorldClock() {
		setBackground(Color.CYAN);

		zdt = ZonedDateTime.now(ZoneId.of(zoneId));
		ts = new TreeSet(ZoneId.getAvailableZoneIds());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("WORLD CLOCK");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(188, 30, 268, 28);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Select Zone");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(93, 122, 109, 28);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(93, 190, 98, 28);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Time");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(93, 253, 98, 28);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Offset");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(93, 311, 98, 22);
		contentPane.add(lblNewLabel_4);

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				zoneId=(String)(e.getItem());
			}
		});
		for (String s : ts)
			comboBox.addItem(s);

		comboBox.setBounds(248, 114, 230, 36);
		contentPane.add(comboBox);

		JLabel lblNewLabel_5 = new JLabel("DateValue");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(248, 186, 230, 36);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(248, 249, 230, 37);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setBounds(248, 304, 230, 36);
		contentPane.add(lblNewLabel_7);

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					zdt = ZonedDateTime.now(ZoneId.of(zoneId));
					lblNewLabel_5.setText(zdt.toLocalDate().toString());
					lblNewLabel_6.setText(zdt.toLocalTime().toString());
					lblNewLabel_7.setText(zdt.getOffset().toString());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t.start();

	}
}
