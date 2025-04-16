package zzdx;

import java.awt.*;   
import javax.swing.*;   
import java.util.*;   
import java.awt.event.*;
import java.sql.SQLException;   
   
/**  
 * <P>Title:OpenSwing </P>  
 * <P>Description: JGroupPanel ��Ⱥ���   
 *  ����QQ�������Ⱥ�������  
 * </P>  
 * ����:   
 *     2004/07/24   ��SunKing����   
 * <P>Copyright: Copyright (c) 2004</P>  
 * <P>Company: </P>  
 * @author <A href="mailto:sunkingxie@hotmail.com" mce_href="mailto:sunkingxie@hotmail.com" ?>Sunking</A>  
 * @version 1.0  
 */   
@SuppressWarnings("serial")
public class qq extends JPanel 
{   
    /*�������������������*/   
    private JPanel pNorth = new JPanel() {};   
    private JPanel pCenter = new JPanel();   
    private JPanel pSouth = new JPanel();   
   
    /*��ǰȫ����ļ���*/   
    @SuppressWarnings("rawtypes")
	private ArrayList groupList = new ArrayList();   
   
    /*�Ƿ��ѽ�ֹ������*/   
    private boolean forbidFlag = false;   
   
    /*��ǰ�������*/   
    private JGroupContainer activeGroup = null;   
    transient ActionListener al = new ActionListener() 
    {   
        public void actionPerformed(ActionEvent e) 
        {   
            JButton bttTitle = (JButton) e.getSource();   
            expandGroup( (JGroupContainer) bttTitle.getParent());   
        }   
    };   
   
    private boolean hasCreateDefaultGroup = false;   
    public qq(int i,String ss,JFrame f) 
    {   
        initComponents();   
        createDefaultGroup(i,ss,f);   
    }   
    private void initComponents()
    {   
        this.setLayout(new BorderLayout());   
        this.add(pNorth, BorderLayout.NORTH);   
        this.add(pCenter, BorderLayout.CENTER);   
        this.add(pSouth, BorderLayout.SOUTH);   
        pNorth.setLayout(new GroupLayout());   
        pCenter.setLayout(new BorderLayout());   
        pSouth.setLayout(new GroupLayout());   
        forbidFlag = true;   
    }   
    private void createDefaultGroup(int x,String ss,JFrame f)
    {   
        //Default Group   
    	if(x==1)
    	{
    		insertGroup(0, "��ѯ");  
            JButton b1 = new JButton("�鿴�γ�");   
            addMember(0,b1);   
            b1.setPreferredSize(new Dimension(1, 40));   
            b1.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
//					aaa.dispose();
					try {
						ckkb.main(ss);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
            
            
            JButton b2 = new JButton("�鿴�ɼ�");   
            addMember(0,b2);   
            b2.setPreferredSize(new Dimension(1, 40));   
            b2.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ckcj.main(ss);
				}
			});
            
            JButton b3 = new JButton("�鿴֪ͨ");   
            addMember(0,b3);   
            b3.setPreferredSize(new Dimension(1, 40));   
            b3.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					cktz.main(ss);
				}
			});
            JButton b4 = new JButton("��ѯ�ον�ʦ�绰");   
            addMember(0,b4);   
            b4.setPreferredSize(new Dimension(1, 40));   
            b4.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						jsdh.main(ss);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
            
            insertGroup(1, "����");  
            JButton b5 = new JButton("ѡ��");   
            addMember(1,b5);   
            b5.setPreferredSize(new Dimension(1, 40));   
            b5.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						xk.main(ss);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

            JButton b6 = new JButton("��������");   
            addMember(1,b6);   
            b6.setPreferredSize(new Dimension(1, 40));   
            b6.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					xgmm.main(ss,f);
				}
			});
            
            
            insertGroup(2, "�˳�");  
            JButton b7 = new JButton("�˳�ϵͳ");   
            addMember(2,b7);   
            b7.setPreferredSize(new Dimension(1, 40));   
            b7.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "�˳�ϵͳ�ɹ�");
					f.dispose();
					System.exit(0);
				}
			});
	//            getGroup(i - 1).getTitleButton().setForeground(bg[i - 1]);  
	        expandGroup(0);   
	        hasCreateDefaultGroup = true; 
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	else if(x==2)
    	{
    		insertGroup(0, "��ѯ");  
            JButton b1 = new JButton("�鿴���ڿγ�");   
            addMember(0,b1);   
            b1.setPreferredSize(new Dimension(1, 40));   
            b1.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
//					aaa.dispose();
					try {
						ckkc.main(ss);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
            
            
            insertGroup(1, "����"); 
            JButton b2 = new JButton("����֪ͨ");   
            addMember(1,b2);   
            b2.setPreferredSize(new Dimension(1, 40));   
            b2.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					fbtz.main(ss);
				}
			});
            
            JButton b3 = new JButton("�ϴ�ѧ���ɼ�");   
            addMember(1,b3);   
            b3.setPreferredSize(new Dimension(1, 40));   
            b3.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						sccj.main(ss);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
            
            
            insertGroup(2, "�˳�");  
            JButton b4 = new JButton("�˳�ϵͳ");   
            addMember(2,b4);   
            b4.setPreferredSize(new Dimension(1, 40));   
            b4.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "�˳�ϵͳ�ɹ�");
					f.dispose();
					System.exit(0);
				}
			});
	//            getGroup(i - 1).getTitleButton().setForeground(bg[i - 1]);  
	        expandGroup(0);   
	        hasCreateDefaultGroup = true;
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	else if(x==3)
    	{
    		insertGroup(0, "��ѯ");  
            JButton b1 = new JButton("�鿴�ɼ����¼�¼");   
            addMember(0,b1);   
            b1.setPreferredSize(new Dimension(1, 40));   
            b1.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ckjl.main();
				}
			});
            
            insertGroup(1, "����");  
            JButton b2 = new JButton("����γ�");   
            addMember(1,b2);   
            b2.setPreferredSize(new Dimension(1, 40));   
            b2.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					kskc.main();
				}
			});
            
