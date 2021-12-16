/**
 * author : D.Jean-Baptiste & E.Sriguru
 */

package graphic;

import java.io.File;
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JLabel;


import com.drew.imaging.ImageProcessingException;

import principal.Metadonnees;
import principal.DossierNexistePas;
import principal.ExploRep;

@SuppressWarnings({ "serial", "unused" })
public class Gui extends JFrame{
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p5 = new JPanel();
	private JButton boutton1 = new JButton("Choisissez une image");
	private JButton boutton2 = new JButton("Examiner");
	private	JButton chooseImg1 = new JButton("Charger une image");
	private JButton cacherImg = new JButton("Cacher");
	private JButton chooseDir = new JButton("Choisissez un dossier");
	private JButton analysDir = new JButton("Analyser");
	private JButton reni1 = new JButton("Rénitialiser");
	private JButton reni2 = new JButton("Rénitialiser");
	private JButton reni3 = new JButton("Rénitialiser");

	
	private JTextField nameDir = new JTextField();
	private JTextField resName = new JTextField();
	private JTextArea dirContent = new JTextArea();
	private JTextArea imgContent = new JTextArea();
	private JTextArea affImg = new JTextArea();
    private JTextArea msgContent = new JTextArea();
	private final JLabel myLabe = new JLabel("veuillez choisir un .jpeg ou un .png");//final : on ne peut pas reaffecter cette variable
	private final JLabel myLabe2 = new JLabel("veuillez choisir un .png");
	private JLabel imgLabel = new JLabel("Image :");
	private JLabel msgLabel = new JLabel("Saisissez le texte à cacher :");
	

	
	public Gui(String titre) {
		super(titre);
		//deco arriere-plan
		setBackground(Color.LIGHT_GRAY);
		
		//permet d'afficher la fenetre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		setVisible(true);
		
		//appel de la fonction initLayout()
		initLayout();

/*--------------------------------------------------------------------*/
		//deco chooseDir
		chooseDir.setBackground(Color.DARK_GRAY);
		chooseDir.setForeground(Color.CYAN);
				
		//ajoute un actionListener au boutton chooseDir
		chooseDir.addActionListener(new SelectDirAction());
				
		//deco analysDir
		analysDir.setBackground(Color.DARK_GRAY);
		analysDir.setForeground(Color.CYAN);
				
		//ajoute un actionListener a analysDir
		analysDir.addActionListener(new AnalyseDirAction());
				
		//deco reni1
		reni1.setBackground(Color.DARK_GRAY);
		reni1.setForeground(Color.CYAN);
			    
	    //ajoute un actionListener a reni1
		reni1.addActionListener(new Reni1Action());
		

		
/*--------------------------------------------------------------------*/
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
		
		//deco reni2
		reni2.setBackground(Color.DARK_GRAY);
	    reni2.setForeground(Color.CYAN);
	    
	    //ajoute un actionListener a reni2
	    reni2.addActionListener(new Reni2Action());
	  		
/*--------------------------------------------------------------------*/
		//deco chooseImg1
		chooseImg1.setBackground(Color.DARK_GRAY);
		chooseImg1.setForeground(Color.CYAN);
		
		//ajoute un actionListener au bouton chooseImg1
		chooseImg1.addActionListener(new ChargeImage());
		
		
		//deco cacher
		cacherImg.setBackground(Color.DARK_GRAY);
	    cacherImg.setForeground(Color.CYAN);
			    
	    
	    //deco reni3
	    reni3.setBackground(Color.DARK_GRAY);
	    reni3.setForeground(Color.CYAN);

/*--------------------------------------------------------------------*/
	    
	    
	}
	
	//methode initialisant des composants graphique de la fenetre
	protected void initLayout() {
		GridLayout grid = new GridLayout(1, 1); 
	    Container contentPane = getContentPane();
		contentPane.setLayout(grid);
		
		JTabbedPane onglets = new JTabbedPane(JTabbedPane.TOP);
		
		//deco tab
		onglets.setForeground(Color.MAGENTA);
		onglets.setBackground(Color.BLACK);
		
		
		//pour p1
		onglets.add("Lister un répertoire", p1);
		p1.setLayout(new BorderLayout());
		p1.add(ligne1P1(), BorderLayout.NORTH);
		p1.add(ligne2P1(), FlowLayout.CENTER);
		p1.add(ligne3P1(), BorderLayout.SOUTH);
		
		//pour p2
		onglets.add("Metadonnees", p2);
		p2.setLayout(new BorderLayout());
		p2.add(ligne1P2(), BorderLayout.NORTH);
		p2.add(ligne2P2(), FlowLayout.CENTER);
		p2.add(ligne3P2(), BorderLayout.SOUTH);
		
		
		//pour p3
		onglets.add("Encoder", p3);
		p3.setLayout(new BorderLayout());
		p3.add(ligne1P3(), BorderLayout.NORTH);
		p3.add(ligne2P3(), BorderLayout.CENTER);
		p3.add(ligne3P3(), BorderLayout.SOUTH);
		

		onglets.add("Decoder", p4);
		onglets.add("Aide", p5);
		
		contentPane.add(onglets);
	    
	}

/*POUR P1*/
	private JPanel ligne1P1() {
		JPanel section1 = new JPanel(new FlowLayout());
		section1.setBackground(Color.GRAY);
		
		section1.add(chooseDir);
		
		//deco nameDir
		nameDir.setForeground(Color.RED);
		nameDir.setBackground(Color.LIGHT_GRAY);
		
		nameDir.setPreferredSize(new Dimension(200, 27));
		section1.add(nameDir);	
		
		return section1;
	}
	
