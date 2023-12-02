package it.pssng.eventProject.entities;
import jakarta.persistence.*;
@Entity

@Table(name="artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Artist_FiscaCode;
    
    private String Artist_Name;

    private String Artist_Surname;

    private String Artist_Email_Address;

    private String Phone_Number;

    private String Artist_UserName;

    public long getArtist_FiscaCode(){
        return Artist_FiscaCode;
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

    public void setArtist_FiscaCode(long artist_fiscalcode){
        Artist_FiscaCode = artist_fiscalcode;
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
