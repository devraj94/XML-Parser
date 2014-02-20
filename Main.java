package xml_parser;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;

public class Main {
	static Main main_ins=null;

	File selected_file=null;
	FileWriter fr;
	BufferedWriter br;
	FileWriter fr1;
	BufferedWriter br1;
	   JFrame frame=null;
	  JPanel panel=null;
	   JScrollPane pane=null;
	   JTextArea textarea=null;
	   Container contentpane=null;
	   JButton start_button,tree_button,displaygui,displayfinalgui,save=null;
	   ArrayList<node_class> list=null;
	   Parser xml_parser=null;
	   Tree_class tree=null;
	   ArrayList<Tree_class> two_nodes;
	   int list_count=0;
	   int startx=0,starty=0;
	   JTree jtree;
	   
	   
	   //Second assign
	   
	   public javax.swing.JTextArea attr_edit_text;
	    public javax.swing.JTextField attributes_text;
	    public javax.swing.JTextArea child_edit_text;
	    public javax.swing.JTextField child_text;
	    public javax.swing.JButton get_attr;
	    public javax.swing.JButton get_child;
	    public javax.swing.JButton get_string;
	    public javax.swing.JButton get_value;
	    public javax.swing.JTextField id_edit_text;
	    public javax.swing.JTextField id_edit_text_ans;
	    public javax.swing.JTextField id_text;
	    public javax.swing.JScrollPane jScrollPane1;
	    public javax.swing.JScrollPane jScrollPane2;
	    public javax.swing.JScrollPane jScrollPane3;
	    public javax.swing.JTextField node_edit_text;
	    public javax.swing.JTextField node_text;
	    public javax.swing.JTextArea string_edit_text;
	    public javax.swing.JTextField string_text;
	   
   public static void main(String[] args){
	  main_ins=new Main();
	  main_ins.start();
	 
   }


