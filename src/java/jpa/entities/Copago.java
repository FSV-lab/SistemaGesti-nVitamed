/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferch
 */
@Entity
@Table(name = "copago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Copago.findAll", query = "SELECT c FROM Copago c")
    , @NamedQuery(name = "Copago.findByIdCopago", query = "SELECT c FROM Copago c WHERE c.idCopago = :idCopago")
    , @NamedQuery(name = "Copago.findByTarifa", query = "SELECT c FROM Copago c WHERE c.tarifa = :tarifa")})
public class Copago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_copago")
    private Integer idCopago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tarifa")
    private String tarifa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCopago")
    private Collection<HistoriaClinica> historiaClinicaCollection;

    public Copago() {
    }

    public Copago(Integer idCopago) {
        this.idCopago = idCopago;
    }

    public Copago(Integer idCopago, String tarifa) {
        this.idCopago = idCopago;
        this.tarifa = tarifa;
    }

    public Integer getIdCopago() {
        return idCopago;
    }

    public void setIdCopago(Integer idCopago) {
        this.idCopago = idCopago;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    @XmlTransient
    public Collection<HistoriaClinica> getHistoriaClinicaCollection() {
        return historiaClinicaCollection;
    }

    public void setHistoriaClinicaCollection(Collection<HistoriaClinica> historiaClinicaCollection) {
        this.historiaClinicaCollection = historiaClinicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCopago != null ? idCopago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Copago)) {
            return false;
        }
        Copago other = (Copago) object;
        if ((this.idCopago == null && other.idCopago != null) || (this.idCopago != null && !this.idCopago.equals(other.idCopago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Copago[ idCopago=" + idCopago + " ]";
    }
    
}
