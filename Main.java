import java.util.Scanner;

public class Main {
    public static void printHeader() {
        System.out.println("█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
        System.out.println("█ ██╗      ██████╗ ███╗   ███╗██████╗  ██████╗ ██╗  ██╗ █");
        System.out.println("█ ██║     ██╔═══██╗████╗ ████║██╔══██╗██╔═══██╗██║ ██╔╝ █");
        System.out.println("█ ██║     ██║   ██║██╔████╔██║██████╔╝██║   ██║█████╔╝  █");
        System.out.println("█ ██║     ██║   ██║██║╚██╔╝██║██╔══██╗██║   ██║██╔═██╗  █");
        System.out.println("█ ███████╗╚██████╔╝██║ ╚═╝ ██║██████ ║╚██████╔╝██║  ██╗ █");
        System.out.println("█ ╚══════╝ ╚═════╝ ╚═╝     ╚═╝╚═════╝ ╚═════╝ ╚═╝  ╚═╝  █");
        System.out.println("█ ================= LOMBOK TOUR GRAPH ================  █");
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
    }  

    public static void loadData(){
        GraphKabupaten gKab = new GraphKabupaten();
        gKab.addJalurKab("Mataram","Lombok Barat 1", 15.7f); //Lombok Barat 1 = atas (Senggigi)
        gKab.addJalurKab("Mataram","Lombok Barat 2", 21.2f); //Lombok Barat 2 = bawah (Lembar)
        gKab.addJalurKab("Mataram","Lombok Barat 3", 10); //Lombok Barat 3 = atas (Narmada)
        gKab.addJalurKab("Mataram", "Lombok Tengah", 37);
        gKab.addJalurKab("Mataram", "Lombok Timur", 89.6f);
        gKab.addJalurKab("Mataram", "Lombok Utara", 42);

        gKab.addJalurKab("Lombok Barat 1", "Lombok Barat 3", 20f);   // Senggigi ↔ Narmada
        gKab.addJalurKab("Lombok Barat 1", "Lombok Barat 2", 36f);   // Senggigi ↔ Lembar
        gKab.addJalurKab("Lombok Barat 3", "Lombok Barat 2", 12f);   // Narmada ↔ Lembar

        gKab.addJalurKab("Lombok Barat 3", "Lombok Tengah", 25f);   // Narmada ↔ Lombok Tengah
        gKab.addJalurKab("Lombok Barat 1", "Lombok Utara", 22f);    // Senggigi ↔ Lombok Utara
        gKab.addJalurKab("Lombok Barat 2", "Lombok Tengah", 30f);   // Lembar ↔ Lombok Tengah
        gKab.addJalurKab("Lombok Barat 2", "Lombok Timur", 75f);    // Lembar ↔ Lombok Timur
        gKab.addJalurKab("Lombok Barat 1", "Lombok Timur", 95f);    // Senggigi ↔ Lombok Timur

        gKab.addJalurKab("Lombok Tengah", "Lombok Timur", 55f);
        gKab.addJalurKab("Lombok Tengah", "Lombok Utara", 50f);

        gKab.addJalurKab("Lombok Utara", "Lombok Timur", 70f);

        //Lombok Barat 1 (Senggigi)
        gKab.addWisata("Lombok Barat 1","Pantai Senggigi","Bukit Malimbu", 6.0f);
        gKab.addWisata("Lombok Barat 1","Pantai Senggigi","Puncak Pusuk", 22.0f);
        gKab.addWisata("Lombok Barat 1","Pantai Senggigi","Pantai Klui", 14.0f);
        gKab.addWisata("Lombok Barat 1","Pantai Senggigi","Pantai Setangi", 12.0f);
        gKab.addWisata("Lombok Barat 1","Pantai Senggigi","Pantai Kerandangan", 18.0f);

        gKab.addWisata("Lombok Barat 1","Bukit Malimbu","Puncak Pusuk", 20.0f);
        gKab.addWisata("Lombok Barat 1","Bukit Malimbu","Pantai Klui", 10.0f);
        gKab.addWisata("Lombok Barat 1","Bukit Malimbu","Pantai Setangi", 9.0f);
        gKab.addWisata("Lombok Barat 1","Bukit Malimbu","Pantai Kerandangan", 15.0f);

        gKab.addWisata("Lombok Barat 1","Puncak Pusuk","Pantai Klui", 25.0f);
        gKab.addWisata("Lombok Barat 1","Puncak Pusuk","Pantai Setangi", 24.0f);
        gKab.addWisata("Lombok Barat 1","Puncak Pusuk","Pantai Kerandangan", 28.0f);

        gKab.addWisata("Lombok Barat 1","Pantai Klui","Pantai Setangi", 6.0f);
        gKab.addWisata("Lombok Barat 1","Pantai Klui","Pantai Kerandangan", 12.0f);

        gKab.addWisata("Lombok Barat 1","Pantai Setangi","Pantai Kerandangan", 14.0f);

        //Lombok Barat 2 ()
        gKab.addWisata("Lombok Barat 2","Pantai Cemare","Pantai Kuranji", 8.0f);
        gKab.addWisata("Lombok Barat 2","Pantai Cemare","Gili Gede", 35.0f);
        gKab.addWisata("Lombok Barat 2","Pantai Cemare","Gili Layar", 40.0f);
        gKab.addWisata("Lombok Barat 2","Pantai Cemare","Gili Asahan", 38.0f);
        gKab.addWisata("Lombok Barat 2","Pantai Cemare","Gili Rengit", 37.0f);

        gKab.addWisata("Lombok Barat 2","Pantai Kuranji","Gili Gede", 30.0f);
        gKab.addWisata("Lombok Barat 2","Pantai Kuranji","Gili Layar", 35.0f);
        gKab.addWisata("Lombok Barat 2","Pantai Kuranji","Gili Asahan", 33.0f);
        gKab.addWisata("Lombok Barat 2","Pantai Kuranji","Gili Rengit", 32.0f);

        gKab.addWisata("Lombok Barat 2","Gili Gede","Gili Layar", 8.0f);
        gKab.addWisata("Lombok Barat 2","Gili Gede","Gili Asahan", 10.0f);
        gKab.addWisata("Lombok Barat 2","Gili Gede","Gili Rengit", 12.0f);

        gKab.addWisata("Lombok Barat 2","Gili Layar","Gili Asahan", 6.0f);
        gKab.addWisata("Lombok Barat 2","Gili Layar","Gili Rengit", 7.0f);

        gKab.addWisata("Lombok Barat 2","Gili Asahan","Gili Rengit", 5.0f);

        //Lombok barat 3
        gKab.addWisata("Lombok Barat 3","Taman Narmada","Taman Suranadi", 9.0f);
        gKab.addWisata("Lombok Barat 3","Taman Narmada","Air Terjun Tibu Atas", 18.0f);
        gKab.addWisata("Lombok Barat 3","Taman Narmada","Taman Hutan Suranadi", 10.0f);
        gKab.addWisata("Lombok Barat 3","Taman Narmada","Kolam Renang Suranadi", 9.0f);
        gKab.addWisata("Lombok Barat 3","Taman Narmada","Narmada Botanic Garden", 3.0f);
        gKab.addWisata("Lombok Barat 3","Taman Narmada","Pemandian Sesaot", 7.0f);

        gKab.addWisata("Lombok Barat 3","Taman Suranadi","Air Terjun Tibu Atas", 16.0f);
        gKab.addWisata("Lombok Barat 3","Taman Suranadi","Taman Hutan Suranadi", 4.0f);
        gKab.addWisata("Lombok Barat 3","Taman Suranadi","Kolam Renang Suranadi", 2.0f);
        gKab.addWisata("Lombok Barat 3","Taman Suranadi","Narmada Botanic Garden", 8.0f);
        gKab.addWisata("Lombok Barat 3","Taman Suranadi","Pemandian Sesaot", 6.0f);

        gKab.addWisata("Lombok Barat 3","Air Terjun Tibu Atas","Taman Hutan Suranadi", 19.0f);
        gKab.addWisata("Lombok Barat 3","Air Terjun Tibu Atas","Kolam Renang Suranadi", 17.0f);
        gKab.addWisata("Lombok Barat 3","Air Terjun Tibu Atas","Narmada Botanic Garden", 20.0f);
        gKab.addWisata("Lombok Barat 3","Air Terjun Tibu Atas","Pemandian Sesaot", 15.0f);

        gKab.addWisata("Lombok Barat 3","Taman Hutan Suranadi","Kolam Renang Suranadi", 3.0f);
        gKab.addWisata("Lombok Barat 3","Taman Hutan Suranadi","Narmada Botanic Garden", 9.0f);
        gKab.addWisata("Lombok Barat 3","Taman Hutan Suranadi","Pemandian Sesaot", 6.0f);

        gKab.addWisata("Lombok Barat 3","Kolam Renang Suranadi","Narmada Botanic Garden", 8.0f);
        gKab.addWisata("Lombok Barat 3","Kolam Renang Suranadi","Pemandian Sesaot", 5.0f);

        gKab.addWisata("Lombok Barat 3","Narmada Botanic Garden","Pemandian Sesaot", 4.0f);

        //Lombok Tengah
        gKab.addWisata("Lombok Tengah","Pantai Kuta Mandalika","Sirkuit Mandalika", 3.0f);
        gKab.addWisata("Lombok Tengah","Pantai Kuta Mandalika","Pantai Tanjung Aan", 18.0f);
        gKab.addWisata("Lombok Tengah","Pantai Kuta Mandalika","Bukit Merese", 16.0f);
        gKab.addWisata("Lombok Tengah","Pantai Kuta Mandalika","Pantai Seger", 20.0f);
        gKab.addWisata("Lombok Tengah","Pantai Kuta Mandalika","Pantai Selong Belanak", 30.0f);
        gKab.addWisata("Lombok Tengah","Pantai Kuta Mandalika","Desa Sade", 22.0f);
        gKab.addWisata("Lombok Tengah","Pantai Kuta Mandalika","Air Terjun Benang Kelambu", 60.0f);
        gKab.addWisata("Lombok Tengah","Pantai Kuta Mandalika","Air Terjun Benang Stokel", 62.0f);

        gKab.addWisata("Lombok Tengah","Sirkuit Mandalika","Pantai Tanjung Aan", 18.0f);
        gKab.addWisata("Lombok Tengah","Sirkuit Mandalika","Bukit Merese", 15.0f);
        gKab.addWisata("Lombok Tengah","Sirkuit Mandalika","Pantai Seger", 19.0f);
        gKab.addWisata("Lombok Tengah","Sirkuit Mandalika","Pantai Selong Belanak", 29.0f);
        gKab.addWisata("Lombok Tengah","Sirkuit Mandalika","Desa Sade", 21.0f);
        gKab.addWisata("Lombok Tengah","Sirkuit Mandalika","Air Terjun Benang Kelambu", 59.0f);
        gKab.addWisata("Lombok Tengah","Sirkuit Mandalika","Air Terjun Benang Stokel", 61.0f);

        gKab.addWisata("Lombok Tengah","Pantai Tanjung Aan","Bukit Merese", 6.0f);
        gKab.addWisata("Lombok Tengah","Pantai Tanjung Aan","Pantai Seger", 10.0f);
        gKab.addWisata("Lombok Tengah","Pantai Tanjung Aan","Pantai Selong Belanak", 22.0f);
        gKab.addWisata("Lombok Tengah","Pantai Tanjung Aan","Desa Sade", 25.0f);
        gKab.addWisata("Lombok Tengah","Pantai Tanjung Aan","Air Terjun Benang Kelambu", 68.0f);
        gKab.addWisata("Lombok Tengah","Pantai Tanjung Aan","Air Terjun Benang Stokel", 70.0f);

        gKab.addWisata("Lombok Tengah","Bukit Merese","Pantai Seger", 12.0f);
        gKab.addWisata("Lombok Tengah","Bukit Merese","Pantai Selong Belanak", 24.0f);
        gKab.addWisata("Lombok Tengah","Bukit Merese","Desa Sade", 27.0f);
        gKab.addWisata("Lombok Tengah","Bukit Merese","Air Terjun Benang Kelambu", 65.0f);
        gKab.addWisata("Lombok Tengah","Bukit Merese","Air Terjun Benang Stokel", 67.0f);

        gKab.addWisata("Lombok Tengah","Pantai Seger","Pantai Selong Belanak", 20.0f);
        gKab.addWisata("Lombok Tengah","Pantai Seger","Desa Sade", 30.0f);
        gKab.addWisata("Lombok Tengah","Pantai Seger","Air Terjun Benang Kelambu", 72.0f);
        gKab.addWisata("Lombok Tengah","Pantai Seger","Air Terjun Benang Stokel", 74.0f);

        gKab.addWisata("Lombok Tengah","Pantai Selong Belanak","Desa Sade", 40.0f);
        gKab.addWisata("Lombok Tengah","Pantai Selong Belanak","Air Terjun Benang Kelambu", 75.0f);
        gKab.addWisata("Lombok Tengah","Pantai Selong Belanak","Air Terjun Benang Stokel", 77.0f);

        gKab.addWisata("Lombok Tengah","Desa Sade","Air Terjun Benang Kelambu", 55.0f);
        gKab.addWisata("Lombok Tengah","Desa Sade","Air Terjun Benang Stokel", 57.0f);

        gKab.addWisata("Lombok Tengah","Air Terjun Benang Kelambu","Air Terjun Benang Stokel", 6.0f);

        //Lombok Timur
        gKab.addWisata("Lombok Timur","Gunung Rinjani","Bukit Pergasingan", 18.0f);
        gKab.addWisata("Lombok Timur","Gunung Rinjani","Sembalun", 10.0f);
        gKab.addWisata("Lombok Timur","Gunung Rinjani","Air Terjun Jeruk Manis", 40.0f);
        gKab.addWisata("Lombok Timur","Gunung Rinjani","Pantai Pink", 85.0f);
        gKab.addWisata("Lombok Timur","Gunung Rinjani","Gili Pasir", 70.0f);
        gKab.addWisata("Lombok Timur","Gunung Rinjani","Savana Sembalun", 12.0f);
        gKab.addWisata("Lombok Timur","Gunung Rinjani","Kebun Stroberi Sembalun", 11.0f);

        gKab.addWisata("Lombok Timur","Bukit Pergasingan","Sembalun", 8.0f);
        gKab.addWisata("Lombok Timur","Bukit Pergasingan","Air Terjun Jeruk Manis", 38.0f);
        gKab.addWisata("Lombok Timur","Bukit Pergasingan","Pantai Pink", 82.0f);
        gKab.addWisata("Lombok Timur","Bukit Pergasingan","Gili Pasir", 67.0f);
        gKab.addWisata("Lombok Timur","Bukit Pergasingan","Savana Sembalun", 10.0f);
        gKab.addWisata("Lombok Timur","Bukit Pergasingan","Kebun Stroberi Sembalun", 9.0f);

        gKab.addWisata("Lombok Timur","Sembalun","Air Terjun Jeruk Manis", 35.0f);
        gKab.addWisata("Lombok Timur","Sembalun","Pantai Pink", 80.0f);
        gKab.addWisata("Lombok Timur","Sembalun","Gili Pasir", 65.0f);
        gKab.addWisata("Lombok Timur","Sembalun","Savana Sembalun", 5.0f);
        gKab.addWisata("Lombok Timur","Sembalun","Kebun Stroberi Sembalun", 6.0f);

        gKab.addWisata("Lombok Timur","Air Terjun Jeruk Manis","Pantai Pink", 60.0f);
        gKab.addWisata("Lombok Timur","Air Terjun Jeruk Manis","Gili Pasir", 48.0f);
        gKab.addWisata("Lombok Timur","Air Terjun Jeruk Manis","Savana Sembalun", 37.0f);
        gKab.addWisata("Lombok Timur","Air Terjun Jeruk Manis","Kebun Stroberi Sembalun", 36.0f);

        gKab.addWisata("Lombok Timur","Pantai Pink","Gili Pasir", 5.0f);
        gKab.addWisata("Lombok Timur","Pantai Pink","Savana Sembalun", 82.0f);
        gKab.addWisata("Lombok Timur","Pantai Pink","Kebun Stroberi Sembalun", 81.0f);

        gKab.addWisata("Lombok Timur","Gili Pasir","Savana Sembalun", 67.0f);
        gKab.addWisata("Lombok Timur","Gili Pasir","Kebun Stroberi Sembalun", 66.0f);

        gKab.addWisata("Lombok Timur","Savana Sembalun","Kebun Stroberi Sembalun", 2.0f);

        //Lombok Utara
        gKab.addWisata("Lombok Utara","Gili Trawangan","Gili Air", 3.0f);
        gKab.addWisata("Lombok Utara","Gili Trawangan","Gili Meno", 4.0f);
        gKab.addWisata("Lombok Utara","Gili Air","Gili Meno", 2.5f);

        gKab.addWisata("Lombok Utara","Gili Trawangan","Air Terjun Sendang Gile", 35.0f);
        gKab.addWisata("Lombok Utara","Gili Air","Air Terjun Sendang Gile", 33.0f);
        gKab.addWisata("Lombok Utara","Gili Meno","Air Terjun Sendang Gile", 34.0f);

        gKab.addWisata("Lombok Utara","Air Terjun Sendang Gile","Air Terjun Tiu Kelep", 1.5f);
        gKab.addWisata("Lombok Utara","Air Terjun Sendang Gile","Pantai Nipah", 40.0f);
        gKab.addWisata("Lombok Utara","Air Terjun Sendang Gile","Desa Wisata Senaru", 3.0f);

        gKab.addWisata("Lombok Utara","Air Terjun Tiu Kelep","Pantai Nipah", 41.0f);
        gKab.addWisata("Lombok Utara","Air Terjun Tiu Kelep","Desa Wisata Senaru", 2.5f);

        gKab.addWisata("Lombok Utara","Pantai Nipah","Desa Wisata Senaru", 38.0f);

    }


    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        boolean pilihan = false;

        Queue queue = new Queue(); //ini contoh dulu
        int pilih;
        do{
            System.out.println("Welcome to LOMBOK TOUR GRAPH");
            System.out.println("1. Lihat Semua Wisata"); //display graph wisata
            System.out.println("2. Cari Tempat Wisata"); //searching graph wisata
            System.out.println("3. Daftar Antrian"); //queue
            System.out.println("4. Jalankan Antrian"); //djikstra, linkedlist, stack ulasan
            System.out.print("Pilih: ");
            pilih = input.nextInt(); input.nextLine();
            
            if (pilih == 1) {
                
            }else if (pilih == 2) {

            }else if (pilih == 3) {
            //tambahin 2 tombol, lihat antrian dan daftar ke antrian
                System.out.println("Antrian LOMBOK TOUR GRAPH");
                System.out.println("1. Lihat Antrian");
                System.out.println("2. Daftar Antrian");
                System.out.println("Pilih: ");
                pilih = input.nextInt(); input.nextLine();

                switch (pilih){
                    case 1:
                        queue.displayQueue();
                        break;
                    case 2:
                        System.out.print("Masukkan Nama Anda: ");
                        String name = input.nextLine();
                        queue.enqueue(name);
                        System.out.println("Anda berhasil masuk ke dalam antrian!!!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid");
                        break;
                }
                
                
            }else if (pilih == 4) {
                
            }else{
                System.out.println("Pilihan tidak valid");
                pilihan = true;
            }
    
        }while (pilihan);
    }
}

//kalau udah masuk coba tulis tulis disni
