package com.epic.trials;

import javax.swing.*;
import java.awt.EventQueue;

public class Main extends JFrame{
    public Main(){
        if(initUI() == false){
            System.out.println("Initializing UI failed");	
        }
    }

    private boolean initUI(){
        try{
            add(new Board());
            setSize(800,600);

            setTitle("The Epic Trials of Hercules");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {	
        EventQueue.invokeLater(	
                new Runnable(){
                    @Override
                    public void run(){
                        Main main = new Main();
                        main.setVisible(true);
                    }
                }
                );
    }
}
