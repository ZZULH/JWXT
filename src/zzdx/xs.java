package zzdx;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class xs {

	public static void main() {
		JFrame app = new JFrame( "管理学生账号" );
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        app.setVisible( true );
        app.setSize( 500,600);
        Container cc = app.getContentPane( );
        cc.setLayout( null );
        Font mf = new Font("楷体",Font.CENTER_BASELINE,20);
        
        JButton b1=new JButton("创建");
        b1.setFont(mf);
        b1.setBounds(100, 100, 300, 50);
        b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				app.dispose();
				try {
					cj.main(1);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        cc.add(b1);
        
        JButton b2=new JButton("删除");
        b2.setFont(mf);
        b2.setBounds(100, 300, 300, 50);
        b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				app.dispose();
				sc.main(1);
			}
		});
        cc.add(b2);
	}

}
