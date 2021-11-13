package com.vitocarlengiovanni.gd10_json_a_10181.models;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("firstName")
    String firstName;
    @SerializedName("lastName")
    String lastName;
    @SerializedName("npm")
    String npm;
    @SerializedName("prodi")
    String prodi;
    @SerializedName("fakultas")
    String fakultas;

    public String getFullName() { return firstName.concat(lastName); }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getNpm() { return npm; }
    public void setNpm(String npm) { this.npm = npm; }
    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }
    public String getFakultas() { return fakultas; }
    public void setFakultas(String fakultas) { this.fakultas = fakultas; }
}
