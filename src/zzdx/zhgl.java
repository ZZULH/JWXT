package zzdx;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class zhgl {

	public static void main() {
		// TODO Auto-generated method stub
		JFrame app = new JFrame( "管理账号" );
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        app.setVisible( true );
        app.setSize( 500,600);
        Container cc = app.getContentPane( );
        cc.setLayout( null );
        Font mf = new Font("楷体",Font.CENTER_BASELINE,20);
        
        JButton b1=new JButton("管理学生账号");
        b1.setFont(mf);
        b1.setBounds(100, 100, 300, 50);
        b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				app.dispose();
				xs.main();
			}
		});
        cc.add(b1);
        
        JButton b2=new JButton("管理教师账号");
        b2.setFont(mf);
        b2.setBounds(100, 300, 300, 50);
        b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				app.dispose();
				js.main();
			}
		});
        cc.add(b2);
	}

}
