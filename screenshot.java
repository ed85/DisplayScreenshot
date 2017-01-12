/*
 * Screenshot
 * @en85
 * Rdgr: Edin
 * 
 * License: use if you need it.
 * Credits if you like! */


import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File; 
import javax.imageio.ImageIO;
import javax.swing.*;  

public class screenshot extends JFrame implements ActionListener {
	
	JButton ins,abr;
	
	public screenshot() {
	    this.setVisible(true);
	    this.setLayout(new BorderLayout());
	    this.setTitle("Make your Display Screenshot");
	    
	    Image image = new ImageIcon(this.getClass().getResource("/img/flysea-com.jpg")).getImage();
	    
	    JLabel bgr = new JLabel(new ImageIcon(image));
	    add(bgr);
	    bgr.setLayout(new FlowLayout());
		
	
	    abr = new JButton("Exit");
	    abr.setBounds(100, 150, 120, 30);
	    abr.setBackground(Color.red);
	    abr.setVisible(true);
	    abr.addActionListener(this);
	    bgr.add(abr);
	    
	    ins = new JButton("Click Here");
	    ins.setBounds(250, 150, 120, 30);
	    ins.setBackground(Color.green);
	    ins.setVisible(true);
	    ins.addActionListener(this);
	    bgr.add(ins);
	    setSize(630, 500);
	}


	private String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	    return dateFormat.format(date);
	}


	
	public void actionPerformed(ActionEvent e)
	{
	    if (e.getSource() == ins) 
	    {
	    	System.out.println("Screenshot and Exit!"); 
	        this.dispose();
	        try {
	            Thread.sleep(1000);
	            Toolkit tk = Toolkit.getDefaultToolkit(); 
	            Dimension d = tk.getScreenSize();
	            Rectangle rec = new Rectangle(0, 0, d.width, d.height);  
	            Robot ro = new Robot();
	            BufferedImage img = ro.createScreenCapture(rec);
	            File f = new File(getDateTime() + "myimage.jpg");//set appropriate path; Currently will be saved into program root.
	            ImageIO.write(img, "jpg", f);
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	    }
	    else if (e.getSource() == abr) { 
	    	System.out.println("Exit"); 
	    	this.dispose();
	    }
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		screenshot obj = new screenshot();
	}
}

