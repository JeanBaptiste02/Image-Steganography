package graphic;

import java.io.File;
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;

import com.drew.imaging.ImageProcessingException;

import principal.Metadonnees;
import principal.DossierNexistePas;
import principal.ExploRep;
import principal.ImageExtensionException;
import principal.EncoderImage;
import principal.DecoderImage;

/**
 * la classe Gui cree une interface graphique pour explorer un repertoire, pour encoder et decoder 
 * @author D.JEAN BAPTISTE & E.SRIGURU
 *
 */
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
	private JButton OPbout = new JButton("Ouvrir");
		
	private JButton DecoBoutt = new JButton("Decoder");
	
	private JButton analysDir = new JButton("Analyser");
	private JButton reni1 = new JButton("Rénitialiser");
	private JButton reni2 = new JButton("Rénitialiser");
	private JButton reni3 = new JButton("Rénitialiser");
	private JButton reni4 = new JButton("Rénitialiser");
	
	private JTextField nameDir = new JTextField();
	private JTextField resName = new JTextField();
	private JTextField nomImg2 = new JTextField();
	private JTextArea dirContent = new JTextArea();
	private JTextArea imgContent = new JTextArea();
    private JTextArea msgContent = new JTextArea();
    //private	JTextArea affImgEncode = new JTextArea();
	private JTextArea affMsgSec = new JTextArea();

    
	private JLabel myLabe = new JLabel("veuillez choisir un .jpeg ou un .png");
	private JLabel myLabe2 = new JLabel("veuillez choisir un .png");
	private JLabel imgLabel = new JLabel("Image :");
	private JLabel msgLabel = new JLabel("Saisissez le texte à cacher :");
	private JLabel imgchooseLabel = new JLabel("Choisissez le nom de l'image en sortie :");
	private JLabel l = new JLabel();
	private JLabel naImg = new JLabel();
	private	JLabel imgaDecoder = new JLabel("L'image qui a été encodée : ");
	private JLabel resDecode = new JLabel("Message secret");
	private JLabel affImgEncode = new JLabel();
	private JLabel naImg2 = new JLabel();
	
	/**
	 * Ce constructeur cree une fenetre, decore les composants et ajoute des actionListeners a des composants specifiques
	 * @param titre indique le titre que portera la fenetre
	 */
	public Gui(String titre) {
		super(titre);
		//deco arriere-plan
		setBackground(Color.LIGHT_GRAY);
		
		//permet d'afficher la fenetre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800, 600); //taille
		this.setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false); //pour ne pas agrandir la fenetre
		
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
		
		//ajoute un actionListener au boutton chooseImg1
		chooseImg1.addActionListener(new ChoixImageAction());
		
		//deco cacher
		cacherImg.setBackground(Color.DARK_GRAY);
	    cacherImg.setForeground(Color.CYAN);
			    
	    //ajoute un actionListener au boutton cacherImg
	    cacherImg.addActionListener(new CacherAction());
	   
	    //deco reni3
	    reni3.setBackground(Color.DARK_GRAY);
	    reni3.setForeground(Color.CYAN);

	    //ajoute un actionListener au boutton reni3
	    reni3.addActionListener(new Reni3Action());
/*--------------------------------------------------------------------*/
	    //deco OPbout
	    OPbout.setBackground(Color.DARK_GRAY);
	  	OPbout.setForeground(Color.CYAN);
	    //ajoute un actionListener au boutton OPbout
	    OPbout.addActionListener(new ChoixImage2Action());
	    
	    //deco DecoBoutt
	    DecoBoutt.setBackground(Color.DARK_GRAY);
	  	DecoBoutt.setForeground(Color.CYAN);
	  			    
	    //ajoute un actionListener au boutton DecoBoutt
	    DecoBoutt.addActionListener(new DecoderAction());
	    
	    //deco reni4
	    reni4.setBackground(Color.DARK_GRAY);
	    reni4.setForeground(Color.CYAN);
	    
	    //ajoute un actionListener au boutton reni4
	    reni4.addActionListener(new Reni4Action());
	    
	}
