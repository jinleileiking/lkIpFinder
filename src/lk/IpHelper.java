package lk;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class IpHelper extends javax.swing.JFrame {
	private JButton cBNScan;
	private JScrollPane cjSPIpScanned;
	private JLabel jlblLocalMac;
	private JMenu About;
	private JMenuBar cjMB;
	private JTable cjTIpScanned;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				IpHelper inst = new IpHelper();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public IpHelper() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("\u672c\u673a\u7f51\u6bb5IP\u641c\u7d22\u5de5\u5177_Leiking");
			this.addWindowListener(new WindowAdapter() {
				public void windowOpened(WindowEvent evt) {
					thisWindowOpened(evt);
				}
			});
			{
				cjMB = new JMenuBar();
				setJMenuBar(cjMB);
				{
					About = new JMenu();
					cjMB.add(About);
					About.setText("About");
					About.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							AboutMouseClicked(evt);
						}
					});

				}
			}
			{
				cBNScan = new JButton();
				getContentPane().add(cBNScan, BorderLayout.SOUTH);
				cBNScan.setText("Scan");
				cBNScan.setPreferredSize(new java.awt.Dimension(292, 30));
				cBNScan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cBNScanActionPerformed(evt);
					}
				});
			}
			{
				cjSPIpScanned = new JScrollPane();
				getContentPane().add(cjSPIpScanned, BorderLayout.NORTH);
				cjSPIpScanned.setPreferredSize(new java.awt.Dimension(292, 358));
				{
					TableModel cjTIpScannedModel = 
						new DefaultTableModel(
								new String[][] {  },
								new String[] { "IP", "In Use?" });
					cjTIpScanned = new JTable();
					cjSPIpScanned.setViewportView(cjTIpScanned);
					cjTIpScanned.setModel(cjTIpScannedModel);
				}
			}
			{
				jlblLocalMac = new JLabel();
				getContentPane().add(jlblLocalMac, BorderLayout.CENTER);
				jlblLocalMac.setPreferredSize(new java.awt.Dimension(292, 33));
			}
			pack();
			this.setSize(300, 474);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cBNScanActionPerformed(ActionEvent evt) {
		System.out.println("cBNScan.actionPerformed, event="+evt);
		//TODO add your code for cBNScan.actionPerformed
		InetAddress cLocalIP;

		  
		try
		{
			cLocalIP = InetAddress.getLocalHost();
			System.out.println(cLocalIP.toString());
		}
		catch (UnknownHostException e)
		{
			System.out.println("err");
			return;
		}
		
		try
		{
			String cLocalIp = cLocalIP.toString();
			
			// Find the '/'
			String[] acLocalIpSplitFirst = cLocalIp.split("/");
			String[] acLocalIpSplit = acLocalIpSplitFirst[1].split("\\.");


			for (short wTmp = 230; wTmp <255; wTmp++)
			{
				String cToPing;
				cToPing = acLocalIpSplit[0] + "." + 
				          acLocalIpSplit[1] + "." + 
				          acLocalIpSplit[2] + "." + 
				          wTmp;
//					System.out.println("cToPing = " + cToPing);
				InetAddress cIPAddrToPing = InetAddress.getByName(cToPing);
				
//			      try {
//			          Thread.currentThread().sleep(100);
//			        } catch (InterruptedException e){}
//			        
				if (true == PingCmd.Ping(cIPAddrToPing.getHostAddress()))
				{
					//ping success
					//Change the Text
					DefaultTableModel tableModel = (DefaultTableModel) cjTIpScanned.getModel();
					tableModel.addRow(new Object[]{cToPing, "Yes"});
					tableModel.fireTableDataChanged();
//					tableModel.fireTableRowsInserted(tableModel.getRowCount(),tableModel.getRowCount());//
////					cjTIpScanned.scrollRectToVisible(cjTIpScanned.getCellRect(newRowIdx,0,false));
//					cjTIpScanned.invalidate();
//					try
//                    {
//                        Thread.sleep(100);
//                    }
//                    catch (InterruptedException e)
//                    {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }

				}
				else
				{
					DefaultTableModel tableModel = (DefaultTableModel) cjTIpScanned.getModel();
					tableModel.addRow(new Object[]{cToPing, "No"});
				    tableModel.fireTableDataChanged();

				}
			}

		}
		catch (UnknownHostException e)
		{
		    System.out.println("err");
		}		
	}
	
	
	private void AboutMouseClicked(MouseEvent evt) {
		System.out.println("About.mouseClicked, event="+evt);
		//TODO add your code for About.mouseClicked
		String cStrShow =  "";
		MsgBox.show(cStrShow, "关于");
	}
	
	private void thisWindowOpened(WindowEvent evt) {
		System.out.println("this.windowOpened, event="+evt);
		//TODO add your code for this.windowOpened
		jlblLocalMac.setText("本机MAC: " + LocalHost.getMac());
	}

}
