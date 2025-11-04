---
obsidianUIMode: preview
note_type: Book Theory
judul_materi: Memahami Konsep Dasar OOP (untuk Pemula)
sumber:
  - petanikode
date_learned: 2025-11-04T17:32:00
tags:
  - java
  - oop
---
Link Sumber: [Belajar Java OOP: Memahami Konsep Dasar OOP (untuk Pemula)](https://www.petanikode.com/java-oop/)

---
# Memahami Konsep Dasar OOP (untuk Pemula)

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-1.png]]

OOP merupakan hal yang harus dipelajari untuk memahami Java lebih dalam. Karena Java sendiri merupakan bahasa yang didesain untuk OOP.

Buktinya:

Saat kita [membuat program pertama](https://www.petanikode.com/java-linux/), kita diwajibkan menggunakan _class_.

```java
class Hello {
    public static void main(String[] args){
        System.out.println("Hello World!");
    }
}
```

OOP dikenal sebagai teknik pemrograman modern yang lebih efisien dan banyak digunakan pada _Framework_.

> *Jika kamu ingin memahami Framework, pelajari dulu konsep OOP*

Jadi tidak ada alasan untuk tidak belajar OOP.

Apa saja yang akan kita pelajari pada artikel ini?

1. Mengapa Harus Belajar OOP?
2. Apa itu OOP?
3. Objek dan Class
4. Class Diagram

Mari kita mulai…

## 1 | Mengapa Sih Harus Belajar OOP?

Mengapa sih OOP itu penting? Bukannya kita bisa bikin program dengan prosedural saja?

Ya memang bisa… Tapi masalahnya nanti kalau programnya sudah semakin besar dan kompleks. Kode program akan sulit di-maintenance.

Pada pemrograman prosedural, kita biasanya memecah program menjadi beberapa prosedur. Lalu membuat variabel global dan lokal untuk menyimpan data.

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-2.png]]

Semakin besar programnya, semakin banyak pula variabel dan prosedur yang harus dibuat. Lama-kelamaan, kode program akan sulit dimodifikasi.. karena sudah terlalu kompleks.

Di sinilah kita harus menggunakan OOP.

Jadi..

## 2 | Apa itu OOP?

OOP (_Object Oriented Programming_) atau dalam bahasa indonesia dikenal dengan pemrograman berorientasikan objek (PBO) merupakan sebuah paradigma atau teknik pemrograman yang **berorientesikan Objek**.

Pada OOP, Fungsi dan variabel **dibungkus** dalam sebuah **objek** atau _class_ yang dapat saling brinteraksi, sehingga membentuk sebuah program.

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-3.png]]

Dengan demikian, tidak akan ada lagi kode yang “berantakan.” Semua akan kita bungkus dalam objek.

Tapi sebelum membuat objek, kita harus membuat class dulu…

## 3 | Class dan Object

Class sebenarnya bertugas untuk mengumpulkan prosedur/fungsi dan variabel dalam satu tempat.

Contoh:

Kita ingin membuat game sederhana, di dalamnya ada kucing dan makanan.

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-4.png]]

Dengan class, kita bisa menentukan.. mana variabel dan prosedur untuk kucing dan makanan. Class ini nanti yang akan kita pakai untuk membuat objek.

Jadi…

> Class adalah rancangan atau _blue print_ dari sebuah objek.

Sedangkan objek adalah sebuah variabel yang merupakan _instance_ atau perwujudan dari _Class_. _Instance_ bisa diartikan sebagai wujud dari _class_. _Class_ berisi definisi variabel dan fungsi yang menggambarkan sebuah objek.

Dalam OOP:

- **Variabel** disebut **atribut** atau **properti**;
- **Fungsi** disebut **method**.

Contoh _Class_:

```java
class NamaClass {
    String atribut1;
    String atribut2;

    void namaMethod(){ ... }
    void namaMethodLain(){ ... }
}
```

