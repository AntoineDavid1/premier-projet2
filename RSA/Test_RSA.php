<?php
include 'rsa.php';
$dsn = "mysql:host=localhost;dbname=projet_perso";
$login = "root";
$mdp = "";
$bd = new PDO($dsn, $login, $mdp); 
$bd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test RSA</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Formulaire de test des Fonction RSA</h2>
    <form action="ajout_personne.php" method="post">
        <div class="form-group">
            <label for="nom">Nom :</label>
            <input type="text" class="form-control" name="nom" id="nom">
        </div>
        <div class="form-group">
            <label for="prenom">Prénom :</label>
            <input type="text" class="form-control" name="prenom" id="prenom">
        </div>
        <div class="form-group">
            <label for="email">Email :</label>
            <input type="email" class="form-control" name="email" id="email">
        </div>
        <div class="form-group">
            <label for="mot_de_passe">Mot de passe :</label>
            <input type="password" class="form-control" name="mot_de_passe" id="mot_de_passe">
        </div>
        <button type="submit" class="btn btn-primary">Envoyer</button>
    </form>
</div>
<table>
    <?php
    $sql = "SELECT nom,prenom,email,motDePasse FROM personne";
    $requette = $bd->prepare($sql);
    $requette->execute();
    $personnes = $requette->fetchAll(PDO::FETCH_ASSOC);
    echo '<table>';
    echo '<thead>';
    echo '<tr><td>Nom</td> <td>prenom</td> <td>Email</td> <td>Mot De passe</td> </tr>';
    echo '</thead>';
    echo '<tbody>';
    foreach($personnes as $personne){
        echo '<tr>';
        foreach($personne as $key=>$info_personne){
            if($key == "motDePasse"){
                echo '<td> MDP crypté: '.$info_personne.'<br>';
                echo 'MDP decrypté: '.decrypt($info_personne).'</td>';
            }
            else{
                echo '<td>'.$info_personne.'</td>';
            }
        }
        echo '</tr>';
    }
    echo '</tbody>';
    echo '</table>';
    ?>
</table>
<!-- Bootstrap JS (facultatif si vous n'utilisez pas les fonctionnalités JavaScript de Bootstrap) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>