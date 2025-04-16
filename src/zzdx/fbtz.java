package zzdx;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class fbtz {

	public static void main(String ss) {
		// TODO Auto-generated method stub
		JFrame app = new JFrame( "发布通知" );
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        app.setVisible( true );
        app.setSize( 500,600);
        Container cc = app.getContentPane( );
        cc.setLayout( null );
        Font mf = new Font("楷体",Font.CENTER_BASELINE,20);
        Font mf1 = new Font("楷体",Font.CENTER_BASELINE,15);
        
        JLabel l1=new JLabel("请在下面的文本框内编辑通知内容：");
        l1.setFont(mf);
        l1.setBounds(60, 50, 400, 25);
        cc.add(l1);
        
        JTextArea t1=new JTextArea();
        t1.setFont(mf1);
        t1.setBounds(50, 100, 400, 400);
        cc.add(t1);
        
        JButton b1=new JButton("发布");
        b1.setFont(mf);
        b1.setBounds(200, 510, 100, 30);
        b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
					BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\app\\eclipse\\workspace\\lin\\src\\zzdx\\"+ss+".txt"));
					String[] strs = t1.getText().split("\n");
					for (String str : strs) 
					{
						bw.write(str);
						bw.newLine();
						bw.flush();
					}
					bw.close();
					JOptionPane.showMessageDialog(null, "通知发布成功。");
					app.dispose();
				}
				catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
        cc.add(b1);
	}

}
