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

public class cj {

	public static void main(int i) throws ClassNotFoundException, SQLException 
	{
		if(i==1)
		{
			JFrame app = new JFrame( "����ѧ���˺�" );
	        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        app.setVisible( true );
	        app.setSize( 500,600);
	        Container cc = app.getContentPane( );
	        cc.setLayout( null );
	        Font mf = new Font("����",Font.CENTER_BASELINE,20);
	        
	        JLabel l1=new JLabel("�����·�����ѧ�������Ϣ��");
	        l1.setFont(mf);
	        l1.setBounds(100, 0, 400, 30);
	        cc.add(l1);
	        
	        JLabel l2=new JLabel("ѧ�ţ�");
	        l2.setFont(mf);
	        l2.setBounds(0, 40, 200, 30);
	        cc.add(l2);
	        JLabel l3=new JLabel("������");
	        l3.setFont(mf);
	        l3.setBounds(0, 80, 200, 30);
	        cc.add(l3);
	        JLabel l4=new JLabel("�༶��");
	        l4.setFont(mf);
	        l4.setBounds(0, 120, 200, 30);
	        cc.add(l4);
	        JLabel l5=new JLabel("�Ա�(m or w)��");
	        l5.setFont(mf);
	        l5.setBounds(0, 160, 200, 30);
	        cc.add(l5);
	        JLabel l6=new JLabel("ϵ�ţ�");
	        l6.setFont(mf);
	        l6.setBounds(0, 200, 200, 30);
	        cc.add(l6);
	        JLabel l7=new JLabel("��ʼ���룺");
	        l7.setFont(mf);
	        l7.setBounds(0, 240, 200, 30);
	        cc.add(l7);
	        
	        
	        
	        JTextField t1=new JTextField();
	        t1.setFont(mf);
	        t1.setBounds(200, 40, 200, 30);
	        cc.add(t1);
	        JTextField t2=new JTextField();
	        t2.setFont(mf);
	        t2.setBounds(200, 80, 200, 30);
	        cc.add(t2);
	        JTextField t3=new JTextField();
	        t3.setFont(mf);
	        t3.setBounds(200, 120, 200, 30);
	        cc.add(t3);
	        JTextField t4=new JTextField();
	        t4.setFont(mf);
	        t4.setBounds(200, 160, 200, 30);
	        cc.add(t4);
	        JTextField t5=new JTextField();
	        t5.setFont(mf);
	        t5.setBounds(200, 200, 200, 30);
	        cc.add(t5);
	        JTextField t6=new JTextField();
	        t6.setFont(mf);
	        t6.setBounds(200, 240, 200, 30);
	        cc.add(t6);
	        
	        JButton b1=new JButton("ȷ�ϴ���");
	        b1.setFont(mf);
	        b1.setBounds(200, 300, 200, 50);
	        b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try 
					{
						if(t1.getText().trim().length()==0||t2.getText().trim().length()==0||t3.getText().trim().length()==0
								||t4.getText().trim().length()==0||t5.getText().trim().length()==0
								||t6.getText().trim().length()==0)
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
							int flag=1;
							while(rs.next())
							{
								if(rs.getString(1).trim().equals(t1.getText().trim()))//==t1.getText().trim())
								{
									JOptionPane.showMessageDialog(null, "��ѧ���Ѵ��ڣ�","��ʾ",JOptionPane.ERROR_MESSAGE);
									flag=0;
									break;
								}
							}
							if(flag==1)
							{
								s.executeUpdate("insert into ѧ�� values("+t1.getText().trim()+",'"+t2.getText().trim()
										+"',"+Integer.valueOf(t3.getText().trim())+",'"+t4.getText().trim()+
										"','"+t5.getText().trim()+"',"+t6.getText().trim()+")");
								JOptionPane.showMessageDialog(null, "�����ɹ���");
								app.dispose();
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
			JFrame app = new JFrame( "������ʦ�˺�" );
	        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        app.setVisible( true );
	        app.setSize( 500,600);
	        Container cc = app.getContentPane( );
	        cc.setLayout( null );
	        Font mf = new Font("����",Font.CENTER_BASELINE,20);
	        
	        JLabel l1=new JLabel("�����·������ʦ�����Ϣ��");
	        l1.setFont(mf);
	        l1.setBounds(100, 0, 400, 30);
	        cc.add(l1);
	        
	        JLabel l2=new JLabel("��ʦ��ţ�");
	        l2.setFont(mf);
	        l2.setBounds(0, 40, 200, 30);
	        cc.add(l2);
	        JLabel l3=new JLabel("������");
	        l3.setFont(mf);
	        l3.setBounds(0, 80, 200, 30);
	        cc.add(l3);
	        JLabel l4=new JLabel("�绰��");
	        l4.setFont(mf);
	        l4.setBounds(0, 120, 200, 30);
	        cc.add(l4);
	        JLabel l5=new JLabel("��ʼ���룺");
	        l5.setFont(mf);
	        l5.setBounds(0, 160, 200, 30);
	        cc.add(l5);
	        
	        
	        
	        JTextField t1=new JTextField();
	        t1.setFont(mf);
	        t1.setBounds(200, 40, 200, 30);
	        cc.add(t1);
	        JTextField t2=new JTextField();
	        t2.setFont(mf);
	        t2.setBounds(200, 80, 200, 30);
	        cc.add(t2);
	        JTextField t3=new JTextField();
	        t3.setFont(mf);
	        t3.setBounds(200, 120, 200, 30);
	        cc.add(t3);
	        JTextField t4=new JTextField();
	        t4.setFont(mf);
	        t4.setBounds(200, 160, 200, 30);
	        cc.add(t4);
	        
	        JButton b1=new JButton("ȷ�ϴ���");
	        b1.setFont(mf);
	        b1.setBounds(200, 300, 200, 50);
	        b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try 
					{
						if(t1.getText().trim().length()==0||t2.getText().trim().length()==0||t3.getText().trim().length()==0
								||t4.getText().trim().length()==0)
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
							int flag=1;
							while(rs.next())
							{
								if(rs.getString(1).trim().equals(t1.getText().trim()))//==t1.getText().trim())
								{
									JOptionPane.showMessageDialog(null, "�ý�ʦ����Ѵ��ڣ�","��ʾ",JOptionPane.ERROR_MESSAGE);
									flag=0;
									break;
								}
							}
							if(flag==1)
							{
								s.executeUpdate("insert into ��ʦ values("+t1.getText().trim()+",'"+t2.getText().trim()
										+"',0,"+t3.getText().trim()+","+t4.getText().trim()+")");
								JOptionPane.showMessageDialog(null, "�����ɹ���");
								app.dispose();
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
