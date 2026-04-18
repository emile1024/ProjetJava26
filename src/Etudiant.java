public class Etudiant {

    // 🔹 Liste des cours valides
    public static final String[] COURS_VALIDES = {
            "PRA", "BDM", "BDA", "STA", "IIA", "SRD", "OIN"
    };

    // 🔹 Méthode pour vérifier si le cours est valide
    public static boolean estCoursValide(String cours) {
        for (int i = 0; i < COURS_VALIDES.length; i++) {
            if (COURS_VALIDES[i].equalsIgnoreCase(cours)) {
                return true;
            }
        }
        return false;
    }

    // 🔹 Méthode pour normaliser (mettre en majuscule)
    public static String normaliserCours(String cours) {
        return cours.toUpperCase();
    }

    // 🔹 Méthode pour vérifier la note
    public static boolean estNoteValide(double note) {
        return note >= 0 && note <= 100;
    }

    // 🔹 Attributs (encapsulation)
    private String prenom;
    private String nom;
    private String cours;
    private double note;

    // 🔹 Constructeur
    public Etudiant(String prenom, String nom, String cours, double note) {
        this.prenom = prenom;
        this.nom = nom;
        this.cours = normaliserCours(cours); // on normalise directement
        this.note = note;
    }

    // 🔹 Getters
    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getCours() {
        return cours;
    }

    public double getNote() {
        return note;
    }

    // 🔹 Setters
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCours(String cours) {
        this.cours = normaliserCours(cours);
    }

    public void setNote(double note) {
        this.note = note;
    }

    // 🔹 Calcul de la moyenne (simple pour étape 1)
    public double calculerMoyenne() {
        return note;
    }

    // 🔹 Affichage
    public void afficher() {
        System.out.println("Prenom : " + prenom +
                " | Nom : " + nom +
                " | Cours : " + cours +
                " | Note : " + note +
                " | Moyenne : " + calculerMoyenne());
    }

    // 🔹 Sauvegarde (format CSV)
    @Override
    public String toString() {
        return prenom + ";" + nom + ";" + cours + ";" + note + ";" + calculerMoyenne();
    }
}