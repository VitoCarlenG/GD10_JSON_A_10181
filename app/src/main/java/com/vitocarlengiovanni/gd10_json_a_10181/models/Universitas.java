package com.vitocarlengiovanni.gd10_json_a_10181.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Universitas {
    @SerializedName("NamaUniversitas")
    String NamaUniversitas;
    @SerializedName("students")
    List<Student> students;

    public String getNamaUniversitas() { return NamaUniversitas; }
    public void setNamaUniversitas(String namaUniversitas) { NamaUniversitas = namaUniversitas; }
    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}
