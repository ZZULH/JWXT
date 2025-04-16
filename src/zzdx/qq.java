package zzdx;

import java.awt.*;   
import javax.swing.*;   
import java.util.*;   
import java.awt.event.*;
import java.sql.SQLException;   
   
/**  
 * <P>Title:OpenSwing </P>  
 * <P>Description: JGroupPanel 组群面板   
 *  类似QQ界面的组群管理面板  
 * </P>  
 * 履历:   
 *     2004/07/24   由SunKing作成   
 * <P>Copyright: Copyright (c) 2004</P>  
 * <P>Company: </P>  
 * @author <A href="mailto:sunkingxie@hotmail.com" mce_href="mailto:sunkingxie@hotmail.com" ?>Sunking</A>  
 * @version 1.0  
 */   
@SuppressWarnings("serial")
public class qq extends JPanel 
{   
    /*用来管理组的三个容器*/   
    private JPanel pNorth = new JPanel() {};   
    private JPanel pCenter = new JPanel();   
    private JPanel pSouth = new JPanel();   
   
    /*当前全部组的集合*/   
    @SuppressWarnings("rawtypes")
	private ArrayList groupList = new ArrayList();   
   
    /*是否已禁止添加组件*/   
    private boolean forbidFlag = false;   
   
    /*当前激活的组*/   
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
    		insertGroup(0, "查询");  
            JButton b1 = new JButton("查看课程");   
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
            
            
            JButton b2 = new JButton("查看成绩");   
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
            
            JButton b3 = new JButton("查看通知");   
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
            JButton b4 = new JButton("查询任课教师电话");   
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
            
            insertGroup(1, "更新");  
            JButton b5 = new JButton("选课");   
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

            JButton b6 = new JButton("更换密码");   
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
            
            
            insertGroup(2, "退出");  
            JButton b7 = new JButton("退出系统");   
            addMember(2,b7);   
            b7.setPreferredSize(new Dimension(1, 40));   
            b7.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "退出系统成功");
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
    		insertGroup(0, "查询");  
            JButton b1 = new JButton("查看讲授课程");   
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
            
            
            insertGroup(1, "更新"); 
            JButton b2 = new JButton("发布通知");   
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
            
            JButton b3 = new JButton("上传学生成绩");   
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
            
            
            insertGroup(2, "退出");  
            JButton b4 = new JButton("退出系统");   
            addMember(2,b4);   
            b4.setPreferredSize(new Dimension(1, 40));   
            b4.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "退出系统成功");
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
    		insertGroup(0, "查询");  
            JButton b1 = new JButton("查看成绩更新记录");   
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
            
            insertGroup(1, "更新");  
            JButton b2 = new JButton("开设课程");   
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
            
