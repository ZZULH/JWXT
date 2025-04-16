package zzdx;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ckkc {

	public static void main(String ss) throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		
		JFrame app = new JFrame( "查看讲授课程" );
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        app.setVisible( true );
        app.setSize( 500,600);
        Container cc = app.getContentPane( );
        cc.setLayout( null );
        Font mf = new Font("楷体",Font.CENTER_BASELINE,18);
        
        JPanel p1=new JPanel();
        p1.setBounds(0, 0, 500, 130);
        p1.setLayout(null);
        cc.add(p1);
        
        JLabel l1=new JLabel("您所讲授的课程如下：");
        l1.setFont(mf);
        l1.setBounds(150, 100, 200, 20);
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
				+ "from 课程,讲授,教师 "
				+ "where 课程.课程编号=讲授.课程编号 "
				+ "and 讲授.教师编号=教师.教师编号 "
				+ "and 教师.教师编号="
				+ ss);
		while(r.next())
		{
			JLabel l6=new JLabel(r.getString(1).trim());
			l6.setFont(mf);
			l6.setPreferredSize(new Dimension(120,20));
			p2.add(l6);
			
			JLabel l7=new JLabel(r.getString(2).trim());
			l7.setFont(mf);
			l7.setPreferredSize(new Dimension(120,20));
			p2.add(l7);
			
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

}