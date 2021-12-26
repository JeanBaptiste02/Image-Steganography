# PROJET S3 METADONNEES DES FICHIERS IMAGES ET STEGANOGRAPHIE PAR DAMODARANE.JEAN-BAPTISTE et ELUMALAI.SRIGURU

## Introduction
Ce projet est fait par <b> DAMODARANE Jean-Baptiste et ELUMALAI Sriguru </b>, étudiants en Licence 2 Informatique en groupe C.
<br></br>
Le projet se base sur le concept de <b>  steganographie </b>, dont l'objectif est de dissimuler un message dans un fichier image de type .png ou .jpeg et sur les métadonnées des fichiers images.

**La version java**
<br></br>
Pour ce projet, nous choisi avec la version javaSE-11

## Utilisation et exécutions en mode CLI

Ce projet peut être exécuté en mode CLI sur la console à l'aide d'un <b>fichier jar</b>.
<br></br>
Ouvrir votre console Linux.
<br></br>
le ficher se nomme : myCli.jar
<br></br>
En mode CLI, l'utilisateur peut :
<br></br>

1. explorer un dossier, dont le nom sera passé en argument ou l'utilisateur devra mettre un '.'
<br></br>
        commande à taper : `java -jar myCli.jar -d .`  ou `java -jar myCli.jar -d images`

2. afficher les métadonnées d'un fichier image dont le nom sera passé en argument
<br></br>
        commande à taper : `java -jar myCli.jar nom_image.png`

3. cacher un message/texte dans une image, le message et le nom de l'image seront passés en argument
<br></br>
        commande à taper : `java -jar myCli.jar -f nom_image.png -s "message_secret"`

4. extraire le message dissimulé dans l'image, le nom de l'image contenant le message caché sera passé en argument
<br></br>
        commande à taper : `java -jar myCli.jar -f nom_image_encode.png -e"`

5. pour avoir des aides
<br></br>   
        commande à taper : `java -jar myCli.jar -h` ou `java -jar myCli.jar --help`


## Utilisation et exécutions en mode GUI

Ce projet peut être exécuté en mode GUI à l'aide d'un <b>fichier jar</b>.
<br></br>
le ficher se nomme : myGui.jar
<br></br>

Pour lancer la fenêtre, veuillez taper la commande : `java -jar myGui.jar`
<br></br>
1. Pour explorer un dossier, l'utilisateur doit se placer dans l'onlget "Lister un repertoire", puis cliquer sur le boutton "choisissez un dossier' (pour choisir un dossier) et ensuite cliquer sur analyser
![image](https://user-images.githubusercontent.com/91695685/147091029-71debde3-2ab0-41b1-8603-93771f3d145f.png)

<br></br>

2. Pour afficher les metadonnees d'une image, l'utilisateur doit se placer dans l'onglet "Metadonnees", puis choisir un fichier image et ensuite examiner
![image](https://user-images.githubusercontent.com/91695685/147091137-e863be34-0429-47b1-a493-a2a8c9c1ae1d.png)

<br></br>

3. Pour encoder une image, l'utilisateur doit se placer dans l'onglet correspondant, puis choisir une image et taper nom de la nouvelle image qui va contenir le message. Ensuite taper le message secret et enfin appuyer sur le bouton cacher
![image](https://user-images.githubusercontent.com/91695685/147091253-4dca57d7-ab67-419a-8505-cd80b53321b8.png)

<br></br>

4. Pour decoder l'image, l'utilisateur doit se placer dans l'onglet correspondant, choisir le fichier image qui contient le message secret et appuyer sur le bouton decoder
![image](https://user-images.githubusercontent.com/91695685/147091328-41b617f3-78cd-4169-9708-a0314f231803.png)
