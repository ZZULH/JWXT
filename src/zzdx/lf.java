package zzdx;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
@SuppressWarnings("serial")
public class lf extends JFrame
{
	public static lf app;
	public static JButton b;
    public lf( )
    {
        super( "֣�ݴ�ѧ����ϵͳ" );
        String s = "��ӭ����֣�ݴ�ѧ";
        Font mf = new Font("����",Font.CENTER_BASELINE,30);
        String s1="                                                                              ��������Խ���ϵͳ......                                                                                ";
        ImageIcon ic = new ImageIcon( "D:\\app\\eclipse\\workspace\\lin\\src\\zzdx\\l1.jpg" );
        Container c = getContentPane( );
        c.setLayout( new FlowLayout(FlowLayout.CENTER) );
        JLabel aLabel = new JLabel( s, ic, JLabel.CENTER);
        aLabel.setFont(mf);
        aLabel.setHorizontalTextPosition(JLabel.CENTER);
        aLabel.setVerticalTextPosition(JLabel.BOTTOM);
        c.add( aLabel );
        JLabel a = new JLabel( s1, null, JLabel.CENTER);
        a.setHorizontalTextPosition(JLabel.CENTER);
        a.setVerticalTextPosition(JLabel.BOTTOM);
        c.add(a);
        JButton b=lf.lf1("����");
        c.add(b);
    } // J_LabelFrame���췽������
    public static JButton lf1( String ab)
    {
        JButton b = new JButton(ab);
        b.addActionListener(new ActionListener() 
        {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				app.dispose();
				welcome.main(null);
			}
		});
        return b;
    } // J_Button1���췽������
    public static void main(String args[ ])
    {
        app= new lf( );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500,600);
        app.setVisible( true );
        
    } // ����main����
} // ��J_LabelFrame����






