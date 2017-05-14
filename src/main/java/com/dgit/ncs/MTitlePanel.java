package com.dgit.ncs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import com.dgit.ncs.dto.Employee;
import com.dgit.ncs.dto.Title;
import com.dgit.ncs.service.DepartmentService;
import com.dgit.ncs.service.EmployeeService;
import com.dgit.ncs.service.TitleService;
import com.dgit.ncs.util.TableUtil;

@SuppressWarnings("serial")
public class MTitlePanel extends JPanel implements ActionListener {

	private JTextField txtNum;
	private JTextField txtTName;
	private JButton btnAdd;
	private JButton btnCancel;
	private JTable tbl;
	private JMenuItem menuItemUpdate;
	private JMenuItem menuItemRemove;

	/**
	 * Create the panel.
	 */

	public MTitlePanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(3, 1, 0, 0));

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

		JLabel lblTName = new JLabel("직책명");
		lblTName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTName.setBounds(87, 14, 57, 15);
		panel_2.add(lblTName);

		txtTName = new JTextField();
		txtTName.setColumns(10);
		txtTName.setBounds(171, 6, 170, 30);
		panel_2.add(txtTName);

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
		txtTName.setText("");
		btnAdd.setText("추가");
		tbl.setComponentPopupMenu(null);
		setTblDataLoad();
		setDefaultNum();
	}

	private void setDefaultNum() {

		if (tbl.getRowCount() == 0) {
			txtNum.setText(String.format("T%03d", 1));
		} else {
			String tmpValue = (String) tbl.getValueAt(tbl.getRowCount() - 1, 0);
			txtNum.setText(String.format("T%03d", Integer.parseInt(tmpValue.substring(1)) + 1));
		}
	}

	private void setTblDataLoad() {

		List<Title> list = TitleService.getInstance().selectAll();
		String COL_NAMES[] = { "번호", "직책" };
		String[][] data = new String[list.size()][COL_NAMES.length];

		int idx = 0;
		for (Title title : list) {
			data[idx][0] = String.format("T%03d", title.getTcode());
			data[idx][1] = title.getTname();
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
		TableUtil.tblCellCenter(tbl, SwingConstants.CENTER, 0, 1);

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

		if (!txtTName.getText().equals("")) {

			Title title = new Title();
			title.setTcode(Integer.parseInt(txtNum.getText().substring(1)));
			title.setTname(txtTName.getText());

			if (btnAdd.getText().equals("추가"))
				TitleService.getInstance().insert(title);
			else
				TitleService.getInstance().update(title);

			btnAdd.setText("추가");
			setDefaultData();

		} else {
			JOptionPane.showMessageDialog(this, "직책명을 입력해주세요.");
		}
	}

	protected void actionPerformedBtnCancel(ActionEvent arg0) {
		setDefaultData();
	}

	private void actionPerformedMenuItemUpdate(ActionEvent arg0) {

		btnAdd.setText("수정");

		String value = (String) tbl.getValueAt(tbl.getSelectedRow(), 0);
		Title title = TitleService.getInstance().selectByNo(Integer.parseInt(value.substring(1)));

		txtNum.setText(String.format("T%03d", title.getTcode()));
		txtTName.setText(title.getTname());

	}

	private void actionPerformedMenuItemRemove(ActionEvent arg0) {

		String value = (String) tbl.getValueAt(tbl.getSelectedRow(), 0);
		int result =
				JOptionPane.showConfirmDialog(
						null,
						"정말 삭제하시겠습니까?",
						"삭제 확인",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);

		if (result == JOptionPane.YES_OPTION) {
			try {
				TitleService.getInstance().delete(Integer.parseInt(value.substring(1)));
				setDefaultData();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "삭제 할 수 없는 항목입니다.");
			}
		}

	}

}
