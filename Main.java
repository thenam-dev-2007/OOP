import java.util.*;

class SanPham {
    private String maSP;
    private String tenSP;
    private double donGia;
    private int soLuongTon;

    // Constructor 1: Không tham số
    public SanPham() {
    }

    // Constructor 2: Hai tham số
    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    // Constructor 3: Đủ bốn tham số
    public SanPham(String maSP, String tenSP, double donGia, int soLuongTon) {
        this(maSP, tenSP);
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
    }

    // Getter và Setter cho maSP
    public String getMaSP() {
        return this.maSP;
    }
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    // Getter và Setter cho tenSP
    public String getTenSP() {
        return this.tenSP;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    // Getter và Setter cho donGia
    public double getDonGia() {
        return this.donGia;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    // Getter và Setter cho soLuongTon
    public int getSoLuongTon() {
        return this.soLuongTon;
    }
    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public void hienThi() {
        System.out.printf("%s %s %.3f %d%n", this.maSP, this.tenSP, this.donGia, this.soLuongTon);
    }

}

class DonHang {
    private String tenKhach;
    private SanPham sanPham;
    private  int soLuong;

    public DonHang(String tenKhach,SanPham sanPham, int soLuong) {
        this.tenKhach = tenKhach;
        this.sanPham = sanPham;
        this.soLuong = Math.max(1, soLuong);
    }

    public void inDonHang() {
        double thanhTien = this.sanPham.getDonGia() * this.soLuong;
        if(this.soLuong >= 5) {
            thanhTien -= thanhTien * 0.1;
        }
        System.out.printf("%s %s %d %.3f%n", this.tenKhach, this.sanPham.getTenSP(), this.soLuong, thanhTien);
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<SanPham> production = new ArrayList<>();
        ArrayList<DonHang> order = new ArrayList<>();

        SanPham banPhim = new SanPham("SP01", "Bàn phím cơ", 450000, 20);
        production.add(banPhim);
        SanPham chuotKhongDay = new SanPham("SP02", "Chuột không dây", 200000, 50);
        production.add(chuotKhongDay);
        SanPham taiNghe = new SanPham("SP03", "Tai nghe");
        taiNghe.setDonGia(350000);
        taiNghe.setSoLuongTon(10);
        production.add(taiNghe);
        System.out.println("===== DANH SÁCH SẢN PHẨM =====");
        for(SanPham sp: production) {
            sp.hienThi();
        }

        System.out.println();

        DonHang don1 = new DonHang("An", banPhim, 2);
        order.add(don1);
        DonHang don2 = new DonHang("Bình", chuotKhongDay, 5);
        order.add(don2);
        DonHang don3 = new DonHang("Chi", taiNghe, 0);
        order.add(don3);
        System.out.println("===== DANH SÁCH ĐƠN HÀNG =====");
        System.out.printf("%s %s %s %s%n", "Khách", "Sản Phẩm", "SL", "Thành tiền");
        for(DonHang dh: order) {
            dh.inDonHang();
        }
    }
}