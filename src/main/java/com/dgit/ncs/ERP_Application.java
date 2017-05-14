package com.dgit.ncs;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ERP_Application extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnMEmp;
	private JButton btnMDep;
	private JButton btnMTitle;
	private boolean openSubEmp;
	private boolean openSubTitle;
	private boolean openSubDep;

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

		openSubEmp = false;
		openSubTitle = false;
		openSubDep = false;

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

		JFrame subFrame = null;

		if (arg0.getSource() == btnMTitle) {
			if (openSubTitle) return;
			subFrame = new JFrame();
			actionPerformedBtnMTitle(arg0, subFrame);
			subFrame.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					super.windowClosed(e);
					openSubTitle = false;
				}

			});
		}
		if (arg0.getSource() == btnMDep) {
			if (openSubDep) return;
			subFrame = new JFrame();
			actionPerformedBtnMDep(arg0, subFrame);
			subFrame.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					super.windowClosed(e);
					openSubDep = false;
				}

			});
		}
		if (arg0.getSource() == btnMEmp) {
			if (openSubEmp) return;
			subFrame = new JFrame();
			actionPerformedBtnMEmp(arg0, subFrame);
			subFrame.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					super.windowClosed(e);
					openSubEmp = false;
				}

			});
		}

		setFrameRelocation(subFrame);
		subFrame.setResizable(false);
		subFrame.setVisible(true);
	}

	protected void actionPerformedBtnMEmp(ActionEvent arg0, JFrame subFrame) {
		subFrame.setTitle("사원관리");
		subFrame.setSize(650, 600);

		MEmpPanel mEmpPanel = new MEmpPanel();
		subFrame.getContentPane().add(mEmpPanel);
		openSubEmp = true;
	}

	protected void actionPerformedBtnMDep(ActionEvent arg0, JFrame subFrame) {
		subFrame.setTitle("부서 관리");
		subFrame.setSize(440, 330);

		MDepPanel mDepPanel = new MDepPanel();
		subFrame.getContentPane().add(mDepPanel);
		openSubDep = true;
	}

	protected void actionPerformedBtnMTitle(ActionEvent arg0, JFrame subFrame) {
		subFrame.setTitle("직책 관리");
		subFrame.setSize(440, 300);

		MTitlePanel mTitlePanel = new MTitlePanel();
		subFrame.getContentPane().add(mTitlePanel);
		openSubTitle = true;
	}

	public void setFrameRelocation() {
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - getSize().width) / 2, (windowSize.height - getSize().height) / 2);
	}

	public void setFrameRelocation(JFrame frame) {
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((windowSize.width - frame.getSize().width) / 2, (windowSize.height - frame.getSize().height) / 2);
	}
}
