package com.dgit.ncs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dgit.ncs.dto.Department;
import com.dgit.ncs.dto.Employee;
import com.dgit.ncs.dto.Title;
import com.dgit.ncs.service.DepartmentService;
import com.dgit.ncs.service.EmployeeService;
import com.dgit.ncs.service.TitleService;
import com.dgit.ncs.util.TableUtil;

@SuppressWarnings("serial")
public class MEmpPanel extends JPanel implements ActionListener {

	private JTextField txtNum;
	private JTextField txtName;
	private JTextField txtJoin;
	private JComboBox<String> comboTitle;
	private JSpinner spinSalary;
	private ButtonGroup rgroup;
	private JRadioButton radioM;
	private JRadioButton radioW;
	private JComboBox<String> comboDep;
	private JTable tbl;
	private JButton btnCancel;
	private JButton btnAdd;
	private JMenuItem menuItemUpdate;
	private JMenuItem menuItemRemove;

	/**
	 * Create the panel.
	 */

	public MEmpPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(15, 0, 0, 0));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel row1_1 = new JPanel();
		panel.add(row1_1);
		row1_1.setLayout(null);

		JLabel lblNum = new JLabel("번호");
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum.setBounds(182, 13, 57, 15);
		row1_1.add(lblNum);

		txtNum = new JTextField();
		txtNum.setEditable(false);
		txtNum.setBounds(279, 6, 170, 30);
		row1_1.add(txtNum);
		txtNum.setColumns(10);

		JPanel row1_2 = new JPanel();
		panel.add(row1_2);
		row1_2.setLayout(null);

		JLabel lblName = new JLabel("사원명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(182, 14, 57, 15);
		row1_2.add(lblName);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(279, 6, 170, 30);
		row1_2.add(txtName);

		JPanel row1_3 = new JPanel();
		panel.add(row1_3);
		row1_3.setLayout(null);

		JLabel lblTitle = new JLabel("직책");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setBounds(182, 14, 57, 15);
		row1_3.add(lblTitle);

		comboTitle = new JComboBox<String>();
		comboTitle.setBounds(279, 6, 170, 30);
		row1_3.add(comboTitle);

		JPanel row1_4 = new JPanel();
		panel.add(row1_4);
		row1_4.setLayout(null);

		JLabel lblSalary = new JLabel("급여");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalary.setBounds(182, 14, 57, 15);
		row1_4.add(lblSalary);

		spinSalary = new JSpinner();
		spinSalary.setBounds(279, 6, 170, 30);
		row1_4.add(spinSalary);

		JPanel row1_5 = new JPanel();
		panel.add(row1_5);
		row1_5.setLayout(null);

		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(182, 14, 57, 15);
		row1_5.add(lblGender);

		rgroup = new ButtonGroup();
		radioM = new JRadioButton("남");

		radioM.setBounds(307, 10, 44, 23);
		row1_5.add(radioM);

		radioW = new JRadioButton("여");
		radioW.setBounds(355, 10, 44, 23);
		row1_5.add(radioW);

		rgroup.add(radioM);
		rgroup.add(radioW);

		JPanel row1_6 = new JPanel();
		panel.add(row1_6);
		row1_6.setLayout(null);

		JLabel lblDep = new JLabel("부서");
		lblDep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDep.setBounds(182, 14, 57, 15);
		row1_6.add(lblDep);

		comboDep = new JComboBox<String>();
		comboDep.setBounds(279, 6, 170, 30);
		row1_6.add(comboDep);

		JPanel row1_7 = new JPanel();
		panel.add(row1_7);
		row1_7.setLayout(null);

		JLabel lblJoin = new JLabel("입사일");
		lblJoin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJoin.setBounds(182, 14, 57, 15);
		row1_7.add(lblJoin);

		txtJoin = new JTextField();
		txtJoin.setColumns(10);
		txtJoin.setBounds(279, 6, 170, 30);
		row1_7.add(txtJoin);

		JPanel row2 = new JPanel();
		row2.setBorder(new EmptyBorder(5, 0, 5, 0));
		panel.add(row2);
		row2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		row2.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		row2.add(btnCancel);

		JPanel row3 = new JPanel();
		row3.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(row3);
		row3.setLayout(new BorderLayout(0, 0));
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
		row3.add(scrollPane, BorderLayout.CENTER);

		setDefaultData();

	}

	private void setDefaultData() {
		txtName.setText("");
		btnAdd.setText("추가");

		SpinnerModel spinnerModel = new SpinnerNumberModel(1500000, 1000000, 5000000, 100000);
		spinSalary.setModel(spinnerModel);

		radioM.setSelected(true);

		txtJoin.setText(changeDateFormat(new Date()));

		tbl.setComponentPopupMenu(null);

		setCmbTitleDataLoad();
		setCmbDepDataLoad();
		setTblDataLoad();
		setDefaultEcode();
	}

	private void setDefaultEcode() {
		if (tbl.getRowCount() == 0) {
			String dateStr = changeDateFormat(new Date());
			txtNum.setText(String.format("E%s%03d", dateStr.substring(1, 4), 1));
		} else {
			String tmpValue = (String) tbl.getValueAt(tbl.getRowCount() - 1, 0);
			txtNum.setText(String.format("E%s%03d", tmpValue.substring(1, 4), Integer.parseInt(tmpValue.substring(5)) + 1));
		}
	}

	private void setTblDataLoad() {
		List<Employee> list = EmployeeService.getInstance().selectAll();

		String COL_NAMES[] = { "번호", "사원명", "직책", "급여", "성별", "부서", "입사일" };
		String[][] data = new String[list.size()][COL_NAMES.length];

		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");

		int idx = 0;
		for (Employee employee : list) {
			data[idx][0] = String.format("E%06d", employee.getEno());
			data[idx][1] = employee.getEname();
			data[idx][2] = employee.getTitle().getTname();
			data[idx][3] = String.format("%,d", employee.getSalary());
			data[idx][4] = (employee.getGender() == 0 ? "남" : "여");
			data[idx][5] = employee.getDepartment().getDname() + "(" + employee.getDepartment().getFloor() + "층)";
			if (employee.getJoindate() != null) {
				data[idx][6] = dFormat.format(employee.getJoindate());
			}
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
		TableUtil.tblCellCenter(tbl, SwingConstants.CENTER, 0, 1, 2, 4, 5, 6);
		TableUtil.tblCellCenter(tbl, SwingConstants.RIGHT, 3);

	}

	private void setCmbDepDataLoad() {
		comboDep.removeAllItems();
		List<Department> list = DepartmentService.getInstance().selectAll();

		for (Department department : list) {
			comboDep.addItem(department.getDname());
		}
		comboDep.setSelectedIndex(0);

	}

	private void setCmbTitleDataLoad() {
		comboTitle.removeAllItems();
		List<Title> list = TitleService.getInstance().selectAll();

		for (Title title : list) {
			comboTitle.addItem(title.getTname());
		}
		comboTitle.setSelectedIndex(0);
	}

	private String changeDateFormat(Date date) {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dFormat.format(date);
	}

	private Date changeDateFormat(String inputDate) {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date outputDate = null;
		try {
			outputDate = dFormat.parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputDate;
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

	private void actionPerformedMenuItemUpdate(ActionEvent arg0) {
		// TODO Auto-generated method stub
		btnAdd.setText("수정");

		String value = (String) tbl.getValueAt(tbl.getSelectedRow(), 0);
		Employee employee = EmployeeService.getInstance().selectByNo(Integer.parseInt(value.substring(1)));

		txtNum.setText(String.format("E%d", employee.getEno()));
		txtName.setText(employee.getEname());
		txtJoin.setText(changeDateFormat(employee.getJoindate()));

		comboTitle.setSelectedIndex(employee.getTitle().getTcode() - 1);
		spinSalary.setValue(employee.getSalary());

		if (employee.getGender() == 0) radioM.setSelected(true);
		else radioW.setSelected(true);

		comboDep.setSelectedIndex(employee.getDepartment().getDcode() - 1);

	}

	private void actionPerformedMenuItemRemove(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String value = (String) tbl.getValueAt(tbl.getSelectedRow(), 0);

		int result = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);

		if (result == JOptionPane.YES_OPTION) {
			EmployeeService.getInstance().delete(Integer.parseInt(value.substring(1)));
			setDefaultData();
		}

	}

	protected void actionPerformedBtnAdd(ActionEvent arg0) {

		if (!txtName.getText().equals("")) {

			Department dep = new Department();
			Title title = new Title();

			dep.setDcode(comboDep.getSelectedIndex() + 1);
			title.setTcode(comboTitle.getSelectedIndex() + 1);

			Employee employee = new Employee();
			employee.setDepartment(dep);
			employee.setEname(txtName.getText());
			employee.setEno(Integer.parseInt(txtNum.getText().substring(1)));
			employee.setGender(radioM.isSelected() ? 0 : 1);
			employee.setJoindate(changeDateFormat(txtJoin.getText()));
			employee.setSalary((int) spinSalary.getValue());
			employee.setTitle(title);

			if (btnAdd.getText().equals("추가")) {
				EmployeeService.getInstance().insert(employee);
			} else {
				int result = JOptionPane.showConfirmDialog(null, "정말 수정하시겠습니까?", "수정 확인", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);

				if (result == JOptionPane.YES_OPTION) {
					EmployeeService.getInstance().update(employee);
				}
			}
			btnAdd.setText("추가");
			setDefaultData();

		} else {
			JOptionPane.showMessageDialog(this, "사원명을 입력해주세요.");
		}

	}

	protected void actionPerformedBtnCancel(ActionEvent arg0) {

		setDefaultData();
	}

}
