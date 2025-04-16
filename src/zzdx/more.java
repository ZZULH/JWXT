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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class more {

	public static void main()  {
		// TODO Auto-generated method stub
		
		
		
		
		JFrame app = new JFrame( "更多..." );
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        app.setVisible( true );
        app.setSize( 500,600);
        Container cc = app.getContentPane( );
        JPanel jp1=new JPanel();
        jp1.setBounds(0, 0, 500, 200);
        jp1.setLayout(null);
        cc.setLayout( null );
        Font mf = new Font("楷体",Font.CENTER_BASELINE,20);
        Font mf1 = new Font("楷体",Font.CENTER_BASELINE,15);
        
        JLabel l=new JLabel("请输入你想要查找的教师的姓名");
        l.setFont(mf);
        l.setBounds(80, 100, 300, 30);
        jp1.add(l);
        
        JTextField t=new JTextField();
        t.setBounds(150, 160, 100, 30);
        t.setFont(mf);
        jp1.add(t);
        
        
        JPanel jp2=new JPanel();
		jp2.setBounds(0, 200, 500, 400);
        
        
        JButton b=new JButton("搜索");
        b.setFont(mf1);
        b.setBounds(270, 160, 70, 30);
        b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
					String gh=t.getText();
					int i=0;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
					Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ResultSet r=s.executeQuery("select 姓名,电话 from 教师" );
					while(r.next())
					{
						if(String.valueOf(r.getString(1)).trim().equals(gh))
						{
							
							JLabel l1=new JLabel(gh);
							l1.setPreferredSize(new Dimension(200,30));
							l1.setFont(mf);
							jp2.add(l1);
							
							JLabel l2=new JLabel(String.valueOf(r.getString(2)).trim());
							l2.setPreferredSize(new Dimension(200,30));
							l2.setFont(mf);
							jp2.add(l2);
							
							i=1;
						}
							
					}
					if(i==0)
					{
						JLabel l3=new JLabel("抱歉，没有找到"+gh+"老师的电话，请核对无误后再重试");
						l3.setPreferredSize(new Dimension(400,30));
						l3.setFont(mf1);
						jp2.add(l3);
					}
						
				
					cc.add(jp2);
					
					
					
					app.setVisible(true);
					
					
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
        jp1.add(b);
        cc.add(jp1);
        
        
        
        
        
        
	}

}
