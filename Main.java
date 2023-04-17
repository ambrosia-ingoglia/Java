import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Library library = new Library();
        library.lib();
        studentList students = new studentList();
        students.stuList();
        String user;
        Scanner choice = new Scanner(System.in);
        do {
            System.out.println("Are you signing(in as a student or librarian) or signing out?");
            user = choice.nextLine();
            if ((Objects.equals(user, "Student") == true) || (Objects.equals(user, "student") == true)) {
                String stu;
                do {
                    System.out.println("What would you like to do? options are, search or stop");
                    stu = choice.nextLine();
                    if (Objects.equals(stu, "Search") == true || Objects.equals(stu, "search") == true) {
                        System.out.println("Search by Author, Isbn, or Title?");
                        String search = choice.nextLine();
                        if (Objects.equals(search, "Author") == true || Objects.equals(search, "author") == true) {
                            System.out.println("Enter the Author: ");
                            String author = choice.nextLine();
                            library.SearchByAuthor(author);
                        } else if (Objects.equals(search, "Title") == true || Objects.equals(search, "title") == true) {
                            System.out.println("Enter the Title: ");
                            String title = choice.nextLine();
                            library.SearchByTitle(title);
                        } else if (Objects.equals(search, "isbn") == true || Objects.equals(search, "Isbn") == true) {
                            System.out.println("Enter the isbn: ");
                            String isbn = choice.nextLine();
                            library.SearchByIsbn(isbn);

                        } else {
                            System.out.println("Not valid");
                        }
                    } else if (Objects.equals(stu, "stop") == true) {
                        System.out.println("Till next time!");
                    } else {
                        System.out.println("Not option");
                    }
                } while (Objects.equals(stu, "stop") != true);

            } else if (Objects.equals(user, "Librarian") == true || (Objects.equals(user, "librarian") == true)) {
                System.out.println("Enter password to enter library database");
                user = choice.nextLine();
                String libr;
                if (Objects.equals(user, "cookie") == true) {
                    do {
                        System.out.println(
                                "What would you like to do? options are, book report, student report, check out, search book, search student, or stop");
                        libr = choice.nextLine();
                        System.out.println(libr);
                        if (Objects.equals(libr, "Search book") == true
                                || Objects.equals(libr, "search book") == true) {
                            System.out.println("Search by Author, Isbn, or Title?");
                            String search = choice.nextLine();
                            if (Objects.equals(search, "Author") == true || Objects.equals(search, "author") == true) {
                                System.out.println("Enter the Author: ");
                                String author = choice.nextLine();
                                library.SearchByAuthor(author);
                            } else if (Objects.equals(search, "Title") == true
                                    || Objects.equals(search, "title") == true) {
                                System.out.println("Enter the Title: ");
                                String title = choice.nextLine();
                                library.SearchByTitle(title);
                            } else if (Objects.equals(search, "isbn") == true
                                    || Objects.equals(search, "Isbn") == true) {
                                System.out.println("Enter the isbn: ");
                                String isbn = choice.nextLine();
                                library.SearchByIsbn(isbn);
                            } else {
                                System.out.println("Not valid");
                            }
                        } else if (Objects.equals(libr, "check out") == true) {
                            System.out.println("What is the isbn of the book?");
                            String isbn = choice.nextLine();
                            if (library.checkStatus(isbn) == 0) {
                                System.out.println("Which student is checking out?");
                                String student = choice.nextLine();
                                if (students.checkStudent(student) == 0) {
                                    library.updateStatus(isbn);
                                    students.updateStu(isbn, student);
                                    System.out.println(" ");
                                } else {
                                    System.out.println("This student does not exist.");
                                }

                            } else {
                                System.out.println("This book is already checked out");
                            }

                        } else if (Objects.equals(libr, "book report") == true) {
                            library.createReport();
                            System.out.println(" ");
                        } else if (Objects.equals(libr, "student report") == true) {
                            students.createReport();
                            System.out.println(" ");
                        } else if (Objects.equals(libr, "search student") == true) {
                            System.out.println("Which student are you searching for?");
                            String student = choice.nextLine();
                            if (students.checkStudent(student) == 0) {
                                students.searchStudent(student);
                            } else {
                                System.out.println("This student does not exist.");
                            }

                        } else if (Objects.equals(libr, "stop") == true) {
                            System.out.println("Till next time!");
                        } else {
                            System.out.println("invalid option");
                        }
                    } while (Objects.equals(libr, "stop") != true);
                } else {
                    System.out.println("Only librarians can access the librarian menu.");
                }
            }
        } while (Objects.equals(user, "sign out") != true);
        library.writeBack();
        students.writeInfo();
        students.writeLoans();
        choice.close();

    }
}
