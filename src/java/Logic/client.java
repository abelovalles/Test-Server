/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author abelricardo
 */
public class client {
    private String namecliente;
    private String ruc;
    private String addressCleint;
    private String phonecleinte;
    private int idcliente;

    public client() {
        this.namecliente = "";
        this.ruc = "";
        this.addressCleint = "";
        this.phonecleinte = "";
         this.idcliente = 0;
    }
    

    public String getNamecliente() {
        return namecliente;
    }

    public void setNamecliente(String namecliente) {
        this.namecliente = namecliente;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getAddressCleint() {
        return addressCleint;
    }

    public void setAddressCleint(String addressCleint) {
        this.addressCleint = addressCleint;
    }

    public String getPhonecleinte() {
        return phonecleinte;
    }

    public void setPhonecleinte(String phonecleinte) {
        this.phonecleinte = phonecleinte;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int iscliente) {
        this.idcliente = iscliente;
    }
    
    
}
