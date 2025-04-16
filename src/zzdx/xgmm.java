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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class xgmm {

	public static void main(String ss,JFrame f) {
		// TODO Auto-generated method stub
		JFrame app = new JFrame( "修改密码" );
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        app.setVisible( true );
        app.setSize( 500,600);
        Container cc = app.getContentPane( );
        cc.setLayout( null );
        Font mf = new Font("楷体",Font.CENTER_BASELINE,20);
        
        JLabel l1=new JLabel("原密码：");
        l1.setFont(mf);
        l1.setBounds(50, 100, 100, 30);
        cc.add(l1);
        
        JTextField t1=new JTextField();
        t1.setFont(mf);
        t1.setBounds(180, 100, 250, 30);
        cc.add(t1);
        
        JLabel l2=new JLabel("新密码：");
        l2.setFont(mf);
        l2.setBounds(50, 150, 100, 30);
        cc.add(l2);
        
        JPasswordField p1=new JPasswordField();
        p1.setFont(mf);
        p1.setBounds(180, 150, 250, 30);
        cc.add(p1);
        
        JLabel l3=new JLabel("确认新密码：");
        l3.setFont(mf);
        l3.setBounds(20, 200, 130, 30);
        cc.add(l3);
        
        JPasswordField p2=new JPasswordField();
        p2.setFont(mf);
        p2.setBounds(180, 200, 250, 30);
        cc.add(p2);
        
        
        JButton b1=new JButton("确认修改");
        b1.setFont(mf);
        b1.setBounds(150, 300, 200, 50);
        b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String t11=t1.getText().trim();
				String p11=String.valueOf(p1.getPassword()).trim();
				String p22=String.valueOf(p2.getPassword()).trim();
				if(t11.length()==0 || p11.length()==0 ||p22.length()==0 )
				{
					JOptionPane.showMessageDialog(null, "密码不能为空","提示", JOptionPane.ERROR_MESSAGE);
				}
				else if(!p11.equals(p22))
				{
					JOptionPane.showMessageDialog(null, "两次输入的新密码不一致！","提示", JOptionPane.ERROR_MESSAGE);
				}
				else if(p11.length()<6)
				{
					JOptionPane.showMessageDialog(null, "密码安全性过低，适当增加密码长度。","提示", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try 
					{
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
						Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						ResultSet r=s.executeQuery("select 密码 "
								+ "from 学生 "
								+ "where 学号= "
								+ ss );
						r.next();
						if(r.getString(1).trim().equals(t11))
						{
							s.executeUpdate("update 学生 "
									+ "set 密码= "
									+ p11
									+ "where 学号="
									+ ss);
							app.dispose();
							f.dispose();
							JOptionPane.showMessageDialog(null, "密码修改成功！");
							dl.main(1);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "原密码不正确！","提示", JOptionPane.ERROR_MESSAGE);
						}
					} 
					catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
        cc.add(b1);
	}

}
