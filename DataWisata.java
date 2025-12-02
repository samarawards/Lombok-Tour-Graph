public class DataWisata {
    // Setup wisata di Lombok Barat 1 (Area Senggigi)
    public static void setupWisataLombokBarat1(GraphWisata graph) {
        // Tambah wisata dengan info lengkap
        graph.addWisataWithInfo(
            "Pantai Senggigi", 
            "Pantai terkenal dengan sunset indah dan fasilitas lengkap", 
            "Pantai"
        );
        graph.addWisataWithInfo(
            "Bukit Malimbu", 
            "Bukit dengan view Gili Trawangan dari atas dan foto instagramable", 
            "Bukit"
        );
        graph.addWisataWithInfo(
            "Puncak Pusuk", 
            "Hutan dengan banyak monyet liar dan udara sejuk pegunungan", 
            "Hutan Wisata"
        );
        graph.addWisataWithInfo(
            "Pantai Klui", 
            "Pantai tenang dengan pasir putih dan spot snorkeling", 
            "Pantai"
        );
        graph.addWisataWithInfo(
            "Pantai Setangi", 
            "Pantai tersembunyi dengan ombak besar untuk surfing", 
            "Pantai"
        );
        graph.addWisataWithInfo(
            "Pantai Kerandangan", 
            "Pantai dengan view sunset dan batu karang unik", 
            "Pantai"
        );
        
        // Setup jalur antar wisata
        graph.addJalurWisata("Pantai Senggigi", "Bukit Malimbu", 6.0f);
        graph.addJalurWisata("Pantai Senggigi", "Puncak Pusuk", 22.0f);
        graph.addJalurWisata("Pantai Senggigi", "Pantai Klui", 14.0f);
        graph.addJalurWisata("Pantai Senggigi", "Pantai Setangi", 12.0f);
        graph.addJalurWisata("Pantai Senggigi", "Pantai Kerandangan", 18.0f);
        
        graph.addJalurWisata("Bukit Malimbu", "Puncak Pusuk", 20.0f);
        graph.addJalurWisata("Bukit Malimbu", "Pantai Klui", 10.0f);
        graph.addJalurWisata("Bukit Malimbu", "Pantai Setangi", 9.0f);
        graph.addJalurWisata("Bukit Malimbu", "Pantai Kerandangan", 15.0f);
        
        graph.addJalurWisata("Puncak Pusuk", "Pantai Klui", 25.0f);
        graph.addJalurWisata("Puncak Pusuk", "Pantai Setangi", 24.0f);
        graph.addJalurWisata("Puncak Pusuk", "Pantai Kerandangan", 28.0f);
        
        graph.addJalurWisata("Pantai Klui", "Pantai Setangi", 6.0f);
        graph.addJalurWisata("Pantai Klui", "Pantai Kerandangan", 12.0f);
        
        graph.addJalurWisata("Pantai Setangi", "Pantai Kerandangan", 14.0f);
    }
    
    // Setup wisata di Lombok Barat 2 (Area Lembar - Gili Selatan)
    public static void setupWisataLombokBarat2(GraphWisata graph) {
        graph.addWisataWithInfo(
            "Pantai Cemare", 
            "Pantai tenang dengan view pegunungan dan pelabuhan tradisional", 
            "Pantai"
        );
        graph.addWisataWithInfo(
            "Pantai Kuranji", 
            "Pantai dengan pasir putih dan spot memancing ikan", 
            "Pantai"
        );
        graph.addWisataWithInfo(
            "Gili Gede", 
            "Pulau besar dengan resort mewah dan kehidupan laut beragam", 
            "Pulau"
        );
        graph.addWisataWithInfo(
            "Gili Layar", 
            "Pulau kecil dengan pantai sepi dan spot diving terbaik", 
            "Pulau"
        );
        graph.addWisataWithInfo(
            "Gili Asahan", 
            "Pulau dengan penginapan tradisional dan suasana tenang", 
            "Pulau"
        );
        graph.addWisataWithInfo(
            "Gili Rengit", 
            "Pulau eksotis dengan terumbu karang indah dan air jernih", 
            "Pulau"
        );
        
        graph.addJalurWisata("Pantai Cemare", "Pantai Kuranji", 8.0f);
        graph.addJalurWisata("Pantai Cemare", "Gili Gede", 35.0f);
        graph.addJalurWisata("Pantai Cemare", "Gili Layar", 40.0f);
        graph.addJalurWisata("Pantai Cemare", "Gili Asahan", 38.0f);
        graph.addJalurWisata("Pantai Cemare", "Gili Rengit", 37.0f);
        
        graph.addJalurWisata("Pantai Kuranji", "Gili Gede", 30.0f);
        graph.addJalurWisata("Pantai Kuranji", "Gili Layar", 35.0f);
        graph.addJalurWisata("Pantai Kuranji", "Gili Asahan", 33.0f);
        graph.addJalurWisata("Pantai Kuranji", "Gili Rengit", 32.0f);
        
        graph.addJalurWisata("Gili Gede", "Gili Layar", 8.0f);
        graph.addJalurWisata("Gili Gede", "Gili Asahan", 10.0f);
        graph.addJalurWisata("Gili Gede", "Gili Rengit", 12.0f);
        
        graph.addJalurWisata("Gili Layar", "Gili Asahan", 6.0f);
        graph.addJalurWisata("Gili Layar", "Gili Rengit", 7.0f);
        
        graph.addJalurWisata("Gili Asahan", "Gili Rengit", 5.0f);
    }
    
    // Setup wisata di Lombok Barat 3 (Area Narmada)
    public static void setupWisataLombokBarat3(GraphWisata graph) {
        graph.addWisataWithInfo(
            "Taman Narmada", 
            "Taman bersejarah dengan kolam dan bangunan kerajaan Bali kuno", 
            "Taman"
        );
        graph.addWisataWithInfo(
            "Taman Suranadi", 
            "Taman dengan sumber mata air suci dan pura Hindu", 
            "Taman"
        );
        graph.addWisataWithInfo(
            "Air Terjun Tibu Atas", 
            "Air terjun tinggi dengan trekking menantang di hutan tropis", 
            "Air Terjun"
        );
        graph.addWisataWithInfo(
            "Taman Hutan Suranadi", 
            "Hutan lindung dengan kera ekor panjang dan jalur hiking", 
            "Hutan Wisata"
        );
        graph.addWisataWithInfo(
            "Kolam Renang Suranadi", 
            "Kolam alami dengan air pegunungan yang dingin dan segar", 
            "Kolam Renang"
        );
        graph.addWisataWithInfo(
            "Narmada Botanic Garden", 
            "Kebun botani dengan koleksi tanaman tropis dan edukasi", 
            "Taman"
        );
        graph.addWisataWithInfo(
            "Pemandian Sesaot", 
            "Pemandian alami dengan air jernih dari mata air pegunungan", 
            "Pemandian"
        );
        
        graph.addJalurWisata("Taman Narmada", "Taman Suranadi", 9.0f);
        graph.addJalurWisata("Taman Narmada", "Air Terjun Tibu Atas", 18.0f);
        graph.addJalurWisata("Taman Narmada", "Taman Hutan Suranadi", 10.0f);
        graph.addJalurWisata("Taman Narmada", "Kolam Renang Suranadi", 9.0f);
        graph.addJalurWisata("Taman Narmada", "Narmada Botanic Garden", 3.0f);
        graph.addJalurWisata("Taman Narmada", "Pemandian Sesaot", 7.0f);
        
        graph.addJalurWisata("Taman Suranadi", "Air Terjun Tibu Atas", 16.0f);
        graph.addJalurWisata("Taman Suranadi", "Taman Hutan Suranadi", 4.0f);
        graph.addJalurWisata("Taman Suranadi", "Kolam Renang Suranadi", 2.0f);
        graph.addJalurWisata("Taman Suranadi", "Narmada Botanic Garden", 8.0f);
        graph.addJalurWisata("Taman Suranadi", "Pemandian Sesaot", 6.0f);
        
        graph.addJalurWisata("Air Terjun Tibu Atas", "Taman Hutan Suranadi", 19.0f);
        graph.addJalurWisata("Air Terjun Tibu Atas", "Kolam Renang Suranadi", 17.0f);
        graph.addJalurWisata("Air Terjun Tibu Atas", "Narmada Botanic Garden", 20.0f);
        graph.addJalurWisata("Air Terjun Tibu Atas", "Pemandian Sesaot", 15.0f);
        
        graph.addJalurWisata("Taman Hutan Suranadi", "Kolam Renang Suranadi", 3.0f);
        graph.addJalurWisata("Taman Hutan Suranadi", "Narmada Botanic Garden", 9.0f);
        graph.addJalurWisata("Taman Hutan Suranadi", "Pemandian Sesaot", 6.0f);
        
        graph.addJalurWisata("Kolam Renang Suranadi", "Narmada Botanic Garden", 8.0f);
        graph.addJalurWisata("Kolam Renang Suranadi", "Pemandian Sesaot", 5.0f);
        
        graph.addJalurWisata("Narmada Botanic Garden", "Pemandian Sesaot", 4.0f);
    }
    
    // Setup wisata di Lombok Tengah
    public static void setupWisataLombokTengah(GraphWisata graph) {
        graph.addWisataWithInfo(
            "Pantai Kuta Mandalika", 
            "Pantai dengan pasir seperti merica dan spot surfing internasional", 
            "Pantai"
        );
        graph.addWisataWithInfo(
            "Sirkuit Mandalika", 
            "Sirkuit MotoGP pertama di Indonesia dengan fasilitas world class", 
            "Sirkuit"
        );
        graph.addWisataWithInfo(
            "Pantai Tanjung Aan", 
            "Pantai dengan 2 jenis pasir berbeda dan teluk landai", 
            "Pantai"
        );
        graph.addWisataWithInfo(
            "Bukit Merese", 
            "Bukit rumput hijau dengan sunset spektakuler dan view 360 derajat", 
            "Bukit"
        );
        graph.addWisataWithInfo(
            "Pantai Seger", 
            "Pantai dengan legenda Putri Mandalika dan upacara Bau Nyale", 
            "Pantai"
        );
        graph.addWisataWithInfo(
            "Pantai Selong Belanak", 
            "Pantai luas dengan ombak tenang cocok untuk belajar surfing", 
            "Pantai"
        );
        graph.addWisataWithInfo(
            "Desa Sade", 
            "Desa adat Sasak dengan rumah tradisional dan kerajinan tenun", 
            "Desa Wisata"
        );
        graph.addWisataWithInfo(
            "Air Terjun Benang Kelambu", 
            "Air terjun unik dengan air mengalir seperti tirai kelambu", 
            "Air Terjun"
        );
        graph.addWisataWithInfo(
            "Air Terjun Benang Stokel", 
            "Air terjun kembar dengan kolam alami untuk berenang", 
            "Air Terjun"
        );
        
        graph.addJalurWisata("Pantai Kuta Mandalika", "Sirkuit Mandalika", 3.0f);
        graph.addJalurWisata("Pantai Kuta Mandalika", "Pantai Tanjung Aan", 18.0f);
        graph.addJalurWisata("Pantai Kuta Mandalika", "Bukit Merese", 16.0f);
        graph.addJalurWisata("Pantai Kuta Mandalika", "Pantai Seger", 20.0f);
        graph.addJalurWisata("Pantai Kuta Mandalika", "Pantai Selong Belanak", 30.0f);
        graph.addJalurWisata("Pantai Kuta Mandalika", "Desa Sade", 22.0f);
        graph.addJalurWisata("Pantai Kuta Mandalika", "Air Terjun Benang Kelambu", 60.0f);
        graph.addJalurWisata("Pantai Kuta Mandalika", "Air Terjun Benang Stokel", 62.0f);
        
        graph.addJalurWisata("Sirkuit Mandalika", "Pantai Tanjung Aan", 18.0f);
        graph.addJalurWisata("Sirkuit Mandalika", "Bukit Merese", 15.0f);
        graph.addJalurWisata("Sirkuit Mandalika", "Pantai Seger", 19.0f);
        graph.addJalurWisata("Sirkuit Mandalika", "Pantai Selong Belanak", 29.0f);
        graph.addJalurWisata("Sirkuit Mandalika", "Desa Sade", 21.0f);
        graph.addJalurWisata("Sirkuit Mandalika", "Air Terjun Benang Kelambu", 59.0f);
        graph.addJalurWisata("Sirkuit Mandalika", "Air Terjun Benang Stokel", 61.0f);
        
        graph.addJalurWisata("Pantai Tanjung Aan", "Bukit Merese", 6.0f);
        graph.addJalurWisata("Pantai Tanjung Aan", "Pantai Seger", 10.0f);
        graph.addJalurWisata("Pantai Tanjung Aan", "Pantai Selong Belanak", 22.0f);
        graph.addJalurWisata("Pantai Tanjung Aan", "Desa Sade", 25.0f);
        graph.addJalurWisata("Pantai Tanjung Aan", "Air Terjun Benang Kelambu", 68.0f);
        graph.addJalurWisata("Pantai Tanjung Aan", "Air Terjun Benang Stokel", 70.0f);
        
        graph.addJalurWisata("Bukit Merese", "Pantai Seger", 12.0f);
        graph.addJalurWisata("Bukit Merese", "Pantai Selong Belanak", 24.0f);
        graph.addJalurWisata("Bukit Merese", "Desa Sade", 27.0f);
        graph.addJalurWisata("Bukit Merese", "Air Terjun Benang Kelambu", 65.0f);
        graph.addJalurWisata("Bukit Merese", "Air Terjun Benang Stokel", 67.0f);
        
        graph.addJalurWisata("Pantai Seger", "Pantai Selong Belanak", 20.0f);
        graph.addJalurWisata("Pantai Seger", "Desa Sade", 30.0f);
        graph.addJalurWisata("Pantai Seger", "Air Terjun Benang Kelambu", 72.0f);
        graph.addJalurWisata("Pantai Seger", "Air Terjun Benang Stokel", 74.0f);
        
        graph.addJalurWisata("Pantai Selong Belanak", "Desa Sade", 40.0f);
        graph.addJalurWisata("Pantai Selong Belanak", "Air Terjun Benang Kelambu", 75.0f);
        graph.addJalurWisata("Pantai Selong Belanak", "Air Terjun Benang Stokel", 77.0f);
        
        graph.addJalurWisata("Desa Sade", "Air Terjun Benang Kelambu", 55.0f);
        graph.addJalurWisata("Desa Sade", "Air Terjun Benang Stokel", 57.0f);
        
        graph.addJalurWisata("Air Terjun Benang Kelambu", "Air Terjun Benang Stokel", 6.0f);
    }
    
    // Setup wisata di Lombok Timur
    public static void setupWisataLombokTimur(GraphWisata graph) {
        graph.addWisataWithInfo(
            "Gunung Rinjani", 
            "Gunung berapi aktif tertinggi kedua di Indonesia dengan danau Segara Anak", 
            "Gunung"
        );
        graph.addWisataWithInfo(
            "Bukit Pergasingan", 
            "Bukit dengan sunrise terbaik dan view Gunung Rinjani", 
            "Bukit"
        );
        graph.addWisataWithInfo(
            "Sembalun", 
            "Desa di kaki Rinjani dengan pemandangan savana hijau luas", 
            "Desa Wisata"
        );
        graph.addWisataWithInfo(
            "Air Terjun Jeruk Manis", 
            "Air terjun dengan air dingin dan trek hiking menantang", 
            "Air Terjun"
        );
        graph.addWisataWithInfo(
            "Pantai Pink", 
            "Pantai dengan pasir merah muda unik hasil pecahan karang", 
            "Pantai"
        );
        graph.addWisataWithInfo(
            "Gili Pasir", 
            "Pulau pasir yang muncul saat air laut surut dengan view 360", 
            "Pulau"
        );
        graph.addWisataWithInfo(
            "Savana Sembalun", 
            "Padang savana luas dengan bunga edelweis dan kambing liar", 
            "Savana"
        );
        graph.addWisataWithInfo(
            "Kebun Stroberi Sembalun", 
            "Kebun stroberi petik sendiri dengan udara sejuk pegunungan", 
            "Kebun Wisata"
        );
        
        graph.addJalurWisata("Gunung Rinjani", "Bukit Pergasingan", 18.0f);
        graph.addJalurWisata("Gunung Rinjani", "Sembalun", 10.0f);
        graph.addJalurWisata("Gunung Rinjani", "Air Terjun Jeruk Manis", 40.0f);
        graph.addJalurWisata("Gunung Rinjani", "Pantai Pink", 85.0f);
        graph.addJalurWisata("Gunung Rinjani", "Gili Pasir", 70.0f);
        graph.addJalurWisata("Gunung Rinjani", "Savana Sembalun", 12.0f);
        graph.addJalurWisata("Gunung Rinjani", "Kebun Stroberi Sembalun", 11.0f);
        
        graph.addJalurWisata("Bukit Pergasingan", "Sembalun", 8.0f);
        graph.addJalurWisata("Bukit Pergasingan", "Air Terjun Jeruk Manis", 38.0f);
        graph.addJalurWisata("Bukit Pergasingan", "Pantai Pink", 82.0f);
        graph.addJalurWisata("Bukit Pergasingan", "Gili Pasir", 67.0f);
        graph.addJalurWisata("Bukit Pergasingan", "Savana Sembalun", 10.0f);
        graph.addJalurWisata("Bukit Pergasingan", "Kebun Stroberi Sembalun", 9.0f);
        
        graph.addJalurWisata("Sembalun", "Air Terjun Jeruk Manis", 35.0f);
        graph.addJalurWisata("Sembalun", "Pantai Pink", 80.0f);
        graph.addJalurWisata("Sembalun", "Gili Pasir", 65.0f);
        graph.addJalurWisata("Sembalun", "Savana Sembalun", 5.0f);
        graph.addJalurWisata("Sembalun", "Kebun Stroberi Sembalun", 6.0f);
        
        graph.addJalurWisata("Air Terjun Jeruk Manis", "Pantai Pink", 60.0f);
        graph.addJalurWisata("Air Terjun Jeruk Manis", "Gili Pasir", 48.0f);
        graph.addJalurWisata("Air Terjun Jeruk Manis", "Savana Sembalun", 37.0f);
        graph.addJalurWisata("Air Terjun Jeruk Manis", "Kebun Stroberi Sembalun", 36.0f);
        
        graph.addJalurWisata("Pantai Pink", "Gili Pasir", 5.0f);
        graph.addJalurWisata("Pantai Pink", "Savana Sembalun", 82.0f);
        graph.addJalurWisata("Pantai Pink", "Kebun Stroberi Sembalun", 81.0f);
        
        graph.addJalurWisata("Gili Pasir", "Savana Sembalun", 67.0f);
        graph.addJalurWisata("Gili Pasir", "Kebun Stroberi Sembalun", 66.0f);
        
        graph.addJalurWisata("Savana Sembalun", "Kebun Stroberi Sembalun", 2.0f);
    }
    
    // Setup wisata di Lombok Utara
    public static void setupWisataLombokUtara(GraphWisata graph) {
        graph.addWisataWithInfo(
            "Gili Trawangan", 
            "Pulau dengan kehidupan malam terbaik dan spot diving berkelas dunia", 
            "Pulau"
        );
        graph.addWisataWithInfo(
            "Gili Air", 
            "Pulau dengan suasana tenang dan spot snorkeling dekat pantai", 
            "Pulau"
        );
        graph.addWisataWithInfo(
            "Gili Meno", 
            "Pulau paling tenang cocok untuk honeymoon dengan penyu laut", 
            "Pulau"
        );
        graph.addWisataWithInfo(
            "Air Terjun Sendang Gile", 
            "Air terjun megah dengan debit air deras dan jalur pendek", 
            "Air Terjun"
        );
        graph.addWisataWithInfo(
            "Air Terjun Tiu Kelep", 
            "Air terjun tersembunyi dengan rainbow dan kolam alami", 
            "Air Terjun"
        );
        graph.addWisataWithInfo(
            "Pantai Nipah", 
            "Pantai dengan pasir hitam vulkanik dan ombak tenang", 
            "Pantai"
        );
        graph.addWisataWithInfo(
            "Desa Wisata Senaru", 
            "Desa tradisional Sasak dengan budaya asli dan rumah adat", 
            "Desa Wisata"
        );
        
        graph.addJalurWisata("Gili Trawangan", "Gili Air", 3.0f);
        graph.addJalurWisata("Gili Trawangan", "Gili Meno", 4.0f);
        graph.addJalurWisata("Gili Air", "Gili Meno", 2.5f);
        
        graph.addJalurWisata("Gili Trawangan", "Air Terjun Sendang Gile", 35.0f);
        graph.addJalurWisata("Gili Air", "Air Terjun Sendang Gile", 33.0f);
        graph.addJalurWisata("Gili Meno", "Air Terjun Sendang Gile", 34.0f);
        
        graph.addJalurWisata("Air Terjun Sendang Gile", "Air Terjun Tiu Kelep", 1.5f);
        graph.addJalurWisata("Air Terjun Sendang Gile", "Pantai Nipah", 40.0f);
        graph.addJalurWisata("Air Terjun Sendang Gile", "Desa Wisata Senaru", 3.0f);
        
        graph.addJalurWisata("Air Terjun Tiu Kelep", "Pantai Nipah", 41.0f);
        graph.addJalurWisata("Air Terjun Tiu Kelep", "Desa Wisata Senaru", 2.5f);
        
        graph.addJalurWisata("Pantai Nipah", "Desa Wisata Senaru", 38.0f);
    }
    
    // Setup dummy review untuk testing
    public static void setupDummyReview(GraphKabupaten graph) {
        // Review untuk beberapa wisata populer
        
        // Sembalun
        GNodeKabupaten lombokTimur = graph.getNode("Lombok Timur");
        if (lombokTimur != null) {
            GNodeWisata sembalun = lombokTimur.graphWisata.getNode("Sembalun");
            if (sembalun != null) {
                sembalun.ulasan.push("Fatio", 5, "Pemandangan savana luar biasa! Must visit!", "01-12-2024");
                sembalun.ulasan.push("Ayu", 4, "Bagus tapi jalannya rusak", "28-11-2024");
                sembalun.ulasan.push("Ara", 5, "Udara sejuk dan view 360 derajat mantap", "25-11-2024");
                sembalun.updateRating();
            }
            
            GNodeWisata pantaiPink = lombokTimur.graphWisata.getNode("Pantai Pink");
            if (pantaiPink != null) {
                pantaiPink.ulasan.push("Nazril", 5, "Pasir pink nya unik banget!", "02-12-2024");
                pantaiPink.ulasan.push("Habib", 4, "Perjalanan jauh tapi worth it", "30-11-2024");
                pantaiPink.updateRating();
            }
        }
        
        // Gili Trawangan
        GNodeKabupaten lombokUtara = graph.getNode("Lombok Utara");
        if (lombokUtara != null) {
            GNodeWisata giliT = lombokUtara.graphWisata.getNode("Gili Trawangan");
            if (giliT != null) {
            giliT.ulasan.push("Naya", 5, "Party island terbaik di Indonesia!", "03-12-2024");
            giliT.ulasan.push("Gea", 5, "Diving spot keren dan nightlife seru", "01-12-2024");
            giliT.ulasan.push("Bang Ridho", 4, "Ramai tapi menyenangkan", "29-11-2024");
            giliT.updateRating();
            }
        }
        // Pantai Kuta Mandalika
        GNodeKabupaten lombokTengah = graph.getNode("Lombok Tengah");
        if (lombokTengah != null) {
            GNodeWisata kuta = lombokTengah.graphWisata.getNode("Pantai Kuta Mandalika");
            if (kuta != null) {
                kuta.ulasan.push("Fatio", 5, "Pantai dengan pasir seperti merica, unik!", "02-12-2024");
                kuta.ulasan.push("Nazril", 4, "Ombak bagus untuk surfing", "30-11-2024");
                kuta.ulasan.push("Habib", 5, "Sunset view spektakuler", "27-11-2024");
                kuta.updateRating();
            }
        }
    }
}