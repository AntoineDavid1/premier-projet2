<?php 


// Cette fonction vérifie si $nombre est premier
function estPremier($nombre) {
    return gmp_prob_prime($nombre) == 2;
}


//à partir du $phi cette nous retourne une clé publique
function generate_public_key($phi) {
    $inversible = [3,5,11,17,83,107,167,257,65537];
    foreach($inversible as $val){
        $e = $val;
        if(gmp_gcd($e, $phi)== 1) {
            return $e;
        }
        
    }
    
}
// Cette fonction retourne une paire de clé publique et sa clé privé à partir d'un p et q donnée
function generate_keypair() {
    //On prend un p et q élever pour un max de sécurité
    $p = 500699;
    $q = 51000343;
    $n = $p*$q;
    $phi = ($p - 1)*($q - 1);
    $e = generate_public_key($phi);
    //Cette fonction retourne l'inverse de la clé publique
    $d = gmp_invert($e, $phi);
    return [
        "paire"=>$n,
        "cles_public" => $e,
        "cles_priver"=>gmp_strval($d)
    ];
    
}
//cette fonction prend en paramètre un tableau de code ascii et les converti en lettre
function enlettre($tab){
    $tabR = [];
    foreach($tab as $val){
        $tabR[] = chr($val);
    }
    return implode ("",$tabR);
}
//Voici la fonction de cryptage
function encrypt($plaintext) {
    //On génaire une paire de clé publique et privé avec generate_keypair()
    $paire = generate_keypair();
    //On stoke la paire de clé privé dans un fichier "cleprv" et "paireN.txt" pour pouvoir la récupérer et l'utilisé pour le décryptage
    file_put_contents("cleprv",$paire['cles_priver']);
    file_put_contents("paireN.txt",$paire['paire']);
    //$n prend la paire de clé publique dans un tableau
    $n = [$paire["paire"],$paire["cles_public"]];
    // Découper les données en blocs de 1
    $tailleBloc = 1;
    $blocs = str_split($plaintext, $tailleBloc);
    $blocsChiffres = [];
    $chiffrer = [];
    //dans ce foreach on convertir les caaractère en code ascii puis on les crypte 
    foreach($blocs as $val){
                
            $char_int = ord($val);
            $chiffrer[] = $char_int;
        }
        foreach($chiffrer as $val){
            $crypte = bcpowmod($val, $n[1], $n[0]);
            $blocsChiffres[] = strval($crypte); 
        }
    //On retourne le code chiffré, chaque caractère séparé d'un espace comme repère
    return implode(" ",$blocsChiffres);
      
    }
    
   
    //echo $cryp;
    //var_dump(gettype($str));
   // var_dump($nom_manga);
   // $mangacryp = $nom_manga[0];
    

    



function decrypt($txtcrypt) {
    //comme on sait de chaque code ascii est séparer par un espace on les récupère dans un tableau grâce au séparateur 
    $tabcryp = explode(" ",$txtcrypt);
    //On récupère la paire de clé privé dans les fichier "paireN.txt" et "cleprv"
    $paire = file_get_contents("paireN.txt");
    $cle_prv = file_get_contents("cleprv");
    //on lance un foreache pour sur le tableau crypté
    foreach($tabcryp as $val){
        //la fonction bcpowmode va décrypté chaque code crypté
        $crypte = bcpowmod($val, $cle_prv, $paire);
        // on stocke chaque code décrypte dans un tableau  
        $blocsChiffres[] = strval($crypte); 
    }
    // On le met en lettre
    return enlettre($blocsChiffres);
} 
//Pour ce connecter à la base de donné et récupère des donnéinclude "credentials.php";
/*$bd = new PDO('pgsql:host=localhost;dbname=SAE',"postgres",'');
$bd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$bd->query("SET nameS 'utf8'");
$req = $bd->prepare("SELECT nom FROM personne");
$req->execute();
$nom_manga = $req->fetchAll(PDO::FETCH_COLUMN);
/*
cela retourne 
$nom_manga = [
    0 => 'Naruto',
    1 => 'One piece',
    2 => 'DBZ'
]
*/
// Pour tester on va coder, mettre modifier dans la BDD puis afficher le décodage de Naruto
/*echo "avant le cryptage/////".$nom_manga[0];
$str = $nom_manga[0];
$cryp = encrypt($str);
echo "////après le cryptage////".$cryp;
$req2 = $bd->prepare("UPDATE personne SET nom = :nom   where id_personne = 1;");
$req2->bindValue("nom",$cryp);
$req2->execute();
$req3 = $bd->prepare("SELECT nom FROM personne");
$req3->execute();
$nom_manga2 = $req3->fetchAll(PDO::FETCH_COLUMN);

echo "////après le décryptage/////".decrypt($cryp);*/

?>


