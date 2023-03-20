package GUI;

import comp_decomp.Compressor;
import comp_decomp.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton CompressButton;
    JButton DecompressButton;
    AppFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CompressButton=new JButton("Select File to compress");
        CompressButton.setBounds(200,100,200, 30);
        CompressButton.addActionListener(this);

        DecompressButton=new JButton("Select File to decompress");
        DecompressButton.setBounds(250,100,200, 30);
        DecompressButton.addActionListener(this);

        this.add(CompressButton);
        this.add(DecompressButton);
        this.setSize(1000,500);
        this.getContentPane().setBackground(Color.red);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==CompressButton)
        {
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.toString());
                }
            }
        }
        if(e.getSource()==DecompressButton)
        {
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.toString());
                }
            }
        }
    }
}
