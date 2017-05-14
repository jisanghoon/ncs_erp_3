package com.dgit.ncs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dgit.ncs.dto.Department;
import com.dgit.ncs.service.DepartmentService;
import com.dgit.ncs.util.TableUtil;

@SuppressWarnings("serial")
public class MDepPanel extends JPanel implements ActionListener {

	private JTextField txtNum;
	private JTextField txtDName;
	private JTextField txtFloor;
	private JButton btnAdd;
	private JButton btnCancel;
	private JTable tbl;
	private JMenuItem menuItemUpdate;
	private JMenuItem menuItemRemove;

	/**
	 * Create the panel.
	 */
	/*
	 * public MDepPanel(JFrame mainFrame) { this(); setDefaultData();
	 * this.mainFrame = mainFrame; }
	 */

	public MDepPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(4, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNum = new JLabel("번호");
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum.setBounds(87, 14, 57, 15);
		panel_1.add(lblNum);

		txtNum = new JTextField();
		txtNum.setEditable(false);
		txtNum.setColumns(10);
		txtNum.setBounds(171, 6, 170, 30);
		panel_1.add(txtNum);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblDName = new JLabel("부서명");
		lblDName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDName.setBounds(87, 14, 57, 15);
		panel_2.add(lblDName);

		txtDName = new JTextField();
		txtDName.setColumns(10);
		txtDName.setBounds(171, 6, 170, 30);
		panel_2.add(txtDName);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblFloor = new JLabel("위치");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFloor.setBounds(87, 14, 57, 15);
		panel_4.add(lblFloor);

		txtFloor = new JTextField();
		txtFloor.setColumns(10);
		txtFloor.setBounds(171, 6, 170, 30);
		panel_4.add(txtFloor);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(5, 0, 5, 0));
		panel.add(panel_3);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel_3.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_3.add(btnCancel);

		JPanel panel_5 = new JPanel();
		add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		tbl = new JTable();

		JPopupMenu popupMenu = new JPopupMenu();
		menuItemUpdate = new JMenuItem("수정");
		menuItemRemove = new JMenuItem("삭제");

		menuItemUpdate.addActionListener(this);
		menuItemRemove.addActionListener(this);
		popupMenu.add(menuItemUpdate);
		popupMenu.add(menuItemRemove);

		tbl.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (tbl.getSelectedRow() > -1) {
					tbl.setComponentPopupMenu(popupMenu);
				} else {
					tbl.setComponentPopupMenu(null);
				}
			}
		});
		tbl.getTableHeader().setReorderingAllowed(false); // 이동 불가
		tbl.getTableHeader().setResizingAllowed(false); // 크기 조절 불가
		tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(tbl);
		panel_5.add(scrollPane);

		setDefaultData();

	}

	private void setDefaultData() {
		txtDName.setText("");
		txtFloor.setText("");
		btnAdd.setText("추가");
		tbl.setComponentPopupMenu(null);
		setTblDataLoad();
		setDefaultNum();
	}

	private void setDefaultNum() {
		if (tbl.getRowCount() == 0) {
			txtNum.setText(String.format("D%03d", 1));
		} else {
			String tmpValue = (String) tbl.getValueAt(tbl.getRowCount() - 1, 0);
			txtNum.setText(String.format("D%03d", Integer.parseInt(tmpValue.substring(1)) + 1));
		}
	}

	private void setTblDataLoad() {
		List<Department> list = DepartmentService.getInstance().selectAll();
		String COL_NAMES[] = { "번호", "부서명", "위치" };
		String[][] data = new String[list.size()][COL_NAMES.length];

		int idx = 0;
		for (Department dep : list) {
			data[idx][0] = String.format("D%03d", dep.getDcode());
			data[idx][1] = dep.getDname();
			data[idx][2] = dep.getFloor() + "";
			idx++;
		}

		DefaultTableModel tblModel = new DefaultTableModel(data, COL_NAMES) {

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}

		};

		tbl.setModel(tblModel);
		TableUtil.tblHeaderCenter(tbl);
		TableUtil.tblCellCenter(tbl, SwingConstants.CENTER, 0, 1, 2);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAdd) {
			actionPerformedBtnAdd(arg0);
		} else if (arg0.getSource() == btnCancel) {
			actionPerformedBtnCancel(arg0);
		} else if (arg0.getSource() == menuItemUpdate) {
			actionPerformedMenuItemUpdate(arg0);
		} else if (arg0.getSource() == menuItemRemove) {
			actionPerformedMenuItemRemove(arg0);
		}

	}

	protected void actionPerformedBtnAdd(ActionEvent arg0) {

		if (!txtDName.getText().equals("") && !txtFloor.getText().equals("")) {

			Department dep = new Department();
			dep.setDcode(Integer.parseInt(txtNum.getText().substring(1)));
			dep.setDname(txtDName.getText());
			dep.setFloor(Integer.parseInt(txtFloor.getText()));

			if (btnAdd.getText().equals("추가")) DepartmentService.getInstance().insert(dep);
			else DepartmentService.getInstance().update(dep);

			btnAdd.setText("추가");
			setDefaultData();

		} else {
			JOptionPane.showMessageDialog(this, "부서정보를 입력해주세요.");
		}
	}

	protected void actionPerformedBtnCancel(ActionEvent arg0) {
		setDefaultData();
	}

	private void actionPerformedMenuItemUpdate(ActionEvent arg0) {

		btnAdd.setText("수정");

		String value = (String) tbl.getValueAt(tbl.getSelectedRow(), 0);
		Department dep = DepartmentService.getInstance().selectByNo(Integer.parseInt(value.substring(1)));

		txtNum.setText(String.format("D%03d", dep.getDcode()));
		txtDName.setText(dep.getDname());
		txtFloor.setText(dep.getFloor() + "");

	}

	private void actionPerformedMenuItemRemove(ActionEvent arg0) {

		String value = (String) tbl.getValueAt(tbl.getSelectedRow(), 0);
		int result = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);

		if (result == JOptionPane.YES_OPTION) {
			try {
				DepartmentService.getInstance().delete(Integer.parseInt(value.substring(1)));
				setDefaultData();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "삭제 할 수 없는 항목입니다.");
			}
		}
	}
}
