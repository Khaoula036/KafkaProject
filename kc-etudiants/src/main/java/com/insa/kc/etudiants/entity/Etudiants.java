package com.insa.kc.etudiants.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TONDEUR Hervé
 */
@Entity
@Table(name = "etudiants")
@JsonIgnoreProperties(ignoreUnknown = true)
//@XmlRootElement
public class Etudiants implements Serializable 
{

    private static final long serialVersionUID = 1L;

@Column(name = "identifiant")
    @Id
private String identifiant;

@Column(name = "nom")
private String nom;

@Column(name = "prenom")
private String prenom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identifiant != null ? identifiant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the identifiant fields are not set
        if (!(object instanceof Etudiants)) {
            return false;
        }
        Etudiants other = (Etudiants) object;
        if ((this.identifiant == null && other.identifiant != null) || (this.identifiant != null && !this.identifiant.equals(other.identifiant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.insa.kc.entity.bem_patients[ id=" + identifiant + " ]";
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    
}
