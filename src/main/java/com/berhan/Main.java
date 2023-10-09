package com.berhan;

import com.berhan.controller.*;
import com.berhan.repository.entity.*;
import com.berhan.utility.UtilityClass;

import java.util.List;
import java.util.Optional;


public class Main {
    UserController userController;
    ComputerSpecController computerSpecController;
    PostController postController;
    PhotoController photoController;
    LikeController likeController;
    ComputerController computerController;

    UtilityClass  utilityClass;
    public static void main(String[] args) {

        Main main = new Main();
        main.anaEkran();

    }

    /**
     * Kod çalıştığında karşılaşılacak ilk ekran
     */
    public void anaEkran(){
      boolean secim = true;
       do {
           System.out.println("*********************");
           System.out.println("1- Giris Yap");
           System.out.println("2- Kayıt Ol");
           System.out.println("0- Cikis");
           System.out.println("*********************");
           int secimint = new UtilityClass().intDeger(" Lütfen seçim yapınız");

           switch (secimint){
               case 1: loginUser();break;
               case 2: createUser();break;
               case 0: secim=false; break;
           }
       }while (secim);
    }



    /**
     * Bu method kullanıcıdan kayıt olabilmesi için değer alır ve kaydeder
     */

    public void createUser(){
        String adsoyad = new UtilityClass().stringDeger("adınızı ve soyadınızı giriniz ");
        String email = new UtilityClass().stringDeger("email adresinizi giriniz ");
        String phone = new UtilityClass().stringDeger("telefon numarası giriniz ");
        String nickname= new UtilityClass().stringDeger("kullanıcı adınızı giriniz ");
       new UserController().createAccount(adsoyad,email,phone,nickname);
        System.out.println(nickname +" Kullanicisi başarıyla oluşturuldu");
    }

    /**
     * Kullanıcının doğrulanıp giriş yaptığı method.
     */
    public void loginUser(){

        String nickName = new UtilityClass().stringDeger("Giriş yapmak için nickName giriniz");
        if(new UserController().userDogrulamaSorgusu(nickName).isPresent()){
            System.out.println("Giris Basarılı");
            Long id =  new UserController().findByColumnNameAndValue("nickName",nickName).get(0).getId();
            girisYap(id);
        } else {
            System.out.println("Giris Basarısız");

        }
    }

    /**
     * Bilgisayarın özelliklerini oluşturan bir method
     */
    public void createComputerSpec(Long computerid){
        String ram = new UtilityClass().stringDeger("Bilgisayarın ramini girin");
        String ekranKarti = new UtilityClass().stringDeger("Ekrna kartı özelliklerini girin");
        Double fiyat = new UtilityClass().doubleDeger("Fiyatını girin");
        new ComputerSpecController().computerSpecOlustur(ram,computerid,ekranKarti,fiyat);

    }

    /**
     * Post oluşturmak için kullanılan method
     */
    public void postCreate(Long userid){
        String text = new UtilityClass().stringDeger("Girmek istediğiniz texti yazınız");
        Post post=new PostController().postOlustur(userid,text);
        String photoEkleme = new UtilityClass().stringDeger("Photo eklemek ister misiniz E/H");
        if(photoEkleme.equalsIgnoreCase("e")){
            String url = new UtilityClass().stringDeger("eklemek istediğiniz fotografın url si");
            new PhotoController().photoOlustur(url,post.getId());
            System.out.println("fotograf başarıyla eklendi, post kayıt edildi");
        }else System.out.println("post kayıt edildi");
        createComputer(post.getId(),userid);
    }

    /**
     * özellikleriyle bilgisayar oluşturma methodu
     * @param postid
     * @param userid
     */
    public void createComputer(Long postid,Long userid){
        Computer computer= new ComputerController().computerOlustur(postid,userid);
        createComputerSpec(computer.getId());
    }

    /**
     * Aranılan kullanıcının postlarını görüntülemek için kullanılır
     */
    public void findUser(){
       String kullaniciAdi = new UtilityClass().stringDeger("Aramak istediğiniz kullanici adi nedir");
        Long id=  new UserController().userDogrulamaSorgusu(kullaniciAdi).get().getId();
        List<Post> posts = new PostController().kullanicininPostları(id);
        posts.forEach(System.out::println);

    }

    /**
     * tüm postları getiren bir method
     * @param userid
     */
    public void tumPostlariGetir(Long userid){
        new PostController().findAll().forEach(System.out::println);
        likeYap(userid);


    }
    public Like likeYap(Long userid){
        String cevap = new UtilityClass().stringDeger("Beğenmek istediğiniz post var mı? E/H");

            while (!cevap.equalsIgnoreCase("h")){

                Long postid = new UtilityClass().longDeger("Beğenmek istediğiniz postun id sini giriniz");
                return  new LikeController().likeOlustur(postid,userid);
            }
          return null;
    }
    public void likelediklerim(Long userid){
        new LikeController().begenilenPostlariGetir(userid);
    }

    public void girisYap(Long userid){
        int cikis = 6;
        do{
            System.out.println("1- Post At");
            System.out.println("2- Kullanici Ara");
            System.out.println("3- Ana Sayfada Gezin");
            System.out.println("4- Beğenilenlere Git");
            System.out.println("0- CİKİS");
            cikis = new UtilityClass().intDeger("Lütfen seçim yapınız");
            girisIslemleri(cikis,userid);

        }while (cikis!=0);

    }
    public void girisIslemleri(int cikis,Long userid){

        switch (cikis){
            case 1: postCreate(userid);break;
            case 2: findUser();break;
            case 3: tumPostlariGetir(userid);break;
            case 4: likelediklerim(userid);break;
            case 0: break;
            default:
                System.out.println("geçerli bir seçim yapınız");
        }
    }



}