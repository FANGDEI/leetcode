//package com.feng.draft.template.alpha_beta搜索算法;
//
//
//import java.awt.*;
//import javax.swing.*;
//import javax.swing.event.*;
//import java.awt.event.*;
//import java.lang.*;
//
//public class UI {
//    private JFrame frame;//五子棋游戏窗口
//
//    //五子棋盘
//    private ChessBoard chessboard = new ChessBoard();//五子棋盘
//    //五子棋逻辑
//    private Chess chess = new Chess();
//
//    private JMenuBar menu;//菜单栏
//    private JMenu option;//菜单栏中的OPTION菜单
//    private JMenuItem replayOption;//OPTION下拉项中的RESTART选项，重玩一局
//    private JMenuItem AIFirstOption;//OPTION下拉项中的WHITE选项，机器先手
//    private JMenuItem HumanFirstOption;//OPTION下拉项中的BLACK选项,人类先手
//    //游戏运行入口
//    public static void main(String[] args){
//        new UI().init();
//    }
//    public void init(){
//        frame = new JFrame("GOBANG");
//        frame.setSize(518, 565);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        menu = new JMenuBar();
//        option = new JMenu("OPTION");
//        menu.add(option);
//
//        replayOption = new JMenuItem("RESTART");
//        AIFirstOption = new JMenuItem("WHITE");
//        HumanFirstOption = new JMenuItem("BLACK");
//        option.add(replayOption);
//        option.addSeparator();
//        option.add(AIFirstOption);
//        option.add(HumanFirstOption);
//
//        replayOption.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                chess.init();
//                chessboard.init();
//            }
//        });
//        AIFirstOption.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                //如果此时棋盘无子，则机器执黑先行
//                if(chessboard.isEmpty()) {
//                    chess.FIRST = -1;
//                    //机器先手，则先在中间位置下一个棋子
//                    chessboard.addChessman(7, 7, -1);
//                    chess.putChess(7, 7, -1);
//                }
//                else
//                    JOptionPane.showMessageDialog(frame, "If you want to play as WHITE, please restart the game.","Message", JOptionPane.PLAIN_MESSAGE);
//            }
//        });
//        HumanFirstOption.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                if(chessboard.isEmpty()){
//                    chess.FIRST = 1;
//                }
//                else
//                    JOptionPane.showMessageDialog(frame, "If you want to play as BLACK, please restart the game.", "Message", JOptionPane.PLAIN_MESSAGE);
//            }
//        });
//
//        frame.setJMenuBar(menu);
//        frame.add(chessboard);
//        chess.init();
//        chessboard.init();
//
//        chessboard.addMouseListener(new MouseAdapter() {
//                                        @Override
//                                        public void mouseClicked(MouseEvent e) {
//                                            play(e);
//                                        }
//
//            private void play(MouseEvent e) {
//                int cellSize = chessboard.getCellSize();//每个格子的边长
//                int x = (e.getX() - 5) / cellSize;//像素值转换成棋盘坐标
//                int y = (e.getY() - 5) / cellSize;//像素值转换成棋盘坐标
//                //判断落子是否合法
//                boolean isLegal = chess.isEmpty(x, y);
//                //如果落子合法
//                if(isLegal){
//                    chessboard.addChessman(x, y, 1);//界面方面加一个棋子
//                    chess.putChess(x, y, 1);//逻辑业务方面加一个棋子
//
//                    //判断是否违反长连禁手
//                    if (chess.longLink(x, y)){
//                        JOptionPane.showMessageDialog(frame, "lose.", "Sorry, you lose.", JOptionPane.PLAIN_MESSAGE);
//                        chessboard.init();
//                        chess.init();
//                        return;
//                    }
//
//                    //判断人类是否胜利
//                    if(chess.isWin(x, y, 1)){
//                        JOptionPane.showMessageDialog(frame, "win!", "Congratulations, you win！", JOptionPane.PLAIN_MESSAGE);
//                        chessboard.init();
//                        chess.init();
//                        return;
//                    }
//
//                    //只有五连与禁手同时出现，才算胜利
//                    if(chess.ban(x, y)){
//                        JOptionPane.showMessageDialog(frame, "lose.", "Sorry, you lose.", JOptionPane.PLAIN_MESSAGE);
//                        chessboard.init();
//                        chess.init();
//                        return;
//                    }
//
//                    //机器落子
//                    Location loc = chess.search(x,y);
//                    chessboard.addChessman(loc);
//                    chess.putChess(loc.getX(), loc.getY(), loc.getOwner());
//
//                    //判断是否违反长连禁手
//                    if (chess.longLink(x, y)){
//                        JOptionPane.showMessageDialog(frame, "win!", "Congratulations, you win！", JOptionPane.PLAIN_MESSAGE);
//                        chessboard.init();
//                        chess.init();
//                        return;
//                    }
//
//                    //判断机器是否胜利
//                    if(chess.isWin(loc.getX(), loc.getY(), -1)){
//                        JOptionPane.showMessageDialog(frame, "lose.", "Sorry, you lose.", JOptionPane.PLAIN_MESSAGE);
//                        chessboard.init();
//                        chess.init();
//                        return;
//                    }
//
//                    if(chess.ban(loc.getX(), loc.getY())){
//                        JOptionPane.showMessageDialog(frame, "win!", "Congratulations, you win！", JOptionPane.PLAIN_MESSAGE);
//                        chessboard.init();
//                        chess.init();
//                        return;
//                    }
//
//                }
//            }
//        });
//        frame.setVisible(true);
//    }
//}
//