Lalu, Kita biasanya membuat objek _(instance)_ seperti ini:

```java
NamaClass namaObj = new NamaClass();
```

Kata kunci `new` berfungsi untuk membuat objek baru dari _class_ tertentu.

Setelah membuat objek, kita bisa mengakses atribut dan method dari objek tersebut.

Contoh:

```java
namaObj.namaMethod();
namaObj.atribut1;
```

Tanda titik (`.`) berfungsi untuk mengakses atribut dan method.

## 4 | Contoh Program OOP

Kita akan menggunakan Netbeans, silakan buat project baru.

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-5.png]]

Isi nama project-nya dengan **“BelajarOOP”** dan jangan centang **“Create Main Class”**.

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-6.png]]

Setelah itu, silakan buat _package_ baru. Klik kanan pada `<default package>`, lalu pilih **New->Java Package**.

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-7.png]]

Isi nama _package_ dengan **“dasar”**:

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-8.png]]

Setelah itu, di dalam package `dasar`, silakan buat _class_ baru bernama `Player.java`.

Klik kanan pada package `dasar` lalu pilih **New->Java Class**. Setelah itu, isi namanya dengan `Player.java`.

Silakan tulis kode pada `Player.java` seperti ini:

```java
package dasar;

public class Player {
    
    // definisi atribut
    String name;
    int speed;
    int healthPoin;

    // definisi method run
    void run(){
        System.out.println(name +" is running...");
        System.out.println("Speed: "+ speed);
    }

    // definisi method isDead untuk mengecek nilai kesehatan (healthPoin)
    boolean isDead(){
        if(healthPoin <= 0) return true;
        return false;
    }
    
}
```

Berikutnya, buat _class_ baru lagi bernama `Game.java` dan isi kodenya seperti ini:

```java
package dasar;

public class Game {
    public static void main(String[] args){

        // membuat objek player
        Player petani = new Player();

        // mengisi atribut player
        petani.name = "Petani Kode";
        petani.speed = 78;
        petani.healthPoin = 100;

        // menjalankan method
        petani.run();

        if(petani.isDead()){
            System.out.println("Game Over!");
        }

    }
}
```

Coba eksekusi `Game.java` dengan klik kanan pada `Game.java` lalu pilih **Run File**. Maka hasilnya:

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-9.png]]

Coba ganti nilai `healthPoin` menjadi `0`.

```java
petani.healthPoin = 0;
```

Setelah itu, coba eksekusi lagi:

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-10.png]]

Player `petani` sudah mati, Game selesai! 😄

#### Kok Bisa Begitu? Jelaskan Donk!

Baik, kita mulai dari pembuatan _class_.

Pertama-tama, kita membuat sebuah _class_ dengan nama `Player`. Class ini mendefinisikan objek Player dalam Game dengan atribut sebagai berikut:

- `name` adalah nama objek;
- `speed` adalah kecepatan;
- `healthPoin` adalah nilai kesehatan dari player, biasanya disingkat `hp`.

Lalu class `Player` memiliki method:

- `run()` untuk menggerakkan player;
- `isDead()` untuk mengecek kondisi kesehatan player. Method ini akan mengembalikan nilai `true` apabila nilai `hp` lebih kecil atau sama dengan nol (`0`), sebaliknya akan mengembalikan nilai `false`.

Berikutnya kita membuat objek baru dari class `Player` pada class `Game` bernama `petani`.

```java
// membuat objek player
Player petani = new Player();
```

Setelah itu mengisi atribut-atributnya. Karena kalau tidak diisi akan bernilai _Null_ dan bisa menyebabkan _NullPointerException_.

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-11.png]]

Berikutnya kita coba modifikasi nilai `hp` menjadi nol.

Hasilnya, pesan `Game Over!` akan ditampilkan. Karena method `isDead()` akan mengembalikan nilai `true` jika nilai `hp` kurang atau sama dengan nol.

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-12.png]]

