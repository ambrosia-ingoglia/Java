import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Library {
    int lsize = 0;
    Book library[] = new Book[66];
    int size = 66;

    public Library() {
        for (int i = 0; i < size; i++) {
            library[i] = new Book();
        }
    }

    public void lib() {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("HSBooks.csv"));
            line = br.readLine();
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] bk = line.split(splitBy);
                library[i].setStatus(bk[0]);
                library[i].setTitle(bk[1]);
                library[i].setAuthor(bk[2]);
                library[i].setIsbn(bk[3]);
                library[i].setPublisher(bk[4]);
                i++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (library[i].getTitle() != null) {
                if (library[i].getTitle().contains(title)) {
                    library[i].showDetails();
                }
            }
        }
    }

    public void SearchByAuthor(String author) {
        for (int i = 0; i < size; i++) {
            if (library[i].getAuthor() != null) {
                if (library[i].getAuthor().contains(author)) {
                    library[i].showDetails();
                }
            }
        }
    }

    public void SearchByIsbn(String isbn) {
        for (int i = 0; i < size; i++) {
            if (library[i].getIsbn() != null) {
                if (library[i].getIsbn().contains(isbn)) {
                    library[i].showDetails();
                }
            }
        }
    }

    public int checkStatus(String book) {
        int in = 0;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(library[i].getIsbn(), book) == true) {
                if (Objects.equals(library[i].getStatus(), "out") == true) {
                    in = 1;
                }
            }
        }
        return in;
    }

    public void updateStatus(String book) throws IOException {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(library[i].getIsbn(), book) == true) {
                if (Objects.equals(library[i].getStatus(), "in") == true) {
                    library[i].setStatus("out");
                }
            }
        }
    }

    public void createReport() {

        try {
            FileWriter myWriter = new FileWriter("borrowedbooks.txt", false);
            for (int i = 1; i < size - 1; i++) {
                if (library[i].getStatus().equals("out") == true) {
                    myWriter.write(library[i].getTitle() + "\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote Report.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeBack() throws IOException {
        FileWriter myWriter = new FileWriter("HSBooks.csv", false);
        myWriter.write("Status,title,authors,isbn,publisher");
        myWriter.write("\n");
        for (int i = 0; i < size - 1; i++) {
            myWriter.write(
                    library[i].getStatus() + "," + library[i].getTitle() + "," + library[i].getAuthor() + ","
                            + library[i].getIsbn() + "," + library[i].getPublisher());
            myWriter.write("\n");
        }
        myWriter.close();
    }

}
