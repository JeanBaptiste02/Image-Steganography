/**
 * author : D.Jean-Baptiste & E.Sriguru
 */


package principal;

import java.io.File;
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFileChooser;

import com.drew.imaging.ImageProcessingException;

import principal.Metadonnees;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings({ "serial", "unused" })
public class CreatGUI2 extends JFrame{
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JButton boutton1 = new JButton("Choisissez une image");
	private JButton boutton2 = new JButton("Examiner");
	private	JButton encodeButton = new JButton("Cacher");

	private JTextField resName = new JTextField();
	private JTextField textField;
	private JTextArea imgContent = new JTextArea();
	private final JLabel myLabe = new JLabel("veuillez choisir un .jpeg");//final : on ne peut pas reaffecter cette variable
	private final JLabel labe1 = new JLabel("Tapez le message que vous voulez cacher");//final : on ne peut pas reaffecter cette variable
	private GroupLayout g1_p2;


	
	public CreatGUI2(String titre) {
		super(titre);
		//deco arriere-plan
		setBackground(Color.LIGHT_GRAY);
		
		//permet d'afficher la fenetre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		setVisible(true);
		
		//appel de la fonction initLayout()
		initLayout();
		
		//deco boutton1
		boutton1.setBackground(Color.DARK_GRAY);
		boutton1.setForeground(Color.CYAN);
		
		//ajoute un actionListener au boutton1
		boutton1.addActionListener(new SelectFileAction());
		
		//deco boutton2
		boutton2.setBackground(Color.DARK_GRAY);
		boutton2.setForeground(Color.CYAN);
		
		//ajoute un actionListener au boutton2
		boutton2.addActionListener(new AffichMetaAction());
		
		//ajoute un actionListener au boutton encodeBoutton
		encodeButton.addActionListener(new EncodeAction());
		
	}
	
	//methode initialisant la fenetre
	protected void initLayout() {
		GridLayout grid = new GridLayout(1, 1); 
	    Container contentPane = getContentPane();
		contentPane.setLayout(grid);
		
		JTabbedPane onglets = new JTabbedPane(JTabbedPane.TOP);
		
		//deco tab
		onglets.setForeground(Color.MAGENTA);
		onglets.setBackground(Color.BLACK);
		
		
		//pour p1
		onglets.add("Metadonnees", p1);
		p1.setLayout(new BorderLayout());
		p1.add(ligne1(), BorderLayout.NORTH);
		p1.add(ligne2(), FlowLayout.CENTER);
		p1.add(ligne3(), BorderLayout.SOUTH);
		
		
		//pour p2
		onglets.add("Encoder", p2);
		p2.setBackground(Color.LIGHT_GRAY);
		p2.add(txtar());	
		
		
		onglets.add("Decoder", p3);
		onglets.add("Aide", p4);
		
		contentPane.add(onglets);
	    
	}
	
	
/*POUR P1*/
	/*separations en 3 parties pour p1*/
	private JPanel ligne1() {
		JPanel section1 = new JPanel(new FlowLayout());
		section1.setBackground(Color.GRAY);
		
		section1.add(boutton1);
		
		//deco
		resName.setForeground(Color.RED);
		resName.setBackground(Color.LIGHT_GRAY);
		
		resName.setPreferredSize(new Dimension(200, 27));
		section1.add(resName);	
		
		//deco
		myLabe.setForeground(Color.ORANGE);
		myLabe.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 8));
		
		section1.add(myLabe);
		return section1;
	}
	
	private JPanel ligne2() {
		JPanel section2 = new JPanel(new GridLayout(1,1));
		
		JScrollPane srcContent = new JScrollPane(imgContent);
		section2.add(srcContent);
		
		return section2;
	}
	
	private JPanel ligne3() {
		JPanel section3 = new JPanel(new FlowLayout());
		
		section3.setBackground(Color.GRAY);
		
		section3.add(boutton2);
		
		return section3;
	}
	
	
	
/*POUR P2*/
	/*utilisation du GroupLayout = 1 seule partie = courte et plus simple != plusieurs parties*/
	public JTextArea txtar() {
		JTextArea textArea = new JTextArea();

		//deco
		labe1.setFont(new Font("Tahoma", Font.BOLD, 12));
		labe1.setForeground(Color.BLACK);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
				
		//deco du boutton : encodeButton
		encodeButton.setBackground(Color.DARK_GRAY);
		encodeButton.setForeground(Color.RED);
		
		JLabel labe2 = new JLabel("L'image choisie");
		//deco
		labe2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		labe2.setBackground(Color.WHITE);
		labe2.setForeground(Color.BLUE);
		
		JLabel labe3 = new JLabel("L'image contenant le texte ");
		//deco
		labe3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		labe3.setForeground(Color.BLUE);

		
		//definition des positions et caracteristiques de chacuns des composants
		GroupLayout gl_p2 = new GroupLayout(p2);
		//horizontal
		gl_p2.setHorizontalGroup(
			gl_p2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p2.createSequentialGroup()
					.addContainerGap()
					
					.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_p2.createSequentialGroup()
							.addComponent(labe1)
							.addContainerGap(94, Short.MAX_VALUE))
						
						.addGroup(gl_p2.createSequentialGroup()
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(encodeButton)
							.addContainerGap(38, Short.MAX_VALUE))
						
						.addGroup(Alignment.TRAILING, gl_p2.createSequentialGroup()
							.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
								.addComponent(labe2))
							.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
							.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
								.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
								.addComponent(labe3))
							.addGap(22))))
		);
		//vertical
		gl_p2.setVerticalGroup(
			gl_p2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p2.createSequentialGroup()
						
					.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_p2.createSequentialGroup()
							.addContainerGap()
							.addComponent(labe1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						
						.addGroup(gl_p2.createSequentialGroup()
							.addGap(59)
							.addComponent(encodeButton)))
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					
					.addGroup(gl_p2.createParallelGroup(Alignment.BASELINE)
						.addComponent(labe2)
						.addComponent(labe3))
					.addPreferredGap(ComponentPlacement.RELATED)
					
					.addGroup(gl_p2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textArea_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
			p2.setLayout(gl_p2);

			
			return textArea;
	}
	
	

	
/*Gestions des actions*/
	
	//action du boutton 1
	private class SelectFileAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==boutton1) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("."));
				
				int res = fileChooser.showOpenDialog(null); 
				
				if(res == JFileChooser.APPROVE_OPTION) { 
				    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				    resName.setText(file.getName());
				}
			}
		}
	}
	
	
	//action du boutton 2
	private class AffichMetaAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
				
				try {
				if(e.getSource()==boutton2) {
					File img = new File(resName.getText());
					String lechemin = img.getAbsolutePath();
					Metadonnees var = new Metadonnees(lechemin);
					imgContent.setText(var.lectureMeta());
				}
				}catch (ImageProcessingException erreur1) {
					imgContent.setText("ERREUR");
			    }catch (IOException erreur2) {
			    	imgContent.setText(erreur2.getMessage());
			    }			
		}
		
	}
	
	//action du boutton encoreBoutton
	private class EncodeAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==encodeButton) {
				System.out.println("encode en cours ...............");
			}
		}
	}
    
	
}
