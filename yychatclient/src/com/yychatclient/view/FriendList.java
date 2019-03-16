package com.yychatclient.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
public class FriendList extends JFrame implements ActionListener,MouseListener{
 CardLayout cardLayout;
 
 JPanel myFriendPanel;
 JButton myFriendJButton;
 
 JScrollPane myFriendJScrollPane;
 JPanel myFriendListJPanel;
 static final int FRIENDCOUNT=51;
 JLabel[] myFriendJLabel=new JLabel[FRIENDCOUNT];
 
 
 JPanel myStrangerBlackListJPanel;
 JButton myStrangerJButton;
 JButton blackListJButton;
 
 JPanel myStrangerPanel;
 
 JScrollPane myFriendJScrollPane1;
 JPanel myFriendListJPanel1;
 static final int FRIENDCOUNT1=51;
 JLabel[] myFriendJLabel1=new JLabel[FRIENDCOUNT1];
 
 JPanel myFriendStrangerJPanel;
 JButton myFriendJButton1;
 JButton myStrangerJButton1;
 
 JButton blackListJButton1;
 
 String userName;
 public FriendList(String userName){
	 this.userName=userName;
  myFriendPanel=new JPanel(new BorderLayout());
  
  myFriendJButton=new JButton("我的好友");
  myFriendPanel.add(myFriendJButton,"North");
  
  
  myFriendListJPanel=new JPanel(new GridLayout(50,1));
  for(int i=1;i<FRIENDCOUNT;i++){
   myFriendJLabel[i]=new JLabel(i+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
   myFriendJLabel[i].addMouseListener(this);
   myFriendListJPanel.add(myFriendJLabel[i]);
  }
  myFriendJScrollPane=new JScrollPane(myFriendListJPanel);
  myFriendPanel.add(myFriendJScrollPane);
  
  myStrangerBlackListJPanel=new JPanel(new GridLayout(2,1));
  myStrangerJButton=new JButton("我的陌生人");
  myStrangerJButton.addActionListener(this);
  
  blackListJButton=new JButton("黑名单");
  myStrangerBlackListJPanel.add(myStrangerJButton);
  myStrangerBlackListJPanel.add(blackListJButton);
  myFriendPanel.add(myStrangerBlackListJPanel,"South");
  
  //第二张卡片
  myStrangerPanel=new JPanel(new BorderLayout());
  
  ///尝试
  myFriendListJPanel1=new JPanel(new GridLayout(50,1));
  for(int i=1;i<FRIENDCOUNT1;i++){
   myFriendJLabel1[i]=new JLabel(i+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
   myFriendJLabel1[i].addMouseListener(this);
   myFriendListJPanel1.add(myFriendJLabel1[i]);
  }
  myFriendJScrollPane1=new JScrollPane(myFriendListJPanel1);
  myStrangerPanel.add(myFriendJScrollPane1);
  ///
  myFriendStrangerJPanel=new JPanel(new GridLayout(2,1));
  myFriendJButton1=new JButton("我的好友");
  myFriendJButton1.addActionListener(this);
  myStrangerJButton1=new JButton("我的陌生人");
  
  myFriendStrangerJPanel.add(myFriendJButton1);
  myFriendStrangerJPanel.add(myStrangerJButton1);
  myStrangerPanel.add(myFriendStrangerJPanel,"North");
  
  
  blackListJButton1=new JButton("黑名单");
  myStrangerPanel.add(blackListJButton1,"South");
  cardLayout=new CardLayout();
  this.setLayout(cardLayout);
  this.add(myStrangerPanel,"2");
  this.add(myFriendPanel,"1");
  this.setSize(150,500);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setVisible(true);
 }
 public static void main(String[] args) {
  FriendList friendList=new FriendList("1");
  
 }
 @Override
 public void actionPerformed(ActionEvent arg0) {
  if(arg0.getSource()==myStrangerJButton){
   cardLayout.show(this.getContentPane(),"2");
  }
        if(arg0.getSource()==myFriendJButton1){
         cardLayout.show(this.getContentPane(),"1");
  }
 }
 @Override
 public void mouseClicked(MouseEvent arg0) {
  if(arg0.getClickCount()==2){
	  JLabel jibl=(JLabel)arg0.getSource();
	  String receiver=jibl.getText();
	  new FriendChat(this.userName,receiver);
  }
  
 }
 @Override
 public void mouseEntered(MouseEvent e) {
  JLabel jLabel=(JLabel)e.getSource();
  jLabel.setForeground(Color.red);
 }
 @Override
 public void mouseExited(MouseEvent e) {
  JLabel jLabel=(JLabel)e.getSource();
  jLabel.setForeground(Color.black);
 }
 @Override
 public void mousePressed(MouseEvent arg0) {
  // TODO Auto-generated method stub
  
 }
 @Override
 public void mouseReleased(MouseEvent arg0) {
  // TODO Auto-generated method stub
  
 }
}