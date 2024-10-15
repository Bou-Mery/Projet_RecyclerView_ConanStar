# ConanStars

## Description

**ConanStars** est une application Android dédiée à la gestion et à l'affichage d'une liste de personnages de l'univers de **Detective Conan**. Elle permet aux utilisateurs de consulter les détails de chaque personnage, de noter leurs performances, et de visualiser des images associées. L'application offre une interface conviviale et dynamique, enrichie par des animations pour une expérience utilisateur immersive.

## Fonctionnalités

- **Écran de démarrage animé** : Affichage animé de plusieurs étoiles avec des effets de rotation, de redimensionnement, de translation et de fondu, accompagnés d'effets lumineux et de gloire sur le nom de l'application.
  
- **Affichage de la liste des personnages** : Utilisation d'un `RecyclerView` pour afficher efficacement une liste de personnages avec leurs images, noms et notes.

- **Détail des personnages** : En cliquant sur un personnage, un dialogue s'ouvre permettant de visualiser et de mettre à jour la note du personnage.

- **Évaluation des performances** : Les utilisateurs peuvent noter chaque personnage à l'aide d'un `RatingBar`. Une confirmation s'affiche lors de la mise à jour de la note.

- **Recherche et filtrage** : Barre de recherche intégrée dans la `Toolbar` permettant de filtrer les personnages par nom.

- **Partage** : Option de partage du contenu via les applications compatibles installées sur l'appareil.

- **Animations et effets visuels** : Intégration d'animations pour améliorer l'expérience utilisateur lors de la navigation dans l'application.

## Structure du Projet

Le projet est organisé comme suit :

- **activities/** :
  - `SplashActivity.java` : Gère l'écran de démarrage avec des animations.
  - `ListActivity.java` : Affiche la liste des personnages et gère les interactions de l'utilisateur.

- **adapter/** :
  - `StarAdapter.java` : Adaptateur pour le `RecyclerView` affichant les personnages, incluant les fonctionnalités de filtrage et de mise à jour des notes.

- **bean/** :
  - `Star.java` : Classe représentant un personnage avec des attributs tels que le nom, l'image et la note.

- **dao/** :
  - `IDao.java` : Interface générique pour la gestion des données des personnages.

- **service/** :
  - `StarService.java` : Implémentation de l'interface `IDao` pour gérer les données des personnages dans une liste.

- **res/** :
  - **layout/** :
    - `activity_main.xml` : Layout pour `SplashActivity`.
    - `activity_list.xml` : Layout pour `ListActivity`.
    - `star_item.xml` : Layout pour chaque élément de la liste des personnages.
    - `star_edit_item.xml` : Layout pour le dialogue de mise à jour de la note d'un personnage.
 
## Technologies Utilisées

- **Langage de programmation** : Java
- **IDE** : Android Studio
- **Version Android** : API 24+ (Android 7.0 Nougat)
- **Bibliothèques** :
  - **Glide** : Pour le chargement efficace des images.
  - **RecyclerView** : Pour l'affichage optimisé des listes.
  - **CircleImageView** : Pour afficher des images circulaires.


## Installation

**Cloner le dépôt du projet** :

    ```bash
    git clone https://github.com/votre-utilisateur/ConanStar.git
    ```

## Démonstration Vidéo

Voici une courte démonstration de l'application :

[Visionner la démonstration](#) <!-- Remplacez "#" par le lien de la vidéo de démonstration -->

## Utilisation

1. **Écran de démarrage** :
   - Lors du lancement de l'application, un écran de démarrage animé s'affiche avec des étoiles animées et le nom de l'application.

2. **Liste des personnages** :
   - Après l'écran de démarrage, vous accédez à la liste des personnages.
   - Chaque élément affiche l'image, le nom et la note du personnage.

3. **Recherche** :
   - Utilisez la barre de recherche dans la `Toolbar` pour filtrer les personnages par nom.

4. **Mise à jour des notes** :
   - Cliquez sur un personnage pour ouvrir un dialogue.
   - Ajustez la note à l'aide du `RatingBar` et confirmez la mise à jour.

5. **Partage** :
   - Utilisez l'option de partage dans le menu pour partager le contenu de l'application via d'autres applications installées sur votre appareil.


## Auteur

Ce projet a été réalisé par **[BOUKHRAIS Meryem]** .

