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

             //Frame(String title)을 호출한다.

             super(title);

            

             //Label의 text정렬을 오른쪽으로

             lstring = new Label("내용 :",Label.RIGHT);

 

             //약 10개의 글자를 입력할 수 있는 TextField 생성.


             tfstring = new TextField(10);

            

             ok = new Button("OK");
             end = new Button("END");

             //OK버튼과 TextField에 이벤트처리를 위한 Listener를 추가해준다.

             tfstring.addActionListener(new EventHandler());

             ok.addActionListener(new EventHandler());
             end.addActionListener(new EventHandler(){
            	 public void actionPerformed(ActionEvent e) {
            		 System.exit(0);}}
            );
            

             //LayoutManager를 FlowLayout으로

             setLayout(new FlowLayout());

             //생성한 component들을 Frame에 포함시킨다.


             add(lstring);

             add(tfstring);

             add(ok);
             
             add(end);

             setSize(450,65);

             //화면이 보이게 한다.

             setVisible(true);

       }

       public static void main(String args[]){

    	   textfield f = new textfield("Tweet");

       }

      

       class EventHandler implements ActionListener{

             public void actionPerformed(ActionEvent e){

                    //tfId에  입력되어있는 text를 얻어온다.


                    String istring = tfstring.getText();
                    
                    String[] A = {istring};
                    TWEET.main(A);
             }

       }

}