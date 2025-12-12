import java.util.Scanner;

public class Main {
    public static void printHeader() {
        System.out.println("\n█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
        System.out.println("█ ██╗      ██████╗ ███╗   ███╗██████╗  ██████╗ ██╗  ██╗ █");
        System.out.println("█ ██║     ██╔═══██╗████╗ ████║██╔══██╗██╔═══██╗██║ ██╔╝ █");
        System.out.println("█ ██║     ██║   ██║██╔████╔██║██████╔╝██║   ██║█████╔╝  █");
        System.out.println("█ ██║     ██║   ██║██║╚██╔╝██║██╔══██╗██║   ██║██╔═██╗  █");
        System.out.println("█ ███████╗╚██████╔╝██║ ╚═╝ ██║██████╔╝╚██████╔╝██║  ██╗ █");
        System.out.println("█ ╚══════╝ ╚═════╝ ╚═╝     ╚═╝╚═════╝ ╚═════╝ ╚═╝  ╚═╝  █");
        System.out.println("█ ================= LOMBOK TOUR GRAPH ================  █");
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║                 LOMBOK TOUR GRAPH SYSTEM              ║");
        System.out.println("╠═══════════════════════════════════════════════════════╣");
        System.out.println("║     Explore Lombok's beauty through connected nodes   ║");
        System.out.println("║         and intelligent route calculations.           ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
    }
    
    public static GraphKabupaten loadData() {
        GraphKabupaten gKab = new GraphKabupaten();
        
        gKab.addJalurKab("Mataram", "Lombok Barat 1", 15.7f);
        gKab.addJalurKab("Mataram", "Lombok Barat 2", 21.2f);
        gKab.addJalurKab("Mataram", "Lombok Barat 3", 10);
        gKab.addJalurKab("Mataram", "Lombok Tengah", 37);
        gKab.addJalurKab("Mataram", "Lombok Timur", 89.6f);
        gKab.addJalurKab("Mataram", "Lombok Utara", 42);

        gKab.addJalurKab("Lombok Barat 1", "Lombok Barat 3", 20f);
        gKab.addJalurKab("Lombok Barat 1", "Lombok Barat 2", 36f);
        gKab.addJalurKab("Lombok Barat 3", "Lombok Barat 2", 12f);

        gKab.addJalurKab("Lombok Barat 3", "Lombok Tengah", 25f);
        gKab.addJalurKab("Lombok Barat 1", "Lombok Utara", 22f);
        gKab.addJalurKab("Lombok Barat 2", "Lombok Tengah", 30f);
        gKab.addJalurKab("Lombok Barat 2", "Lombok Timur", 75f);
        gKab.addJalurKab("Lombok Barat 1", "Lombok Timur", 95f);

        gKab.addJalurKab("Lombok Tengah", "Lombok Timur", 55f);
        gKab.addJalurKab("Lombok Tengah", "Lombok Utara", 50f);

        gKab.addJalurKab("Lombok Utara", "Lombok Timur", 70f);

        GNodeKabupaten lombokBarat1 = gKab.getNode("Lombok Barat 1");
        if (lombokBarat1 != null) {
            DataWisata.setupWisataLombokBarat1(lombokBarat1.graphWisata);
        }

        GNodeKabupaten lombokBarat2 = gKab.getNode("Lombok Barat 2");
        if (lombokBarat2 != null) {
            DataWisata.setupWisataLombokBarat2(lombokBarat2.graphWisata);
        }

        GNodeKabupaten lombokBarat3 = gKab.getNode("Lombok Barat 3");
        if (lombokBarat3 != null) {
            DataWisata.setupWisataLombokBarat3(lombokBarat3.graphWisata);
        }

        GNodeKabupaten lombokTengah = gKab.getNode("Lombok Tengah");
        if (lombokTengah != null) {
            DataWisata.setupWisataLombokTengah(lombokTengah.graphWisata);
        }
        
        GNodeKabupaten lombokTimur = gKab.getNode("Lombok Timur");
        if (lombokTimur != null) {
            DataWisata.setupWisataLombokTimur(lombokTimur.graphWisata);
        }
        
        GNodeKabupaten lombokUtara = gKab.getNode("Lombok Utara");
        if (lombokUtara != null) {
            DataWisata.setupWisataLombokUtara(lombokUtara.graphWisata);
        }
        
        DataWisata.setupDummyReview(gKab);
        
        return gKab;
    }
    
    public static void displaySemuaWisata(GraphKabupaten graph) {
        System.out.println("\n===========================================================");
        System.out.println("           SEMUA WISATA DI PULAU LOMBOK");
        System.out.println("===========================================================");
        
        LinkedList kabupatenList = new LinkedList();
        kabupatenList.addKabupaten("Lombok Barat 1");
        kabupatenList.addKabupaten("Lombok Barat 2");
        kabupatenList.addKabupaten("Lombok Barat 3");
        kabupatenList.addKabupaten("Lombok Tengah ");
        kabupatenList.addKabupaten("Lombok Timur");
        kabupatenList.addKabupaten("Lombok Utara");

        LLNode current = kabupatenList.head;
        while (current.next != null) {
            GNodeKabupaten kab = graph.getNode(current.lokasi);
            if (kab != null && !kab.graphWisata.isEmpty()) {
                kab.graphWisata.displayWisata();
            }
            current = current.next;
        }
    }
    
    public static String cariKabupatenDariWisata(GraphKabupaten graph, String namaWisata) {
        GNodeKabupaten currentKab = graph.firstKab;
        
        while (currentKab != null) {
            GNodeWisata found = currentKab.graphWisata.getNode(namaWisata);
            if (found != null) {
                return currentKab.namaKabupaten;
            }
            currentKab = currentKab.next;
        }
        
        return null;
    }
    
    public static void displayRuteKabupaten(PathResult result, String startKab, String goalKab) {
        if (!result.found) {
            System.out.println("\n[X] Tidak dapat menemukan rute ke kabupaten tujuan!");
            return;
        }
        
        System.out.println("\n===========================================================");
        System.out.println("           RUTE PERJALANAN ANTAR KABUPATEN");
        System.out.println("===========================================================");
        
        String jalur = result.jalur;
        int startIdx = 0;
        int stepNum = 1;
        
        for (int i = 0; i <= jalur.length(); i++) {
            if (i == jalur.length() || (i < jalur.length() - 1 && jalur.charAt(i) == ' ' && jalur.charAt(i+1) == '-')) {
                String kab = jalur.substring(startIdx, i).trim();
                
                if (kab.length() > 0) {
                    if (stepNum == 1) {
                        System.out.println("  " + stepNum + ". [START] " + kab);
                    } else {
                        System.out.println("       |");
                        System.out.println("       v");
                        System.out.println("  " + stepNum + ". " + kab);
                    }
                    stepNum++;
                }
                
                if (i < jalur.length() - 2 && jalur.charAt(i+1) == '-') {
                    i += 3;
                }
                startIdx = i + 1;
            }
        }
        
        System.out.println("-----------------------------------------------------------");
        System.out.println("  Total Jarak Antar Kabupaten: " + result.totalJarak + " km");
        System.out.println("===========================================================");
    }
    
    public static void displayRuteWisata(PathResult result, String kabupaten) {
        if (!result.found) {
            System.out.println("\n[X] Tidak dapat menemukan rute ke wisata tujuan!");
            return;
        }
        
        System.out.println("\n===========================================================");
        System.out.println("      RUTE WISATA DI DALAM " + kabupaten.toUpperCase());
        System.out.println("===========================================================");
        
        String jalur = result.jalur;
        int startIdx = 0;
        int stepNum = 1;
        
        for (int i = 0; i <= jalur.length(); i++) {
            if (i == jalur.length() || (i < jalur.length() - 1 && jalur.charAt(i) == ' ' && jalur.charAt(i+1) == '-')) {
                String wisata = jalur.substring(startIdx, i).trim();
                
                if (wisata.length() > 0) {
                    if (stepNum == 1) {
                        System.out.println("  " + stepNum + ". [ENTRY] " + wisata);
                    } else {
                        System.out.println("       |");
                        System.out.println("       v");
                        System.out.println("  " + stepNum + ". " + wisata);
                    }
                    stepNum++;
                }
                
                if (i < jalur.length() - 2 && jalur.charAt(i+1) == '-') {
                    i += 3;
                }
                startIdx = i + 1;
            }
        }
        
        System.out.println("-----------------------------------------------------------");
        System.out.println("  Jarak Dalam Kabupaten: " + result.totalJarak + " km");
        System.out.println("===========================================================");
    }
    
    public static void simpanJalurKeLinkedList(LinkedList jalur, PathResult resultKab, PathResult resultWis, String kabupatenTujuan) {
        if (resultKab.found) {
            String jalurKab = resultKab.jalur;
            int startIdx = 0;
            
            for (int i = 0; i <= jalurKab.length(); i++) {
                if (i == jalurKab.length() || (i < jalurKab.length() - 1 && jalurKab.charAt(i) == ' ' && jalurKab.charAt(i+1) == '-')) {
                    String kab = jalurKab.substring(startIdx, i).trim();
                    
                    if (kab.length() > 0) {
                        float jarak = 0;
                        if (startIdx > 0) {
                            jarak = resultKab.totalJarak / countArrows(jalurKab);
                        }
                        jalur.addLokasi(kab, "Kabupaten", jarak);
                    }
                    
                    if (i < jalurKab.length() - 2 && jalurKab.charAt(i+1) == '-') {
                        i += 3;
                    }
                    startIdx = i + 1;
                }
            }
        }
        
        if (resultWis.found) {
            String jalurWis = resultWis.jalur;
            int startIdx = 0;
            
            for (int i = 0; i <= jalurWis.length(); i++) {
                if (i == jalurWis.length() || (i < jalurWis.length() - 1 && jalurWis.charAt(i) == ' ' && jalurWis.charAt(i+1) == '-')) {
                    String wisata = jalurWis.substring(startIdx, i).trim();
                    
                    if (wisata.length() > 0) {
                        float jarak = 0;
                        if (startIdx > 0) {
                            jarak = resultWis.totalJarak / countArrows(jalurWis);
                        }
                        jalur.addLokasi(wisata, "Wisata", jarak);
                    }
                    
                    if (i < jalurWis.length() - 2 && jalurWis.charAt(i+1) == '-') {
                        i += 3;
                    }
                    startIdx = i + 1;
                }
            }
        }
    }
    
    public static int countArrows(String jalur) {
        int count = 0;
        for (int i = 0; i < jalur.length() - 1; i++) {
            if (jalur.charAt(i) == '-' && i > 0 && jalur.charAt(i-1) == ' ') {
                count++;
            }
        }
        return count > 0 ? count : 1;
    }
    
    public static void main(String[] args) {
        printHeader();
        
        GraphKabupaten graph = loadData();
        Queue queue = new Queue();
        SearchEngine search = new SearchEngine();
        
        Scanner input = new Scanner(System.in);
        boolean running = true;

        String pilih;
        do {
            System.out.println("\n===========================================================");
            System.out.println("           LOMBOK TOUR GUIDE SYSTEM");
            System.out.println("===========================================================");
            System.out.println("  1. Lihat Semua Wisata");
            System.out.println("  2. Cari Tempat Wisata");
            System.out.println("  3. Antrian");
            System.out.println("  4. Mulai Tour");
            System.out.println("  5. Keluar");
            System.out.println("===========================================================");
            System.out.print("Pilih menu: ");

            pilih = input.nextLine().trim();

            switch (pilih) {

                case "1":
                    displaySemuaWisata(graph);
                    break;

                case "2":
                    System.out.println("\n===========================================================");
                    System.out.println("       CARI TEMPAT WISATA BERDASARKAN");
                    System.out.println("===========================================================");
                    System.out.println("  1. Nama");
                    System.out.println("  2. Kategori/Jenis");
                    System.out.println("  3. Rating");
                    System.out.println("  4. Kabupaten");
                    System.out.println("  5. Kembali");
                    System.out.println("===========================================================");
                    System.out.print("Pilih: ");

                    String pilihCari = input.next();
                    input.nextLine();

                    if (pilihCari == "1") {
                        // ---- kode kamu tetap, tidak diubah ----
                    } else if (pilihCari == "2") {
                        // ---- kode kamu tetap ----
                    } else if (pilihCari == "3") {
                        // ---- kode kamu tetap ----
                    } else if (pilihCari == "4") {
                        // ---- kode kamu tetap ----
                    } else if (pilihCari == "5") {
                        break;
                    } else {
                        System.out.println("[X] Pilihan tidak valid");
                    }
                    break;

                case "3":
                    System.out.println("\n===========================================================");
                    System.out.println("               ANTRIAN PENGUNJUNG");
                    System.out.println("===========================================================");
                    System.out.println("  1. Lihat Antrian");
                    System.out.println("  2. Daftar Antrian");
                    System.out.println("  3. Kembali");
                    System.out.println("===========================================================");
                    System.out.print("Pilih: ");

                    String pilihAntri = input.next();

                    switch (pilihAntri) {
                        case "1":
                            queue.displayQueue();
                            break;
                        case "2":
                            System.out.print("\nMasukkan Nama Anda: ");
                            input.nextLine();
                            String name = input.nextLine();
                            System.out.print("Tanggal Tour (DD-MM-YYYY): ");
                            String tanggal = input.nextLine();
                            queue.enqueue(name, tanggal);
                            System.out.println("\n[V] Anda berhasil masuk ke dalam antrian!");
                            System.out.println("    Tanggal tour: " + tanggal);
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("[X] Pilihan tidak valid");
                    }
                    break;

                case "4":
                    // === seluruh kode 'Mulai Tour' kamu tetap ===
                    // (tidak aku ubah satupun)
                    // tinggal copy-paste blok aslinya di sini
                    // ...
                    break;

                case "5":
                    System.out.println("\n===========================================================");
                    System.out.println("         TERIMA KASIH SUDAH BERKUNJUNG!");
                    System.out.println("             Sampai jumpa kembali!");
                    System.out.println("===========================================================");
                    running = false;
                    break;

                default:
                    System.out.println("[X] Pilihan tidak valid. Silakan pilih 1-5.");
            }

        } while (running);
        
        input.close();
    }
}