package zzdx;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class xk {

	public static void main(String ss) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ssui(ss);
	}
	public static void check(String ss,String te,Statement s,String st) throws SQLException
	{
		ResultSet rs=s.executeQuery("select ѧ��,�γ��� "
				+ "from ѡ��,�γ� "
				+ "where ѡ��.�γ̱��=�γ�.�γ̱�� "
				+ "and ѧ��= "+ss
				+ "and �γ���='"+te+"'");
		if(rs.next())
		{
			JOptionPane.showMessageDialog(null, "���ſ��Ѿ�����ѡ���ˡ�","��ʾ", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			ResultSet rs2=s.executeQuery("select �γ�.�Ͽ�ʱ�� "
					+ "from ѡ��,�γ� "
					+ "where ѡ��.�γ̱��=�γ�.�γ̱�� "
					+ "and ѡ��.ѧ��= "
					+ ss);
			int i=0;
			while(rs2.next())
			{
				if(rs2.getString(1).trim().equals(st.trim()))
				{
					JOptionPane.showMessageDialog(null, "���ſ��������ѡ���г�ͻ���޷�ѡ�ޡ�","��ʾ", JOptionPane.ERROR_MESSAGE);
					i=1;
					break;
				}
			}
			if(i==0)
			{
				ResultSet rs1=s.executeQuery("select �γ̱�� from �γ� where �γ���='"+te+"'");
				rs1.next();
				s.execute("insert into ѡ��(ѧ��,�γ̱��) values("+ss+",'"+rs1.getString(1).trim()+"')");
			    JOptionPane.showMessageDialog(null, "ѡ�γɹ���");
			}
		}
			
	}
	public static void ssui( String ss) throws ClassNotFoundException, SQLException 
	{
		JFrame sapp2=new JFrame("ѡ��");
		sapp2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sapp2.setSize(1000,800);
		sapp2.setLocationRelativeTo(null);
		Container c1=sapp2.getContentPane();
		c1.setLayout(null);
		
		
		
		JPanel jp3=new JPanel();
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
		JTextField jtss=new JTextField(20);
		JButton jbSs=new JButton("����");
		JButton tk=new JButton("�˿�");
		jp3.add(jtss);
		jp3.add(jbSs);
		jp3.add(tk);
		jtss.setPreferredSize(new Dimension(100,50));
		jbSs.setPreferredSize(new Dimension(100,50));
		tk.setPreferredSize(new Dimension(100,50));
		jp3.setBounds(0, 0, 1000, 50);
		c1.add(jp3);
		
		tk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					tuike.main(ss);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
		Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rc=s.executeQuery("select �γ�.�γ̱��,�γ���,����,�Ͽεص�,�Ͽ�ʱ�� "
				+ "from �γ�,��ʦ,���� "
				+ "where �γ�.�γ̱��=����.�γ̱�� "
				+ "and ����.��ʦ���=��ʦ.��ʦ��� "
				+ "and �γ�.�γ̱��  not in "
				+ "(select �γ̱�� "
				+ "from ѡ�� "
				+ "where ѧ��= "
				+ ss
				+ ")" );
		
		
		JLabel j1=new JLabel("�γ̱��");
		JLabel j2=new JLabel("�γ���");
		JLabel j3=new JLabel("��ʦ");
		JLabel j4=new JLabel("�Ͽεص�");
		JLabel j5=new JLabel("�Ͽ�ʱ��");
		JPanel jp2=new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(j1);
		jp2.add(j2);
		jp2.add(j3);
		jp2.add(j4);
		jp2.add(j5);
		j1.setPreferredSize(new Dimension(180,40));
		j2.setPreferredSize(new Dimension(180,40));
		j3.setPreferredSize(new Dimension(180,40));
		j4.setPreferredSize(new Dimension(180,40));
		j5.setPreferredSize(new Dimension(180,40));
		jp2.setBounds(0, 60, 1000, 1000);
		c1.add(jp2);
		while(rc.next()){
			String scno=rc.getString(1);
	    	String scna=rc.getString(2);
	    	String sctna=rc.getString(3);
	    	String sclo=rc.getString(4);
	    	String sctime=rc.getString(5);
	    	JLabel jlscno=new JLabel(scno);
	    	JButton jbscna=new JButton(scna);
	    	JLabel jlsctna=new JLabel(sctna);
	    	JLabel jlsctime=new JLabel(sclo);
	    	JLabel jlsclo=new JLabel(sctime);
	    	jlscno.setPreferredSize(new Dimension(180,40));
	    	jbscna.setPreferredSize(new Dimension(180,40));
	    	jlsctna.setPreferredSize(new Dimension(180,40));
	    	jlsctime.setPreferredSize(new Dimension(180,40));
	    	jlsclo.setPreferredSize(new Dimension(180,40));
			    	
	    	jbscna.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						check(ss,jbscna.getText(),s,sctime);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
	    	
	    	jp2.add(jlscno);
	    	jp2.add(jbscna);
	    	jp2.add(jlsctna);
	    	jp2.add(jlsctime);
	    	jp2.add(jlsclo);
	    	jp2.validate();
	    	c1.validate();
	    	}
		jbSs.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			try {
			String str3=jtss.getText();
			ResultSet rc=s.executeQuery("select �γ�.�γ̱��,�γ���,����,�Ͽεص�,�Ͽ�ʱ�� "
	    			+ "from �γ�,��ʦ,���� "
					+ "where �γ�.�γ̱��=����.�γ̱�� "
					+ "and ����.��ʦ���=��ʦ.��ʦ��� "
					+ "and �γ�.�γ��� like '%"+str3+"%' "
					+ "and �γ�.�γ̱��  not in "
					+ "(select �γ̱�� "
					+ "from ѡ�� "
					+ "where ѧ��= "
					+ ss
					+ ")" );
			jp2.removeAll();
			jp2.repaint();
			JLabel jlcno=new JLabel("�γ̱��");
			JLabel jlcna=new JLabel("�γ���");
			JLabel jlct=new JLabel("��ʦ");
			JLabel jlclo=new JLabel("�Ͽεص�");
			JLabel jlctime=new JLabel("�Ͽ�ʱ��");
			jp2.setLayout(new FlowLayout());
			jp2.add(jlcno);
			jp2.add(jlcna);
			jp2.add(jlct);
			jp2.add(jlctime);
			jp2.add(jlclo);
			jlcno.setPreferredSize(new Dimension(180,40));
			jlcna.setPreferredSize(new Dimension(180,40));
			jlct.setPreferredSize(new Dimension(180,40));
			jlctime.setPreferredSize(new Dimension(180,40));
			jlclo.setPreferredSize(new Dimension(180,40));
			jp2.setBounds(0, 60, 1000, 500);
			c1.add(jp2);
			while(rc.next()){
				String scno=rc.getString(1);
		    	String scna=rc.getString(2);
		    	String sctna=rc.getString(3);
		    	String sclo=rc.getString(4);
		    	String sctime=rc.getString(5);
		    	JLabel jlscno=new JLabel(scno);
		    	JButton jbscna=new JButton(scna);
		    	JLabel jlsctna=new JLabel(sctna);
		    	JLabel jlsctime=new JLabel(sclo);
		    	JLabel jlsclo=new JLabel(sctime);
		    	jlscno.setPreferredSize(new Dimension(180,40));
		    	jbscna.setPreferredSize(new Dimension(180,40));
		    	jlsctna.setPreferredSize(new Dimension(180,40));
		    	jlsctime.setPreferredSize(new Dimension(180,40));
		    	jlsclo.setPreferredSize(new Dimension(180,40));
				    	
		    	jbscna.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							check(ss,jbscna.getText(),s,sctime);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		    	
		    	jp2.add(jlscno);
		    	jp2.add(jbscna);
		    	jp2.add(jlsctna);
		    	jp2.add(jlsctime);
		    	jp2.add(jlsclo);
		    	jp2.validate();
		    	c1.validate();

				jp2.repaint();
		    	}
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			}
		});
		sapp2.setVisible(true);
	}
}