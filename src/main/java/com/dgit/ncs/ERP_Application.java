package com.dgit.ncs;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ERP_Application extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnMEmp;
	private JButton btnMDep;
	private JButton btnMTitle;
	private static boolean openSub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERP_Application frame = new ERP_Application();
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
	public ERP_Application() {
		openSub = false;
		setTitle("DB관리메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 99);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 3, 20, 0));

		btnMEmp = new JButton("사원관리");
		btnMEmp.addActionListener(this);
		contentPane.add(btnMEmp);

		btnMDep = new JButton("부서관리");
		btnMDep.addActionListener(this);
		contentPane.add(btnMDep);

		btnMTitle = new JButton("직책관리");
		btnMTitle.addActionListener(this);
		contentPane.add(btnMTitle);

		setSize(360, 110);
		setResizable(false);
		setFrameRelocation();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (openSub)
			return;

		JFrame subFrame = new JFrame();
		subFrame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
				openSub = false;
			}

		});

		if (arg0.getSource() == btnMTitle) {
			actionPerformedBtnMTitle(arg0, subFrame);
		}
		if (arg0.getSource() == btnMDep) {
			actionPerformedBtnMDep(arg0, subFrame);
		}
		if (arg0.getSource() == btnMEmp) {
			actionPerformedBtnMEmp(arg0, subFrame);
		}

		setFrameRelocation(subFrame);
		subFrame.setResizable(false);
		subFrame.setVisible(true);
		openSub = true;
	}

	protected void actionPerformedBtnMEmp(ActionEvent arg0, JFrame subFrame) {

		subFrame.setTitle("사원관리");
		subFrame.setSize(650, 600);

		MEmpPanel mEmpPanel = new MEmpPanel();
		subFrame.getContentPane().add(mEmpPanel);
	}

	protected void actionPerformedBtnMDep(ActionEvent arg0, JFrame subFrame) {
		subFrame.setTitle("부서 관리");
		subFrame.setSize(440, 330);

		MDepPanel mDepPanel = new MDepPanel();
		subFrame.getContentPane().add(mDepPanel);
	}

	protected void actionPerformedBtnMTitle(ActionEvent arg0, JFrame subFrame) {
		subFrame.setTitle("직책 관리");
		subFrame.setSize(440, 300);

		MTitlePanel mTitlePanel = new MTitlePanel();
		subFrame.getContentPane().add(mTitlePanel);
	}

	public void setFrameRelocation() {
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - getSize().width) / 2, (windowSize.height - getSize().height) / 2);
	}

	public void setFrameRelocation(JFrame frame) {
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(
				(windowSize.width - frame.getSize().width) / 2,
				(windowSize.height - frame.getSize().height) / 2);
	}
}