//            JButton b3 = new JButton("更新教师工作年限");   
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
            JButton b4 = new JButton("账号管理");   
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
            
            insertGroup(2, "退出");
            JButton b5 = new JButton("退出系统");   
            addMember(2,b5);   
            b5.setPreferredSize(new Dimension(1, 40));   
            b5.setOpaque(false);     
            getGroup(0).setMemberGap(20, 5);   
            b5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "退出系统成功");
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
     * @param groupNames String[] 预设组名  
     */   
    public qq(String groupNames[]) {   
        initComponents();   
        addGroup(groupNames);   
    }   
    /**  
     * 展开组  
     * @param name String 组名  
     */   
    public void expandGroup(String name) {   
        for (int i = getGroupCount() - 1; i >= 0; i--) {   
            if (getGroupName(i).equals(name)) {   
                expandGroup(i);   
            }   
        }   
    }   
    /**  
     * 展开组  
     * @param index int 组的顺序号  
     */   
    public void expandGroup(int index) {   
        expandGroup(getGroup(index));   
    }   
    /**  
     * 展开组  
     * @param group JGroupContainer 组  
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
     * 收缩组  
     * @param name String 组名  
     */   
    public void collapseGroup(String name) {   
        for (int i = getGroupCount() - 1; i >= 0; i--) {   
            if (getGroupName(i).equals(name)) {   
                collapseGroup(i);   
            }   
        }   
    }   
   
    /**  
     * 收缩组  
     * @param index int 组的顺序号  
     */   
    public void collapseGroup(int index) {   
        collapseGroup(getGroup(index));   
    }   
   
    /**  
     * 收缩组  
     * @param group JGroupContainer 组  
     */   
    protected void collapseGroup(JGroupContainer group) {   
        if (group == activeGroup) {   
            activeGroup.collapse();   
            activeGroup = null;   
        }   
    }   
   
    /**  
     * 添加组  
     * @param name String 组名  
     */   
    public void addGroup(String name) {   
        this.insertGroup(getGroupCount(), name);   
    }   
   
    /**  
     * 添加多个组  
     * @param names String[] 组名  
     */   
    public void addGroup(String names[]) {   
        for (int i = 0; i < names.length; i++) {   
            addGroup(names[i]);   
        }   
    }   
   
    /**  
     * 插入一个组  
     * @param index int 顺序号  
     * @param name String 组名  
     * @param bg Color 背景色  
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
     * 插入一个组  
     * @param index int 顺序号  
     * @param name String 组名  
     */   
    public void insertGroup(int index, String name) {   
        insertGroup(index, name, UIManager.getColor("Desktop.background"));   
    }   
   
    /**  
     * 插入一个组  
     * @param p JPanel 目标面板  
     * @param index int 顺序号  
     * @param name String 组名  
  
  
         /**  
      * 插入一个组  
      * @param p JPanel 目标面板  
      * @param index int 顺序号  
      * @param name String 组名  
      * @return JGroupContainer  
      */   
     private JGroupContainer insertGroup(JPanel p, int index, String name,   
                                         Color bg) {   
         JGroupContainer group = new JGroupContainer(name, bg);   
         p.add(group);   
         return group;   
     }   
   
    /**  
     * 删除一个组  
     * @param index int 顺序号  
     */   
    public void removeGroup(int index) {   
        JGroupContainer c = (JGroupContainer) groupList.get(index);   
        c.getParent().remove(c);   
        c.getTitleButton().removeActionListener(al);   
    }   
   
    /**  
     * 删除一个组  
     * @param name String 组名  
     */   
    public void removeGroup(String name) {   
        for (int i = getGroupCount() - 1; i >= 0; i--) {   
            if (getGroupName(i).equals(name)) {   
                this.removeGroup(i);   
            }   
        }   
    }   
   
    /**  
     * 设置组名  
     * @param index int 顺序号  
     * @param name String 组名  
     */   
    public void setGroupName(int index, String name) {   
        this.getGroup(index).setName(name);   
    }   
   
    /**  
     * 取得组名  
     * @param groupIndex int 顺序号  
     * @return String 组名  
     */   
    public String getGroupName(int groupIndex) {   
        return getGroup(groupIndex).getName();   
    }   
   
    /**  
     * 取得全部组名  
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
     * 取得当前组的总数  
     * @return int  
     */   
    public int getGroupCount() {   
        return groupList.size();   
    }   
   
    /**  
     * 往组中添加成员组件  
     * @param groupIndex int 组的顺序号  
     * @param member Component 成员组件  
     */   
    public void addMember(int groupIndex, Component member) {   
        getGroup(groupIndex).addMember(getGroup(groupIndex).getMemberCount(),   
                                       member);   
    }   
   
    /**  
     * 往组中插入成员组件  
     * @param groupIndex int 组的顺序号  
     * @param memberIndex int 插入的顺序号  
     * @param member Component 成员组件  
     */   
    public void insertMember(int groupIndex, int memberIndex, Component member) {   
        getGroup(groupIndex).addMember(memberIndex, member);   
    }   
   
    /**  
     * 从组中移除成员组件  
     * @param groupIndex int  
     * @param memberIndex int  
     */   
    public void removeMember(int groupIndex, int memberIndex) {   
        getGroup(groupIndex).removeMember(memberIndex);   
    }   
   
    /**  
     * 取得成员组件  
     * @param groupIndex int 组的顺序号  
     * @param memberIndex int 成员组件的顺序号  
     * @return Component 成员组件  
     */   
    public Component getMember(int groupIndex, int memberIndex) {   
        return getGroup(groupIndex).getMember(memberIndex);   
    }   
   
    /**  
     * 取得全部成员组件  
     * @param groupIndex int 组的顺序号  
     * @return Component[] 全部成员组件  
     */   
    public Component[] getMembers(int groupIndex) {  return getGroup(groupIndex).getMembers();   }   
   
    /**  
     * 取得成员组件的总数  
     * @param groupIndex int 组的顺序号  
     * @return int 总数  
     */   
    public int getMemberCount(int groupIndex) { return getGroup(groupIndex).getMemberCount(); }   
   
    /**  
     * 取得组  
     * @param index int 组的顺序号  
     * @return JGroupContainer 组  
     */   
    protected JGroupContainer getGroup(int index) {   
        return (JGroupContainer) groupList.get(index);   
    }   
   
    /**  
     * 覆写的addImpl方法,禁止再向JGroupPane中添加组件  
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
     * <P>Description: 组面板布局管理器</P>  
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
     * <P>Description: 组</P>  
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
         * @param name String  组名  
         * @param background Color 成员组件所在面板背景色  
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
         * 设置间距  
         * @param hgap int 横间距  
         * @param vgap int 竖间距  
         */   
        public void setMemberGap(int hgap, int vgap) {    pMembers.setLayout(new GroupLayout(hgap, vgap));    }   
   
        /**  
         * 取得组的标题按钮  
         * @return JButton  
         */   
        public JButton getTitleButton() {    return bttGroupTitle;   }   
   
        /**  
         * 取得组的成员组件面板  
         * @return JPanel  
         */   
        public JPanel getMembersContainer() {    return pMembers;    }   
   
        /**  
         * 收缩组  
         */   
        public void collapse() {    sp.setVisible(false);    this.revalidate();     }   
   
        /**  
         * 展开组  
         */   
        public void expand() {    sp.setVisible(true);       this.revalidate();      }   
   
        /**  
         * 设置组名  
         * @param name String 组名  
         */   
        public void setName(String name) {    bttGroupTitle.setText(name);     }   
   
        /**  
         * 取得组名  
         * @return String  
         */   
        public String getName() {     return bttGroupTitle.getText();      }   
   
        /**  
         * 添加一个成员组件  
         * @param index int 顺序号  
         * @param c Component 成员组件  
         */   
        public void addMember(int index, Component c) {    pMembers.add(c, index);     pMembers.doLayout();    }   
   
        /**  
         * 删除一个成员组件  
         * @param index int 顺序号  
         */   
        public void removeMember(int index) {      pMembers.remove(index);       pMembers.doLayout();   }   
   
        /**  
         * 取得一个成员组件  
         * @param index int 顺序号  
         * @return Component 成员组件  
         */   
        public Component getMember(int index) {     return pMembers.getComponent(index);     }   
   
        /**  
         * 取得全部成员组件  
         * @return Component[] 成员组件  
         */   
        public Component[] getMembers() {   
            Component coms[] = new Component[getMemberCount()];   
            for (int i = 0; i < coms.length; i++) {     coms[i] = pMembers.getComponent(i);    }   
            return coms;   
        }   
   
        /**  
         * 取得成员组件总数  
         * @return int 总数  
         */   
        public int getMemberCount() {    return pMembers.getComponentCount();    }   
   
        /**  
         * 重写的toString方法  
         * @return String  
         */   
        public String toString() {     return getName();    }   
    }   
   
    /**  
         /**  
      * 测试程序  
      * @param args String[]  
      */   
     public static qq main(int i,String ss,JFrame f)
     {    
         qq p = new qq(i,ss,f);   
         return p;   
     }   
   
}