## 5 | Contoh Program OOP 2: Program Drone

Untuk praktek berikutnya, coba buat class `Drone`.

```java
class Drone {
    // atribut
    int energi;
    int ketinggian;
    int kecepatan;
    String merek;

    // method
    void terbang(){
        energi--;
        if(energi > 10){
            // terbang berarti nilai ketinggian bertambah
            ketinggian++;
            System.out.println("Dorne terbang...");
        } else {
            System.out.println("Energi lemah: Drone nggak bisa terbang");
        }
    }

    void matikanMesin(){
        if(ketinggian > 0){
            System.out.println("Mesin tidak bisa dimatikan karena sedang terbang");
        } else {
            System.out.println("Mesin dimatikan...");
        }
    }

    void turun(){
        // ketinggian berkurang, karena turun
        ketinggian--;
        energi--;
        System.out.println("Drone turun");
    }

    void belok(){
        energi--;
        System.out.println("Drone belok");
        // belok ke mana? perlu dicek :)
    }

    void maju(){
        energi--;
        System.out.println("Drone maju ke depan");
        kecepatan++;
    }

    void mundur(){
        energi--;
        System.out.println("Drone mundur");
        kecepatan++;
    }
}
```

## 6 | Bagaimana Menentukan Atribut dan Method dari Objek?

Seperti yang sudah dijelaskan di awal. Objek memiliki data (atribut) dan operasi (fungsi).

Kuncinya:

- Atribut itu seperti ciri-ciri dari objek.
- Method itu seperti tingkah laku atau operasi.

Contoh:

Misalkan kita ingin membuat _class_ dari `Senjata`.

Apa ciri-ciri dari senjata atau data yang bisa dijadikan atribut?

- jumlah peluru
- jenis
- nama senjata
- berat
- warna
- dll

Lalu apa tingkah laku atau operasi (fungsi) yang bisa dilakukan?

- tembak()
- lempar()
- kurangiPeluru()
- reload()
- dll.


![[01-Memahami Konsep Dasar OOP (untuk Pemula)-13.png]]

Maka class-nya bisa dibuat seperti ini:

```java
class Senjata {
    // atribut
    String nama;
    int jumlahPeluru;
    
    // method
    void tembak(){
        //..
        // setelah nembak, kurangi peluru
        jumlahPeluru--;
    }

    void reload(){
        //..
        // kalau di-reload maka jumlah peluru diisi ulang
        jumlahPeluru = 300;
    }
}
```

Mudah bukan…

## 7 | Mengenal Class Diagram

_Class Diagram_ adalah sebuah diagram yang menggambarkan hubungan antar _class_. _Class Diagram_ dapat kita buat dengan aplikasi perancangan (CASE), seperti StarUML.

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-14.png]]

Sebuah _class_ digambarkan dengan sebuah tabel 1 kolom dan 3 baris.

Baris pertama berisi nama _class_; Baris kedua berisi atribut; dan Baris ketiga berisi method.

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-15.png]]

Selain itu, terdapat garis yang menggambarkan hubungan antar _class_.

![[01-Memahami Konsep Dasar OOP (untuk Pemula)-16.png]]

_Class Diagram_ biasanya digunakan oleh _software engineer_ untuk merancang software dengan paradigma OOP.

Sebagai programmer, kita hanya perlu tahu cara membaca dan menuliskannya ke dalam kode.

Jika kamu tertarik dengan _class_ diagram, bisa membaca buku-buku tentang UML.

## 8 | Akhir Kata…

Buat yang baru pertama belajar OOP, mungkin akan merasa kesulitan. Karena banyak hal baru yang belum dipahami.

Namun tenang saja…

Itu adalah proses belajar.

Silakan banyak-banyak latihan dan pahami hakikat dari _class_, atribut, _method_, dll.

Selamat belajar.