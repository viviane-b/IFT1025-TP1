# TP1 - IFT 1025

![](https://com.medecine.umontreal.ca/wp-content/themes/departements/images/logo/logo-udem.png)

Projet : Gestion d'une guilde
=============================

Ce projet est à faire **seul** ou en équipe de **deux**. **Aucune** équipe de 3 ne sera tolérée pour ce projet. Si lors de la remise il y a trois noms inscrits et que nous n’y étions pas au courant, **vous serez pénalisés** sur votre note finale.

Mise en situation.
------------------

Le son du cocher vous prévenant de votre arrivée imminente vous tire des bras de Morphée. Cela fait maintenant 3 jours que vous voyagez et ce n'est qu'à présent que vous réalisez que ce travail dont vous rêvez depuis tout.e petit.e est enfin à porter de main. Plus que jamais, vous sentez que vous êtes prêt.e à affronter ce que la vie vous réserve. Vous avez toujours voulu être programmeur informatique à la glorieuse _Guilde des Programmes Unis_ (_GPU_) et rien ne peut plus vous en empêcher!  
...  
Une fois installé.e, vous vous rendez au GPU afin de commencer votre première journée. C'est à ce moment que vous apprenez que votre mandat sera difficile, car le **système de communication** entre votre succursale et le siège social est à refaire complètement. Celui-ci s'occupe de traiter les commandes du siège social, c'est-à-dire **l'embauche de Héros**, **l'entraînement de Héros**, **l'affectation de quêtes**, **la répartition du butin** et **l'achat d'armures**. Si cela n'était pas suffisant, vous apprenez que vous n'avez que 3 semaines pour rendre un produit fini! Vous avez déjà trop sacrifié.e pour cet emploi, impossible de faire marche arrière. Il vous faudra affronter vos peurs et vous surpasser, mais vous êtes confiant.e. Vous vous retroussez les manches et vous poursuivez la lecture du dossier.

Fonctionnement final de l’application
-------------------------------------

L’application devra lire et traiter les instructions définies dans [instructions](#instructions).

Les instructions
----------------

1.  `buy-hero`
    Format de l'instruction:
    *   Nom du héro {string}
    *   Catégorie (common=0, uncommon=1, rare=2, epic=3, legendary=4) {int}
    *   Coût en argent {double}
    *   Coût en armures {int}
    *   Points de vie {double}
  
3.  `buy-armure`
    Format de l'instruction:
    *   Nombre d'armures achetées {int}
    *   Prix par armure {int}
  
5.  `do-quest`
    Format de l'instruction:
    *   Catégorie (common=0, uncommon=1, rare=2, epic=3, legendary=4) {int}
    *   Coût en points de vie {double}
    *   Récompense en argent {int}
    *   Récompense en armures {int}
  
7.  `train-hero`
    Format de l'instruction:
    *   Nom du héro {string}

Aperçu
------

Dès le début, le programme doit être exécuté avec des commandes passées en paramètre c.-à-d.: args. De plus, plusieurs types de commandes peuvent être passé et avec **plusieurs** variables! Le programme devra reconnaitre le niveau de difficulté de la quête et envoyer le bon héros. Finalement, le programme devra permettre l'amélioration des héros en échange d'armure et d'argent.

Voici un exemple d'utilisation:

1.  buy-hero:Arthur,3,**50.19**,5,10.5
2.  buy-armor:2,5
3.  do-quest:2,**1.5**,6,3
4.  train-hero:Arthur
5.  Une quête ne peut être résolu que par un héros du même niveau.  
      **Si on ne remplit pas ce critère, on choisit le héros qui le suit en ordre de puissance.  
      Donc si on n'a pas un niveau 3, on prend le niveau 4 suivant.**

  **Nottez que les paramètres dans les commandes sont sérarés par des virgules.**

Lorsqu'on achète un héros, il faut donc remplir certaines contraintes comme le coût en argent et en armure.

Acheter de l'armure est un critère primordial. En effet, à moins d'avoir complété une quête avec succès, il n'existerait pas d'autres moyennes pour en procurer. Le prix des armures/unité sera l'objet d'une des paramètres que le programme devra savoir gérer.

Le programme doit obligatoirement accepter les quêtes qu'on lui passe. De plus, le niveau des héros envoyés devra être le même que la quête. S'il existe des héros remplissant ce critère, ils doivent être envoyés en priorité. S'il n'existe pas de héros de même niveau, c'est alors qu'on peut aller chercher un héros qui suit le niveau en rang. Le programme donc devra faire un triage au sein d'une **liste** de héros.

De plus, à chaque fois qu'un héros est envoyé en quête, il perd un peu de ses points de vie. S'il tombe en dessous ou égal à zéro, la quête échoue et le héros est enlevé de la liste.

Lorsqu'on améliore un héros, le programme devra le chercher selon l'ID qu'on met en paramètre. Si le héros en question n'existe pas alors on renvoie un message d'erreur pour le signaler à l'utilisateur. Par la suite, il faut vérifier qu'on a assez d'argent et d'armure en inventaire pour pouvoir l'améliorer sinon on renvoie message d'erreur pour le signaler.

Structure du programme
----------------------

Avant de commencer à programmer, il faudra mettre en place la structure de votre programme. Pour ce devoir, nous vous imposerons plus de liberté dans la structure de celui-ci. Pourquoi ? Parce qu’il est important que vous soyez en mesure d’écrire un code structuré par vous-même.

Nous vous demandons uniquement d’avoir quelques fichiers et quelques fonctions. Vous devrez enovoyer ces fichier **.java** pour votre remise:

*   Un fichier pour votre code de départ (`Main.java`)
*   Un fichier de gestion qui gère l'inventaire (`Bank`)
*   Deux fichier de gestion pour les commandes (`GuildCommand.java & GuildCommandSystem.java`)
*   Un fichier pour chaque niveau de héros
*   Un fichier permettant le lancement des quêtes(`Quete.java`)
*   Un fichier qui regroupe toutes les informations en lien avec le guild(`Guild.java`)

 **Notez que vos classes ne devraient pas êtres lourds si vous subdivisez bien votre programme.**

Fonctionnement
--------------

Lorsqu'on démarre le programme, on le fait avec des arguments en paramètre(args). Ces arguments sont automatiquement mis en tableau. Le programme devra prendre chacune de ces commandes et l'exécuter avec le résultat attendu.

### Exemple:

#### exemple 1

    
        Input:
        guild:100.0,10 buy-hero:Berserker,2,52.5,6,30.5 do-quest:2,5.3,60,3
        Output:
        Guild Bank account: 107.5 gold & 7 armours
        Heroes:
        -Berserker: level=2, HP=25.2
      

#### exemple 2

    
        Input:
        guild:100.0,10 buy-hero:Berserker,2,52.5,6,30.5 buy-hero:Zorro,1,36.2,2,15.0 do-quest:2,5.3,60,3 train-hero:Zorro
        Output:
        Guild Bank account: 23.3 gold & 2 armours
        Heroes:
        -Berserker: level=2, HP=25.2
        -Zorro: level=2 HP=22.5
      

#### exemple 3

    
        Input:
        guild:100.0,10 buy-hero:Rogue,3,73.5,7,40.7 train-hero:Rogue do-quest:2,5.3,60,3 train-hero:Zorro
        Output:
        Guild Bank account: 23.3 gold & 6 armours
        Heroes:
        -Rogue: level=3, HP=36.9
        Erreur:
        -Il vous manque de l'argent et/ou des armures pour améliorer Rogue.
        -Le héros au nom de Zorro n'apparêt pas dans la liste
      

Pour calculer le prix que prend une amélioration, il faut calculer: **20\*ln(niveau + 10)**  
Un calcul semblable est effectué pour les armures où on calcule le "roof" de : **ln(niveau + 10)**  
Pour calculer les points de vie du héros, on fait: **maxHP\*1.5** de plus, ça permet au héros de regagner des ponts de vie.  
Finalement, pour calculer les points de vie perdu si le héros ne correspond pas au niveau de la quête: **vie\_enlevée - (niveau\_actuelle - niveau\_origine) \* 1.5**

Plagiat
-------

Sachez que le plagiat entraine directement la note de **0** et mène à une **note dans votre dossier**. Tout partage de code ou copie de code qui n’est pas le vôtre, qu’il soit sous forme de texte, de photo ou tout autre format, est considéré comme du plagiat. Lors de la correction, nous allons utiliser plusieurs méthodes pour détecter le plagiat. Ne vous essayez pas, les conséquences seront sévères.

Vous pouvez consulter [le site de l’université](https://integrite.umontreal.ca/accueil/) pour plus d’informations

Remise
------

Remettez tout votre code, pour les 4 itérations ainsi que les données dans le même dossier sous format compressé .zip avec les noms des membres de l’équipe comme ceci: `projet_PrenomNom1_PrenomNom2.zip` (où PrenomNom1 est votre nom ex: _MathisLaroche_ et PrenomNom2 est celui de votre coéquipier.ère ex: _Enric Soldevila_). Remettez-le tout sur studium sous le devoir qui est affiché.

Pour compresser le fichier:

*   MacOS: vous devriez avoir le bouton compresser lorsques vous sélectionnez les fichiers à compresser ([https://support.apple.com/en-mz/guide/mac-help/mchlp2528/mac](https://support.apple.com/en-mz/guide/mac-help/mchlp2528/mac)).
*   Windows: je recommande WinRAR qui est un logiciel gratuit très répandu ([https://www.win-rar.com/start.html?&L=10](https://www.win-rar.com/start.html?&L=10) oui leur site fait vieux, mais il s’agit du bon site).

Si vous avez des questions sur des instructions du devoir, n’hésitez pas à les poser sur le forum ! Il est possible que je fasse des modifications à l’énoncé pour clarifier les consignes, je vous le ferai savoir si c’est le cas.

Correction
----------

Les exercices sont à faire en équipe de **2**. Pour vous évaluer, nous allons nous fier à ces critères de correction :

*   50% **Fonctionnement du code** Votre code va être testé avec plusieurs valeurs d’entrée. Si certaines réponses ne sont pas valides, vous allez perdre des points. En revanche, si votre code fonctionne à merveille, vous allez avoir tous vos points ! Je vous conseille de bien tester votre programme.
    
*   10% **Compilation :** Votre programme arrive-t-il à passer la compilation ? Vous devez vous assurer que le code qu'on vous passe fonctionne avec le reste de votre programme tout restant inchangé. En effet, le squelette du programme qu'on vous fournit est sur quoi devra se baser le reste de votre code.
    
*   40% **Beauté du code** Plus votre code est simple et facile à lire, plus vous allez avoir de points ! Voici des éléments qui contribuent à la beauté d’un code :
    
    *   Est-ce que vos noms de variable sont descriptifs de leur utilisation ?
    *   Est-ce que vous aérez vos expressions (par exemple, mettre des espaces avant et après un `=`) ?
    *   Utilisez-vous des variables inutiles ? Évitez-vous la répétition de code ?
    *   Est-ce que votre code est concis ?
    *   Votre code est-il facilement adaptable à d’autres situations ? (Par exemple, peut-on rapidement changer le nombre de vies de départ…)
*   5% **Points bonus** Points bonus pour le rajout d’un élément WOW
    

Le travail doit être remis le 5 mars à minuit (11:59 pm) au plus tard!
