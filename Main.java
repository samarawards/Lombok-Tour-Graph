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
        SearchEngine search = new SearchEngine();
        
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

                String cari;
                switch (pilihCari) {
                    case 1:
                        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
                        System.out.print("Cari tempat wisata berdasarkan nama: ");
                        cari = input.nextLine();
                        System.out.println("╠═══════════════════════════════════════════════════════╣");
                        GNodeWisata inidia = search.searchByNama(graph, cari);
                        if (inidia != null) {
                            inidia.displayInfo();
                            System.out.print("See Comments...(Y/N)");
                            cari = input.nextLine();
                            if (cari == "Y" || cari == "y" ) {
                                //DISPLAY KOMEN UNTUK WISATA YANG DICARI => inidia
                                System.out.println("\n╔════════════════════════════════════════════╗");
                                System.out.println("║           SORT ULASAN BERDASARKAN          ║");
                                System.out.println("╠════════════════════════════════════════════╣");
                                System.out.println("║1. Rating Tertinggi → Terendah              ║");
                                System.out.println("║2. Rating Terendah → Tertinggi              ║");
                                System.out.println("║3. Komentar Pertama → Terakhir              ║");
                                System.out.println("║4. Komentar Terakhir → Pertama              ║");
                                System.out.println("║5. Kembali                                  ║");
                                System.out.println("╚════════════════════════════════════════════╝");
                                System.out.print("pilihan: ");
                                int pilihSort = input.nextInt(); input.nextLine();
                                switch (pilihSort) {
                                    case 1:
                                        SortingManager.sortUlasanByRating(inidia.getUlasan(), true);
                                        break;
                                    case 2:
                                        SortingManager.sortUlasanByRating(inidia.getUlasan(), false);
                                        break;
                                    case 3:
                                        SortingManager.sortUlasanByIndeks(inidia.getUlasan(), true);
                                        break;
                                    case 4:
                                        SortingManager.sortUlasanByIndeks(inidia.getUlasan(), false);
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("❌ Pilihan tidak valid");
                                        break;
                                }
 
                            }
                        }else{
                            System.out.println("Wisata " + cari + " belum terdaftar dalam sistem.");
                        }
                        System.out.println("╚═══════════════════════════════════════════════════════╝");
                        break;
                    case 2:
                        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
                        System.out.print("Cari tempat wisata berdasarkan jenis: ");
                        cari = input.nextLine();
                        System.out.println("╠═══════════════════════════════════════════════════════╣");
                        search.searchByJenis(graph, cari);
                        System.out.println("╚═══════════════════════════════════════════════════════╝");
                        break;
                    case 3:
                        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
                        System.out.print("Cari tempat wisata dengan rating minimal: ");
                        float rate = input.nextFloat(); input.nextLine();
                        System.out.println("╠═══════════════════════════════════════════════════════╣");
                        search.searchByRating(graph, rate);
                        System.out.println("╚═══════════════════════════════════════════════════════╝");
                        break;
                    case 4:
                        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
                        System.out.print("Cari tempat wisata di dalam kabupaten: ");
                        cari = input.nextLine();
                        System.out.println("╠═══════════════════════════════════════════════════════╣");
                        search.searchByKabupaten(graph, cari);
                        System.out.println("╚═══════════════════════════════════════════════════════╝");
                        break;
                    case 5: break;
                    default:
                        System.out.println("❌ Pilihan tidak valid");
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
                GNodeWisata tujuan;
                GNodeKabupaten start = graph.firstKab; //ini harusnya mataram sih
                queue.displayQueue();
                QueueNode orang = queue.dequeue();
                System.out.println("\n╔═══════════════════════════════════════════════════════╗");
                System.out.println("║             SELAMAT DATANG " + orang.pengunjung + "            ║");
                System.out.println("║                 Lokasi: Kantor Tour Mataram           ║");
                System.out.println("╚═══════════════════════════════════════════════════════╝\n");
                do {
                    System.out.println("[admin] : Mau kemana hari ini?");
                    System.out.print("["+ orang.pengunjung +"] : "); 
                    String t = input.nextLine();
                    tujuan = search.searchByNama(graph, t);
                    if (tujuan != null) {
                        break;
                    }else System.out.println("Maaf, tujuan yang anda cari belum terdaftar dalam sistem.");
                } while (tujuan == null);
                int pilihperjalanan;
                do {
                    //MULAI PERJALANAN DJIKSTRA & PRINT HASIL DJIKSTRA (yang dilewatin)
                    System.out.println("\n╔═══════════════════════════════════════════════════════╗");
                    System.out.println(" PERJALANAN DARI " + start.namaKabupaten +" MENUJU "+ tujuan.namaWisata);
                    System.out.println("╠═══════════════════════════════════════════════════════╣");
                    System.out.println("\n  JALANKAN DJIKSTRA DISINI");
                    System.out.println("    DAN DISINI");
                    System.out.println("╠═══════════════════════════════════════════════════════╣");
                    System.out.println("║                 LANGKAH SELANJUTNYA                   ║");
                    System.out.println("╠═══════════════════════════════════════════════════════╣");
                    System.out.println("║1. Melanjutkan perjalanan menuju tujuan baru           ║"); //kalau dia pilih ini antara dia looping atau rekursif, ntahlah
                    System.out.println("║2. Selesaikan perjalanan                               ║");
                    System.out.println("╠═══════════════════════════════════════════════════════╣");
                    do {
                        System.out.print(" Pilihan: "); 
                        pilihperjalanan = input.nextInt(); input.nextLine();
                        
                        switch (pilihperjalanan) {
                            case 1:
                                do {
                                    System.out.println("[admin] : Mau melanjutkan perjalanan kemana?");
                                    System.out.print("["+ orang.pengunjung +"] : "); 
                                    String t = input.nextLine();
                                    tujuan = search.searchByNama(graph, t); //ini tujuannya diperbarahui, tapi startnya belum diperbaharui
                                    if (tujuan != null) {
                                        break;
                                    }else System.out.println("Maaf, tujuan yang anda cari belum terdaftar dalam sistem.");
                                } while (tujuan == null);
                                break;
                                
                            case 2:
                                //INI BUAT MENU UNTUK MEMBERIKAN ULASAN ATAU TIDAK, KALAU IYA KELUARKAN SEMUA TEMPAT YANG MASUK LINKED LISTNYA
                                //ORANG ITU SATU PERSATU TERUS MINTA INPUT RATING DAN KOMENTAR UNTUK SETIAP TEMPAT YANG DIKUNJUNGI
                                break;
                            default:
                                System.out.println("❌ Pilihan tidak valid");
                                break;
                        }
                    } while (pilihperjalanan != 1 || pilihperjalanan != 2);
                } while (pilihperjalanan == 1);
                
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