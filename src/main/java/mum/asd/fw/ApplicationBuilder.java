package mum.asd.fw;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mum.asd.fw.dao.IAccountDao;
import mum.asd.fw.dao.ITransactionDao;
import mum.asd.fw.gui.ComputeButton;
import mum.asd.fw.gui.ComputeButtonListener;
import mum.asd.fw.gui.DialogButton;
import mum.asd.fw.gui.DialogButtonListener;
import mum.asd.fw.gui.FormButton;
import mum.asd.fw.gui.FormButtonListener;
import mum.asd.fw.gui.ReportButton;
import mum.asd.fw.gui.ReportButtonListener;

public class ApplicationBuilder {
	public static void build(FWApplication app) {
		JFrame frame = new JFrame(app.getTitle());
		List<DialogButton> dButts = app.getDialogButts();
		List<FormButton> fButts = app.getFormButts();
		List<ReportButton> rButts = app.getReportButts();
		List<ComputeButton> cButts = app.getComputeButts();

		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(575, 310);
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

		for (FormButton fb : fButts) {
			JButton b = new JButton(fb.getLabel());
			b.addActionListener(new FormButtonListener(app.getForm(fb
					.getFormType())));
			panel1.add(b);
		}
		for (ComputeButton rb : cButts) {
			JButton b = new JButton(rb.getLabel());
			b.addActionListener(new ComputeButtonListener(app
					.getAddInterestController()));
			panel1.add(b);
		}

		for (ReportButton rb : rButts) {
			JButton b = new JButton(rb.getLabel());
			b.addActionListener(new ReportButtonListener(app.getReport(rb
					.getReportType())));
			panel1.add(b);
		}

		FWTableModel model = app.getTableModel();

		JTable table = new JTable(model);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		for (DialogButton db : dButts) {
			JButton b = new JButton(db.getLabel());
			model.refreshData();
			DialogButtonListener listener = new DialogButtonListener(
					model.getAccountList(), app.getDialog(db
							.getTransactionType()), table);
			b.addActionListener(listener);
			table.getSelectionModel().addListSelectionListener(listener);
			panel2.add(b);
			panel2.add(Box.createHorizontalStrut(1));
		}

		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		panel2.add(exit);
		Container c = frame.getContentPane();
		c.add(BorderLayout.CENTER, new JScrollPane(table));
		c.add(BorderLayout.NORTH, panel1);
		c.add(BorderLayout.EAST, panel2);

		frame.setVisible(true);

	}
}
