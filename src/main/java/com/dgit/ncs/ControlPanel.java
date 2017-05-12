package com.dgit.ncs;
/*package com.digit.ncs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener {
	JButton btnMEmp, btnMDep, btnMTitle;
	JFrame mainFrame;

	*//**
	 * Create the panel.
	 *//*
	public ControlPanel(JFrame mainFrame) {
		this();
		this.mainFrame = mainFrame;
		// mainFrameSetting(mainFrame);
	}

	public ControlPanel() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new GridLayout(1, 3, 20, 0));

		btnMEmp = new JButton("사원관리");
		btnMEmp.addActionListener(this);
		add(btnMEmp);

		btnMDep = new JButton("부서관리");
		btnMDep.addActionListener(this);
		add(btnMDep);

		btnMTitle = new JButton("직책관리");
		btnMTitle.addActionListener(this);
		add(btnMTitle);
	}

	
	 * private void mainFrameSetting(JFrame mainFrame) { ERP_Application frame =
	 * (ERP_Application) mainFrame; frame.setTitle("대구아이티ERP");
	 * frame.setSize(360, 120); frame.setFrameRelocation(); }
	 

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnMEmp) {
			btnMEmpActionPerformed(e);
		} else if (e.getSource() == btnMDep) {
			btnMDepActionPerformed(e);
		} else if (e.getSource() == btnMTitle) {
			btnMTitleActionPerformed(e);
		}

		JPanel contentPane = (JPanel) getParent();
		contentPane.remove(this);
		contentPane.invalidate();
	}

	protected void btnMEmpActionPerformed(ActionEvent e) {
		MEmpPanel mEmpPanel = new MEmpPanel(mainFrame);
		ERP_Application frame = (ERP_Application) mainFrame;
		frame.setTitle("사원관리");
		frame.setSize(650, 600);
		getParent().add(mEmpPanel);
		frame.setFrameRelocation();

	}

	protected void btnMDepActionPerformed(ActionEvent e) {
		MDepPanel mDepPanel = new MDepPanel(mainFrame);
		ERP_Application frame = (ERP_Application) mainFrame;
		frame.setTitle("부서 관리");
		frame.setSize(440, 330);
		getParent().add(mDepPanel);
		frame.setFrameRelocation();

	}

	protected void btnMTitleActionPerformed(ActionEvent e) {
		MTitlePanel mTitlePanel = new MTitlePanel(mainFrame);
		ERP_Application frame = (ERP_Application) mainFrame;
		frame.setTitle("직책 관리");
		frame.setSize(440, 300);
		getParent().add(mTitlePanel);
		frame.setFrameRelocation();

	}

}
*/