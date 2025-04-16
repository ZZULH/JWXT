package zzdx;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class sccj 
{
	public static void main(String ss) throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		JFrame app = new JFrame( "上传成绩" );
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        app.setVisible( true );
        app.setSize(500,600);
        Container cc = app.getContentPane( );
        cc.setLayout( null );
        cc.validate();
        Font mf = new Font("楷体",Font.CENTER_BASELINE,20);
        Font mf1 = new Font("楷体",Font.CENTER_BASELINE,15);
        Font mf2 = new Font("楷体",Font.CENTER_BASELINE,10);
        
        JPanel p1=new JPanel();
//        p1.setFont(mf);
        p1.setLayout(null);
        p1.setBounds(0, 0, 500, 100);
        cc.add(p1);
        
        JLabel l1=new JLabel("请在以下空格填入对应学生对应科目的成绩：");
        l1.setFont(mf);
        l1.setBounds(25, 50, 500, 30);
        p1.add(l1);
        
        JPanel p2=new JPanel();
        p2.setFont(mf1);
        p2.setBounds(0, 110, 500, 20);
        cc.add(p2);
        
        JLabel l2=new JLabel("学号");
        l2.setFont(mf1);
        l2.setPreferredSize(new Dimension(80,20));
        p2.add(l2);
        
        JLabel l3=new JLabel("学生姓名");
        l3.setFont(mf1);
        l3.setPreferredSize(new Dimension(75,20));
        p2.add(l3);
        
        JLabel l4=new JLabel("课程编号");
        l4.setFont(mf1);
        l4.setPreferredSize(new Dimension(100,20));
        p2.add(l4);
        
        JLabel l5=new JLabel("课程名");
        l5.setFont(mf1);
        l5.setPreferredSize(new Dimension(100,20));
        p2.add(l5);
        
        JLabel l6=new JLabel("分数");
        l6.setFont(mf1);
        l6.setPreferredSize(new Dimension(55,20));
        p2.add(l6);
        
        JLabel l11=new JLabel("提交键");
        l11.setFont(mf1);
        l11.setPreferredSize(new Dimension(55,20));
        p2.add(l11);
        
        
        JPanel p3=new JPanel();
        p3.setFont(mf1);
//        p3.setLayout(null);
        
        p3.setBounds(0, 130, 500, 470);
        cc.add(p3);
        
        
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
		Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		ResultSet r=s.executeQuery("select 学生.学号,学生.姓名,课程.课程编号,课程.课程名 "
				+ "from 学生,选修,课程,讲授,教师 "
				+ "where 学生.学号=选修.学号 "
				+ "and 选修.课程编号=课程.课程编号 "
				+ "and 课程.课程编号=讲授.课程编号 "
				+ "and 讲授.教师编号=教师.教师编号 "
				+ "and 选修.成绩 is null "
				+ "and 教师.教师编号="
				+ ss);
		while(r.next())
		{
			JLabel l7=new JLabel(r.getString(1).trim());
	        l7.setFont(mf2);
	        l7.setPreferredSize(new Dimension(80,20));
	        p3.add(l7);
	        
	        JLabel l8=new JLabel(r.getString(2).trim());
	        l8.setFont(mf1);
	        l8.setPreferredSize(new Dimension(75,20));
	        p3.add(l8);
	        
	        JLabel l9=new JLabel(r.getString(3).trim());
	        l9.setFont(mf1);
	        l9.setPreferredSize(new Dimension(100,20));
	        p3.add(l9);
	        
	        JLabel l10=new JLabel(r.getString(4).trim());
	        l10.setFont(mf2);
	        l10.setPreferredSize(new Dimension(100,20));
	        p3.add(l10);
	        
	        
	        JTextField t1=new JTextField();
	        t1.setFont(mf1);
	        t1.setPreferredSize(new Dimension(55,20));
	        p3.add(t1);
	        
	        JButton b1=new JButton("提交");
	        b1.setFont(mf1);
	        b1.setPreferredSize(new Dimension(55,20));
	        p3.add(b1);
	        
	        String gs1=r.getString(1).trim();
	        String gs2=r.getString(2).trim();
	        String gs3=r.getString(3).trim();
	        String gs4=r.getString(4).trim();
	        b1.addActionListener(new ActionListener() 
	        {
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					// TODO Auto-generated method stub
					String t11=t1.getText().trim();
					if(t11.length()==0)
					{
						JOptionPane.showMessageDialog(null, "分数不能为空!","提醒",JOptionPane.ERROR_MESSAGE);
					}
					else if(Integer.valueOf(t11)<0 || Integer.valueOf(t11)>100)
					{
						JOptionPane.showMessageDialog(null, "您所输入的分数异常，请检查。","提醒",JOptionPane.ERROR_MESSAGE);
					}
					else if(Integer.valueOf(t11)>=0 && Integer.valueOf(t11)<=100)
					{
						int t111=Integer.valueOf(t11);
						try 
						{
							s.executeUpdate("update 选修 "
									+ "set 成绩= "
									+ t111
									+ "where 学号= "
									+ gs1
									+"and 课程编号= "
									+ "'"+ gs3+"'");
							SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm");
							Date date = new Date(System.currentTimeMillis());
							String b=formatter.format(date);
							BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\app\\eclipse\\workspace\\lin\\src\\zzdx\\record.txt",true));
							ResultSet rr=s.executeQuery("select 姓名 "
									+ "from 教师 "
									+ "where 教师编号="
									+ ss);
							rr.next();
							String name=rr.getString(1).trim();
							bw.write("编号为"+ss+"的教师"+name);
							bw.newLine();
							bw.write( "在"+b);
							bw.newLine();
							bw.write( "修改了学号为"+gs1+"的学生"+gs2);
							bw.newLine();
							bw.write( "的编号为"+gs3+"的课程"+gs4+"的成绩："+t111);
							bw.newLine();
							bw.write( "********************************************************");
							bw.newLine();
							bw.flush();
							bw.close();
							JOptionPane.showMessageDialog(null, "上传成功。");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
		}
//		cc.add(p3);
	}
}