/*--------------------------------------------------------------------*/	
	
	
	/**
	 * methode initialisant des composants graphique de la fenetre
	 */
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
		
        //pour p4
		onglets.add("Decoder", p4);
		p4.setLayout(new BoxLayout(p4, BoxLayout.X_AXIS));		
		p4.add(ligne2P4());
		//p4.add(ligne3P4(), BorderLayout.SOUTH);
		
		
		onglets.add("Aide", p5);
		
		contentPane.add(onglets);
	    
	}

/*POUR P1*/
	
	/**
	 * Construit la premiere ligne de l'onglet p1
	 * @return
	 */
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
	
	/**
	 * Construit la deuxieme ligne de l'onglet p1
	 * @return
	 */
	private JPanel ligne2P1() {
		JPanel section2 = new JPanel(new GridLayout(1,1));
		
		JScrollPane srcContent = new JScrollPane(dirContent);
		section2.add(srcContent);
		
		return section2;
	}
	
	/**
	 * Construit la troisieme ligne de l'onglet p1
	 * @return
	 */
	private JPanel ligne3P1() {
		JPanel section3 = new JPanel(new FlowLayout());
		
		section3.setBackground(Color.GRAY);
		
		section3.add(analysDir);
		section3.add(reni1);
		
		return section3;
	}
	
	
/*POUR P2*/
	
	/**
	 * Construit la premiere ligne de l'onglet p2
	 * @return
	 */
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
	
	/**
	 * Construit la deuxieme ligne de l'onglet p2
	 * @return
	 */
	private JPanel ligne2P2() {
		JPanel section2 = new JPanel(new GridLayout(1,1));
		
		JScrollPane srcContent = new JScrollPane(imgContent);
		section2.add(srcContent);
		
		return section2;
	}
	
	/**
	 * Construit la troisieme ligne de l'onglet p2
	 * @return
	 */
	private JPanel ligne3P2() {
		JPanel section3 = new JPanel(new FlowLayout());
		
		section3.setBackground(Color.GRAY);
		
		section3.add(boutton2);
		section3.add(reni2);
		
		return section3;
	}
	
	
/*POUR P3*/
	/**
	 * Construit la premiere ligne de l'onglet p3
	 * @return
	 */
	private JPanel ligne1P3() {
	    JPanel section1 = new JPanel();
	    section1.setLayout(new BoxLayout(section1, BoxLayout.X_AXIS));
	    
	    section1.setBackground(Color.GRAY);
	    
	    section1.add(chooseImg1);
	    
	    section1.add(Box.createRigidArea(new Dimension(15, 0)));
	    naImg.setForeground(Color.RED);
		naImg.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
	    section1.add(naImg);
	    
	    section1.add(Box.createRigidArea(new Dimension(120, 0)));
	    imgchooseLabel.setForeground(Color.ORANGE);
		imgchooseLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
		section1.add(imgchooseLabel);
		
		nomImg2.setPreferredSize(new Dimension(200, 27));
		section1.add(nomImg2);
	    
	    return section1;
	 }
	 
	 /**
	  * Construit la deuxieme ligne de l'onglet p3
	  * @return
	  */
	private JPanel ligne2P3() {
		JPanel section2 = new JPanel(new GridLayout(2,2));
		
		
		imgLabel.setForeground(Color.ORANGE);
		imgLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		section2.add(imgLabel);
		//JScrollPane srcContent = new JScrollPane(affImg);
		//section2.add(srcContent);
	    l.setBounds(10,10,365,290);
	    section2.add(l);
		
		msgLabel.setForeground(Color.ORANGE);
		msgLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		section2.add(msgLabel);
		JScrollPane srcContent2 = new JScrollPane(msgContent);
		section2.add(srcContent2);

		return section2;
	}
	
	/**
	 * Construit la troisieme ligne de l'onglet p3
	 * @return
	 */
	private JPanel ligne3P3() {
		JPanel section3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		section3.setBackground(Color.GRAY);
		
		section3.add(cacherImg);
		section3.add(reni3);
		
		return section3;
	}
	
