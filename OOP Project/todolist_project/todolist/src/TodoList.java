import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    ArrayList<Task> task = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    TodoList(){}

    void skip(){
        System.out.println("\n");
    }

    int mainMenu() {
        System.out.println("=== MAIN MENU ===");
        System.out.println("1. Tambah Task");
        System.out.println("2. Daftar Task");
        System.out.println("3. Tampil Detail Task");
        System.out.println("4. Tambah Subtask");
        System.out.println("5. Daftar Subtask");
        System.out.print("Pilihan anda: ");
        int pil = input.nextInt();
        input.nextLine();
        skip();
        return pil;
    }

    void tambahtask(){
        String judul, desk;
        int deadline;
        int prior;
        input.nextLine();
        System.out.println("=== TAMBAH TASK ===");
        System.out.print("Judul    : ");
        judul = input.nextLine();
        System.out.print("Deskripsi: ");
        desk = input.nextLine();
        System.out.print("Deadline : ");
        deadline = input.nextInt();
        System.out.print("Prioritas: ");
        prior = input.nextInt();
        Task temp = new Task(judul, desk, deadline, true, prior);
        task.add(temp);
        skip();
    }
    void daftarTask(){
        for(int i=0; i<task.size(); i++){
            System.out.print((i+1) + ". ");
            System.out.println("Judul Task: " + task.get(i).judul);
        }
        skip();
    }
    void tampilTaskDetail() {
        for(int i=0; i<task.size(); i++){
            System.out.println("Task ke-" + (i+1));
            System.out.println("Judul       : " + task.get(i).judul);
            System.out.println("Deskripsi   : " + task.get(i).deskripsi);
            System.out.println("Tanggal Buat: " + task.get(i).tanggalBuat);
            System.out.println("Deadline    : " + task.get(i).tanggalDeadline);
            System.out.println("Status      : " + task.get(i).status);
            System.out.println("Prioritas   : " + task.get(i).prioritas);
            System.out.println("\n");
        }
        skip();
    }
    void tambahSubtask(){
        System.out.println("== DAFTAR TASK YANG ADA === ");
        for(int i=0; i<task.size(); i++){
            System.out.println((i+1) + ". " + task.get(i).judul);
        }
        skip();

        int idx;
        while(true){
            System.out.print("Pilih Task untuk menambahkan SubTask: ");
            idx = input.nextInt();
            idx--;
            if(idx < 0 || idx >= task.size()){
                System.out.println("Pilih Task yang sesuai!");
            } else {
                break;
            }
        }

        task.get(idx).addSubTask();
        task.get(idx).daftarSubTask();
        skip();
    }

    void daftarSubtask(){
        System.out.println("== DAFTAR TASK YANG ADA === ");
        for(int i=0; i<task.size(); i++){
            System.out.println((i+1) + ". " + task.get(i).judul);
        }
        skip();

        int idx;
        while(true){
            System.out.print("Pilih Task untuk melihat daftar SubTask: ");
            idx = input.nextInt();
            idx--;
            if(idx < 0 || idx >= task.size()){
                System.out.println("Pilih Task yang sesuai!");
            } else {
                break;
            }
        }
        skip();

        int pil;
        do {
            System.out.println("1. Daftar Subtask");
            System.out.println("2. Detail Subtask");
            System.out.println("0. Keluar");
            System.out.print("Pilihan anda: ");
            pil = input.nextInt();
            input.nextLine();
            skip();
            if(pil == 1){
                task.get(idx).daftarSubTask();
            } else if(pil == 2) {
                task.get(idx).subtaskDetail();
            }
        } while(pil != 0);
    }
}