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
			JFrame app = new JFrame( "ɾ��ѧ���˺�" );
	        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        app.setVisible( true );
	        app.setSize( 500,600);
	        Container cc = app.getContentPane( );
	        cc.setLayout( null );
	        Font mf = new Font("����",Font.CENTER_BASELINE,20);
	        
	        JLabel l1=new JLabel("�����·�������Ҫɾ���˺ŵ�ѧ����Ϣ��");
	        l1.setFont(mf);
	        l1.setBounds(100, 100, 400, 30);
	        cc.add(l1);
	        
	        JLabel l2=new JLabel("ѧ�ţ�");
	        l2.setFont(mf);
	        l2.setBounds(0, 150, 200, 30);
	        cc.add(l2);
	        
	        
	        
	        JTextField t1=new JTextField();
	        t1.setFont(mf);
	        t1.setBounds(200, 150, 200, 30);
	        cc.add(t1);
	        
	        JButton b1=new JButton("ȷ��ɾ��");
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
							JOptionPane.showMessageDialog(null, "�������գ�","����",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
							Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet rs=s.executeQuery("select ѧ�� "
									+ "from ѧ�� ");
							int flag=0;
							while(rs.next())
							{
								if(rs.getString(1).trim().equals(t1.getText().trim()))//==t1.getText().trim())
								{
									s.executeUpdate("delete from ѧ�� "
											+ "where ѧ��= "
											+ t1.getText().trim());
									JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
									app.dispose();
									flag=1;
									break;
								}
							}
							if(flag==0)
							{
								JOptionPane.showMessageDialog(null, "��ѧ�Ų����ڣ�","��ʾ",JOptionPane.ERROR_MESSAGE);
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
			JFrame app = new JFrame( "ɾ����ʦ�˺�" );
	        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        app.setVisible( true );
	        app.setSize( 500,600);
	        Container cc = app.getContentPane( );
	        cc.setLayout( null );
	        Font mf = new Font("����",Font.CENTER_BASELINE,20);
	        
	        JLabel l1=new JLabel("�����·�������Ҫɾ���˺ŵĽ�ʦ��ţ�");
	        l1.setFont(mf);
	        l1.setBounds(100, 100, 400, 30);
	        cc.add(l1);
	        
	        JLabel l2=new JLabel("��ʦ��ţ�");
	        l2.setFont(mf);
	        l2.setBounds(0, 150, 200, 30);
	        cc.add(l2);
	        
	        
	        
	        JTextField t1=new JTextField();
	        t1.setFont(mf);
	        t1.setBounds(200, 150, 200, 30);
	        cc.add(t1);
	        
	        JButton b1=new JButton("ȷ��ɾ��");
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
							JOptionPane.showMessageDialog(null, "�������գ�","����",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
							Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet rs=s.executeQuery("select ��ʦ��� "
									+ "from ��ʦ ");
							int flag=0;
							while(rs.next())
							{
								if(rs.getString(1).trim().equals(t1.getText().trim()))//==t1.getText().trim())
								{
									s.executeUpdate("delete from ��ʦ "
											+ "where ��ʦ���= "
											+ t1.getText().trim());
									JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
									app.dispose();
									flag=1;
									break;
								}
							}
							if(flag==0)
							{
								JOptionPane.showMessageDialog(null, "�˽�ʦ��Ų����ڣ�","��ʾ",JOptionPane.ERROR_MESSAGE);
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
