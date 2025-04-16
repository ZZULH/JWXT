package zzdx;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class error 
{
	public static void main(int e)
	{
		if(e==1)
		{
			JFrame app = new JFrame( "错误" );
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setSize( 500,600 );
			Container c = app.getContentPane( );
			c.setLayout( null);
			app.setVisible( true );
			String b="你的学号或密码输入错误，请重新输入......";
	        Font mf = new Font("楷体",Font.CENTER_BASELINE,20);
	        ImageIcon ic = new ImageIcon( "D:\\app\\eclipse\\workspace\\lin\\src\\zzdx\\l2.jpg" );
	        JLabel a=new JLabel(b,ic,JLabel.CENTER);
	        a.setHorizontalTextPosition(JLabel.CENTER);
	        a.setVerticalTextPosition(JLabel.BOTTOM);
	        a.setBounds(25, 2, 400, 400);
	        a.setFont(mf);
	        c.add(a);
	        JButton d=new JButton("重新输入");
	        d.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					app.dispose();
					dl.main(1);
				}
			});
	        d.setFont(mf);
	        d.setBounds(150, 450, 150, 50);
	        c.add(d);
		}
		else if(e==2)
		{
			JFrame app = new JFrame( "错误" );
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setSize( 500,600 );
			Container c = app.getContentPane( );
			c.setLayout( null);
			app.setVisible( true );
			String b="你的教师编号或密码输入错误，请重新输入......";
	        Font mf = new Font("楷体",Font.CENTER_BASELINE,18);
	        ImageIcon ic = new ImageIcon( "D:\\app\\eclipse\\workspace\\lin\\src\\zzdx\\l2.jpg" );
	        JLabel a=new JLabel(b,ic,JLabel.CENTER);
	        a.setHorizontalTextPosition(JLabel.CENTER);
	        a.setVerticalTextPosition(JLabel.BOTTOM);
	        a.setBounds(25, 2, 400, 400);
	        a.setFont(mf);
	        c.add(a);
	        JButton d=new JButton("重新输入");
	        d.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					app.dispose();
					dl.main(2);
				}
			});
	        d.setFont(mf);
	        d.setBounds(150, 450, 150, 50);
	        c.add(d);
		}
		else if(e==3)
		{
			JFrame app = new JFrame( "错误" );
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setSize( 500,600 );
			Container c = app.getContentPane( );
			c.setLayout( null);
			app.setVisible( true );
			String b="系号或密码输入错误，请重新输入......";
	        Font mf = new Font("楷体",Font.CENTER_BASELINE,18);
	        ImageIcon ic = new ImageIcon( "D:\\app\\eclipse\\workspace\\lin\\src\\zzdx\\l2.jpg" );
	        JLabel a=new JLabel(b,ic,JLabel.CENTER);
	        a.setHorizontalTextPosition(JLabel.CENTER);
	        a.setVerticalTextPosition(JLabel.BOTTOM);
	        a.setBounds(25, 2, 400, 400);
	        a.setFont(mf);
	        c.add(a);
	        JButton d=new JButton("重新输入");
	        d.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					app.dispose();
					dl.main(3);
				}
			});
	        d.setFont(mf);
	        d.setBounds(150, 450, 150, 50);
	        c.add(d);
		}
			
	}

}
