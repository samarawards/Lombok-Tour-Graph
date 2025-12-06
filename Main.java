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
    
    // Load semua data Lombok (kabupaten + wisata)
    public static GraphKabupaten loadData() {
        
        GraphKabupaten gKab = new GraphKabupaten();
        
        // ===== SETUP GRAPH KABUPATEN =====
        
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
        
        // Setup dummy review untuk testing
        DataWisata.setupDummyReview(gKab);
        
        return gKab;
    }
    
    
    // Display semua wisata dari semua kabupaten (untuk menu 1)
    public static void displaySemuaWisata(GraphKabupaten graph) {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║               SEMUA WISATA DI PULAU LOMBOK             ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        String[] kabupatenList = {
            "Lombok Barat 1", "Lombok Barat 2", "Lombok Barat 3",
            "Lombok Tengah", "Lombok Timur", "Lombok Utara"
        };
        
        for (int i = 0; i < kabupatenList.length; i++) {
            GNodeKabupaten kab = graph.getNode(kabupatenList[i]);
            if (kab != null && !kab.graphWisata.isEmpty()) {
                kab.graphWisata.displayWisata();
            }
        }
    }

    public static void main(String[] args) {
        printHeader();
        
        // Initialize data
        GraphKabupaten graph = loadData();
        Queue queue = new Queue();
        
        Scanner input = new Scanner(System.in);
        boolean running = true;

        int pilih;
        do {
            System.out.println("\n╔═══════════════════════════════════════════════════════╗");
            System.out.println("║               LOMBOK TOUR GUIDE SYSTEM                ║");
            System.out.println("╠═══════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Lihat Semua Wisata                                 ║");
            System.out.println("║ 2. Cari Tempat Wisata                                 ║");
            System.out.println("║ 3. Antrian                                            ║");
            System.out.println("║ 4. Mulai Tour                                         ║");
            System.out.println("║ 5. Keluar                                             ║");
            System.out.println("╚═══════════════════════════════════════════════════════╝");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt(); 
            input.nextLine();
            
            if (pilih == 1) {
                // Display semua wisata
                displaySemuaWisata(graph);
                
            } else if (pilih == 2) {
                SearchEngine search = new SearchEngine();
                // Search wisata (Anggota 5 - SearchEngine)
                System.out.println("\n╔═══════════════════════════════════════════════════════╗");
                System.out.println("║           CARI TEMPAT WISATA BERDASARKAN              ║");
                System.out.println("╠═══════════════════════════════════════════════════════╣");
                System.out.println("║ 1. Nama                                               ║");
                System.out.println("║ 2. Kategori/Jenis                                     ║");
                System.out.println("║ 3. Rating                                             ║");
                System.out.println("║ 4. Kabupaten                                          ║");
                System.out.println("║ 5. Kembali                                            ║");
                System.out.println("╚═══════════════════════════════════════════════════════╝");
                System.out.print("Pilih: ");
                int pilihCari = input.nextInt(); 
                input.nextLine();

                switch (pilihCari) {
                    case 1:
                        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
                        System.out.print("Cari tempat wisata berdasarkan nama: ");
                        System.out.println("╠═══════════════════════════════════════════════════════╣");
                        String cari = input.nextLine();
                        GNodeWisata inidia = search.searchByNama(graph, cari);
                        if (inidia != null) {
                            inidia.displayInfo();
                        }else{
                            System.out.println("Wisata " + cari + " belum terdaftar dalam sistem.");
                        }
                        System.out.println("╚═══════════════════════════════════════════════════════╝");
                        break;
                
                    default:
                        break;
                }
                
            } else if (pilih == 3) {
                // Menu Antrian
                System.out.println("\n╔═══════════════════════════════════════════════════════╗");
                System.out.println("║                   ANTRIAN PENGUNJUNG                  ║");
                System.out.println("╠═══════════════════════════════════════════════════════╣");
                System.out.println("║ 1. Lihat Antrian                                      ║");
                System.out.println("║ 2. Daftar Antrian                                     ║");
                System.out.println("║ 3. Kembali                                            ║");
                System.out.println("╚═══════════════════════════════════════════════════════╝");
                System.out.print("Pilih: ");
                int pilihAntri = input.nextInt(); 
                input.nextLine();

                switch (pilihAntri) {
                    case 1:
                        queue.displayQueue();
                        break;
                    case 2:
                        System.out.print("\nMasukkan Nama Anda: ");
                        String name = input.nextLine();
                        queue.enqueue(name);
                        System.out.println("✓ Anda berhasil masuk ke dalam antrian!");
                        // System.out.println("  Nomor antrian Anda: #" + queue.size);
                        break;
                    case 3:
                        // Kembali ke menu utama
                        break;
                    default:
                        System.out.println("❌ Pilihan tidak valid");
                        break;
                }
                
            } else if (pilih == 4) {
                // Mulai tour (Integrasi semua modul)
                System.out.println("\n  Fitur tour belum diimplementasi.");
                System.out.println("    (Akan dikerjakan setelah semua modul selesai)");
                
            } else if (pilih == 5) {
                System.out.println("\n╔═══════════════════════════════════════════════════════╗");
                System.out.println("║             TERIMA KASIH SUDAH BERKUNJUNG!            ║");
                System.out.println("║                 Sampai jumpa kembali!                 ║");
                System.out.println("╚═══════════════════════════════════════════════════════╝\n");
                running = false;
                
            } else {
                System.out.println("❌ Pilihan tidak valid. Silakan pilih 1-5.");
            }
        } while (running);
        
        input.close();
    }
}