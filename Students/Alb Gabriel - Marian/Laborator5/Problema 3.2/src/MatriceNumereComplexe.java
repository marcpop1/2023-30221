import java.util.Arrays;

public class MatriceNumereComplexe {
    private NumarComplex[][] matrice;
    private int nrRanduri, nrColoane;
    public MatriceNumereComplexe(int nrRanduri, int nrColoane){
        matrice = new NumarComplex[nrRanduri][nrColoane];
        this.nrRanduri = nrRanduri;
        this.nrColoane = nrColoane;
    }

    public MatriceNumereComplexe(int nrRanduri, int nrColoane, NumarComplex[][] matrice){
        this.matrice = matrice.clone();
        this.nrRanduri = nrRanduri;
        this.nrColoane = nrColoane;
    }

    public int getNrRanduri() {
        return nrRanduri;
    }

    public int getNrColoane() {
        return nrColoane;
    }

    public NumarComplex[][] getMatrice() {
        return matrice;
    }

    public MatriceNumereComplexe adunare(MatriceNumereComplexe matrice){
        if(this.nrRanduri != matrice.getNrRanduri() || this.nrColoane != matrice.getNrColoane()) {
            System.out.println("Dimensiunile nu coincid");
            return new MatriceNumereComplexe(0, 0);
        }

        NumarComplex[][] rezultat = new NumarComplex[this.nrRanduri][this.nrColoane];

        for(int i = 0; i < this.nrRanduri; i++){
            for(int j = 0; j < this.nrColoane; j++){
                rezultat[i][j] = matrice.getMatrice()[i][j].adunare(this.matrice[i][j]);
            }
        }

        return new MatriceNumereComplexe(nrRanduri, nrColoane, rezultat);
    }

    public MatriceNumereComplexe scadere(MatriceNumereComplexe matrice){
        if(this.nrRanduri != matrice.getNrRanduri() || this.nrColoane != matrice.getNrColoane()) {
            System.out.println("Dimensiunile nu coincid");
            return new MatriceNumereComplexe(0, 0);
        }

        NumarComplex[][] rezultat = new NumarComplex[this.nrRanduri][this.nrColoane];

        for(int i = 0; i < this.nrRanduri; i++){
            for(int j = 0; j < this.nrColoane; j++){
                rezultat[i][j] = this.matrice[i][j].scadere(matrice.getMatrice()[i][j]);
            }
        }

        return new MatriceNumereComplexe(nrRanduri, nrColoane, rezultat);
    }

    public MatriceNumereComplexe inmultireScalar(int scalar){
        NumarComplex[][] rezultat = new NumarComplex[this.nrRanduri][this.nrColoane];

        for(int i = 0; i < this.nrRanduri; i++){
            for(int j = 0; j < this.nrColoane; j++){
                rezultat[i][j] = this.matrice[i][j].inmultireCuScalar(scalar);
            }
        }

        return new MatriceNumereComplexe(this.nrRanduri, this.nrColoane, rezultat);
    }

    public MatriceNumereComplexe inmultireMatrice(MatriceNumereComplexe matrice){
        if(this.nrRanduri != matrice.nrRanduri || this.nrColoane != matrice.nrColoane){
            System.out.println("Dimensiunile nu coincid");
            return new MatriceNumereComplexe(0, 0);
        }

        NumarComplex[][] rezultat = new NumarComplex[this.nrRanduri][this.nrColoane];

        for(int i = 0; i < this.nrRanduri; i++){
            for(int j = 0; j < this.nrColoane; j++){
                rezultat[i][j] = new NumarComplex(0, 0);
                for(int k = 0; k < this.nrRanduri && k < this.nrColoane && k < matrice.nrRanduri && k < matrice.nrColoane; k++){
                    rezultat[i][j] = rezultat[i][j].adunare(this.matrice[i][k].inmultireNumereComplexe(matrice.getMatrice()[k][j]));
                }
            }
        }

        return new MatriceNumereComplexe(this.nrRanduri, this.nrColoane, rezultat);
    }

    @Override
    public String toString() {
        String s ="";

        for(int i = 0; i < this.nrRanduri; i++){
            for(int j = 0; j < this.nrColoane; j++){
                s += matrice[i][j].toString() + " | ";
            }
            s += "\n";
        }

        return s;
    }
}
