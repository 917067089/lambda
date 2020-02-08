package com.imooc.proxy.one;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class UFrame extends JFrame implements MouseListener {
    ManageItems manageItems = new ManageItems();
    JTable table;
    JTextArea t = new JTextArea();
    JTextArea t2 = new JTextArea();
    public void init()throws  Exception{
        setLayout(null);
        manageItems.firstSearch();//进行第一级查询
        String title[] ={"账号","姓名","项目名称"};
        String data [][] = null;
        Vector<Proxyitem> v = manageItems.v;
        data = new String[v.size()][title.length];
        for (int i=0;i<v.size();i++){
            Proxyitem proxy = v.get(i);
            data[i][0] = proxy.getAccount();
            data[i][1] = proxy.getName();
            data[i][2] = proxy.getProject();
        }
        table = new JTable(data,title);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(10,10,200,340);

        JLabel label = new JLabel("项目主要内容");
        JLabel labe2 = new JLabel("计划安排");
        label.setBounds(230,5,100,20);t.setBounds(230,40,200,100);
        labe2.setBounds(230,160,100,20);t2.setBounds(230,195,200,100);
        add(pane);
        add(label);add(t);
        add(labe2);add(t2);
        table.addMouseListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,350);
        setVisible(true);

    }
    @Override
    public void mouseClicked(MouseEvent e) {//进行2级查询
        int n = table.getSelectedRow();
        if(n>=0){
            Proxyitem proxyitem = manageItems.v.get(n);
            try {
                proxyitem.itemFill();
                t.setText(proxyitem.getContent());
                t2.setText(proxyitem.getPlan());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) throws  Exception {
        new UFrame().init();
    }
}
