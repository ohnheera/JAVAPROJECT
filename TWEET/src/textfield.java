import java.awt.*;

import java.awt.event.*;

 

class textfield extends Frame{

       Label lnum;

       Label lstring;

       TextField tfnum;

       TextField tfstring;

       Button ok;
       
       Button end;

      

       textfield(String title){

             //Frame(String title)�� ȣ���Ѵ�.

             super(title);

            

             //Label�� text������ ����������

             lstring = new Label("���� :",Label.RIGHT);

 

             //�� 10���� ���ڸ� �Է��� �� �ִ� TextField ����.


             tfstring = new TextField(10);

            

             ok = new Button("OK");
             end = new Button("END");

             //OK��ư�� TextField�� �̺�Ʈó���� ���� Listener�� �߰����ش�.

             tfstring.addActionListener(new EventHandler());

             ok.addActionListener(new EventHandler());
             end.addActionListener(new EventHandler(){
            	 public void actionPerformed(ActionEvent e) {
            		 System.exit(0);}}
            );
            

             //LayoutManager�� FlowLayout����

             setLayout(new FlowLayout());

             //������ component���� Frame�� ���Խ�Ų��.


             add(lstring);

             add(tfstring);

             add(ok);
             
             add(end);

             setSize(450,65);

             //ȭ���� ���̰� �Ѵ�.

             setVisible(true);

       }

       public static void main(String args[]){

    	   textfield f = new textfield("Tweet");

       }

      

       class EventHandler implements ActionListener{

             public void actionPerformed(ActionEvent e){

                    //tfId��  �ԷµǾ��ִ� text�� ���´�.


                    String istring = tfstring.getText();
                    
                    String[] A = {istring};
                    TWEET.main(A);
             }

       }

}