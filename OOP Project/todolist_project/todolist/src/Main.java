public class Main {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        int pil = 0;
        do {
            pil = list.mainMenu();
            if(pil == 1){
                list.tambahtask();
            } else if(pil == 2){
                list.daftarTask();
            } else if(pil == 3){
                list.tampilTaskDetail();
            } else if(pil == 4){
                list.tambahSubtask();
            } else if(pil == 5) {
                list.daftarSubtask();
            }
        } while (pil != 0);
    }
}