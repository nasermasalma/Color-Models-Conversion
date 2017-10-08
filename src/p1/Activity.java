package p1;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this is my project   Naser Masalma

@SuppressWarnings("serial")
public class Activity extends JFrame {//name of class
	JPanel p2 = new JPanel(new FlowLayout());//panel to fill the 
	JPanel p2cmy = new JPanel(new FlowLayout());//panel to fill the 
	JPanel p2hsv = new JPanel(new GridLayout(1,7,5,2));//panel to fill the 
	JPanel p1 = new JPanel(new GridLayout(3,2,10,5));//panel to fill the 
	JPanel p1cmy = new JPanel(new GridLayout(3,2,10,5));//panel to fill the 
	JPanel p3 = new JPanel(new GridLayout(1,2,10,5));//panel to fill the 
	JPanel p4 = new JPanel(new BorderLayout(20,15));//panel to fill the 
	JPanel totalPanel = new JPanel(new GridLayout(2,1,20,10));//panel to fill the 
	

	private JButton showIt =new JButton("Show It");
	private JButton showIt2 =new JButton("Show It");
	private JButton showIt3 =new JButton("Show It");
	JPanel colorProject =new JPanel();
	
	JSlider sliderRed = new JSlider(JSlider.HORIZONTAL,0,255,0);
	JSlider sliderGreen = new JSlider(JSlider.HORIZONTAL,0,255,0);
	JSlider sliderBlue = new JSlider(JSlider.HORIZONTAL,0,255,0);
	
	static JLabel red = new JLabel("Red = 0",JLabel.CENTER);
	static JLabel green = new JLabel("Green = 0",JLabel.CENTER);
	static JLabel blue = new JLabel("Blue = 0",JLabel.CENTER);
	
	JTextField textHue =new JTextField("0");
	JTextField textSaturation =new JTextField("0.0");
	JTextField textValue =new JTextField("0.0");

	
	static JLabel Hue = new JLabel("Hue(0-360)",JLabel.CENTER);
	static JLabel Saturation = new JLabel("Saturation(0-1)",JLabel.CENTER);
	static JLabel Value = new JLabel("Value(0-1)",JLabel.CENTER);
	
	JSlider sliderCyan = new JSlider(JSlider.HORIZONTAL,0,255,255);
	JSlider sliderMagenta = new JSlider(JSlider.HORIZONTAL,0,255,255);
	JSlider sliderYellow = new JSlider(JSlider.HORIZONTAL,0,255,255);
	
	static JLabel cyan = new JLabel("Cyan = 0",JLabel.CENTER);
	static JLabel magenta = new JLabel("Magenta = 0",JLabel.CENTER);
	static JLabel yellow = new JLabel("Yellow = 0",JLabel.CENTER);
	
	
	
	public Activity(){
		TitledBorder t1 = new TitledBorder("Color Models");
		TitledBorder t2 = new TitledBorder("RGB model");
		TitledBorder t3 = new TitledBorder("CMY model");
		TitledBorder t4 = new TitledBorder("HSV model");
		red.setForeground(Color.RED);
		green.setForeground(Color.green);
		blue.setForeground(Color.blue);
		
		sliderRed.setMajorTickSpacing(50);
		sliderRed.setMinorTickSpacing(1);
		sliderRed.setPaintTicks(true);
		sliderRed.setPaintLabels(true);
		
		sliderGreen.setMajorTickSpacing(50);
		sliderGreen.setMinorTickSpacing(1);
		sliderGreen.setPaintTicks(true);
		sliderGreen.setPaintLabels(true);
		
		sliderBlue.setMajorTickSpacing(50);
		sliderBlue.setMinorTickSpacing(1);
		sliderBlue.setPaintTicks(true);
		sliderBlue.setPaintLabels(true);
		
		cyan.setForeground(Color.CYAN);
		magenta.setForeground(Color.MAGENTA);
		yellow.setForeground(Color.black);
		
		sliderCyan.setMajorTickSpacing(50);
		sliderCyan.setMinorTickSpacing(1);
		sliderCyan.setPaintTicks(true);
		sliderCyan.setPaintLabels(true);
		
		sliderMagenta.setMajorTickSpacing(50);
		sliderMagenta.setMinorTickSpacing(1);
		sliderMagenta.setPaintTicks(true);
		sliderMagenta.setPaintLabels(true);
		
		sliderYellow.setMajorTickSpacing(50);
		sliderYellow.setMinorTickSpacing(1);
		sliderYellow.setPaintTicks(true);
		sliderYellow.setPaintLabels(true);
		
		colorProject.setBackground(Color.black);
		
		
		sliderRed.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
             red.setText("Red = "+sliderRed.getValue());				
			}
		});
		sliderGreen.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
		   green.setText("Green = "+sliderGreen.getValue());				
			}
		});
		sliderBlue.addChangeListener(new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			blue.setText("Blue = "+sliderBlue.getValue());				
		}
	});
		
