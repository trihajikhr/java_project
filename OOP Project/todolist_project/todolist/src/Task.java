import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    public String judul;
    public String deskripsi;
    LocalDate tanggalBuat;
    LocalDate tanggalDeadline;
    boolean status;
    int prioritas;

    Scanner input = new Scanner(System.in);
    ArrayList<Task> subtask = new ArrayList<>();

    void skip(){
        System.out.println("\n");
    }

    Task(String judul, String deskripsi, int deadline, boolean status, int prioritas) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.status = status;
        this.prioritas = prioritas;

        // pengaturan tanggal
        this.tanggalBuat = LocalDate.now();
        this.tanggalDeadline = LocalDate.now().plusDays(deadline);
    }

    void addSubTask() {
        input.nextLine();
        String judul, deskripsi;
        int deadline, prioritas;
        System.out.println("=== TAMBAH SUB TASK ===");
        System.out.print("Judul    : ");
        judul = input.nextLine();
        System.out.print("Deskripsi: ");
        deskripsi = input.nextLine();
        System.out.print("Deadline : ");
        deadline = input.nextInt();
        System.out.print("Prioritas: ");
        prioritas = input.nextInt();

        Task sub = new SubTask(judul, deskripsi, deadline, true,prioritas);
        subtask.add(sub);
        skip();
    }

    void daftarSubTask() {
        for(int i=0; i<subtask.size(); i++) {
            System.out.println((i+1) + ". " + subtask.get(i).judul);
        }
        skip();
    }

    void subtaskDetail(){
        for(int i=0; i<subtask.size(); i++){
            System.out.println("subtask ke-" + (i+1));
            System.out.println("Judul       : " + subtask.get(i).judul);
            System.out.println("Deskripsi   : " + subtask.get(i).deskripsi);
            System.out.println("Tanggal Buat: " + subtask.get(i).tanggalBuat);
            System.out.println("Deadline    : " + subtask.get(i).tanggalDeadline);
            System.out.println("Status      : " + subtask.get(i).status);
            System.out.println("Prioritas   : " + subtask.get(i).prioritas);
            System.out.println("\n");
        }
        skip();
    }
}
