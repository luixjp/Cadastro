package br.edu.ifsp.scl.sdm.cadastro.data;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Formulario implements Serializable {

    private String name;
    private String phone;
    private String email;
    private boolean list;
    private boolean isMale;
    private String city;
    private String state;

    public Formulario() {

    }

    public Formulario(String name, String phone, String email, boolean list, boolean isMale, String city, String state) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.list = list;
        this.isMale = isMale;
        this.city = city;
        this.state = state;
    }

    public void clear() {
        this.name = "";
        this.phone = "";
        this.city = "";
        this.email = "";
        this.isMale = true;
        this.list = false;
        this.state = "";
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append( this.getClass().getName() );
        result.append(newLine);

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields  ) {
            result.append("  ");
            try {
                result.append( field.getName() );
                result.append(": ");
                result.append( field.get(this) );
            } catch ( IllegalAccessException ex ) {
                System.out.println(ex);
            }
            result.append(newLine);
        }

        return result.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isList() {
        return list;
    }

    public void setList(boolean list) {
        this.list = list;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
