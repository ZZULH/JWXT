package zzdx;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class welcome
{
    public static void main(String args[ ])
    {
        JFrame app = new JFrame( "郑州大学教务管理系统" );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible( true );
        app.setSize( 500,600);
        Container c = app.getContentPane( );
        c.setLayout( null );
        JLabel a=new JLabel("请选择你的身份：");
        Font mf = new Font("楷体",Font.CENTER_BASELINE,20);
        a.setFont(mf);
        a.setBounds(150, 100, 200, 100);
        c.add(a);
        
        
        
        
        JButton b=new JButton( "学生" );
        b.setBounds(150, 200, 150, 50);
        b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				app.dispose();
				dl.main(1);
			}
		});
        c.add( b );
        
        
        
        JButton b0 = new JButton( "教师" );
        b0.setBounds(150, 300, 150, 50);
        b0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				app.dispose();
				dl.main(2);
			}
		});
        c.add( b0 );
        
        
        
        
        
        JButton b2 = new JButton( "主任" );
        b2.setBounds(150, 400,150,50);
        b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				app.dispose();
				dl.main(3);
			}
		});
        c.add( b2 );
    } // 方法main结束
} // 类J_BoxLayout结束