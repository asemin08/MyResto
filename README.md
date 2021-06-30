# MyResto

## Fonctionalités
Application web et mobile permettant :
* Aux visiteurs de voir la carte
* Aux clients de commander en ligne
* Au gérant d'analyser les commandes en cours et faire un prévisionnel de commandes

## V1
Création d'une application web permettant :
* Aux visiteurs de voir la carte
* Aux clients de commander en ligne


## Application héberger
CLiquer sur [MyResto - Acceuil](http://vps-0c0ccce5.vps.ovh.net:8081/MyResto/)


<hr>

## Pré-requis
Version java : 11.0.0 <br>
Système de gestion de Base de donnée: MySQL <br>
Container web Tomcat : version 9.0


## Installation

1. **Récupéré le projet**
    * avec zip
        * Aller dans le projet [Github](https://github.com/Flav1-ann/MyResto).
        * Cliquer sur le bouton vert "code" puis télécharger le fichier zip.
        * Dans Windows extraire le fichier zip.
    * avec git
        * Ouvrir un terminale dans le dossier ou vous souhaiter avoir l'application
        * Copier/coller cette ligne dans le terminal `git clone https://github.com/Flav1-ann/MyResto.git`
    

2. **La base de donnée**
    * Allez dans le dossier MyResto
    * Utiliser le fichier `myresto.sql` pour généré la base de donnée


## Utiliser l'application

**Generer le war:** <br>
`mvn tomcat:run`

**Lancer l'application:**
* Allez dans le dossier MyResto/Presentation/target
* Copier/Coller le fichier `Presentation-1.0-SNAPSHOT.war` dans le répertoire 'webapps' de votre container web. Vous devez avoir une instance de tomcat en fonctionnement.
* Ouvrir la page web http://localhost:8080/Presentation dans votre navigateur


## Tests unitaires
Pour lancer les tests unitaires
> mvn test


## Les logs
Vous pouvez retrouver les logs dans les différents sous-dossers de MyResto dans un dossier nommer logs. <br>
Les logs sont ranger dans des dossiers en fonction du jour ou ils ont été générer.

