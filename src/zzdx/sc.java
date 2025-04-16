package zzdx;

import java.awt.Container;
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
import javax.swing.JTextField;

public class sc {

	public static void main(int i) {
		// TODO Auto-generated method stub
		if(i==1)
		{
			JFrame app = new JFrame( "删除学生账号" );
	        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        app.setVisible( true );
	        app.setSize( 500,600);
	        Container cc = app.getContentPane( );
	        cc.setLayout( null );
	        Font mf = new Font("楷体",Font.CENTER_BASELINE,20);
	        
	        JLabel l1=new JLabel("请在下方填入需要删除账号的学号信息：");
	        l1.setFont(mf);
	        l1.setBounds(100, 100, 400, 30);
	        cc.add(l1);
	        
	        JLabel l2=new JLabel("学号：");
	        l2.setFont(mf);
	        l2.setBounds(0, 150, 200, 30);
	        cc.add(l2);
	        
	        
	        
	        JTextField t1=new JTextField();
	        t1.setFont(mf);
	        t1.setBounds(200, 150, 200, 30);
	        cc.add(t1);
	        
	        JButton b1=new JButton("确认删除");
	        b1.setFont(mf);
	        b1.setBounds(200, 300, 200, 50);
	        b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try 
					{
						if(t1.getText().trim().length()==0)
						{
							JOptionPane.showMessageDialog(null, "不能留空！","提醒",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
							Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet rs=s.executeQuery("select 学号 "
									+ "from 学生 ");
							int flag=0;
							while(rs.next())
							{
								if(rs.getString(1).trim().equals(t1.getText().trim()))//==t1.getText().trim())
								{
									s.executeUpdate("delete from 学生 "
											+ "where 学号= "
											+ t1.getText().trim());
									JOptionPane.showMessageDialog(null, "删除成功。");
									app.dispose();
									flag=1;
									break;
								}
							}
							if(flag==0)
							{
								JOptionPane.showMessageDialog(null, "此学号不存在！","提示",JOptionPane.ERROR_MESSAGE);
							}
							
						}
						
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
	        cc.add(b1);
		}
		else if(i==2)
		{
			JFrame app = new JFrame( "删除教师账号" );
	        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        app.setVisible( true );
	        app.setSize( 500,600);
	        Container cc = app.getContentPane( );
	        cc.setLayout( null );
	        Font mf = new Font("楷体",Font.CENTER_BASELINE,20);
	        
	        JLabel l1=new JLabel("请在下方填入需要删除账号的教师编号：");
	        l1.setFont(mf);
	        l1.setBounds(100, 100, 400, 30);
	        cc.add(l1);
	        
	        JLabel l2=new JLabel("教师编号：");
	        l2.setFont(mf);
	        l2.setBounds(0, 150, 200, 30);
	        cc.add(l2);
	        
	        
	        
	        JTextField t1=new JTextField();
	        t1.setFont(mf);
	        t1.setBounds(200, 150, 200, 30);
	        cc.add(t1);
	        
	        JButton b1=new JButton("确认删除");
	        b1.setFont(mf);
	        b1.setBounds(200, 300, 200, 50);
	        b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try 
					{
						if(t1.getText().trim().length()==0)
						{
							JOptionPane.showMessageDialog(null, "不能留空！","提醒",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
							Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet rs=s.executeQuery("select 教师编号 "
									+ "from 教师 ");
							int flag=0;
							while(rs.next())
							{
								if(rs.getString(1).trim().equals(t1.getText().trim()))//==t1.getText().trim())
								{
									s.executeUpdate("delete from 教师 "
											+ "where 教师编号= "
											+ t1.getText().trim());
									JOptionPane.showMessageDialog(null, "删除成功。");
									app.dispose();
									flag=1;
									break;
								}
							}
							if(flag==0)
							{
								JOptionPane.showMessageDialog(null, "此教师编号不存在！","提示",JOptionPane.ERROR_MESSAGE);
							}
									
						}
						
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
	        cc.add(b1);
		}
	}

}