//            JButton b3 = new JButton("���½�ʦ��������");   
//            addMember(1,b3);   
//            b3.setPreferredSize(new Dimension(1, 40));   
//            b3.setOpaque(false);     
//            getGroup(0).setMemberGap(20, 5);   
//            b3.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					try {
//						gznx.main();
//					} catch (ClassNotFoundException | SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			});
            JButton b4 = new JButton("�˺Ź���");   
            addMember(1,b4);   
            b4.setPreferredSize(new Dimension(1, 40));   
            b4.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					zhgl.main();
				}
			});
            
            insertGroup(2, "�˳�");
            JButton b5 = new JButton("�˳�ϵͳ");   
            addMember(2,b5);   
            b5.setPreferredSize(new Dimension(1, 40));   
            b5.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "�˳�ϵͳ�ɹ�");
					f.dispose();
					System.exit(0);
				}
			});

	//            getGroup(i - 1).getTitleButton().setForeground(bg[i - 1]);  
	        expandGroup(0);   
	        hasCreateDefaultGroup = true; 
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }   
    /**  
     * @param groupNames String[] Ԥ������  
     */   
    public qq(String groupNames[]) {   
        initComponents();   
        addGroup(groupNames);   
    }   
    /**  
     * չ����  
     * @param name String ����  
     */   
    public void expandGroup(String name) {   
        for (int i = getGroupCount() - 1; i >= 0; i--) {   
            if (getGroupName(i).equals(name)) {   
                expandGroup(i);   
            }   
        }   
    }   
    /**  
     * չ����  
     * @param index int ���˳���  
     */   
    public void expandGroup(int index) {   
        expandGroup(getGroup(index));   
    }   
    /**  
     * չ����  
     * @param group JGroupContainer ��  
     */   
    protected void expandGroup(JGroupContainer group) {   
        pNorth.removeAll();   
        pCenter.removeAll();   
        pSouth.removeAll();   
        boolean hasAddCenter = false;   
        for (int i = 0; i < groupList.size(); i++) {   
            Component c = (Component) groupList.get(i);   
            if (hasAddCenter) {   
                pSouth.add(c);   
            }   
            else if (c == group) {   
                pCenter.add(c, BorderLayout.CENTER);   
                hasAddCenter = true;   
            }   
            else {   
                pNorth.add(c);   
            }   
        }   
        if (activeGroup != null) {   
            activeGroup.collapse();   
        }   
        activeGroup = group;   
        activeGroup.expand();   
        pNorth.doLayout();   
        pCenter.doLayout();   
        pSouth.doLayout();   
        doLayout();   
    }   
   
    /**  
     * ������  
     * @param name String ����  
     */   
    public void collapseGroup(String name) {   
        for (int i = getGroupCount() - 1; i >= 0; i--) {   
            if (getGroupName(i).equals(name)) {   
                collapseGroup(i);   
            }   
        }   
    }   
   
    /**  
     * ������  
     * @param index int ���˳���  
     */   
    public void collapseGroup(int index) {   
        collapseGroup(getGroup(index));   
    }   
   
    /**  
     * ������  
     * @param group JGroupContainer ��  
     */   
    protected void collapseGroup(JGroupContainer group) {   
        if (group == activeGroup) {   
            activeGroup.collapse();   
            activeGroup = null;   
        }   
    }   
   
    /**  
     * �����  
     * @param name String ����  
     */   
    public void addGroup(String name) {   
        this.insertGroup(getGroupCount(), name);   
    }   
   
    /**  
     * ��Ӷ����  
     * @param names String[] ����  
     */   
    public void addGroup(String names[]) {   
        for (int i = 0; i < names.length; i++) {   
            addGroup(names[i]);   
        }   
    }   
   
    /**  
     * ����һ����  
     * @param index int ˳���  
     * @param name String ����  
     * @param bg Color ����ɫ  
     */   
    @SuppressWarnings("unchecked")
	public void insertGroup(int index, String name, Color bg) {   
        if (index < 0 || index > groupList.size()) {   
            throw new ArrayIndexOutOfBoundsException("index:" + index +   
                " >count:" + groupList.size());   
        }   
        if(hasCreateDefaultGroup){   
            while(getGroupCount()>0){   
                removeGroup(0);   
            }   
            hasCreateDefaultGroup = false;   
        }   
        int countNorth = pNorth.getComponentCount();   
        int countCenter = pCenter.getComponentCount();   
        int countSouth = pSouth.getComponentCount();   
        JGroupContainer group;   
        if (index <= countNorth) {   
            group = insertGroup(pNorth, index, name, bg);   
        }   
        else if (index <= countNorth + countCenter) {   
            group = insertGroup(pCenter, index - countNorth, name, bg);   
        }   
        else if (index <= countNorth + countCenter + countSouth) {   
            group = insertGroup(pSouth, index - countNorth - countCenter, name,   
                                bg);   
        }   
        else {   
            group = insertGroup(pSouth, countSouth, name, bg);   
        }   
        group.getTitleButton().addActionListener(al);   
        groupList.add(index, group);   
   
    }   
   
    /**  
     * ����һ����  
     * @param index int ˳���  
     * @param name String ����  
     */   
    public void insertGroup(int index, String name) {   
        insertGroup(index, name, UIManager.getColor("Desktop.background"));   
    }   
   
    /**  
     * ����һ����  
     * @param p JPanel Ŀ�����  
     * @param index int ˳���  
     * @param name String ����  
  
  
         /**  
      * ����һ����  
      * @param p JPanel Ŀ�����  
      * @param index int ˳���  
      * @param name String ����  
      * @return JGroupContainer  
      */   
     private JGroupContainer insertGroup(JPanel p, int index, String name,   
                                         Color bg) {   
         JGroupContainer group = new JGroupContainer(name, bg);   
         p.add(group);   
         return group;   
     }   
   
    /**  
     * ɾ��һ����  
     * @param index int ˳���  
     */   
    public void removeGroup(int index) {   
        JGroupContainer c = (JGroupContainer) groupList.get(index);   
        c.getParent().remove(c);   
        c.getTitleButton().removeActionListener(al);   
    }   
   
    /**  
     * ɾ��һ����  
     * @param name String ����  
     */   
    public void removeGroup(String name) {   
        for (int i = getGroupCount() - 1; i >= 0; i--) {   
            if (getGroupName(i).equals(name)) {   
                this.removeGroup(i);   
            }   
        }   
    }   
   
    /**  
     * ��������  
     * @param index int ˳���  
     * @param name String ����  
     */   
    public void setGroupName(int index, String name) {   
        this.getGroup(index).setName(name);   
    }   
   
    /**  
     * ȡ������  
     * @param groupIndex int ˳���  
     * @return String ����  
     */   
    public String getGroupName(int groupIndex) {   
        return getGroup(groupIndex).getName();   
    }   
   
    /**  
     * ȡ��ȫ������  
     * @return String[]  
     */   
    public String[] getGroupNames() {   
        String sResult[] = new String[getGroupCount()];   
        for (int i = 0; i < getGroupCount(); i++) {   
            sResult[i] = getGroupName(i);   
        }   
        return sResult;   
    }   
   
    /**  
     * ȡ�õ�ǰ�������  
     * @return int  
     */   
    public int getGroupCount() {   
        return groupList.size();   
    }   
   
    /**  
     * ��������ӳ�Ա���  
     * @param groupIndex int ���˳���  
     * @param member Component ��Ա���  
     */   
    public void addMember(int groupIndex, Component member) {   
        getGroup(groupIndex).addMember(getGroup(groupIndex).getMemberCount(),   
                                       member);   
    }   
   
    /**  
     * �����в����Ա���  
     * @param groupIndex int ���˳���  
     * @param memberIndex int �����˳���  
     * @param member Component ��Ա���  
     */   
    public void insertMember(int groupIndex, int memberIndex, Component member) {   
        getGroup(groupIndex).addMember(memberIndex, member);   
    }   
   
    /**  
     * �������Ƴ���Ա���  
     * @param groupIndex int  
     * @param memberIndex int  
     */   
    public void removeMember(int groupIndex, int memberIndex) {   
        getGroup(groupIndex).removeMember(memberIndex);   
    }   
   
    /**  
     * ȡ�ó�Ա���  
     * @param groupIndex int ���˳���  
     * @param memberIndex int ��Ա�����˳���  
     * @return Component ��Ա���  
     */   
    public Component getMember(int groupIndex, int memberIndex) {   
        return getGroup(groupIndex).getMember(memberIndex);   
    }   
   
    /**  
     * ȡ��ȫ����Ա���  
     * @param groupIndex int ���˳���  
     * @return Component[] ȫ����Ա���  
     */   
    public Component[] getMembers(int groupIndex) {  return getGroup(groupIndex).getMembers();   }   
   
    /**  
     * ȡ�ó�Ա���������  
     * @param groupIndex int ���˳���  
     * @return int ����  
     */   
    public int getMemberCount(int groupIndex) { return getGroup(groupIndex).getMemberCount(); }   
   
    /**  
     * ȡ����  
     * @param index int ���˳���  
     * @return JGroupContainer ��  
     */   
    protected JGroupContainer getGroup(int index) {   
        return (JGroupContainer) groupList.get(index);   
    }   
   
    /**  
     * ��д��addImpl����,��ֹ����JGroupPane��������  
     * @param comp Component  
     * @param constraints Object  
     * @param index int  
     */   
    protected void addImpl(Component comp, Object constraints, int index) {   
        if (forbidFlag) {   
            if (! (comp instanceof JGroupContainer)) {   
                throw new UnsupportedOperationException(   
                    "JGroupPane can't add component!");   
            }   
        }   
        else {    super.addImpl(comp, constraints, index);    }   
    }   
   
    /**  
     * <P>Title: OpenSwing</P>  
     * <P>Description: ����岼�ֹ�����</P>  
     * <P>Copyright: Copyright (c) 2004</P>  
     * <P>Company: </P>  
     * @author <A href="mailto:sunkingxie@hotmail.com" mce_href="mailto:sunkingxie@hotmail.com">SunKing</A>  
     * @version 1.0  
     */   
    class GroupLayout  implements LayoutManager, java.io.Serializable {   
        int vgap = 0;   
        int hgap = 0;   
        public GroupLayout() {}   
   
        public GroupLayout(int hg, int vg) {   
            this.hgap = hg;   
            this.vgap = vg;   
        }   
        public void addLayoutComponent(String name, Component comp) {    }   
        public void removeLayoutComponent(Component comp) {   }   
        public Dimension preferredLayoutSize(Container parent) {   
            synchronized (parent.getTreeLock()) {   
                Insets insets = parent.getInsets();   
                int ncomponents = parent.getComponentCount();   
                int w = 0;   
                int h = 0;   
                for (int i = 0; i < ncomponents; i++) {   
                    Component comp = parent.getComponent(i);   
                    Dimension d = comp.getPreferredSize();   
                    if (w < d.width) {   
                        w = d.width;   
                    }   
                    h += d.height + vgap;   
                }   
                return new Dimension(insets.left + insets.right + w + 2 * hgap, insets.top + insets.bottom + h + 2 * vgap);   
            }   
        }   
   
        public Dimension minimumLayoutSize(Container parent) {    return preferredLayoutSize(parent);    }   
   
        public void layoutContainer(Container parent) {   
            synchronized (parent.getTreeLock()) {   
                Insets insets = parent.getInsets();   
                int ncomponents = parent.getComponentCount();   
                if (ncomponents == 0) {  return;  }   
                int y = insets.top + vgap;   
                for (int c = 0; c < ncomponents; c++) {   
                    int h = parent.getComponent(c).getPreferredSize().height;   
                    parent.getComponent(c).setBounds(   
                        insets.left + hgap,   
                        y,   
                        parent.getWidth() - insets.left - insets.right -   
                        2 * hgap, h);   
                    y += h + vgap;   
                }   
            }   
        }   
   
        public String toString() {   
            return getClass().getName();   
        }   
    }   
   
    /**  
     * <P>Title: OpenSwing</P>  
     * <P>Description: ��</P>  
     * <P>Copyright: Copyright (c) 2004</P>  
     * <P>Company: </P>  
     * @author <A href="mailto:sunkingxie@hotmail.com" mce_href="mailto:sunkingxie@hotmail.com">SunKing</A>  
     * @version 1.0  
     */   
    class JGroupContainer   
        extends JPanel {   
        private JButton bttGroupTitle = new JButton();   
        private JPanel pMembers = new JPanel();   
        private JScrollPane sp;   
        public JGroupContainer() {   
            this("");   
        }   
   
        public JGroupContainer(String name) {   
            this(name, UIManager.getColor("Desktop.background"));   
        }   
   
        /**  
         * @param name String  ����  
         * @param background Color ��Ա���������屳��ɫ  
         */   
        public JGroupContainer(String name, Color background) {   
            bttGroupTitle.setText(name);   
            bttGroupTitle.setFocusable(false);   
            pMembers.setLayout(new GroupLayout(5, 5));   
            this.setLayout(new BorderLayout());   
            this.add(bttGroupTitle, BorderLayout.NORTH);   
   
            pMembers.setBackground(background);   
   
            Color thumbColor = UIManager.getColor("ScrollBar.thumb");   
            Color trackColor = UIManager.getColor("ScrollBar.track");   
            Color trackHighlightColor = UIManager.getColor(   
                "ScrollBar.trackHighlight");   
   
            UIManager.put("ScrollBar.thumb", background);   
            UIManager.put("ScrollBar.track", background);   
            UIManager.put("ScrollBar.trackHighlight", background);   
            sp = new JScrollPane(pMembers);   
            sp.setHorizontalScrollBarPolicy(   
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);   
            this.add(sp, BorderLayout.CENTER);   
            collapse();   
            UIManager.put("ScrollBar.thumb", thumbColor);   
            UIManager.put("ScrollBar.track", trackColor);   
            UIManager.put("ScrollBar.trackHighlight", trackHighlightColor);   
   
        }   
   
        /**  
         * ���ü��  
         * @param hgap int ����  
         * @param vgap int �����  
         */   
        public void setMemberGap(int hgap, int vgap) {    pMembers.setLayout(new GroupLayout(hgap, vgap));    }   
   
        /**  
         * ȡ����ı��ⰴť  
         * @return JButton  
         */   
        public JButton getTitleButton() {    return bttGroupTitle;   }   
   
        /**  
         * ȡ����ĳ�Ա������  
         * @return JPanel  
         */   
        public JPanel getMembersContainer() {    return pMembers;    }   
   
        /**  
         * ������  
         */   
        public void collapse() {    sp.setVisible(false);    this.revalidate();     }   
   
        /**  
         * չ����  
         */   
        public void expand() {    sp.setVisible(true);       this.revalidate();      }   
   
        /**  
         * ��������  
         * @param name String ����  
         */   
        public void setName(String name) {    bttGroupTitle.setText(name);     }   
   
        /**  
         * ȡ������  
         * @return String  
         */   
        public String getName() {     return bttGroupTitle.getText();      }   
   
        /**  
         * ���һ����Ա���  
         * @param index int ˳���  
         * @param c Component ��Ա���  
         */   
        public void addMember(int index, Component c) {    pMembers.add(c, index);     pMembers.doLayout();    }   
   
        /**  
         * ɾ��һ����Ա���  
         * @param index int ˳���  
         */   
        public void removeMember(int index) {      pMembers.remove(index);       pMembers.doLayout();   }   
   
        /**  
         * ȡ��һ����Ա���  
         * @param index int ˳���  
         * @return Component ��Ա���  
         */   
        public Component getMember(int index) {     return pMembers.getComponent(index);     }   
   
        /**  
         * ȡ��ȫ����Ա���  
         * @return Component[] ��Ա���  
         */   
        public Component[] getMembers() {   
            Component coms[] = new Component[getMemberCount()];   
            for (int i = 0; i < coms.length; i++) {     coms[i] = pMembers.getComponent(i);    }   
            return coms;   
        }   
   
        /**  
         * ȡ�ó�Ա�������  
         * @return int ����  
         */   
        public int getMemberCount() {    return pMembers.getComponentCount();    }   
   
        /**  
         * ��д��toString����  
         * @return String  
         */   
        public String toString() {     return getName();    }   
    }   
   
    /**  
         /**  
      * ���Գ���  
      * @param args String[]  
      */   
     public static qq main(int i,String ss,JFrame f)
     {    
         qq p = new qq(i,ss,f);   
         return p;   
     }   
   
}