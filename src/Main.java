import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestionEtudiants gestion = new GestionEtudiants(20);

        int choix;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher les étudiants");
            System.out.println("3. Modifier un étudiant");
            System.out.println("4. Supprimer un étudiant");
            System.out.println("5. Trier par moyenne");
            System.out.println("0. Quitter");

            System.out.print("Choix : ");
            choix = sc.nextInt();
            sc.nextLine(); // vider buffer

            switch (choix) {

                case 1:
                    System.out.print("Prenom : ");
                    String prenom = sc.nextLine();

                    System.out.print("Nom : ");
                    String nom = sc.nextLine();

                    String cours;
                    do {
                        System.out.print("Cours : ");
                        cours = sc.nextLine();

                        if (!Etudiant.estCoursValide(cours)) {
                            System.out.println("❌ Cours invalide.");
                        }

                    } while (!Etudiant.estCoursValide(cours));

                    cours = Etudiant.normaliserCours(cours);

                    double note;
                    do {
                        System.out.print("Note : ");
                        note = sc.nextDouble();

                        if (!Etudiant.estNoteValide(note)) {
                            System.out.println("❌ Note invalide.");
                        }

                    } while (!Etudiant.estNoteValide(note));

                    sc.nextLine();

                    gestion.ajouterEtudiant(new Etudiant(prenom, nom, cours, note));
                    break;

                case 2:
                    gestion.afficherEtudiants();
                    break;

                case 3:
                    System.out.print("Nom à modifier : ");
                    String nomMod = sc.nextLine();

                    System.out.print("Nouveau cours : ");
                    String newCours = sc.nextLine();

                    System.out.print("Nouvelle note : ");
                    double newNote = sc.nextDouble();
                    sc.nextLine();

                    gestion.modifierEtudiant(nomMod, newCours, newNote);
                    break;

                case 4:
                    System.out.print("Nom à supprimer : ");
                    String nomSup = sc.nextLine();

                    gestion.supprimerEtudiant(nomSup);
                    break;

                case 5:
                    gestion.trierParMoyenne();
                    break;

                case 0:
                    System.out.println("Fin du programme.");
                    break;

                default:
                    System.out.println("❌ Choix invalide.");
            }

        } while (choix != 0);

        sc.close();
    }
}