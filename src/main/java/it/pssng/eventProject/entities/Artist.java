package it.pssng.eventProject.entities;
import jakarta.persistence.*;
@Entity

@Table(name="artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ArtistFiscalCode")
    private long Artist_FiscalCode;
    @Column(name = "ArtistName")
    private String Artist_Name;
    @Column(name = "ArtistSurname")
    private String Artist_Surname;
    @Column(name = "ArtistEmailAddress")
    private String Artist_Email_Address;
    @Column(name = "PhoneNumber")
    private String Phone_Number;
    @Column(name = "ArtistUserName")
    private String Artist_UserName;

    public long getArtist_FiscalCode(){
        return Artist_FiscalCode;
    }

    public String getArtistName(){
        return Artist_Name;
    }

    public String getArtistSurname(){
        return Artist_Surname;
    }

    public String getArtistEmailAddress(){
        return Artist_Email_Address;
    }

    public String getPhoneNumber(){
        return Phone_Number;
    }

    public String getArtistUserName(){
        return Artist_UserName;
    }

    public void setArtist_FiscalCode(long artist_fiscalcode){
        Artist_FiscalCode = artist_fiscalcode;
    }

    public void setArtistName(String artist_name){
        Artist_Name = artist_name;
    }

    public void setArtistSurname(String artist_surname){
        Artist_Surname = artist_surname;
    }

    public void setArtistAddress(String artist_email_address){
        Artist_Email_Address = artist_email_address;
    }

    public void setArtisPhoneNumber(String artist_phone_number){
        Phone_Number = artist_phone_number;
    }

    public void setArtistUserName(String artist_username){
        Artist_UserName = artist_username;
    }
}