   public void start(){
	   frame=new JFrame();
	   panel=new JPanel();
	   textarea=new JTextArea(25,41);
	   textarea.setEditable(false);
	   start_button=new JButton();
	   panel.add(textarea);
	   pane=new JScrollPane(panel);
	   contentpane=frame.getContentPane();
	   contentpane.setLayout(new BorderLayout());
	   contentpane.add(pane,BorderLayout.CENTER);
	   start_button.setText("Choose File");
	   contentpane.add(start_button,BorderLayout.SOUTH);
	   textarea.setText("Choose an XML file to start");
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setSize(500, 500);
	   frame.show();
	   
	   start_button.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  JFileChooser chooser=new JFileChooser();
				  FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
				  chooser.setDialogTitle("Open XML file");
				  chooser.setFileFilter(xmlfilter);
		            chooser.setFileSelectionMode( JFileChooser.OPEN_DIALOG);
		            chooser.showOpenDialog( null );
				  selected_file=chooser.getSelectedFile();
				  textarea.setText("Parsing your XML....\n Please wait...");
				  xml_parser=new Parser(selected_file,main_ins);
				  xml_parser.parse();
				  if(xml_parser.EOF){
				  textarea.append("\n hello end ");
				  preparing_tree();
				  }
			  }

			
		  });
   }
   public void preparing_tree() {

	   list=new ArrayList<node_class>();
	   list=xml_parser.nodelist;
	   textarea.setText("");
	   for(int u=0;u<list.size();u++){
			node_class nd=list.get(u);
			textarea.append(nd.node_name +"\n");
			textarea.append("     String :"+nd.node_string +"\n");
			textarea.append("     Value :"+nd.node_value + "\n");
			textarea.append("     no_of_nodes :"+String.valueOf(nd.no_of_nodes)+"\n");
		}
	   tree_button=new JButton("GO ON");
	   contentpane.remove(start_button);
	   frame.revalidate();
		contentpane.add(tree_button,BorderLayout.SOUTH);
		frame.revalidate();
		
		tree_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				make_n_show_tree();
				
			}

		});
	}
   

	public void make_n_show_tree() {

		tree=new Tree_class();
		Tree_class treedupe=tree;
		treedupe.name=list.get(list_count).node_name;
		treedupe.number=list_count;
	    complete_the_tree(treedupe,list.get(list_count).no_of_nodes);
	    textarea.setText("");
	   // Tree_class treedupedisplay=tree;
	   // textarea.append(treedupedisplay.name+"\n");
		//display_tree(treedupedisplay,treedupedisplay.tree_list.size());
		//displaygui=new JButton("Display JTree");
		 contentpane.remove(tree_button);
		 panel.remove(textarea);
		 pane.remove(panel);
		 contentpane.remove(pane);
		 frame.revalidate();
			//contentpane.add(displaygui,BorderLayout.SOUTH);
		 get_child = new javax.swing.JButton();
	        get_attr = new javax.swing.JButton();
	        get_string = new javax.swing.JButton();
	        get_value = new javax.swing.JButton();
	        node_text = new javax.swing.JTextField();
	        node_edit_text = new javax.swing.JTextField();
	        attributes_text = new javax.swing.JTextField();
	        id_text = new javax.swing.JTextField();
	        id_edit_text = new javax.swing.JTextField();
	        child_text = new javax.swing.JTextField();
	        id_edit_text_ans = new javax.swing.JTextField();
	        string_text = new javax.swing.JTextField();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        attr_edit_text = new javax.swing.JTextArea();
	        jScrollPane2 = new javax.swing.JScrollPane();
	        child_edit_text = new javax.swing.JTextArea();
	        jScrollPane3 = new javax.swing.JScrollPane();
	        string_edit_text = new javax.swing.JTextArea();

	        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        get_child.setText("Get Child");

	        get_attr.setText("Get Attributes");

	        get_string.setText("Get String");

	        get_value.setText("Get Value");

	        node_text.setText("Node :");

	        node_text.setEditable(false);
	        attributes_text.setText("Attributes:");
            attributes_text.setEditable(false);
	        id_text.setText("ID    :");
             id_text.setEditable(false);
	        child_text.setText("Children :");
            child_text.setEditable(false);
	        string_text.setText("String :");
           string_text.setEditable(false);
	        attr_edit_text.setColumns(20);
	        attr_edit_text.setRows(5);
	        jScrollPane1.setViewportView(attr_edit_text);

	        child_edit_text.setColumns(20);
	        child_edit_text.setRows(5);
	        jScrollPane2.setViewportView(child_edit_text);

	        string_edit_text.setColumns(20);
	        string_edit_text.setRows(5);
	        jScrollPane3.setViewportView(string_edit_text);

	        attr_edit_text.setEditable(false);
	        child_edit_text.setEditable(false);
	        string_edit_text.setEditable(false);
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(contentpane);
	        contentpane.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                            .addComponent(get_string, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
	                            .addComponent(get_child, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(get_attr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(get_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(id_text, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(id_edit_text, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addComponent(attributes_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(id_edit_text_ans, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(child_text, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(node_text, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(node_edit_text, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(string_text, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addGap(0, 0, Short.MAX_VALUE)))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(node_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(node_edit_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(attributes_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(11, 11, 11)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(id_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(id_edit_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(id_edit_text_ans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(child_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addComponent(string_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(83, 83, 83))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(get_child)
	                    .addComponent(get_attr))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(get_string)
	                    .addComponent(get_value))
	                .addGap(19, 19, 19))
	        );


	        frame.revalidate();
			
	        get_child.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		child_edit_text.setText("");
	        		String node=node_edit_text.getText().toString();
	        		if(node.compareTo("")!=0)
	        		   show_children(node);
	        		else
	        			child_edit_text.append("please enter a node");
	        	}
	        });
	        
	        get_attr.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		String node=node_edit_text.getText().toString();
	        	    attr_edit_text.setText("");
	        		if(node.compareTo("")!=0)
	        		   show_attributes(node);
	        		else
	        			attr_edit_text.append("please enter a node");
	        	}
	        });

    		id_edit_text_ans.setEditable(false);
	        get_value.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		String node=node_edit_text.getText().toString();
	        	    id_edit_text_ans.setText("");
	        		if(node.compareTo("")!=0)
	        			if(id_edit_text.getText().toString().compareTo("")!=0)
	        		       show_values(node,id_edit_text.getText().toString());
	        			else
	        				id_edit_text_ans.setText("please enter a id");
	        		else
	        			id_edit_text_ans.setText("please enter a id");
	        	}
	        });
	        
	        get_string.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		String node=node_edit_text.getText().toString();
	        		string_edit_text.setText("");
	        		if(node.compareTo("")!=0)
	        		   show_string(node);
	        		else
	        			string_edit_text.append("please enter a node");
	        	}
	        });
	        
		/*	displaygui.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					display_gui();
					
				}
				
			}); */
	}
	


	public void show_children(String node){
		Tree_class treedupedisplay=tree;
		if(treedupedisplay.name.compareTo(node)==0){
			for(int i=0;i<treedupedisplay.tree_list.size();i++){
				child_edit_text.append(treedupedisplay.tree_list.get(i).name+"\n");
			}
			child_edit_text.append("\n");
		}
			display_child(treedupedisplay,treedupedisplay.tree_list.size(),node);
	}
	
	public void show_attributes(String node){
		Tree_class treedupedisplay=tree;
		if(treedupedisplay.name.compareTo(node)==0){
				attr_edit_text.append(list.get(treedupedisplay.number).node_value+"\n");
			attr_edit_text.append("\n");
		}
			display_attr(treedupedisplay,treedupedisplay.tree_list.size(),node);
	}
	
	public void show_values(String node,String id){
		Tree_class treedupedisplay=tree;
		if(treedupedisplay.name.compareTo(node)==0 && list.get(treedupedisplay.number).node_value.contains(id)){
			    String hj[]=list.get(treedupedisplay.number).node_value.replaceAll("\\s+", " ").split(" ");
			    for(int u=0;u<hj.length;u++){
			    	if(hj[u].contains(id)){
			    		id_edit_text_ans.setText(hj[u]);
			    		break;
			    	}
					

			    }
		}
			display_value(treedupedisplay,treedupedisplay.tree_list.size(),node,id);
	}
	
	public void show_string(String node){
		Tree_class treedupedisplay=tree;
		if(treedupedisplay.name.compareTo(node)==0){
			for(int i=0;i<treedupedisplay.tree_list.size();i++){
				attr_edit_text.append((list.get(treedupedisplay.number).node_string).replace(",","")+"..\n");
			}
			attr_edit_text.append("\n");
		}
			display_string(treedupedisplay,treedupedisplay.tree_list.size(),node);
	}
	
	
	public void display_tree(Tree_class treedupedisplay, int size) {

		for(int i=0;i<size;i++){
             if(treedupedisplay.tree_list.get(i).tree_list.size()==0){
            	 textarea.append(treedupedisplay.tree_list.get(i).name+"  "+treedupedisplay.tree_list.get(i).number+" "+i+"\n");
             }else{
            	 textarea.append(treedupedisplay.tree_list.get(i).name+"  "+treedupedisplay.tree_list.get(i).number+"  "+i+"\n");
            	 Tree_class tr=treedupedisplay.tree_list.get(i);
            	 display_tree(tr,tr.tree_list.size());
             }
		}
	}
	
	public void display_child(Tree_class treedupedisplay, int size,String node) {

		for(int i=0;i<size;i++){
             if(treedupedisplay.tree_list.get(i).name.compareTo(node)==0 ){
            	 for(int ie=0;ie<treedupedisplay.tree_list.get(i).tree_list.size();ie++){
     				child_edit_text.append(treedupedisplay.tree_list.get(i).tree_list.get(ie).name+"\n");
     			}
     			child_edit_text.append("\n");	  
             }else{
            	 Tree_class tr=treedupedisplay.tree_list.get(i);
            	 display_child(tr,tr.tree_list.size(),node);
             }
		}
	}

	
	public void display_attr(Tree_class treedupedisplay, int size,String node) {

		for(int i=0;i<size;i++){
             if(treedupedisplay.tree_list.get(i).name.compareTo(node)==0 ){
     				attr_edit_text.append(list.get(treedupedisplay.tree_list.get(i).number).node_value+"\n");
     			
     			attr_edit_text.append("\n");	  
             }else{
            	 Tree_class tr=treedupedisplay.tree_list.get(i);
            	 display_attr(tr,tr.tree_list.size(),node);
             }
		}
	}
	
	public void display_value(Tree_class treedupedisplay, int size,String node,String id) {

		for(int i=0;i<size;i++){
             if(treedupedisplay.tree_list.get(i).name.compareTo(node)==0 && list.get(treedupedisplay.tree_list.get(i).number).node_value.contains(id)){
            	 String hj[]=list.get(treedupedisplay.tree_list.get(i).number).node_value.replaceAll("\\s+", " ").split(" ");
 			    for(int u=0;u<hj.length;u++){
 			    	if(hj[u].contains(id)){
 			    		id_edit_text_ans.setText(hj[u]);
 			    		break;
 			    	}
 					

 			    }	  
             }else{
            	 Tree_class tr=treedupedisplay.tree_list.get(i);
            	 display_value(tr,tr.tree_list.size(),node,id);
             }
		}
	}
	
	public void display_string(Tree_class treedupedisplay, int size,String node) {

		for(int i=0;i<size;i++){
             if(treedupedisplay.tree_list.get(i).name.compareTo(node)==0 ){
     				string_edit_text.append((list.get(treedupedisplay.tree_list.get(i).number).node_string).replace(",","")+"\n");
     			
     			string_edit_text.append("\n");	  
             }else{
            	 Tree_class tr=treedupedisplay.tree_list.get(i);
            	 display_string(tr,tr.tree_list.size(),node);
             }
		}
	}


	public void complete_the_tree(Tree_class treedupe,int no_of_nodes) {

		for(int i=0;i<no_of_nodes;i++){
			list_count++;
			if(list.get(list_count).no_of_nodes==0){
				Tree_class tr=new Tree_class();
				tr.name=list.get(list_count).node_name;
				tr.number=list_count;
				treedupe.tree_list.add(tr);
			}else{
				Tree_class tr=new Tree_class();
				tr.name=list.get(list_count).node_name;
				tr.number=list_count;
				treedupe.tree_list.add(tr);
				complete_the_tree(tr,list.get(list_count).no_of_nodes);
			}
		}
	}

	


/*	public void display_gui() {

		textarea.append("hai");
		contentpane.remove(displaygui);
		frame.revalidate();
		panel.remove(textarea);
		frame.revalidate();
	//	Tree_gui_builder tr_gui_bld=new Tree_gui_builder(tree,0,0);
		pane.remove(panel);
		contentpane.remove(pane);
	//	contentpane.add(tr_gui_bld);
		frame.revalidate();
		Tree_class treedupedisplay=tree;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(treedupedisplay.name+"  ( "+list.get(treedupedisplay.number).node_value+" , "+list.get(treedupedisplay.number).node_string+" )");
		jtree_show(treedupedisplay,treedupedisplay.tree_list.size(),root);
		jtree=new JTree(root);
		contentpane.setLayout(new BorderLayout());
		contentpane.add(jtree,BorderLayout.CENTER);
		displayfinalgui=new JButton("Proceed to GUI");
		contentpane.add(displayfinalgui,BorderLayout.SOUTH);
		frame.revalidate();
		displayfinalgui.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				InteractiveGUI();
			}

			
		});
	}


	public void jtree_show(Tree_class treedupedisplay,int size,DefaultMutableTreeNode root) {

		for(int i=0;i<size;i++){
            if(treedupedisplay.tree_list.get(i).tree_list.size()==0){
            	DefaultMutableTreeNode rt=new DefaultMutableTreeNode(treedupedisplay.tree_list.get(i).name+"  ( "+list.get(treedupedisplay.tree_list.get(i).number).node_value+" , "+list.get(treedupedisplay.tree_list.get(i).number).node_string+" )");
            	root.add(rt);
            }else{
            	DefaultMutableTreeNode rt=new DefaultMutableTreeNode(treedupedisplay.tree_list.get(i).name+"  ( "+list.get(treedupedisplay.tree_list.get(i).number).node_value+" , "+list.get(treedupedisplay.tree_list.get(i).number).node_string+" )");
            	root.add(rt);
           	 Tree_class tr=treedupedisplay.tree_list.get(i);
           	 jtree_show(tr,tr.tree_list.size(),rt);
            }
		}
	}
	
	
	
	public void InteractiveGUI() {
		contentpane.remove(jtree);
		contentpane.remove(displayfinalgui);
		frame.remove(contentpane);
		save = new JButton("Save");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				 Tree_class treedupedisplay1=tree;
				    textarea.append(treedupedisplay1.name+"\n");
					print_display_tree(treedupedisplay1,treedupedisplay1.tree_list.size());
				try{
					 fr=new FileWriter(selected_file);
					 br=new BufferedWriter(fr);
					 Tree_class treedupedisplay=tree;

					 String name=treedupedisplay.name;

					    textarea.append(treedupedisplay.name+"\n");
					    br.append("<?xml version=\"1.0\"?>");
					    br.newLine();
					    br.flush();
					    br.append("<"+treedupedisplay.name+" "+list.get(treedupedisplay.number).node_value+">  "+list.get(treedupedisplay.number).node_string);
						save_to_file(treedupedisplay,treedupedisplay.tree_list.size());

						br.flush();
						fr.close();
	Extra comment from here::	FileReader frw=new FileReader(selected_file);
						BufferedReader brw=new BufferedReader(frw);

						String hai="";
						String hg="";
						while((hg=brw.readLine())!=null){
							hai=hai+hg+"\n";
						}
						fr=new FileWriter(selected_file);
						 br=new BufferedWriter(fr);
						 hai=hai+"</"+name+">";
						 System.out.println(hai); :: Extra comment ends here
						//br.write(hai);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}

			
		});
		frame.add(save,BorderLayout.SOUTH);
		frame.revalidate();
		frame.setVisible(false);
		frame.setVisible(true);
		panel=new JPanel();
		  panel.setLayout(null);
		  two_nodes=new ArrayList<Tree_class>();
		Tree_gui_builder builder_gui=new Tree_gui_builder(tree,startx,starty,panel,frame,list,two_nodes);
		builder_gui.start();
		panel.addMouseListener(new MouseAdapter(){
			int x=0;
			int y=0;
			public void mousePressed(MouseEvent e){
				x=e.getX();
				y=e.getY();
        }
			public void mouseReleased(MouseEvent e){
				x=e.getX()-x;
				y=e.getY()-y;
				startx=startx+x;
				starty=starty+y;
				panel.removeAll();
				frame.setVisible(false);
				frame.setVisible(true);
				Tree_gui_builder builder_gui=new Tree_gui_builder(tree,startx,starty,panel,frame,list,two_nodes);
				builder_gui.start();
	        }
		});
	}
	
	
	public void save_to_file(Tree_class treedupedisplay, int size) {


		for(int i=0;i<size;i++){
			try{
            if(treedupedisplay.tree_list.get(i).tree_list.size()==0){
           	  br.newLine();
			    br.flush();
			    br.append("<"+treedupedisplay.tree_list.get(i).name+" "+list.get(treedupedisplay.tree_list.get(i).number).node_value+">  "+list.get(treedupedisplay.tree_list.get(i).number).node_string);
			    br.flush();
				br.append("</"+treedupedisplay.tree_list.get(i).name+">");
            }else{
           	 br.newLine();
			    br.flush();
			    br.append("<"+treedupedisplay.tree_list.get(i).name+" "+list.get(treedupedisplay.tree_list.get(i).number).node_value+">  "+list.get(treedupedisplay.tree_list.get(i).number).node_string);
				 Tree_class tr=treedupedisplay.tree_list.get(i);
           	 save_to_file(tr,tr.tree_list.size());
            }
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}
	

	public void print_display_tree(Tree_class treedupedisplay,
			int size) {
		for(int i=0;i<size;i++){
            if(treedupedisplay.tree_list.get(i).tree_list.size()==0){
           	 System.out.print(treedupedisplay.tree_list.get(i).name+"  "+treedupedisplay.tree_list.get(i).number+" "+i+"\n");
            }else{
           	 System.out.print(treedupedisplay.tree_list.get(i).name+"  "+treedupedisplay.tree_list.get(i).number+"  "+i+"\n");
           	 Tree_class tr=treedupedisplay.tree_list.get(i);
           	 display_tree(tr,tr.tree_list.size());
            }
		}
		
	}  */

}
