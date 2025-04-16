package zzdx;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class dl
{
	public static String code;
    public static void main(int i)
    {
    	if(i==1)
    	{
    		JFrame app = new JFrame( "学生登陆页" );
    		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		app.setSize( 500,600 );
    		Container c = app.getContentPane( );
    		c.setLayout( null);//new FlowLayout()
    		
    		JLabel la=new JLabel(new ImageIcon("D:\\app\\eclipse\\workspace\\lin\\src\\zzdx\\l5.jpg" ));
	        la.setBounds(150, 0, 201, 225);
	        c.add(la);
	        
	        
	        
	        JLabel a=    new JLabel("学号:", 10);
	        Font mf = new Font("楷体",Font.CENTER_BASELINE,25);
	        a.setFont(mf);
	        a.setBounds(50, 240, 70, 60);
	        c.add(a);
	        
	        
	        
	        JTextField b= new JTextField(null, 10);
	        b.setFont(mf);
	        b.setBounds(150,240, 200, 55);
	        c.add(b);
	        
	        
	        
	        JLabel e=    new JLabel("密码:", 10);
	        e.setFont(mf);
	        e.setBounds(50, 300, 70, 60);
	        c.add(e);
	        
	        
	        
	        JPasswordField d= new JPasswordField(null, 10);
	        d.setFont(mf);
	        d.setBounds(150, 300, 200, 55);
	        c.add(d);
	        
	        
	        JLabel l1=new JLabel("验证码：");
	        l1.setFont(mf);
	        l1.setBounds(20, 360, 150, 60);
	        c.add(l1);
	        
	        JTextField t11=new JTextField();
	        t11.setFont(mf);
	        t11.setBounds(150,360,200,55);
	        c.add(t11);
	        
	        test t=new test();
	        JLabel l2=new JLabel();
	        l2.setIcon(new ImageIcon(t.getImage()));
	        l2.setBounds(360, 360, 120, 55);
	        c.add(l2);
	        
	        
	        
	        
	        code=t.getText().trim();
	        app.setVisible( true );
	        
	        
	        
	        
	        JButton ba=new JButton("登录");
	        ba.setFont(mf);
	        ba.setBounds(200, 500, 100, 60);
	        ba.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String t1=String.valueOf(b.getText());
					String p1=String.valueOf(d.getPassword());
					String s2=String.valueOf(t11.getText().trim());
					if(t1.length()==0||p1.length()==0)
					{
						JOptionPane.showMessageDialog(null, "学号或密码不能为空！","提醒",JOptionPane.ERROR_MESSAGE);
					}
					else if(!s2.equals(code))
					{
						JOptionPane.showMessageDialog(null, "验证码错误","提醒",JOptionPane.ERROR_MESSAGE);
						l2.setIcon(new ImageIcon(t.getImage()));
						code=t.getText().trim();
					}
					else
					{
						app.dispose();
						zzdx.main(t1,p1);
					}
				}
			});
	        c.add(ba);
	        
    	}
    	else if(i==2)
    	{
    		JFrame app = new JFrame( "教师登陆页" );
    		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		app.setSize( 500,600 );
    		Container c = app.getContentPane( );
    		c.setLayout( null);//new FlowLayout()
    		
    		JLabel la=new JLabel(new ImageIcon("D:\\app\\eclipse\\workspace\\lin\\src\\zzdx\\l5.jpg" ));
	        la.setBounds(150, 0, 201, 225);
	        c.add(la);
	        
	        
	        
	        JLabel a=    new JLabel("教师编号:", 10);
	        Font mf = new Font("楷体",Font.CENTER_BASELINE,25);
	        Font mf1 = new Font("楷体",Font.CENTER_BASELINE,20);
	        a.setFont(mf1);
	        a.setBounds(20, 240, 100, 60);
	        c.add(a);
	        
	        
	        
	        JTextField b= new JTextField(null, 10);
	        b.setFont(mf);
	        b.setBounds(150,240, 200, 55);
	        c.add(b);
	        
	        
	        
	        JLabel e=    new JLabel("密码:", 10);
	        e.setFont(mf);
	        e.setBounds(50, 300, 70, 60);
	        c.add(e);
	        
	        
	        
	        JPasswordField d= new JPasswordField(null, 10);
	        d.setFont(mf);
	        d.setBounds(150, 300, 200, 55);
	        c.add(d);
	        
	        
	        JLabel l1=new JLabel("验证码：");
	        l1.setFont(mf);
	        l1.setBounds(20, 360, 150, 60);
	        c.add(l1);
	        
	        JTextField t11=new JTextField();
	        t11.setFont(mf);
	        t11.setBounds(150,360,200,55);
	        c.add(t11);
	        
	        test t=new test();
	        JLabel l2=new JLabel();
	        l2.setIcon(new ImageIcon(t.getImage()));
	        l2.setBounds(360, 360, 120, 55);
	        c.add(l2);
	        
	        
	        
	        
	        code=t.getText().trim();
	        app.setVisible( true );
	        
	        
	        
	        
	        JButton ba=new JButton("登录");
	        ba.setFont(mf);
	        ba.setBounds(200, 500, 100, 60);
	        ba.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String t1=String.valueOf(b.getText());
					String p1=String.valueOf(d.getPassword());
					String s2=String.valueOf(t11.getText().trim());
					if(t1.length()==0||p1.length()==0)
					{
						JOptionPane.showMessageDialog(null, "学号或密码不能为空！","提醒",JOptionPane.ERROR_MESSAGE);
					}
					else if(!s2.equals(code))
					{
						JOptionPane.showMessageDialog(null, "验证码错误","提醒",JOptionPane.ERROR_MESSAGE);
						l2.setIcon(new ImageIcon(t.getImage()));
						code=t.getText().trim();
					}
					else
					{
						app.dispose();
						zzdx1.main(t1,p1);
					}
				}
			});
	        c.add(ba);
	        
    	}
    	else if(i==3)
    	{
    		JFrame app = new JFrame( "主任登陆页" );
    		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		app.setSize( 500,600 );
    		Container c = app.getContentPane( );
    		c.setLayout( null);//new FlowLayout()
    		
    		JLabel la=new JLabel(new ImageIcon("D:\\app\\eclipse\\workspace\\lin\\src\\zzdx\\l5.jpg" ));
	        la.setBounds(150, 0, 201, 225);
	        c.add(la);
	        
	        
	        
	        JLabel a=    new JLabel("系号:", 10);
	        Font mf = new Font("楷体",Font.CENTER_BASELINE,25);
	        a.setFont(mf);
	        a.setBounds(50, 240, 70, 60);
	        c.add(a);
	        
	        
	        
	        JTextField b= new JTextField(null, 10);
	        b.setFont(mf);
	        b.setBounds(150,240, 200, 55);
	        c.add(b);
	        
	        
	        
	        JLabel e=    new JLabel("密码:", 10);
	        e.setFont(mf);
	        e.setBounds(50, 300, 70, 60);
	        c.add(e);
	        
	        
	        
	        JPasswordField d= new JPasswordField(null, 10);
	        d.setFont(mf);
	        d.setBounds(150, 300, 200, 55);
	        c.add(d);
	        
	        
	        JLabel l1=new JLabel("验证码：");
	        l1.setFont(mf);
	        l1.setBounds(20, 360, 150, 60);
	        c.add(l1);
	        
	        JTextField t11=new JTextField();
	        t11.setFont(mf);
	        t11.setBounds(150,360,200,55);
	        c.add(t11);
	        
	        test t=new test();
	        JLabel l2=new JLabel();
	        l2.setIcon(new ImageIcon(t.getImage()));
	        l2.setBounds(360, 360, 120, 55);
	        c.add(l2);
	        
	        
	        
	        
	        code=t.getText().trim();
	        app.setVisible( true );
	        
	        
	        
	        
	        JButton ba=new JButton("登录");
	        ba.setFont(mf);
	        ba.setBounds(200, 500, 100, 60);
	        ba.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String t1=String.valueOf(b.getText());
					String p1=String.valueOf(d.getPassword());
					String s2=String.valueOf(t11.getText().trim());
					if(t1.length()==0||p1.length()==0)
					{
						JOptionPane.showMessageDialog(null, "学号或密码不能为空！","提醒",JOptionPane.ERROR_MESSAGE);
					}
					else if(!s2.equals(code))
					{
						JOptionPane.showMessageDialog(null, "验证码错误","提醒",JOptionPane.ERROR_MESSAGE);
						l2.setIcon(new ImageIcon(t.getImage()));
						code=t.getText().trim();
					}
					else
					{
						app.dispose();
						zzdx2.main(t1,p1);
					}
				}
			});
	        c.add(ba);
    	}
    } // 方法main结束
} // 类J_Text结束
