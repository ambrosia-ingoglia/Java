import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class studentList {
    List<List<String>> students = new ArrayList<List<String>>();

    public void stuList() {

        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("students.csv"));
            while ((line = br.readLine()) != null) {
                String[] bk = line.split(splitBy);
                List<String> student = new ArrayList<String>(bk.length);
                student.add(bk[0]);
                student.add(bk[1]);
                student.add(bk[2]);
                if (bk.length == 4) {
                    student.add(bk[3]);
                } else if (bk.length == 5) {
                    student.add(bk[4]);
                } else if (bk.length == 6) {
                    student.add(bk[5]);
                }
                students.add(student);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateStu(String book, String stud) {
        // List<List<String>> studentsupdate = new ArrayList<List<String>>();
        List<String> student = new ArrayList<String>();
        for (int i = 0; i < students.size(); i++) {
            if (Objects.equals(students.get(i).get(0), stud) == true) {

                student.addAll(students.get(i));
                student.add(book);
                students.set(i, student);
                System.out.println(students);
            }
        }
    }

    public int checkStudent(String stud) {
        int exist = 1;
        for (int i = 0; i < students.size(); i++) {
            if (Objects.equals(students.get(i).get(0), stud) == true) {
                exist = 0;
            } else if (students.get(i).size() == 6) {
                exist = 0;
            }
        }

        return exist;
    }

    public void searchStudent(String student) {
        String s = Character.toUpperCase(student.charAt(0)) + student.substring(1).toLowerCase();
        System.out.println(s);
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.get(i).size(); j++) {
                if ((Objects.equals(s, students.get(i).get(j)) == true)) {
                    System.out.println(students.get(i));
                }
            }
        }
    }

    public void createReport() {
        try {
            FileWriter myWriter = new FileWriter("studentbooks.txt", false);
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).size() == 4) {
                    myWriter.write(
                            students.get(i).get(0) + "," + students.get(i).get(1) + "," + students.get(i).get(3)
                                    + "\n");
                } else if (students.get(i).size() == 5) {
                    myWriter.write(
                            students.get(i).get(0) + "," + students.get(i).get(1) + "," + students.get(i).get(2)
                                    + "," + students.get(i).get(3) + "," + students.get(i).get(4)
                                    + "\n");
                } else if (students.get(i).size() == 6) {
                    myWriter.write(
                            students.get(i).get(0) + "," + students.get(i).get(1) + "," + students.get(i).get(2)
                                    + "," + students.get(i).get(3) + "," + students.get(i).get(4) + ","
                                    + students.get(i).get(5)
                                    + "\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeInfo() {
        try {
            FileWriter myWriter = new FileWriter("students.csv", false);
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).size() == 4) {
                    myWriter.write(
                            students.get(i).get(0) + "," + students.get(i).get(1) + "," + students.get(i).get(2)
                                    + "," + students.get(i).get(3)
                                    + "\n");
                } else if (students.get(i).size() == 5) {
                    myWriter.write(
                            students.get(i).get(0) + "," + students.get(i).get(1) + "," + students.get(i).get(2)
                                    + "," + students.get(i).get(3) + "," + students.get(i).get(4)
                                    + "\n");
                } else if (students.get(i).size() == 6) {
                    myWriter.write(
                            students.get(i).get(0) + "," + students.get(i).get(1) + "," + students.get(i).get(2)
                                    + "," + students.get(i).get(3) + "," + students.get(i).get(4) + ","
                                    + students.get(i).get(5)
                                    + "\n");
                } else {
                    myWriter.write(
                            students.get(i).get(0) + "," + students.get(i).get(1) + "," + students.get(i).get(2)
                                    + "\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeLoans() {
        try {
            FileWriter myWriter = new FileWriter("loans.csv", false);
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).size() == 4) {
                    LocalDate date1 = LocalDate.now();
                    LocalDate returnDate = date1.plusDays(14);
                    myWriter.write(
                            students.get(i).get(3) + "," + students.get(i).get(0) + "," + students.get(i).get(1) + ","
                                    + returnDate + "\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
