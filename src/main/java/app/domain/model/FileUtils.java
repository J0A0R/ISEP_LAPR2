package app.domain.model;

import java.io.*;

public class FileUtils {

    /**
     * import file.
     * @param ficheiro
     * @return lista Do Ficheiro
     */
    public static Company ler(String ficheiro) {
        Company listaDoFicheiro;

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(ficheiro));
            try {
                listaDoFicheiro = (Company) in.readObject();
            } finally {
                in.close();
            }
            return listaDoFicheiro;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Company();
        }
    }

    /**
     * export file.
     * @param lista list
     * @param ficheiro file name
     * @return
     */
    public static boolean gravar(Company lista, String ficheiro) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ficheiro));
            try {
                out.writeObject(lista);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
