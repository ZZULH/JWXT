package zzdx;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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

public class tuike {
	public static void main(String ss) throws ClassNotFoundException, SQLException
	{
		JFrame app = new JFrame( "退课" );
		app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		app.setVisible(true);
		app.setSize(500,600);
		Container cc = app.getContentPane( );
		cc.setLayout( null);
        Font mf = new Font("楷体",Font.CENTER_BASELINE,12);
        
        
        JPanel p1=new JPanel();
        p1.setBounds(0, 0, 500, 130);
        p1.setLayout(null);
        cc.add(p1);
        
        JLabel l1=new JLabel("您的已选课程如下，点击以退课。");
        l1.setFont(mf);
        l1.setBounds(100, 100, 300, 20);
        p1.add(l1);
        
        
        JPanel p2=new JPanel();
        p2.setBounds(0, 140, 500, 400);
        cc.add(p2);
        
        JLabel l2=new JLabel("课程编号");
        l2.setFont(mf);
        l2.setPreferredSize(new Dimension(120,20));
        p2.add(l2);
        
        JLabel l3=new JLabel("课程名");
        l3.setFont(mf);
        l3.setPreferredSize(new Dimension(120,20));
        p2.add(l3);
        
        JLabel l4=new JLabel("上课地点");
        l4.setFont(mf);
        l4.setPreferredSize(new Dimension(120,20));
        p2.add(l4);
        
        JLabel l5=new JLabel("上课时间");
        l5.setFont(mf);
        l5.setPreferredSize(new Dimension(120,20));
        p2.add(l5);
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
		Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet r=s.executeQuery("select 课程.课程编号,课程名,上课地点,上课时间 "
				+ "from 课程,选修 "
				+ "where 课程.课程编号=选修.课程编号 "
				+ "and 选修.学号="
				+ ss);
		while(r.next())
		{
			String abc=r.getString(1).trim().substring(0,2);
//			System.out.println(abc);
			if(abc.equals("oc"))
			{
				String aaa=r.getString(1).trim();
				JButton l7=new JButton(aaa);
				l7.setFont(mf);
				l7.setPreferredSize(new Dimension(120,20));
				p2.add(l7);
				
				l7.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							s.execute("delete from 选修 "
//											+ "where 课程编号='"+l7.getText().trim()+"' "
											+ "where 课程编号='"+r.getString(1).trim()+"' "
											+ "and 学号="
											+ ss);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "退课成功！");
					}
				});
				
				JLabel l6=new JLabel(r.getString(2).trim());
				l6.setFont(mf);
				l6.setPreferredSize(new Dimension(120,20));
				p2.add(l6);
				
				JLabel l8=new JLabel(r.getString(3).trim());
				l8.setFont(mf);
				l8.setPreferredSize(new Dimension(120,20));
				p2.add(l8);
				
				JLabel l9=new JLabel(r.getString(4).trim());
				l9.setFont(mf);
				l9.setPreferredSize(new Dimension(120,20));
				p2.add(l9);
			}
		}
//		s.close();
//		c.close();
//		app.dispose();
	}
}
