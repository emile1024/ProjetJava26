import java.io.FileWriter;
import java.io.IOException;

public class GestionEtudiants {

    private Etudiant[] etudiants;
    private int nbEtudiants;

    // Constructeur
    public GestionEtudiants(int capacite) {
        etudiants = new Etudiant[capacite];
        nbEtudiants = 0;
    }

    // Ajouter un étudiant
    public void ajouterEtudiant(Etudiant e) {
        if (nbEtudiants < etudiants.length) {
            etudiants[nbEtudiants] = e;
            nbEtudiants++;
        } else {
            System.out.println("❌ Liste pleine !");
        }
    }

    // Afficher tous les étudiants
    public void afficherEtudiants() {
        if (nbEtudiants == 0) {
            System.out.println("Aucun étudiant.");
            return;
        }

        for (int i = 0; i < nbEtudiants; i++) {
            etudiants[i].afficher();
        }
    }

    // Etape 3

    // Rechercher un étudiant

    public int rechercherEtudiant(String nom) {
        for (int i = 0; i < nbEtudiants; i++) {
            if (etudiants[i].getNom().equalsIgnoreCase(nom)) {
                return i; // position trouvée
            }
        }
        return -1; // non trouvé
    }

    // Supprimer un étudiant

    public void supprimerEtudiant(String nom) {
        int index = rechercherEtudiant(nom);

        if (index == -1) {
            System.out.println("❌ Étudiant non trouvé.");
            return;
        }

        // décaler les éléments
        for (int i = index; i < nbEtudiants - 1; i++) {
            etudiants[i] = etudiants[i + 1];
        }

        nbEtudiants--;

        System.out.println("✅ Étudiant supprimé.");
    }

    // Modifier un étudiant

    public void modifierEtudiant(String nom, String nouveauCours, double nouvelleNote) {
        int index = rechercherEtudiant(nom);

        if (index == -1) {
            System.out.println("❌ Étudiant non trouvé.");
            return;
        }

        etudiants[index].setCours(nouveauCours);
        etudiants[index].setNote(nouvelleNote);

        System.out.println("✅ Étudiant modifié.");
    }


    // Etape 4

    // Trier par moyenne

    public void trierParMoyenne() {

        for (int i = 0; i < nbEtudiants - 1; i++) {

            for (int j = 0; j < nbEtudiants - 1 - i; j++) {

                if (etudiants[j].calculerMoyenne() < etudiants[j + 1].calculerMoyenne()) {

                    // échange
                    Etudiant temp = etudiants[j];
                    etudiants[j] = etudiants[j + 1];
                    etudiants[j + 1] = temp;
                }
            }
        }

        System.out.println("✅ Étudiants triés par moyenne (décroissant).");
    }

    // Etape 5

    public void sauvegarderDansFichier(String nomFichier) {

        try {
            FileWriter writer = new FileWriter(nomFichier);

            for (int i = 0; i < nbEtudiants; i++) {
                writer.write(etudiants[i].toString() + "\n");
            }

            writer.close();
            System.out.println("✅ Données sauvegardées dans le fichier.");

        } catch (IOException e) {
            System.out.println("❌ Erreur lors de la sauvegarde.");
        }
    }
}