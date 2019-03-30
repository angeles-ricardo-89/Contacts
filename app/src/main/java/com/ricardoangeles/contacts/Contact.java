package com.ricardoangeles.contacts;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Contact implements Parcelable {
    private String nombreCompleto;
    private String telefono;
    private String fechaNacimiento;
    private String descripcion;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public Contact(String nombreCompleto, String telefono, String fechaNacimiento,
                   String descripcion, String email) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.descripcion = descripcion;
        this.email = email;
    }

    public Contact(Parcel in){
        this.nombreCompleto = in.readString();
        this.telefono = in.readString();
        this.fechaNacimiento = in.readString();
        this.email = in.readString();
        this.descripcion = in.readString();

    }

    public static final Parcelable.Creator<Contact> CREATOR
            = new Parcelable.Creator<Contact>() {
        public Contact createFromParcel(Parcel parcel_in){
            return new Contact(parcel_in);
        }

        public Contact[] newArray(int size){
            return new Contact[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombreCompleto);
        parcel.writeString(telefono);
        parcel.writeString(fechaNacimiento);
        parcel.writeString(email);
        parcel.writeString(descripcion);

    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getNombreCompleto(), contact.getNombreCompleto()) &&
                Objects.equals(getTelefono(), contact.getTelefono()) &&
                Objects.equals(getFechaNacimiento(), contact.getFechaNacimiento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombreCompleto(), getTelefono(), getFechaNacimiento());
    }
}
