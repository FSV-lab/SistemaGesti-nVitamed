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
@Table(name = "especialistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialistas.findAll", query = "SELECT e FROM Especialistas e")
    , @NamedQuery(name = "Especialistas.findByIdEspecialistas", query = "SELECT e FROM Especialistas e WHERE e.idEspecialistas = :idEspecialistas")
    , @NamedQuery(name = "Especialistas.findByNombres", query = "SELECT e FROM Especialistas e WHERE e.nombres = :nombres")
    , @NamedQuery(name = "Especialistas.findByApellidos", query = "SELECT e FROM Especialistas e WHERE e.apellidos = :apellidos")
    , @NamedQuery(name = "Especialistas.findByTipoIdentificacion", query = "SELECT e FROM Especialistas e WHERE e.tipoIdentificacion = :tipoIdentificacion")
    , @NamedQuery(name = "Especialistas.findByNumeroIdentificacion", query = "SELECT e FROM Especialistas e WHERE e.numeroIdentificacion = :numeroIdentificacion")
    , @NamedQuery(name = "Especialistas.findByEspecialidad", query = "SELECT e FROM Especialistas e WHERE e.especialidad = :especialidad")})
public class Especialistas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_especialistas")
    private Integer idEspecialistas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_identificacion")
    private int numeroIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "especialidad")
    private String especialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspecialistas")
    private Collection<HistoriaClinica> historiaClinicaCollection;

    public Especialistas() {
    }

    public Especialistas(Integer idEspecialistas) {
        this.idEspecialistas = idEspecialistas;
    }

    public Especialistas(Integer idEspecialistas, String nombres, String apellidos, String tipoIdentificacion, int numeroIdentificacion, String especialidad) {
        this.idEspecialistas = idEspecialistas;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.especialidad = especialidad;
    }

    public Integer getIdEspecialistas() {
        return idEspecialistas;
    }

    public void setIdEspecialistas(Integer idEspecialistas) {
        this.idEspecialistas = idEspecialistas;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
        hash += (idEspecialistas != null ? idEspecialistas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialistas)) {
            return false;
        }
        Especialistas other = (Especialistas) object;
        if ((this.idEspecialistas == null && other.idEspecialistas != null) || (this.idEspecialistas != null && !this.idEspecialistas.equals(other.idEspecialistas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Especialistas[ idEspecialistas=" + idEspecialistas + " ]";
    }
    
}