sliderCyan.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
             cyan.setText("Cyan = "+sliderCyan.getValue());				
			}
		});
		sliderMagenta.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
		   magenta.setText("Magenta = "+sliderMagenta.getValue());				
			}
		});
		sliderYellow.addChangeListener(new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			yellow.setText("Yellow = "+sliderYellow.getValue());				
		}
	});
		showIt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = sliderRed.getValue();
				int g = sliderGreen.getValue();
				int b = sliderBlue.getValue();
				
				colorProject.setBackground(new Color(r, g, b));
				
				RGB toCon =new RGB(r, g, b);
				CMY ret=ConvertRGBtoCMY(toCon);
				sliderCyan.setValue(ret.getC());
				sliderMagenta.setValue(ret.getM());
				sliderYellow.setValue(ret.getY());
				
				HSV n =ConvertRGBtoHSV(toCon);
				textHue.setText(String.valueOf(n.getH()));
				textSaturation.setText(String.valueOf(n.getS()));
				textValue.setText(String.valueOf(n.getV()));
				
			}
		});
		showIt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int c = sliderCyan.getValue();
				int m = sliderMagenta.getValue();
				int y = sliderYellow.getValue();
				
				
				CMY toCon =new CMY(c, m, y);
				RGB ret=ConvertCMYtoRGB(toCon);
				sliderRed.setValue(ret.getR());
				sliderGreen.setValue(ret.getG());
				sliderBlue.setValue(ret.getB());
				colorProject.setBackground(new Color(ret.getR(),ret.getG(), ret.getB()));
				
				HSV n =ConvertRGBtoHSV(ret);
				textHue.setText(String.valueOf(n.getH()));
				textSaturation.setText(String.valueOf(n.getS()));
				textValue.setText(String.valueOf(n.getV()));
				
			}
		});
      showIt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				float h = Float.parseFloat(textHue.getText());
			    float s = Float.parseFloat(textSaturation.getText());
			    float v = Float.parseFloat(textValue.getText());
			    if(s>1 ||v>1||s<0||v<0){
			    JOptionPane.showMessageDialog(null, "the is an error in the enter value with the value of v or s");	
			    }
			    else{
				RGB ret =ConvertHSVtoRGB(h,s,v);
				sliderRed.setValue(ret.getR());
				sliderGreen.setValue(ret.getG());
				sliderBlue.setValue(ret.getB());
				colorProject.setBackground(new Color(ret.getR(),ret.getG(), ret.getB()));
				CMY ret1=ConvertRGBtoCMY(ret);
				sliderCyan.setValue(ret1.getC());
				sliderMagenta.setValue(ret1.getM());
				sliderYellow.setValue(ret1.getY());
			}}
		});
		p1.add(red);
		p1.add(sliderRed);
		p1.add(green);
		p1.add(sliderGreen);
		p1.add(blue);
		p1.add(sliderBlue);
		
		p2.add(p1,BorderLayout.CENTER);
		p2.add(showIt,BorderLayout.EAST);
		p2.setBorder(t2);
		
		p1cmy.add(cyan);
		p1cmy.add(sliderCyan);
		p1cmy.add(magenta);
		p1cmy.add(sliderMagenta);
		p1cmy.add(yellow);
		p1cmy.add(sliderYellow);
		
		p2cmy.add(p1cmy,BorderLayout.CENTER);
		p2cmy.add(showIt2,BorderLayout.EAST);
		p2cmy.setBorder(t3);
		
		p2hsv.add(Hue);
		p2hsv.add(textHue);
		p2hsv.add(Saturation);
		p2hsv.add(textSaturation);
		p2hsv.add(Value);
		p2hsv.add(textValue);
		p2hsv.add(showIt3);
		p2hsv.setBorder(t4);
		
		p3.add(p2);
		p3.add(p2cmy);
	
		
		p4.add(p3,BorderLayout.CENTER);
		p4.add(p2hsv,BorderLayout.SOUTH);
		p4.setBorder(t1);
		totalPanel.add(p4);
		totalPanel.add(colorProject);
		
		add(totalPanel);
		
		
	}
