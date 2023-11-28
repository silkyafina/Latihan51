// Perintah Scanner
import java.util.Scanner;
/**
 *
 * @author User
 * Nama         : Silky Afina Saly
 * NIM          : 22166017
 * Mata Kuliah  : Pemrograman Berorientasi Objek 1
 * Program Studi: Sistem Informasi
 * Semester     : 3
 */
// membuat super class karyawan
public class Karyawan {
// Deklarasi variabel
    protected String nik;
    protected String nama;
    protected String jabatan;
    protected int golongan;
    
// metode getter dan setter untuk mengambil dan mengisi data dalam obyek
    public String getNik(){
        return nik;
    }
    public void setNik(String nik){
         this.nik = nik;
    }
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getJabatan(){
        return jabatan;
    }
    public void setJabatan(String jabatan){
        this.jabatan = jabatan;
    }
    public int getGolongan(){
        return golongan;
    }
    public void setGolongan(int golongan){
        this.golongan = golongan;
    }
// membuat sub class manager
static class Manager extends Karyawan{ 
// deklarasi variabel
    private int kehadiran;
    private float tunjanganGolongan;
    private float tunjanganJabatan;
    private float tunjanganKehadiran;
    float gajiTotal;
// metode getter dan setter     
    public int getKehadiran(){
        return kehadiran;
    }
    public void setKehadiran(int kehadiran){
        this.kehadiran = kehadiran;
    }

// Metode untuk menghitung tunjangan golongan
    public void TunjanganGolongan() {
        switch (golongan) {
            case 1:
                tunjanganGolongan = 500000;
                break;
            case 2:
                tunjanganGolongan = 1000000;
                break;
            case 3:
                tunjanganGolongan = 1500000;
                break;
            default:
                tunjanganGolongan = 0;
        }
    }

// Metode untuk menghitung tunjangan jabatan
    public void TunjanganJabatan() {
        if ("Manager".equalsIgnoreCase(jabatan)) {
            tunjanganJabatan = 2000000;
        } else if ("Kabag".equalsIgnoreCase(jabatan)) {
            tunjanganJabatan = 1000000;
        } else {
            tunjanganJabatan = 0;
        }
    }

// Metode untuk menghitung tunjangan kehadiran
    public void TunjanganKehadiran() {
        tunjanganKehadiran = kehadiran * 10000;
    }

    // Metode untuk menghitung gaji total
    public void GajiTotal() {
        TunjanganGolongan();
        TunjanganJabatan();
        TunjanganKehadiran();
        gajiTotal = tunjanganGolongan + tunjanganJabatan + tunjanganKehadiran;
    }
}
// Menginputkan data
   public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("========== Program Menghitung Gaji Karyawan ========== ");
        System.out.print("Masukkan NIK: ");
        String nik = input.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Golongan (1/2/3): ");
        int golongan = input.nextInt();
        System.out.print("Masukkan Jabatan (Manager/Kabag): ");
        String jabatan = input.next();
        System.out.print("Masukkan Jumlah Kehadiran: ");
        int kehadiran = input.nextInt();

// Output data
        System.out.println("");
        System.out.println("========== Hasil Perhitungan ========== ");
// membuat obyek manager 
        Manager manager = new Manager();
        manager.setNik(nik);
        manager.setNama(nama);
        manager.setGolongan(golongan);
        manager.setJabatan(jabatan);
        manager.setKehadiran(kehadiran);
        manager.GajiTotal();
        System.out.println("NIK : " + manager.getNik());
        System.out.println("NAMA : " + manager.getNama());
        System.out.println("GOLONGAN : " + manager.getGolongan());
        System.out.println("JABATAN : " + manager.getJabatan());
        System.out.println("");
        System.out.println("");
        System.out.println("TUNJANGAN GOLONGAN: " + manager.tunjanganGolongan);
        System.out.println("TUNJANGAN JABATAN: " + manager.tunjanganJabatan);
        System.out.println("TUNJANGAN KEHADIRAN: " + manager.tunjanganKehadiran);
        System.out.println("");
        System.out.println("");
        System.out.println("GAJI TOTAL: " + manager.gajiTotal);
    }
}
