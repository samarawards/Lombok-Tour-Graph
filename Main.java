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
        
        gKab.addJalurKab("Mataram", "Lombok Barat 1", 5.1f); // Gunung Sari
        gKab.addJalurKab("Mataram", "Lombok Barat 2", 10.2f); // Labuapi
        gKab.addJalurKab("Mataram", "Lombok Barat 3", 13.2f); // Narmada

        gKab.addJalurKab("Lombok Barat 1", "Lombok Barat 3", 15.4f);
        gKab.addJalurKab("Lombok Barat 3", "Lombok Barat 2", 12.4f);

        gKab.addJalurKab("Lombok Barat 3", "Lombok Tengah", 18.7f);
        gKab.addJalurKab("Lombok Barat 1", "Lombok Utara", 48.1f);
        gKab.addJalurKab("Lombok Barat 2", "Lombok Tengah", 22.9f);

        gKab.addJalurKab("Lombok Tengah", "Lombok Timur", 49.2f);

        gKab.addJalurKab("Lombok Utara", "Lombok Timur", 89.6f);

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
        kabupatenList.addKabupaten("Lombok Tengah");
        kabupatenList.addKabupaten("Lombok Timur");
        kabupatenList.addKabupaten("Lombok Utara");

        LLNode current = kabupatenList.head;
        while (current != null) {
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

                    if (pilihCari.equals("1")) {
                        System.out.println("\n===========================================================");
                        System.out.print("Cari tempat wisata berdasarkan nama: ");
                        String cari = input.nextLine();
                        System.out.println("-----------------------------------------------------------");
                        GNodeWisata inidia = search.searchByNama(graph, cari);
                        if (inidia != null) {
                            inidia.displayInfo();
                            System.out.print("\nLihat Komentar? (Y/N): ");
                            String lihatKomen = input.nextLine();
                            if (lihatKomen.equalsIgnoreCase("Y")) {
                                if (inidia.ulasan.isEmpty()) {
                                    System.out.println("\n[X] Belum ada ulasan untuk wisata ini.");
                                } else {
                                    boolean viewComments = true;
                                    while (viewComments) {
                                        System.out.println("\n===========================================================");
                                        System.out.println("           SORT ULASAN BERDASARKAN");
                                        System.out.println("===========================================================");
                                        System.out.println("  1. Rating Tertinggi -> Terendah");
                                        System.out.println("  2. Rating Terendah -> Tertinggi");
                                        System.out.println("  3. Komentar Pertama -> Terakhir");
                                        System.out.println("  4. Komentar Terakhir -> Pertama");
                                        System.out.println("  5. Semua Ulasan (LIFO)");
                                        System.out.println("  6. Kembali");
                                        System.out.println("===========================================================");
                                        System.out.print("Pilihan: ");
                                        String pilihSort = input.next();
                                        switch (pilihSort) {
                                            case "1":
                                                SortingManager.sortUlasanByRating(inidia.ulasan, true);
                                                break;
                                            case "2":
                                                SortingManager.sortUlasanByRating(inidia.ulasan, false);
                                                break;
                                            case "3":
                                                SortingManager.sortUlasanByIndeks(inidia.ulasan, true);
                                                break;
                                            case "4":
                                                SortingManager.sortUlasanByIndeks(inidia.ulasan, false);
                                                break;
                                            case "5":
                                                inidia.ulasan.displayAll();
                                                break;
                                            case "6":
                                                viewComments = false;
                                                break;
                                            default:
                                                System.out.println("[X] Pilihan tidak valid");
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("Wisata \"" + cari + "\" belum terdaftar dalam sistem.");
                        }
                        System.out.println("===========================================================");
                        break;

                    } else if (pilihCari.equals("2")) {
                        System.out.println("\n===========================================================");
                        search.displayJenisWisata();
                        System.out.print("Cari tempat wisata berdasarkan jenis: ");
                        String cari = input.nextLine();
                        System.out.println("-----------------------------------------------------------");
                        search.searchByJenis(graph, cari);
                        System.out.println("===========================================================");
                        break;

                    } else if (pilihCari.equals("3")) {
                        System.out.println("\n===========================================================");
                        System.out.print("Cari tempat wisata dengan rating minimal: ");
                        float rate = input.nextFloat();
                        input.nextLine();
                        System.out.println("-----------------------------------------------------------");
                        search.searchByRating(graph, rate);
                        System.out.println("===========================================================");
                        break;

                    } else if (pilihCari.equals("4")) {
                        System.out.println("\n===========================================================");
                        System.out.print("Cari tempat wisata di dalam kabupaten: ");
                        String cari = input.nextLine();
                        System.out.println("-----------------------------------------------------------");
                        search.searchByKabupaten(graph, cari);
                        System.out.println("===========================================================");
                        break;

                    } else if (pilihCari.equals("5")) {
                        break;

                    } else {
                        System.out.println("[X] Pilihan tidak valid");
                        break;
                    }

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
                            input.nextLine();
                            queue.displayQueue();
                            break;
                        case "2":
                            input.nextLine();
                            System.out.print("\nMasukkan Nama Anda: ");
                            String name = input.nextLine();
                            System.out.print("Tanggal Tour (DD-MM-YYYY): ");
                            String tanggal = input.nextLine();
                            queue.enqueueCondi(name, tanggal);
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

                    if (queue.first == null) {
                        System.out.println("\n[X] Tidak ada pengunjung dalam antrian!");
                        System.out.println("    Silakan daftar antrian terlebih dahulu (Menu 3).");
                        continue;
                    }

                    queue.displayQueue();
                    System.out.print("\nProses pengunjung pertama? (Y/N): ");
                    String konfirmasi = input.nextLine();

                    if (!konfirmasi.equalsIgnoreCase("Y")) {
                        continue;
                    }

                    QueueNode orang = queue.dequeue();

                    System.out.println("\n===========================================================");
                    System.out.println("         SELAMAT DATANG " + orang.pengunjung + "!");
                    System.out.println("         Lokasi: Kantor Tour Mataram");
                    System.out.println("         Tanggal Tour: " + orang.tanggalTour);
                    System.out.println("===========================================================");

                    LinkedList finalTujuan = new LinkedList();
                    boolean lanjutTour = true;
                    String lokasiSekarang = "Mataram";

                    while (lanjutTour) {
                        GNodeWisata tujuan = null;
                        String namaTujuan = "";

                        while (tujuan == null) {
                            System.out.println("\n[ LTG ]: Mau kemana hari ini?");
                            System.out.println("         (Ketik nama wisata atau 'list' untuk lihat semua)");
                            System.out.print("[" + orang.pengunjung + "]: ");
                            namaTujuan = input.nextLine();

                            if (namaTujuan.equalsIgnoreCase("list")) {
                                displaySemuaWisata(graph);
                                continue;
                            }

                            tujuan = search.searchByNama(graph, namaTujuan);

                            if (tujuan == null) {
                                System.out.println("[X] Maaf, tujuan \"" + namaTujuan + "\" belum terdaftar dalam sistem.");
                                System.out.print("    Coba lagi? (Y/N): ");
                                String coba = input.nextLine();
                                if (!coba.equalsIgnoreCase("Y")) {
                                    break;
                                }
                            }
                        }

                        if (tujuan == null) {
                            System.out.println("\n[Info] Tidak ada tujuan yang dipilih.");
                            break;
                        }

                        String kabupatenTujuan = cariKabupatenDariWisata(graph, namaTujuan);

                        if (kabupatenTujuan == null) {
                            System.out.println("[X] Error: Tidak dapat menemukan kabupaten wisata ini!");
                            continue;
                        }

                        System.out.println("\n-----------------------------------------------------------");
                        System.out.println("[V] Wisata ditemukan: " + namaTujuan);
                        System.out.println("    Lokasi: " + kabupatenTujuan);
                        System.out.println("    Rating: " + tujuan.formatRating(tujuan.rating));
                        System.out.println("-----------------------------------------------------------");

                        System.out.print("\nKonfirmasi perjalanan ke " + namaTujuan + "? (Y/N): ");
                        String konfirmasiJalan = input.nextLine();

                        if (!konfirmasiJalan.equalsIgnoreCase("Y")) {
                            continue;
                        }

                        finalTujuan.addTujuanOnly(namaTujuan);

                        System.out.println("  [Info] Perjalanan dimulai...");
                        System.out.println("\n[Sistem] Menghitung rute terbaik...\n");

                        PathResult ruteKabupaten = graph.dijkstra(lokasiSekarang, kabupatenTujuan);

                        if (!ruteKabupaten.found) {
                            System.out.println("[X] Tidak dapat menemukan rute ke " + kabupatenTujuan);
                            continue;
                        }

                        GNodeKabupaten kabNode = graph.getNode(kabupatenTujuan);

                        if (kabNode == null) {
                            System.out.println("[X] Error: Node kabupaten tidak ditemukan!");
                            continue;
                        }

                        GNodeWisata entryWisata = kabNode.graphWisata.firstWisata;

                        if (entryWisata == null) {
                            System.out.println("[X] Kabupaten ini tidak memiliki wisata!");
                            continue;
                        }

                        PathResult ruteWisata = kabNode.graphWisata.dijkstra(entryWisata.namaWisata, namaTujuan);

                        if (!ruteWisata.found) {
                            System.out.println("[X] Tidak dapat menemukan rute ke wisata " + namaTujuan);
                            continue;
                        }

                        displayRuteKabupaten(ruteKabupaten, lokasiSekarang, kabupatenTujuan);
                        displayRuteWisata(ruteWisata, kabupatenTujuan);

                        simpanJalurKeLinkedList(orang.jalur, ruteKabupaten, ruteWisata, kabupatenTujuan);

                        System.out.println("\n===========================================================");
                        System.out.println("  [V] Tiba di " + namaTujuan + "!");
                        System.out.println("===========================================================");

                        lokasiSekarang = kabupatenTujuan;

                        String pilihNext;
                        Boolean loop;
                        do{
                            loop = false;
                            System.out.println("\n===========================================================");
                            System.out.println("         ANDA SEKARANG DI " + namaTujuan.toUpperCase());
                            System.out.println("===========================================================");
                            System.out.println("         APA YANG INGIN ANDA LAKUKAN?");
                            System.out.println("===========================================================");
                            System.out.println("  1. Lanjut ke wisata lain");
                            System.out.println("  2. Selesai tour (kembali ke Mataram)");
                            System.out.println("===========================================================");
                            System.out.print("Pilihan: ");
                            pilihNext = input.next();

                            if ((!pilihNext.equals("1")) && (!pilihNext.equals("2"))) {
                                System.out.println("[X] Error: Pilihan tidak valid!");
                                loop = true;
                            }
                        }while (loop);

                        if (pilihNext.equals("2")) {
                            lanjutTour = false;
                        }

                        input.nextLine();
                    }

                    System.out.println("\n===========================================================");
                    System.out.println("                TOUR SELESAI!");
                    System.out.println("===========================================================");

                    orang.jalur.displayJalur();

                    int jumlahWisata = finalTujuan.size;

                    if (jumlahWisata > 0) {
                        System.out.println("\n===========================================================");
                        System.out.println("          BERIKAN RATING & KOMENTAR");
                        System.out.println("===========================================================");
                        System.out.print("Apakah Anda ingin memberikan review? (Y/N): ");
                        String mauReview = input.nextLine();

                        if (mauReview.equalsIgnoreCase("Y")) {
                            LLNode current = finalTujuan.head;
                            int num = 1;

                            while (current != null) {
                                System.out.println("\n===========================================================");
                                System.out.println("  [" + num + "/" + jumlahWisata + "] " + current.lokasi);
                                System.out.println("===========================================================");

                                int rating = 0;
                                while (rating < 1 || rating > 5) {
                                    System.out.print("  Rating (1-5): ");
                                    rating = input.nextInt();
                                    input.nextLine();
                                    if (rating < 1 || rating > 5) {
                                        System.out.println("  [X] Rating harus antara 1-5!");
                                    }
                                }

                                System.out.print("  Komentar: ");
                                String komentar = input.nextLine();

                                GNodeWisata wisataNode = search.searchByNama(graph, current.lokasi);
                                if (wisataNode != null) {
                                    wisataNode.ulasan.push(orang.pengunjung, rating, komentar, orang.tanggalTour);
                                    wisataNode.updateRating();
                                }

                                current = current.next;
                                num++;
                            }

                            System.out.println("\n===========================================================");
                            System.out.println("  [V] Semua ulasan berhasil disimpan!");
                            System.out.println("===========================================================");
                        }
                    }

                    System.out.println("\n===========================================================");
                    System.out.println("            TERIMA KASIH " + orang.pengunjung + "!");
                    System.out.println("           Tour selesai. Sampai jumpa!");
                    System.out.println("===========================================================");
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