public HSV ConvertRGBtoHSV(RGB n){
	float r=(float) (n.getR()/255.0);
	float g=(float) ((n.getG())/255.0);
	float b=(float) ((n.getB())/255.0);
	
	float max =Max(r,Max(g,b));
	float min =Min(r,Min(g,b));
	float mid =Mid(r,g,b);
	float delta =max-min;
	float V =max;
	float H,S;
	int hue;
	if(max==0){
		S=0;
		H=0;
	}
	else{
	 S =delta/max;
		if(S==0){
			H=0;
		}
		else{
			float alpha=60*((mid-min)/delta);
			if(r==max && b==min)
				H=alpha;
			else if(g==max && b==min)
				H=120-alpha;
			else if(g==max && r==min)
				H=120+alpha;
			else if(b==max && r==min)
				H=240-alpha;
			else if(b==max && g==min)
				H=240+alpha;
			else H=360-alpha;
		}
		
	}
	hue=(int)H;
	return new HSV(hue, S, V);
	
	
}
private float Mid(float a, float b, float c) {
	float x = a-b;
	float y = b-c;
	float z = a-c;
    if(x*y > 0) return b;
    if(x*z > 0) return c;
    return a;
}
private float Min(float a, float b) {
	if(a>b)
		return b;
		else return a;
}
private float Max(float a, float b) {
	if(a>b)
	return a;
	else return b;
}
public RGB ConvertHSVtoRGB(float h, float s, float v){
	    int i;
	    float low,mid1,mid2;
	    float r1=0,g1=0,b1=0;
	    int r,g,b;
	   
	    while(h<0){
	    	h=h+360;
	    }
	    while(h>=360){
	    	h=h-360;
	    }
	    
	    float hh =  ((h/360)*6);
	    //System.out.println(hh);
	    if(s==0){
	    	r=(int) (v*255);
	    	g=(int) (v*255);
	    	b=(int) (v*255);
	    }
	    else{
	    if(hh==6){
	    	hh = 0;
	    }
	    
	    i=(int) Math.floor(hh);
	   // System.out.println(i);
	    low= v*(1-s);
	    mid1=v*(1-s*(hh-i));
	    mid2=v*(1-s*(1-(hh-i)));
	 
	    
	    
	     switch(i){
	     case 0:r1=v;g1=mid2;b1=low;break;
	     case 1:r1=mid1;g1=v;b1=low;break;
	     case 2:r1=low;g1=v;b1=mid2;break;
	     case 3:r1=low;g1=mid1;b1=v;break;
	     case 4:r1=mid2;g1=low;b1=v;break;
	     case 5:r1=v;g1=low;b1=mid1;break;
	     }
	     
	    r=(int) (r1*255);
	    g=(int) (g1*255);
	    b=(int) (b1*255);	
	    }
		return new RGB(r, g, b);
	
}
public CMY ConvertRGBtoCMY(RGB n){
	int c=255-n.getR();
	int m=255-n.getG();
	int y =255-n.getB();
	CMY ret =new CMY(c,m,y);
	
	return ret;
	
}	
public RGB ConvertCMYtoRGB(CMY n){
	int r=255-n.getC();
	int g=255-n.getM();
	int b =255-n.getY();
	RGB ret =new RGB(r,g,b);
	
	return ret;
	
}


	public static void main(String[] args) {//Prepare frame
		
		Activity panel = new Activity();//make object 
		panel.setTitle("PROJECT 1 GRAPHICS");//set title for the project
		panel.setLocationRelativeTo(null);
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close when X is clicked
		panel.setVisible(true);//Make frame visible
		panel.setSize(1000,600);//Set size to 
		panel.setResizable(false);//to keep the same size
		}
	
}