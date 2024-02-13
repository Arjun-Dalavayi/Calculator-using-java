package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField text;
    JButton [] numButton=new JButton[10];
    JButton [] signButton=new JButton[9];
    JButton delButton,clrButton,decButton,negButton;
    JButton addButton,subButton,mulButton,divButton,equButton;
    double num1=0,num2=0,result=0;
    String sign="0";
     String temp="0";
    Font myFont=new Font("italic",Font.ITALIC,30);
    Calculator(){
        JFrame frame=new JFrame();
        frame.setTitle("Calculator");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);



        numButton[0]=new JButton("0");
        numButton[1]=new JButton("1");
        numButton[2]=new JButton("2");
        numButton[3]=new JButton("3");
        numButton[4]=new JButton("4");
        numButton[5]=new JButton("5");
        numButton[6]=new JButton("6");
        numButton[7]=new JButton("7");
        numButton[8]=new JButton("8");
        numButton[9]=new JButton("9");

        for (int i=0;i<10;i++){
            numButton[i].setFocusable(false);
            numButton[i].setFont(myFont);
            numButton[i].addActionListener(this);
        }


        signButton[0]=addButton=new JButton("+");
        signButton[1]=subButton=new JButton("-");
        signButton[2]=mulButton=new JButton("X");
        signButton[3]=divButton=new JButton("/");
        signButton[4]=decButton=new JButton(".");
        signButton[5]=delButton=new JButton("Delete");
        signButton[6]=clrButton=new JButton("Clear");
        signButton[7]=equButton=new JButton("=");

        delButton.setBounds(100,410,140,40);
        clrButton.setBounds(250,410,150,40);
        frame.add(delButton);
        frame.add(clrButton);


        for (int i=0;i<8;i++){
            signButton[i].setFocusable(false);
            signButton[i].setFont(myFont);
            signButton[i].addActionListener(this);

        }





        JPanel panel=new JPanel();
        panel.setBounds(100,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        //panel.setBackground(Color.BLACK);
        frame.add(panel);
        text=new JTextField();
        text.setBounds(100,30,300,50);
        text.setFont(myFont);
        text.setEditable(false);
        frame.add(text);

        panel.add(numButton[1]);
        panel.add(numButton[2]);
        panel.add(numButton[3]);
        panel.add(addButton);
        panel.add(numButton[4]);
        panel.add(numButton[5]);
        panel.add(numButton[6]);
        panel.add(subButton);
        panel.add(numButton[7]);
        panel.add(numButton[8]);
        panel.add(numButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButton[0]);
        panel.add(equButton);
        panel.add(divButton);




        frame.setVisible(true);
    }

    void signs(String s,String ch){
        String st = String.valueOf(s.charAt(s.length()-1));
        if(st.equals("+")||st.equals("-")||st.equals("X")||st.equals("/")) {
            String g = s.replace(st, ch);
            text.setText(g);
        }else {
            text.setText(text.getText().concat(ch));
        }

    }
   static double fun(String a) {
        double d = 0;
        for (int i = 0; i < a.length(); i++) {

            if (String.valueOf(a.charAt(i)).equals("/")) {
                String sub = a.substring(0, i);
                a = a.substring((i+1));
                d = Double.parseDouble(sub)/fun(a);
                System.out.println(d);
                return d;
            }
            if (String.valueOf(a.charAt(i)).equals("X")) {
                String sub = a.substring(0, i);
                a = a.substring((i+1));
                d = Double.parseDouble(sub)*fun(a);
                System.out.println(d);
                return d;
            }
            if (String.valueOf(a.charAt(i)).equals("-")) {
                String sub = a.substring(0, i);
                a = a.substring((i+1));
                d = Double.parseDouble(sub)-fun(a);
                System.out.println(d);
                return d;
            }
            if (String.valueOf(a.charAt(i)).equals("+")) {
                String sub = a.substring(0, i);
                a = a.substring((i+1));
                d = Double.parseDouble(sub)+fun(a);
                System.out.println(d);
                return d;
            }
        }
        d=Double.parseDouble(a);
        return d;
    }

    public static void main(String[] args) {

        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          for (int i=0;i<10;i++){
              if(e.getSource()==numButton[i]){
                  text.setText(text.getText().concat(String.valueOf(i)));
              }
          }
          if(e.getSource()==decButton){
              text.setText(text.getText().concat("."));
          }
          if(e.getSource()==delButton){
              String str=text.getText();
              text.setText("");
              for (int i=0;i<str.length()-1;i++) {
                  text.setText(text.getText() + str.charAt(i));
              }
          }
          if(e.getSource()==clrButton){
              text.setText("");
          }
          if(e.getSource()==addButton){
              System.out.println(text.getText());
              String place=text.getText().replace("-", "").replace("X", "").replace("/", "").replace("+", "");
             num1=Double.parseDouble(place);
              sign="+";
              String s=text.getText();
             signs(s,sign);
          }
          if(e.getSource()==subButton){
              System.out.println(text.getText());
                  String replace = text.getText().replace("-", "").replace("X", "").replace("/", "").replace("+", "");
              System.out.println(text.getText());
              num1=Double.parseDouble(replace);
              System.out.println(num1);
              sign="-";
              String s=text.getText();
             signs(s,sign);
          }
        if(e.getSource()==mulButton){
            String lace = text.getText().replace("-", "").replace("X", "").replace("/", "").replace("+", "");
            num1=Double.parseDouble(lace);
            sign="X";
            String s=text.getText();
            signs(s,sign);
        }
        if(e.getSource()==divButton){
            String ace = text.getText().replace("-", "").replace("X", "").replace("/", "").replace("+", "");
            num1=Double.parseDouble(ace);
            sign="/";
            String s=text.getText();
            signs(s,sign);
        }
        if(e.getSource()==equButton){
            String g=text.getText();
            text.setText(String.valueOf(fun(g)));
        }
    }
}
