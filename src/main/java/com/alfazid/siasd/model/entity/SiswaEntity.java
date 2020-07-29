package com.alfazid.siasd.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "siswa", schema = "")
public class SiswaEntity {
    private int idSekolah;

    @Basic
    @javax.persistence.Column(name = "id_sekolah")
    public int getIdSekolah() {
        return idSekolah;
    }

    public void setIdSekolah(int idSekolah) {
        this.idSekolah = idSekolah;
    }

    private int idSiswa;

    @Id
    @javax.persistence.Column(name = "id_siswa")
    public int getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(int idSiswa) {
        this.idSiswa = idSiswa;
    }

    private int idKelas;

    @Basic
    @javax.persistence.Column(name = "id_kelas")
    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    private String nis;

    @Basic
    @javax.persistence.Column(name = "nis")
    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    private String nisn;

    @Basic
    @javax.persistence.Column(name = "nisn")
    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    private String namaLengkap;

    @Basic
    @javax.persistence.Column(name = "nama_lengkap")
    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    private String namaPanggilan;

    @Basic
    @javax.persistence.Column(name = "nama_panggilan")
    public String getNamaPanggilan() {
        return namaPanggilan;
    }

    public void setNamaPanggilan(String namaPanggilan) {
        this.namaPanggilan = namaPanggilan;
    }

    private String jenisKelamin;

    @Basic
    @javax.persistence.Column(name = "jenis_kelamin")
    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    private String agama;

    @Basic
    @javax.persistence.Column(name = "agama")
    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    private String kewarganegaraan;

    @Basic
    @javax.persistence.Column(name = "kewarganegaraan")
    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    private String tempatLahir;

    @Basic
    @javax.persistence.Column(name = "tempat_lahir")
    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalLahir;

    @Basic
    @javax.persistence.Column(name = "tanggal_lahir")
    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    
    private String pendidikanSebelumnya;

    @Basic
    @javax.persistence.Column(name = "pendidikan_sebelumnya")
    public String getPendidikanSebelumnya() {
        return pendidikanSebelumnya;
    }

    public void setPendidikanSebelumnya(String pendidikanSebelumnya) {
        this.pendidikanSebelumnya = pendidikanSebelumnya;
    }
    

    private String alamatSiswa;

    @Basic
    @javax.persistence.Column(name = "alamat_siswa")
    public String getAlamatSiswa() {
        return alamatSiswa;
    }

    public void setAlamatSiswa(String alamatSiswa) {
        this.alamatSiswa = alamatSiswa;
    }
    private String namaAyah;

    @Basic
    @javax.persistence.Column(name = "nama_ayah")
    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    private Date tanggalLahirAyah;

    @Basic
    @javax.persistence.Column(name = "tanggal_lahir_ayah")
    public Date getTanggalLahirAyah() {
        return tanggalLahirAyah;
    }

    public void setTanggalLahirAyah(Date tanggalLahirAyah) {
        this.tanggalLahirAyah = tanggalLahirAyah;
    }

    private String agamaAyah;

    @Basic
    @javax.persistence.Column(name = "agama_ayah")
    public String getAgamaAyah() {
        return agamaAyah;
    }

    public void setAgamaAyah(String agamaAyah) {
        this.agamaAyah = agamaAyah;
    }

    private String pendidikanAyah;

    @Basic
    @javax.persistence.Column(name = "pendidikan_ayah")
    public String getPendidikanAyah() {
        return pendidikanAyah;
    }

    public void setPendidikanAyah(String pendidikanAyah) {
        this.pendidikanAyah = pendidikanAyah;
    }

    private Integer pekerjaanAyah;

    @Basic
    @javax.persistence.Column(name = "pekerjaan_ayah")
    public Integer getPekerjaanAyah() {
        return pekerjaanAyah;
    }

    public void setPekerjaanAyah(Integer pekerjaanAyah) {
        this.pekerjaanAyah = pekerjaanAyah;
    }

    private String namaIbu;

    @Basic
    @javax.persistence.Column(name = "nama_ibu")
    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    private Date tanggalLahirIbu;

    @Basic
    @javax.persistence.Column(name = "tanggal_lahir_ibu")
    public Date getTanggalLahirIbu() {
        return tanggalLahirIbu;
    }

    public void setTanggalLahirIbu(Date tanggalLahirIbu) {
        this.tanggalLahirIbu = tanggalLahirIbu;
    }

