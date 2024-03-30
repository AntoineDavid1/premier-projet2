<?php

function Puissance($nombre, $puissance) {
    if ($puissance == 0) {
        return 1;
    }

    $res = 1;
    $current = $nombre;

    while ($puissance > 0) {
        if ($puissance % 2 == 1) {
            $res = multi($res, $current);
        }

        $current = multi($current, $current);
        $puissance = (int)($puissance / 2);
    }

    return $res;
}

function multi($a, $b) {
    $result = 0;

    while ($b > 0) {
        if ($b % 2 == 1) {
            $result = addition($result, $a);
        }

        $a = addition($a, $a);
        $b = (int)($b / 2);
    }

    return $result;
}

function addition($a, $b) {
    while ($b != 0) {
        $carry = $a & $b;
        $a = $a ^ $b;
        $b = $carry << 1;
    }

    return $a;
}
function multi2($s,$d){
    $i = 0;
    $res = 0;
    while($i<$d){
        $res += $s;
        $i += 1;
    }
    return $res;
}

function Puissance2($nombre, $puissance){
    $j = 0;
    $res = multi2($nombre,$nombre);
    if($puissance == 2){return $res;}
    while($j<$puissance-2){
        $res = multi2($res,$nombre);
        $j += 1;
    }
    return $res;
}



$tempsDebut = hrtime(true);
$startMemory = memory_get_usage();
$test = Puissance(5,10);
$endMemory = memory_get_usage();
$tempsfin = hrtime(true);
$memoryUsed = $endMemory - $startMemory;
$tempsexecution = ($tempsfin - $tempsDebut) / 1e9;
echo "Temps exécution Puissance()".$tempsexecution."En mémoire ".$memoryUsed."</br>";
$tempsDebut2 = hrtime(true);
$startMemory2 = memory_get_usage();
$test2 = Puissance2(5,10);
$endMemory2 = memory_get_usage();
$tempsfin2 = hrtime(true);
$memoryUsed2 = $endMemory2 - $startMemory2;
$tempsexecution1 = ($tempsfin2 - $tempsDebut2) / 1e9;
echo "Temps exécution Puissance2()".$tempsexecution1."En mémoire ".$memoryUsed2."</br>";
if($tempsexecution<$tempsexecution1){echo "la fonction puissance est meilleur";}
else{echo "la fonction puissance2 est meilleur";}
?>