/*POUR P4*/
	/**
	 * Construit l'onglet p4
	 * @return
	 */
	private JPanel ligne2P4() {
		JPanel glob = new JPanel();
		
		JPanel masection1 = new JPanel();
		masection1.setBackground(Color.GRAY);
		masection1.add(OPbout);
		masection1.add(DecoBoutt);
		naImg2.setForeground(Color.RED);
		naImg2.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
		masection1.add(naImg2);
		
		imgaDecoder.setForeground(Color.ORANGE);
		imgaDecoder.setFont(new Font("Georgia", Font.BOLD, 10));
		resDecode.setForeground(Color.ORANGE);
		
		GroupLayout mesCompoP4 = new GroupLayout(glob);
		
		//horizontal
		mesCompoP4.setHorizontalGroup(
			mesCompoP4.createParallelGroup(Alignment.LEADING)
				.addComponent(masection1, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE) //ajoute la section1, c'est le panel1
				
				.addGroup(mesCompoP4.createSequentialGroup()
					.addGap(10)
					.addComponent(imgaDecoder) //ajoute un label
					.addGap(307) //espace entre les 2 labels
					.addComponent(resDecode)//ajoute un label
					.addGap(217))
				
				.addGroup(mesCompoP4.createSequentialGroup()
					.addContainerGap()
					.addComponent(affImgEncode, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE) // JLabel pour afficher l'image encode
					
					.addGroup(mesCompoP4.createParallelGroup(Alignment.LEADING)
						.addGroup(mesCompoP4.createSequentialGroup()
							.addGap(47)
							.addComponent(affMsgSec, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE) //textarea pour afficher le message secret
							.addContainerGap())
						.addGroup(Alignment.TRAILING, mesCompoP4.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(reni4) //bouton reinitialiser
							.addGap(20))))
		);
		
		//vertical
		mesCompoP4.setVerticalGroup(
			mesCompoP4.createParallelGroup(Alignment.LEADING)
				.addGroup(mesCompoP4.createSequentialGroup()
					.addComponent(masection1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(mesCompoP4.createParallelGroup(Alignment.BASELINE)
						.addComponent(imgaDecoder)
						.addComponent(resDecode))
					.addPreferredGap(ComponentPlacement.RELATED)
					
					.addGroup(mesCompoP4.createParallelGroup(Alignment.LEADING)
						.addGroup(mesCompoP4.createSequentialGroup()
							.addComponent(affImgEncode, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(mesCompoP4.createSequentialGroup()
							.addComponent(affMsgSec, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
							.addComponent(reni4)
							.addGap(19))))
		);
		

		
		glob.setLayout(mesCompoP4);
		
	return glob;
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
  					File rep = new File(nameDir.getText());
  					String lechemin = rep.getAbsolutePath();
  					ExploRep explorer = new ExploRep(lechemin);
  					explorer.maListe();
  					dirContent.setText(explorer.toString());
  				}
  				}catch (IllegalArgumentException error1) {
  					//dirContent.setText(error1.getMessage());
  					JOptionPane.showMessageDialog(null,error1.getMessage(),"ERREUR",JOptionPane.WARNING_MESSAGE );
  			    }catch (DossierNexistePas error2) {
  			    	//dirContent.setText(error2.getMessage());
  			    	JOptionPane.showMessageDialog(null,error2.getMessage(),"ERREUR",JOptionPane.WARNING_MESSAGE );
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
					//imgContent.setText("ERREUR");
					JOptionPane.showMessageDialog(null,"Impossible d'ouvrir l'image","ERREUR",JOptionPane.WARNING_MESSAGE );
			    }catch (IOException erreur2) {
			    	//imgContent.setText(erreur2.getMessage());
			    	JOptionPane.showMessageDialog(null,erreur2.getMessage(),"ERREUR",JOptionPane.WARNING_MESSAGE );
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
/*----------------------------------------------------------------------------*/
    
	//action du boutton chooseImg1
	private class ChoixImageAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()==chooseImg1) {
					
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File("."));
				
					int res = fileChooser.showOpenDialog(null); 
					
					if(res == JFileChooser.APPROVE_OPTION) { 
					    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				        String path = file.getAbsolutePath();
				        l.setIcon(resize(path));
				        naImg.setText(file.getName());
					}
			   }
		}
		  //méthode qui permet de redimensionner l'image avec la meme taille que le JLabel
		public ImageIcon resize(String imgPath){
				   ImageIcon path = new ImageIcon(imgPath);
				   Image img = path.getImage();
				   Image newImg = img.getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH);
				   ImageIcon image = new ImageIcon(newImg);
				   return image;
		    }
	}
	
	//action du boutton cacher
	private class CacherAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			try {
			   if(e.getSource()==cacherImg) {
				   String nomImage = naImg.getText();
				   File inFile = new File(nomImage);
				   BufferedImage initImage = null;
                   initImage = ImageIO.read(inFile);
                   
                   String message = msgContent.getText();
                   
                   EncoderImage var = new EncoderImage(message,initImage); 
                   String bitMsg = var.monstring(message);
                   if (var.verifPng(inFile)) {
                       BufferedImage newImage = var.encodeImage(bitMsg,initImage);
                       String nomImageEncoder = nomImg2.getText();
                       File finalImage = new File(nomImageEncoder);
                       ImageIO.write(newImage,"png",finalImage);
                       String lechemin = finalImage.getAbsolutePath();
                     
					   //String lechemin = var.createImg(newImage);
                       //msgContent.setText("Votre image a bien ete encoder sous : " + lechemin);
                       JOptionPane.showMessageDialog(null,"Votre image a bien ete encoder sous : " + lechemin);
			       }
			   }
			} catch (ImageExtensionException er) {
                //msgContent.setText(er.getMessage());
                JOptionPane.showMessageDialog(null,er.getMessage(),"ERREUR",JOptionPane.WARNING_MESSAGE );
            } catch (IOException e1) {
                //msgContent.setText("Impossible d'ouvrir l'image");
            	JOptionPane.showMessageDialog(null,"Impossible d'ouvrir l'image","ERREUR",JOptionPane.WARNING_MESSAGE );
            }
		}
	}
    
	//action du boutton reni3
  	public class Reni3Action implements ActionListener {

  		public void actionPerformed(ActionEvent e) {
  			
  			if (e.getSource() == reni3) {
  			     nomImg2.setText("");
  			     msgContent.setText("");
  			     naImg.setText("");
  			     l.setIcon(null);
  			}
  		}

  	}
	
 /*----------------------------------------------------------------------------*/
  	
    //action du boutton OPbout
  	private class ChoixImage2Action implements ActionListener {
  		
  		public void actionPerformed(ActionEvent e) {
  			
  				if(e.getSource()==OPbout) {
  					
  					JFileChooser fileChooser = new JFileChooser();
  					fileChooser.setCurrentDirectory(new File("."));
  				
  					int res = fileChooser.showOpenDialog(null); 
  					
  					if(res == JFileChooser.APPROVE_OPTION) { 
  					    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
  				        String path = file.getAbsolutePath();
  				        affImgEncode.setIcon(resize(path));
  				        naImg2.setText(file.getName());
  					}
  			   }
  		}
  		  //méthode qui permet de redimensionner l'image avec la meme taille que le JLabel
  		public ImageIcon resize(String imgPath){
  				   ImageIcon path = new ImageIcon(imgPath);
  				   Image img = path.getImage();
  				   Image newImg = img.getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH);
  				   ImageIcon image = new ImageIcon(newImg);
  				   return image;
  		    }
  	}
  	
  	//action du boutton DecoBoutt
  	private class DecoderAction implements ActionListener {
  		
  		public void actionPerformed(ActionEvent e) {
  			
  			try {
  			if(e.getSource()==DecoBoutt) {
  				String nomImg = naImg2.getText();
  				File imageEncode = new File(nomImg);
  				
  				String filePath = imageEncode.getAbsolutePath();
  				File outFile = new File(filePath);
				BufferedImage image = null;

				image = ImageIO.read(outFile);

				DecoderImage var = new DecoderImage(null, image);
				
				String bitMessage = var.decodeMessage(image);
				affMsgSec.setText(var.getMessage(bitMessage));
  			}
  			} catch (IOException e1) {
                //affMsgSec.setText("Impossible d'ouvrir l'image");
  				JOptionPane.showMessageDialog(null,"Impossible d'ouvrir l'image","ERREUR",JOptionPane.WARNING_MESSAGE );
            }
  		}
  	}
  	
  //action du boutton reni4
  	public class Reni4Action implements ActionListener {

  		public void actionPerformed(ActionEvent e) {
  			
  			if (e.getSource() == reni4) {
  			     affMsgSec.setText("");
  			     naImg2.setText("");
  			     affImgEncode.setIcon(null);
  			}
  		}

  	}
  	


	
}