    private String agamaIbu;

    @Basic
    @javax.persistence.Column(name = "agama_ibu")
    public String getAgamaIbu() {
        return agamaIbu;
    }

    public void setAgamaIbu(String agamaIbu) {
        this.agamaIbu = agamaIbu;
    }

    private String pendidikanIbu;

    @Basic
    @javax.persistence.Column(name = "pendidikan_ibu")
    public String getPendidikanIbu() {
        return pendidikanIbu;
    }

    public void setPendidikanIbu(String pendidikanIbu) {
        this.pendidikanIbu = pendidikanIbu;
    }

    private Integer pekerjaanIbu;

    @Basic
    @javax.persistence.Column(name = "pekerjaan_ibu")
    public Integer getPekerjaanIbu() {
        return pekerjaanIbu;
    }

    public void setPekerjaanIbu(Integer pekerjaanIbu) {
        this.pekerjaanIbu = pekerjaanIbu;
    }

    private String alamatOrangtua;

    @Basic
    @javax.persistence.Column(name = "alamat_orangtua")
    public String getAlamatOrangtua() {
        return alamatOrangtua;
    }

    public void setAlamatOrangtua(String alamatOrangtua) {
        this.alamatOrangtua = alamatOrangtua;
    }
    private String teleponOrangtua;

    @Basic
    @Column(name = "telepon_orangtua")
    public String getTeleponOrangtua() {
        return teleponOrangtua;
    }

    public void setTeleponOrangtua(String teleponOrangtua) {
        this.teleponOrangtua = teleponOrangtua;
    }
    
    private Integer idDesa;

    @Basic
    @javax.persistence.Column(name = "id_desa")
    public Integer getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(Integer idDesa) {
        this.idDesa = idDesa;
    }

    private Integer idKecamatan;

