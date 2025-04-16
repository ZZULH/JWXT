package zzdx;

import java.awt.Container;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ckjl 
{
	public static void rf(Container cc,int i) 
	{
        String pathname = "D:\\app\\eclipse\\workspace\\lin\\src\\zzdx\\record.txt"; 
        try (FileReader reader = new FileReader(pathname);BufferedReader br = new BufferedReader(reader) ) 
        {
            Font mf = new Font("楷体",Font.CENTER_BASELINE,15);
            String line;
            while ((line = br.readLine()) != null) 
            {
            	JLabel l2=new JLabel(line);
            	l2.setFont(mf);
            	l2.setBounds(0, i, 500, 20);
            	cc.add(l2);
            	i=i+20;
            }
	            
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
	public static void main() 
	{
		JFrame app = new JFrame( "查看学生成绩修改记录" );
		app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		app.setVisible( true );
		app.setSize( 500,600);
		Container cc = app.getContentPane( );
		cc.setLayout( null );
		int gh=0;
		rf(cc,gh);
	}
}
