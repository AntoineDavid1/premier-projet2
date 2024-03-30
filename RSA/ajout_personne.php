<?php
include 'rsa.php';
$dsn = "mysql:host=localhost;dbname=projet_perso";
$login = "root";
$mdp = "";
$bd = new PDO($dsn, $login, $mdp); 
$bd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

extract($_POST);
$crypte = encrypt($mot_de_passe);
echo "mot de passe crypter:<br>";
echo $crypte."<br>";
$decrypte = decrypt($crypte);
echo "mot de passe Decrypter:<br>";
echo $decrypte;
$sql = "INSERT INTO personne(nom,prenom,email,motDePasse) VALUE(:nom,:prenom,:email,:mdp)";
$requette = $bd->prepare($sql);
$requette->bindValue(":nom",$nom);
$requette->bindValue(":prenom",$prenom);
$requette->bindValue(":email",$email);
$requette->bindValue(":mdp",$crypte);
$requette->execute();
?>
<a href="Test_RSA.php">Retour vers le formulaire</a>