    @Basic
    @javax.persistence.Column(name = "id_kecamatan")
    public Integer getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(Integer idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    private Integer idKabupaten;

    @Basic
    @javax.persistence.Column(name = "id_kabupaten")
    public Integer getIdKabupaten() {
        return idKabupaten;
    }

    public void setIdKabupaten(Integer idKabupaten) {
        this.idKabupaten = idKabupaten;
    }

    private Integer idProvinsi;

    @Basic
    @javax.persistence.Column(name = "id_provinsi")
    public Integer getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(Integer idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    @Basic
    @Column(name = "kodepos")
    private int kodepos;
   
    public int getKodepos() {
		return kodepos;
	}

	public void setKodepos(int kodepos) {
		this.kodepos = kodepos;
	}
	@Basic
    @Column(name = "rt")
    private int rt;
	public int getRt() {
		return rt;
	}

	public void setRt(int rt) {
		this.rt = rt;
	}
	@Basic
    @Column(name = "rw")
    private int rw;
	
	public int getRw() {
		return rw;
	}

	public void setRw(int rw) {
		this.rw = rw;
	}

	private String namaWali;

    @Basic
    @javax.persistence.Column(name = "nama_wali")
    public String getNamaWali() {
        return namaWali;
    }

    public void setNamaWali(String namaWali) {
        this.namaWali = namaWali;
    }

    private Date tanggalLahirWali;

    @Basic
    @javax.persistence.Column(name = "tanggal_lahir_wali")
    public Date getTanggalLahirWali() {
        return tanggalLahirWali;
    }

    public void setTanggalLahirWali(Date tanggalLahirWali) {
        this.tanggalLahirWali = tanggalLahirWali;
    }

    private String agamaWali;

    @Basic
    @javax.persistence.Column(name = "agama_wali")
    public String getAgamaWali() {
        return agamaWali;
    }

    public void setAgamaWali(String agamaWali) {
        this.agamaWali = agamaWali;
    }

    private String pendidikanWali;

    @Basic
    @javax.persistence.Column(name = "pendidikan_wali")
    public String getPendidikanWali() {
        return pendidikanWali;
    }

    public void setPendidikanWali(String pendidikanWali) {
        this.pendidikanWali = pendidikanWali;
    }

    private Integer pekerjaanWali;

    @Basic
    @javax.persistence.Column(name = "pekerjaan_wali")
    public Integer getPekerjaanWali() {
        return pekerjaanWali;
    }

    public void setPekerjaanWali(Integer pekerjaanWali) {
        this.pekerjaanWali = pekerjaanWali;
    }

    private String alamatWali;

    @Basic
    @javax.persistence.Column(name = "alamat_wali")
    public String getAlamatWali() {
        return alamatWali;
    }

    public void setAlamatWali(String alamatWali) {
        this.alamatWali = alamatWali;
    }

    private String teleponWali;

    @Basic
    @javax.persistence.Column(name = "telepon_wali")
    public String getTeleponWali() {
        return teleponWali;
    }

    public void setTeleponWali(String teleponWali) {
        this.teleponWali = teleponWali;
    }

    
    private String hubunganDenganKeluarga;

    @Basic
    @javax.persistence.Column(name = "hubungan_dengan_keluarga")
    public String getHubunganDenganKeluarga() {
        return hubunganDenganKeluarga;
    }

    public void setHubunganDenganKeluarga(String hubunganDenganKeluarga) {
        this.hubunganDenganKeluarga = hubunganDenganKeluarga;
    }


    private int anakKe;

    @Basic
    @javax.persistence.Column(name = "anak_ke")
    public int getAnakKe() {
        return anakKe;
    }

    public void setAnakKe(int anakKe) {
        this.anakKe = anakKe;
    }

    private Integer saudaraKandung;

    @Basic
    @javax.persistence.Column(name = "saudara_kandung")
    public Integer getSaudaraKandung() {
        return saudaraKandung;
    }

    public void setSaudaraKandung(Integer saudaraKandung) {
        this.saudaraKandung = saudaraKandung;
    }

    private Integer saudaraTiri;

    @Basic
    @javax.persistence.Column(name = "saudara_tiri")
    public Integer getSaudaraTiri() {
        return saudaraTiri;
    }

    public void setSaudaraTiri(Integer saudaraTiri) {
        this.saudaraTiri = saudaraTiri;
    }

    private Integer saudaraAngkat;

    @Basic
    @javax.persistence.Column(name = "saudara_angkat")
    public Integer getSaudaraAngkat() {
        return saudaraAngkat;
    }

    public void setSaudaraAngkat(Integer saudaraAngkat) {
        this.saudaraAngkat = saudaraAngkat;
    }

    private Integer idBahasaIbu;

    @Basic
    @javax.persistence.Column(name = "id_bahasa_ibu")
    public Integer getIdBahasaIbu() {
        return idBahasaIbu;
    }

    public void setIdBahasaIbu(Integer idBahasaIbu) {
        this.idBahasaIbu = idBahasaIbu;
    }

    private String photo;

    @Basic
    @javax.persistence.Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
    private String active;

    @Basic
    @javax.persistence.Column(name = "active")
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    private Integer userCreated;

    @Basic
    @javax.persistence.Column(name = "user_created")
    public Integer getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Integer userCreated) {
        this.userCreated = userCreated;
    }

    private Timestamp timestampCreated;

    @Basic
    @javax.persistence.Column(name = "timestamp_created")
    public Timestamp getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(Timestamp timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    private Integer userUpdated;

    @Basic
    @javax.persistence.Column(name = "user_updated")
    public Integer getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(Integer userUpdated) {
        this.userUpdated = userUpdated;
    }

    private Timestamp timestampUpdate;

    @Basic
    @javax.persistence.Column(name = "timestamp_update")
    public Timestamp getTimestampUpdate() {
        return timestampUpdate;
    }

    public void setTimestampUpdate(Timestamp timestampUpdate) {
        this.timestampUpdate = timestampUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiswaEntity that = (SiswaEntity) o;

        if (idSekolah != that.idSekolah) return false;
        if (idSiswa != that.idSiswa) return false;
        if (idKelas != that.idKelas) return false;
        if (anakKe != that.anakKe) return false;
        if (nis != null ? !nis.equals(that.nis) : that.nis != null) return false;
        if (nisn != null ? !nisn.equals(that.nisn) : that.nisn != null) return false;
        if (namaLengkap != null ? !namaLengkap.equals(that.namaLengkap) : that.namaLengkap != null) return false;
        if (namaPanggilan != null ? !namaPanggilan.equals(that.namaPanggilan) : that.namaPanggilan != null)
            return false;
        if (jenisKelamin != null ? !jenisKelamin.equals(that.jenisKelamin) : that.jenisKelamin != null) return false;
        if (agama != null ? !agama.equals(that.agama) : that.agama != null) return false;
        if (kewarganegaraan != null ? !kewarganegaraan.equals(that.kewarganegaraan) : that.kewarganegaraan != null)
            return false;
        if (tempatLahir != null ? !tempatLahir.equals(that.tempatLahir) : that.tempatLahir != null) return false;
        if (tanggalLahir != null ? !tanggalLahir.equals(that.tanggalLahir) : that.tanggalLahir != null) return false;
        if (saudaraKandung != null ? !saudaraKandung.equals(that.saudaraKandung) : that.saudaraKandung != null)
            return false;
        if (saudaraTiri != null ? !saudaraTiri.equals(that.saudaraTiri) : that.saudaraTiri != null) return false;
        if (saudaraAngkat != null ? !saudaraAngkat.equals(that.saudaraAngkat) : that.saudaraAngkat != null)
            return false;
        if (idBahasaIbu != null ? !idBahasaIbu.equals(that.idBahasaIbu) : that.idBahasaIbu != null) return false;
        if (alamatSiswa != null ? !alamatSiswa.equals(that.alamatSiswa) : that.alamatSiswa != null) return false;
        if (namaAyah != null ? !namaAyah.equals(that.namaAyah) : that.namaAyah != null) return false;
        if (tanggalLahirAyah != null ? !tanggalLahirAyah.equals(that.tanggalLahirAyah) : that.tanggalLahirAyah != null)
            return false;
        if (agamaAyah != null ? !agamaAyah.equals(that.agamaAyah) : that.agamaAyah != null) return false;
        if (pendidikanAyah != null ? !pendidikanAyah.equals(that.pendidikanAyah) : that.pendidikanAyah != null)
            return false;
        if (pekerjaanAyah != null ? !pekerjaanAyah.equals(that.pekerjaanAyah) : that.pekerjaanAyah != null)
            return false;
        if (namaIbu != null ? !namaIbu.equals(that.namaIbu) : that.namaIbu != null) return false;
        if (tanggalLahirIbu != null ? !tanggalLahirIbu.equals(that.tanggalLahirIbu) : that.tanggalLahirIbu != null)
            return false;
        if (agamaIbu != null ? !agamaIbu.equals(that.agamaIbu) : that.agamaIbu != null) return false;
        if (pendidikanIbu != null ? !pendidikanIbu.equals(that.pendidikanIbu) : that.pendidikanIbu != null)
            return false;
        if (pekerjaanIbu != null ? !pekerjaanIbu.equals(that.pekerjaanIbu) : that.pekerjaanIbu != null) return false;
        if (alamatOrangtua != null ? !alamatOrangtua.equals(that.alamatOrangtua) : that.alamatOrangtua != null)
            return false;
        if (idDesa != null ? !idDesa.equals(that.idDesa) : that.idDesa != null) return false;
        if (idKecamatan != null ? !idKecamatan.equals(that.idKecamatan) : that.idKecamatan != null) return false;
        if (idKabupaten != null ? !idKabupaten.equals(that.idKabupaten) : that.idKabupaten != null) return false;
        if (idProvinsi != null ? !idProvinsi.equals(that.idProvinsi) : that.idProvinsi != null) return false;
        if (teleponOrangtua != null ? !teleponOrangtua.equals(that.teleponOrangtua) : that.teleponOrangtua != null)
            return false;
        if (namaWali != null ? !namaWali.equals(that.namaWali) : that.namaWali != null) return false;
        if (tanggalLahirWali != null ? !tanggalLahirWali.equals(that.tanggalLahirWali) : that.tanggalLahirWali != null)
            return false;
        if (agamaWali != null ? !agamaWali.equals(that.agamaWali) : that.agamaWali != null) return false;
        if (pendidikanWali != null ? !pendidikanWali.equals(that.pendidikanWali) : that.pendidikanWali != null)
            return false;
        if (pekerjaanWali != null ? !pekerjaanWali.equals(that.pekerjaanWali) : that.pekerjaanWali != null)
            return false;
        if (alamatWali != null ? !alamatWali.equals(that.alamatWali) : that.alamatWali != null) return false;
        if (hubunganDenganKeluarga != null ? !hubunganDenganKeluarga.equals(that.hubunganDenganKeluarga) : that.hubunganDenganKeluarga != null)
            return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (userCreated != null ? !userCreated.equals(that.userCreated) : that.userCreated != null) return false;
        if (timestampCreated != null ? !timestampCreated.equals(that.timestampCreated) : that.timestampCreated != null)
            return false;
        if (userUpdated != null ? !userUpdated.equals(that.userUpdated) : that.userUpdated != null) return false;
        if (timestampUpdate != null ? !timestampUpdate.equals(that.timestampUpdate) : that.timestampUpdate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSekolah;
        result = 31 * result + idSiswa;
        result = 31 * result + idKelas;
        result = 31 * result + (nis != null ? nis.hashCode() : 0);
        result = 31 * result + (nisn != null ? nisn.hashCode() : 0);
        result = 31 * result + (namaLengkap != null ? namaLengkap.hashCode() : 0);
        result = 31 * result + (namaPanggilan != null ? namaPanggilan.hashCode() : 0);
        result = 31 * result + (jenisKelamin != null ? jenisKelamin.hashCode() : 0);
        result = 31 * result + (agama != null ? agama.hashCode() : 0);
        result = 31 * result + (kewarganegaraan != null ? kewarganegaraan.hashCode() : 0);
        result = 31 * result + (tempatLahir != null ? tempatLahir.hashCode() : 0);
        result = 31 * result + (tanggalLahir != null ? tanggalLahir.hashCode() : 0);
        result = 31 * result + anakKe;
        result = 31 * result + (saudaraKandung != null ? saudaraKandung.hashCode() : 0);
        result = 31 * result + (saudaraTiri != null ? saudaraTiri.hashCode() : 0);
        result = 31 * result + (saudaraAngkat != null ? saudaraAngkat.hashCode() : 0);
        result = 31 * result + (idBahasaIbu != null ? idBahasaIbu.hashCode() : 0);
        result = 31 * result + (alamatSiswa != null ? alamatSiswa.hashCode() : 0);
        result = 31 * result + (namaAyah != null ? namaAyah.hashCode() : 0);
        result = 31 * result + (tanggalLahirAyah != null ? tanggalLahirAyah.hashCode() : 0);
        result = 31 * result + (agamaAyah != null ? agamaAyah.hashCode() : 0);
        result = 31 * result + (pendidikanAyah != null ? pendidikanAyah.hashCode() : 0);
        result = 31 * result + (pekerjaanAyah != null ? pekerjaanAyah.hashCode() : 0);
        result = 31 * result + (namaIbu != null ? namaIbu.hashCode() : 0);
        result = 31 * result + (tanggalLahirIbu != null ? tanggalLahirIbu.hashCode() : 0);
        result = 31 * result + (agamaIbu != null ? agamaIbu.hashCode() : 0);
        result = 31 * result + (pendidikanIbu != null ? pendidikanIbu.hashCode() : 0);
        result = 31 * result + (pekerjaanIbu != null ? pekerjaanIbu.hashCode() : 0);
        result = 31 * result + (alamatOrangtua != null ? alamatOrangtua.hashCode() : 0);
        result = 31 * result + (idDesa != null ? idDesa.hashCode() : 0);
        result = 31 * result + (idKecamatan != null ? idKecamatan.hashCode() : 0);
        result = 31 * result + (idKabupaten != null ? idKabupaten.hashCode() : 0);
        result = 31 * result + (idProvinsi != null ? idProvinsi.hashCode() : 0);
        result = 31 * result + (teleponOrangtua != null ? teleponOrangtua.hashCode() : 0);
        result = 31 * result + (namaWali != null ? namaWali.hashCode() : 0);
        result = 31 * result + (tanggalLahirWali != null ? tanggalLahirWali.hashCode() : 0);
        result = 31 * result + (agamaWali != null ? agamaWali.hashCode() : 0);
        result = 31 * result + (pendidikanWali != null ? pendidikanWali.hashCode() : 0);
        result = 31 * result + (pekerjaanWali != null ? pekerjaanWali.hashCode() : 0);
        result = 31 * result + (alamatWali != null ? alamatWali.hashCode() : 0);
        result = 31 * result + (hubunganDenganKeluarga != null ? hubunganDenganKeluarga.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (timestampCreated != null ? timestampCreated.hashCode() : 0);
        result = 31 * result + (userUpdated != null ? userUpdated.hashCode() : 0);
        result = 31 * result + (timestampUpdate != null ? timestampUpdate.hashCode() : 0);
        return result;
    }
}
