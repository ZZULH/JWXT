package zzdx;

import java.awt.Container;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class success 
{

	public static void main(String s1,String s2)
	{
		JFrame app = new JFrame( "系统内页" );
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize( 500,600 );
		Container c = app.getContentPane( );
		c.setLayout( null);
		app.setVisible( true );
		
		
		
        Font mf = new Font("楷体",Font.CENTER_BASELINE,18);
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date(System.currentTimeMillis());
		String b=formatter.format(date);
		String d=new String(s2+"同学，你好。你可以......");
		JTextField a=new JTextField(b);
		a.setEditable(false);
		a.setFont(mf);
		a.setBounds(10, 120, 200, 20);
		c.add(a);
		JTextField e=new JTextField(d);
		e.setEditable(false);
		e.setFont(mf);
		e.setBounds(10, 150, 300, 20);
		c.add(e);
		
        ImageIcon ic = new ImageIcon( "D:\\app\\eclipse\\workspace\\lin\\src\\zzdx\\l3.jpg" );
        JLabel f=new JLabel(null,ic,JLabel.CENTER);
        f.setBounds(20, 0, 400, 100);
        c.add(f);
        

        Font mf1 = new Font("楷体",Font.CENTER_BASELINE,25);
        qq g=qq.main(1,s1,app);
        g.setFont(mf1);
        g.setBounds(0, 200, 500, 300);
        c.add(g);
    }

}