	private JPanel ligne2P1() {
		JPanel section2 = new JPanel(new GridLayout(1,1));
		
		JScrollPane srcContent = new JScrollPane(dirContent);
		section2.add(srcContent);
		
		return section2;
	}
	
	private JPanel ligne3P1() {
		JPanel section3 = new JPanel(new FlowLayout());
		
		section3.setBackground(Color.GRAY);
		
		section3.add(analysDir);
		section3.add(reni1);
		
		return section3;
	}
	
	
/*POUR P2*/
	/*separations en 3 parties pour p2*/
	private JPanel ligne1P2() {
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
	
	private JPanel ligne2P2() {
		JPanel section2 = new JPanel(new GridLayout(1,1));
		
		JScrollPane srcContent = new JScrollPane(imgContent);
		section2.add(srcContent);
		
		return section2;
	}
	
	private JPanel ligne3P2() {
		JPanel section3 = new JPanel(new FlowLayout());
		
		section3.setBackground(Color.GRAY);
		
		section3.add(boutton2);
		section3.add(reni2);
		
		return section3;
	}
	
	
/*POUR P3*/
	 private JPanel ligne1P3() {
	    JPanel section1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    section1.setBackground(Color.GRAY);
	    	
	    section1.add(chooseImg1);
	    
	   //deco
	   myLabe2.setForeground(Color.ORANGE);
	   myLabe2.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 8));
	  		
	   section1.add(myLabe2);
	    return section1;
	 }
	 
	private JPanel ligne2P3() {
		JPanel section2 = new JPanel(new GridLayout(2,2));
		
		
		imgLabel.setForeground(Color.ORANGE);
		imgLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		section2.add(imgLabel);
		JScrollPane srcContent = new JScrollPane(affImg);
		section2.add(srcContent);
		
		msgLabel.setForeground(Color.ORANGE);
		msgLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		section2.add(msgLabel);
		JScrollPane srcContent2 = new JScrollPane(msgContent);
		section2.add(srcContent2);

		return section2;
	}
	
	private JPanel ligne3P3() {
		JPanel section3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		section3.setBackground(Color.GRAY);
		
		section3.add(cacherImg);
		section3.add(reni3);
		
		return section3;
	}
	
	
/*Gestions des actions*/

	//action du chooseDir
    private class SelectDirAction implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		if(e.getSource()==chooseDir) {
    			
    			JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("."));
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
    			
                int res = fileChooser.showOpenDialog(null); 
				
				if(res == JFileChooser.APPROVE_OPTION) { 
				    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				    nameDir.setText(file.getName());
				}
    			
    		}
    	}
    }
    
  //action du analysDir
  	private class AnalyseDirAction implements ActionListener {
  		
  		public void actionPerformed(ActionEvent e) {
  				
  				try {
  				if(e.getSource()==analysDir) {
  					File rep = new File(".");
  					String lechemin = rep.getAbsolutePath();
  					ExploRep explorer = new ExploRep(lechemin);
  					explorer.maListe();
  					dirContent.setText(explorer.toString());
  				}
  				}catch (IllegalArgumentException error1) {
  					dirContent.setText(error1.getMessage());
  			    }catch (DossierNexistePas error2) {
  			    	dirContent.setText(error2.getMessage());
  			    } 			
  		}
  		
  	}

  //action du boutton reni1
  	public class Reni1Action implements ActionListener {

  		public void actionPerformed(ActionEvent e) {
  			
  			if (e.getSource() == reni1) {
  			     nameDir.setText("");
  			     dirContent.setText("");
  			}
  		}

  	}
/*--------------------------------------------------------------------------------*/
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
	
	//action du boutton reni2
	public class Reni2Action implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == reni2) {
			     resName.setText("");
			     imgContent.setText("");
			}
		}

	}
	
	//action dy bouton chooseImg1
	public class ChargeImage implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==chooseImg1) {
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

	
    
	
	
}