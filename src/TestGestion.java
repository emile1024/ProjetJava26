public class TestGestion {
    public static void main(String[] args) {

        GestionEtudiants gestion = new GestionEtudiants(10);

        gestion.ajouterEtudiant(new Etudiant("Jean", "Dupont", "PRA", 80));
        gestion.ajouterEtudiant(new Etudiant("Alice", "Martin", "BDM", 90));

        System.out.println("=== AVANT ===");
        gestion.afficherEtudiants();

        // Etape 3
        gestion.modifierEtudiant("Dupont", "STA", 95);

        System.out.println("\n=== APRES MODIFICATION ===");
        gestion.afficherEtudiants();

        gestion.supprimerEtudiant("Martin");

        System.out.println("\n=== APRES SUPPRESSION ===");
        gestion.afficherEtudiants();

        // ✅ Etape 4 (AU BON ENDROIT)
        System.out.println("\n=== APRES TRI ===");
        gestion.trierParMoyenne();
        gestion.afficherEtudiants();
    }
}