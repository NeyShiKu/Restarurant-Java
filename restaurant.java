import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class restaurant {
    ArrayList <Menu> makanan = new ArrayList<>();
    ArrayList <Pesanan> pesanan = new ArrayList<>();
    ArrayList <Riwayat> riwayat = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        @SuppressWarnings("resource")
        int opsi;

        //Menampilkan menu
        restaurant app = new restaurant();

        //Menjalankan pilihan
        while (run) {
            app.tampilanAwal();
            System.out.print("\nPilih opsi: ");
            opsi = input.nextInt();

            input.nextLine();

            switch (opsi) {
                case 0 -> {
                    System.out.print("\nUsername: ");
                    String username = input.nextLine();
                    System.out.print("Password: ");
                    String password = input.nextLine();

                    if (username.equals("admin") && password.equals("admin123")) {
                        System.out.println("Selamat datang admin\n");

                        app.Admin();
                    } else {
                        System.out.println("Gagal");
                    }
                }
                case 1 -> {
                    System.out.println("\n------------MENU------------");
                    app.tampilanMenu();
                }
                case 2 -> {
                    System.out.println("\n----------PENCARIAN----------");
                    app.mencarimenu();
                }
                case 3 -> {
                    System.out.println("\n----------URUTKAN----------");
                    app.urutan();
                }
                case 4 -> {
                    System.out.println("\n----------PEMBELIAN----------");
                    app.membeli();
                }
                case 5 -> {
                    System.out.println("----------UBAH PESANAN----------");
                    app.ubah();
                }
                case 6 -> {
                    System.out.println("\n------------TOTAL------------");
                    app.total();
                }
                case 7 -> {
                    System.out.println("SANKYU!!!");
                    run = false;
                }
                default -> System.out.println("Input tidak valid");
            }
        }
    }

    //Print pilihan tampilan awal
    public void tampilanAwal() {
        System.out.println("");
        System.out.println("-----------MENU-----------");
        System.out.println("| 1 |Menampilkan menu    |");
        System.out.println("| 2 |Pencarian           |");
        System.out.println("| 3 |Urutkan             |");
        System.out.println("| 4 |Membeli             |");
        System.out.println("| 5 |Ubah pesanan        |");
        System.out.println("| 6 |Total beli          |");
        System.out.println("| 7 |Exit                |");
        System.out.println("--------------------------");
    }

    //Print interface admin
    public void tampilanAdmin() {
        System.out.println("");
        System.out.println("-----------ADMIN-----------");
        System.out.println("| 1 |Tambah menu          |");
        System.out.println("| 2 |Hapus/Kurangi menu   |");
        System.out.println("| 3 |List Menu            |");
        System.out.println("| 4 |Riwayat pembelian    |");
        System.out.println("| 5 |Exit                 |");
        System.out.println("---------------------------");
    }

    //Interface admin
    public void Admin() {
        boolean inadmin = true;
        while (inadmin) {
            tampilanAdmin();
            System.out.print("Pilih opsi: ");
            int opsi = input.nextInt();
            
            switch (opsi) {
                case 1 -> {
                    System.out.println("-------------TAMBAH MENU-------------");
                    tambahMenu();
                }
                case 2 -> {
                    System.out.println("-------------KURANGI MENU-------------");
                    kurangiMenu();
                }
                case 3 -> {
                    System.out.println("\n------------MENU------------");
                    tampilanMenu();
                }
                case 4 -> {
                  System.out.println("----------RIWAYAT----------");
                  isiRiwayat();
                }
                case 5 -> {
                  System.out.println("BYE ADMIN");
                  inadmin = false;
                }
                default -> System.out.println("Input tidak valid");
            }
        }
    }
    
    //Menambah(Awalan) menu ke restaurant
    public restaurant() {
        makanan.add(new Menu("Bakmi Kuah", 10000, 5));
        makanan.add(new Menu("Bakmi Goreng", 11000, 5));
        makanan.add(new Menu("Nasi Goreng", 15000, 5));
        makanan.add(new Menu("Bakso", 10000, 5));
        makanan.add(new Menu("Mie Ayam", 12000, 5));
        makanan.add(new Menu("Miso", 15000, 5));
        makanan.add(new Menu("Ayam Geprek", 10000, 5));
    }

    //Print menu yang tersedia
    public void tampilanMenu() {
        for (Menu menu : makanan) { //for (int t = 0; i < makanan.size(); i++) {Menu menu = makanan.get[i];}
            System.out.println("Nama: "+menu.namaMenu);
            System.out.println("Harga: "+menu.hargaMenu);
            System.out.println("Stok: "+menu.stokMenu);
            System.out.println("----------------------------");
        }
    }

    //PENCARIAN MENU
    public void mencarimenu() {
        boolean ketemu = false;

        System.out.print("Ketik nama makanan: ");
        String cari = input.nextLine();

        System.out.println("");
        for (Menu menu : makanan) {
            if (menu.namaMenu.toLowerCase().contains(cari.toLowerCase())) { //containts
                System.out.println("Menu yang sesuai: "+menu.namaMenu);
                ketemu = true;
            }
        }

        if (!ketemu) {
            System.out.println("Maaf menu tidak ditemukan");
        }
    }

    //URUTAN
    public void urutan() {
        System.out.println("1.Ascending Abjad");
        System.out.println("2.Descending Abjad");
        System.out.println("3.Harga Termurah");
        System.out.println("4.Harga Termahal");
        System.out.print("\nPilih: ");
        int pilih = input.nextInt();

        System.out.println("");
        switch (pilih) {
            case 1 -> {
                makanan.sort(Comparator.comparing(Menu::getnama));
                int i = 1;

                System.out.println("-------ASCENDING-------");
                for (Menu menu : makanan) {
                    System.out.println(i+". "+menu.namaMenu);
                    i++;
                }
            }
            case 2 -> {
                makanan.sort(Comparator.comparing(Menu::getnama).reversed());
                int i = 1;

                System.out.println("-------DESCENDING-------");
                for (Menu menu : makanan) {
                    System.out.println(i+". "+menu.namaMenu);
                    i++;
                }
            }
            case 3 -> {
                makanan.sort(Comparator.comparingInt(Menu::getharga)); //Mengambil reference
                int i = 1;
                
                System.out.println("-------TERMURAH-------");
                for (Menu menu : makanan) {
                    System.out.printf(i+". %-20s : Rp.%d\n", menu.namaMenu, menu.hargaMenu);
                    i++;
                }
            }
            case 4 -> {
                makanan.sort(Comparator.comparingInt(Menu::getharga).reversed()); //Mengambil reference
                int i = 1;
                
                System.out.println("-------TERMAHAL-------");
                for (Menu menu : makanan) {
                    System.out.printf(i+". %-20s : Rp.%d\n", menu.namaMenu, menu.hargaMenu);
                    i++;
                }
            }
            default -> System.out.println("Masukan sesuai angka");
        }
    }

    //Logika membeli makanan
    public void membeli() {
        String beli;
        boolean tersedia = false, sama = false;
        int index = 0, index2 = 0, jumlahBeli;
        
        System.out.print("Ingin membeli apa: ");
        beli = input.nextLine();

        for(Menu menu : makanan) {
            if(beli.equalsIgnoreCase(menu.namaMenu)) {
                tersedia = true;
                System.out.println("Pesanan anda "+menu.namaMenu);
                break;
            }
            index++;
        }

        for(Pesanan nota : pesanan) {
            if(beli.equalsIgnoreCase(nota.namaPesanan)) {
                sama = true;
                break;
            }
            index2++;
        }

        if(tersedia) {
            if(sama) {
                Menu menu = makanan.get(index);
                Pesanan nota = pesanan.get(index2);

                System.out.print("Ingin membeli berapa: ");
                jumlahBeli = input.nextInt();
                if (jumlahBeli > menu.stokMenu) {
                    System.out.println("Maaf stok kurang");
                } else {
                    menu.stokMenu -= jumlahBeli;

                    nota.jumlahPesanan += jumlahBeli;
                    nota.totalhargaPesanan = menu.hargaMenu*nota.jumlahPesanan;
                    System.out.println("Pesanan telah ditambah ke nota");
                }
            } else if(!sama) {
                Menu menu = makanan.get(index);
                System.out.print("Ingin membeli berapa: ");
                jumlahBeli = input.nextInt();
                if (jumlahBeli > menu.stokMenu) {
                    System.out.println("Maaf stok kurang");
                } else {
                    menu.stokMenu -= jumlahBeli;

                    pesanan.add(new Pesanan(beli, menu.hargaMenu, jumlahBeli, menu.hargaMenu*jumlahBeli));
                    System.out.println("Pesanan telah ditambah ke nota");
                }
            }
        }

        if(!tersedia) {
            System.out.println("Maaf tidak ada dalam menu");
        }
    }

    //Ubah nota
    public void ubah() {
        String nama;
        boolean ada = false;
        int hapuspesanan;
        char hapus;

        System.out.print("Nama makanan: ");
        nama = input.nextLine();

        for(int i = 0; i < pesanan.size(); i++) {
            Pesanan nota = pesanan.get(i);

            if (nama.equalsIgnoreCase(nota.namaPesanan)) {
                ada = true;
                for (int j = 0; j < makanan.size(); j++){
                    Menu menu = makanan.get(j);

                    if (nama.equalsIgnoreCase(menu.namaMenu)) {
                        System.out.print("Apakah ingin menghapus? (y/n) ");
                        hapus = input.next().charAt(0);
                        
                        if (hapus == 'y') {
                            menu.stokMenu += nota.jumlahPesanan;
                            pesanan.remove(i);
                        } else {
                            System.out.print("Hapus berapa: ");
                            hapuspesanan = input.nextInt();
                            
                            nota.jumlahPesanan -= hapuspesanan;
                            menu.stokMenu += hapuspesanan;
                            nota.totalhargaPesanan = nota.jumlahPesanan * nota.hargaPesanan;
                        }
                    }
                }

                if (nota.jumlahPesanan < 0) {
                    System.out.println("Anda tidak memesan sebanyak itu");
                } else {
                    System.out.println("Pesanan berhasil dihapus");
                }
            } 
        }

        if(!ada) {
          System.out.println("Tidak ada dalam pesanan");  
        }
    }

    //Menampilkan total beli
    public void total() {
        int totalHarga = 0, total = 0, riwayatpembelian;
        char bayar;
        LocalDate hariIni = LocalDate.now();
        StringBuilder dataPesanan = new StringBuilder();

        if (pesanan == null || pesanan.isEmpty()) {
            System.out.println("Anda belum memesan");
        } else {
            for (int i = 0; i < pesanan.size(); i++) {
                Pesanan nota = pesanan.get(i);
                System.out.println("Nama pesanan: "+nota.namaPesanan);
                System.out.println("Harga satuan: "+nota.hargaPesanan);
                System.out.println("Jumlah pesanan: "+nota.jumlahPesanan);
                System.out.println("Total harga: "+nota.totalhargaPesanan);
                System.out.println("---------------------------");
            }
        }

        //total harga
        if (pesanan.size() > 1) {
            for (Pesanan nota : pesanan) {
                totalHarga += nota.totalhargaPesanan;
            }
            System.out.println("Total seluruh harga: Rp."+totalHarga);
            total = totalHarga;
        }

        //bayar
        if (pesanan.size() >= 1) {
            System.out.print("Konfirmasi pembayaran: (y/n) ");
            bayar = input.next().charAt(0);
            if (bayar == 'y') {
                input.nextLine();
                System.out.print("Masukan nama pemesan: ");
                String nama = input.nextLine();
            
                for (Pesanan nota : pesanan) {
                    dataPesanan.append(String.format("""
                        Nama pesanan: %s
                        Harga satuan: %d
                        Jumlah pesanan: %d
                        Total harga: %d
                        --------------------
                        """,
                        nota.namaPesanan,
                        nota.jumlahPesanan,
                        nota.hargaPesanan,
                        nota.totalhargaPesanan
                    ));
                }
                riwayatpembelian = riwayat.size() + 1;
                riwayat.add(new Riwayat(riwayatpembelian, nama, hariIni, total, dataPesanan.toString()));
                System.out.println("Pesanan telah berhasil dibayar, Terima Kasih");
                pesanan.clear();
            }
        }
    }

    //Menambah menu pada admin
    public void tambahMenu() {
        String nama;
        int harga, stok, menus = 0;
        boolean baru = true;

        input.nextLine();
        System.out.print("Nama: ");
        nama = input.nextLine();

        for(Menu menu : makanan) {
            if(nama.equalsIgnoreCase(menu.namaMenu)) {
                baru = false;
                break;
            }
            menus++;
        }

        if (baru) {
            System.out.print("Harga: ");
            harga = input.nextInt();
            System.out.print("Stok: ");
            stok = input.nextInt();

            makanan.add(new Menu(nama, harga, stok));
        } else if (!baru) {
            Menu menu = makanan.get(menus);
            System.out.print("Stok: ");

            stok = input.nextInt();
            menu.stokMenu += stok;
        }
        
        System.out.println("Makanan berhasil ditambah");
    }

    //Hapus atau kurangi menu
    public void kurangiMenu() {
        String nama;
        char hapus;
        int Hstok;
        boolean ada = false;

        input.nextLine();
        System.out.print("Pilih menu yang ingin dihapus: ");
        nama = input.nextLine();

        for (int i = 0; i < makanan.size(); i++) {
            Menu menu = makanan.get(i);
            if (nama.equalsIgnoreCase(menu.namaMenu)) {
                ada = true;
                System.out.print("Ingin menghapus menu?(y/n) ");
                hapus = input.next().charAt(0);
                if (hapus == 'y') {
                    makanan.remove(i);    
                } else {
                    System.out.print("Hapus stok: ");
                    Hstok = input.nextInt();
                    menu.stokMenu -= Hstok;

                    if (menu.stokMenu < 0) {
                        System.out.println("Stok kurang untuk dikurangi");
                        menu.stokMenu += Hstok;
                    }
                }
            }
        }

        if (ada) {
            System.out.println("Menu berhasil dihapus");
        } else if (!ada) {
            System.out.println("Tidak ada menu");
        }
    }

    //Menampilkan Riwayat
    public void isiRiwayat() {
        for (Riwayat nota : riwayat) {
            System.out.println(nota.id+". "+nota.namaPembeli+", "+nota.waktu+", RP."+nota.totalhargaPesanan);
        }

        if (riwayat.size() >= 1) {
            detailRiwayat();
        } else {
            System.out.println("Tidak ada pesanan");
        }
    }

    //Menampilkan Detail
    public void detailRiwayat() {
        boolean ada = false;

        System.out.print("Masukan id riwayat: ");
        int pilih = input.nextInt();

        for (Riwayat nota : riwayat) {
            if (pilih == nota.id) {
                ada = true;

                System.out.println("\n-------NOTA-------");
                System.out.println(nota.riwayat);
            }
        }
        
        if (!ada) {
            System.out.println("Id tidak ada");
        }
    }
}


class Menu {
    String namaMenu;
    int hargaMenu;
    int stokMenu;

    public Menu(String namaMenu, int hargaMenu, int stokMenu) {
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.stokMenu = stokMenu;
    }

    public String getnama() {
        return namaMenu;
    }
    public int getharga() {
        return hargaMenu;
    }
}

class Pesanan {
    String namaPesanan;
    int hargaPesanan;
    int jumlahPesanan;
    int totalhargaPesanan;

    public Pesanan(String namaPesanan, int hargaPesanan, int jumlahPesanan, int totalhargaPesanan) {
        this.namaPesanan = namaPesanan;
        this.hargaPesanan = hargaPesanan;
        this.jumlahPesanan = jumlahPesanan;
        this.totalhargaPesanan = totalhargaPesanan;
    }
}

class Riwayat {
    int id;
    String namaPembeli;
    LocalDate waktu;
    int totalhargaPesanan;
    String riwayat;

    public Riwayat(int id, String namaPembeli, LocalDate waktu, int totalhargaPesanan, String riwayat) {
        this.id = id;
        this.namaPembeli = namaPembeli;
        this.waktu = waktu;
        this.totalhargaPesanan = totalhargaPesanan;
        this.riwayat = riwayat;
    }
}