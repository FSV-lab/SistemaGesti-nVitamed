/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferch
 */
@Entity
@Table(name = "historia_clinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriaClinica.findAll", query = "SELECT h FROM HistoriaClinica h")
    , @NamedQuery(name = "HistoriaClinica.findByIdHc", query = "SELECT h FROM HistoriaClinica h WHERE h.idHc = :idHc")
    , @NamedQuery(name = "HistoriaClinica.findByFechaAtencion", query = "SELECT h FROM HistoriaClinica h WHERE h.fechaAtencion = :fechaAtencion")
    , @NamedQuery(name = "HistoriaClinica.findByNombreEps", query = "SELECT h FROM HistoriaClinica h WHERE h.nombreEps = :nombreEps")
    , @NamedQuery(name = "HistoriaClinica.findByRegimenAfiliado", query = "SELECT h FROM HistoriaClinica h WHERE h.regimenAfiliado = :regimenAfiliado")
    , @NamedQuery(name = "HistoriaClinica.findByNOrdenServicio", query = "SELECT h FROM HistoriaClinica h WHERE h.nOrdenServicio = :nOrdenServicio")
    , @NamedQuery(name = "HistoriaClinica.findByCodigoUnidadM", query = "SELECT h FROM HistoriaClinica h WHERE h.codigoUnidadM = :codigoUnidadM")
    , @NamedQuery(name = "HistoriaClinica.findByAtencionLugar", query = "SELECT h FROM HistoriaClinica h WHERE h.atencionLugar = :atencionLugar")
    , @NamedQuery(name = "HistoriaClinica.findByEvaluacionInicialPaci", query = "SELECT h FROM HistoriaClinica h WHERE h.evaluacionInicialPaci = :evaluacionInicialPaci")
    , @NamedQuery(name = "HistoriaClinica.findByEmbarazo", query = "SELECT h FROM HistoriaClinica h WHERE h.embarazo = :embarazo")
    , @NamedQuery(name = "HistoriaClinica.findByGinecoobstetrico", query = "SELECT h FROM HistoriaClinica h WHERE h.ginecoobstetrico = :ginecoobstetrico")
    , @NamedQuery(name = "HistoriaClinica.findByDificultadRespiratoria", query = "SELECT h FROM HistoriaClinica h WHERE h.dificultadRespiratoria = :dificultadRespiratoria")
    , @NamedQuery(name = "HistoriaClinica.findByPsiquiatrico", query = "SELECT h FROM HistoriaClinica h WHERE h.psiquiatrico = :psiquiatrico")
    , @NamedQuery(name = "HistoriaClinica.findByPiel", query = "SELECT h FROM HistoriaClinica h WHERE h.piel = :piel")
    , @NamedQuery(name = "HistoriaClinica.findByEscalaCincinnati", query = "SELECT h FROM HistoriaClinica h WHERE h.escalaCincinnati = :escalaCincinnati")
    , @NamedQuery(name = "HistoriaClinica.findByRevisionGenePaci", query = "SELECT h FROM HistoriaClinica h WHERE h.revisionGenePaci = :revisionGenePaci")
    , @NamedQuery(name = "HistoriaClinica.findByHallazgosPaci", query = "SELECT h FROM HistoriaClinica h WHERE h.hallazgosPaci = :hallazgosPaci")
    , @NamedQuery(name = "HistoriaClinica.findByImpresionDiagnos", query = "SELECT h FROM HistoriaClinica h WHERE h.impresionDiagnos = :impresionDiagnos")})
public class HistoriaClinica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hc")
    private Integer idHc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_atencion")
    @Temporal(TemporalType.DATE)
    private Date fechaAtencion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_eps")
    private String nombreEps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "regimen_afiliado")
    private String regimenAfiliado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_orden_servicio")
    private int nOrdenServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigo_unidad_m")
    private String codigoUnidadM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "atencion_lugar")
    private String atencionLugar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "evaluacion_inicial_paci")
    private String evaluacionInicialPaci;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "embarazo")
    private String embarazo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ginecoobstetrico")
    private String ginecoobstetrico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dificultad_respiratoria")
    private String dificultadRespiratoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "psiquiatrico")
    private String psiquiatrico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "piel")
    private String piel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "escala_cincinnati")
    private String escalaCincinnati;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "revision_gene_paci")
    private String revisionGenePaci;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "hallazgos_paci")
    private String hallazgosPaci;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "impresion_diagnos")
    private String impresionDiagnos;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false)
    private Paciente idPaciente;
    @JoinColumn(name = "id_especialistas", referencedColumnName = "id_especialistas")
    @ManyToOne(optional = false)
    private Especialistas idEspecialistas;
    @JoinColumn(name = "id_copago", referencedColumnName = "id_copago")
    @ManyToOne(optional = false)
    private Copago idCopago;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Integer idHc) {
        this.idHc = idHc;
    }

    public HistoriaClinica(Integer idHc, Date fechaAtencion, String nombreEps, String regimenAfiliado, int nOrdenServicio, String codigoUnidadM, String atencionLugar, String evaluacionInicialPaci, String embarazo, String ginecoobstetrico, String dificultadRespiratoria, String psiquiatrico, String piel, String escalaCincinnati, String revisionGenePaci, String hallazgosPaci, String impresionDiagnos) {
        this.idHc = idHc;
        this.fechaAtencion = fechaAtencion;
        this.nombreEps = nombreEps;
        this.regimenAfiliado = regimenAfiliado;
        this.nOrdenServicio = nOrdenServicio;
        this.codigoUnidadM = codigoUnidadM;
        this.atencionLugar = atencionLugar;
        this.evaluacionInicialPaci = evaluacionInicialPaci;
        this.embarazo = embarazo;
        this.ginecoobstetrico = ginecoobstetrico;
        this.dificultadRespiratoria = dificultadRespiratoria;
        this.psiquiatrico = psiquiatrico;
        this.piel = piel;
        this.escalaCincinnati = escalaCincinnati;
        this.revisionGenePaci = revisionGenePaci;
        this.hallazgosPaci = hallazgosPaci;
        this.impresionDiagnos = impresionDiagnos;
    }

    public Integer getIdHc() {
        return idHc;
    }

    public void setIdHc(Integer idHc) {
        this.idHc = idHc;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getNombreEps() {
        return nombreEps;
    }

    public void setNombreEps(String nombreEps) {
        this.nombreEps = nombreEps;
    }

    public String getRegimenAfiliado() {
        return regimenAfiliado;
    }

    public void setRegimenAfiliado(String regimenAfiliado) {
        this.regimenAfiliado = regimenAfiliado;
    }

    public int getNOrdenServicio() {
        return nOrdenServicio;
    }

    public void setNOrdenServicio(int nOrdenServicio) {
        this.nOrdenServicio = nOrdenServicio;
    }

    public String getCodigoUnidadM() {
        return codigoUnidadM;
    }

    public void setCodigoUnidadM(String codigoUnidadM) {
        this.codigoUnidadM = codigoUnidadM;
    }

    public String getAtencionLugar() {
        return atencionLugar;
    }

    public void setAtencionLugar(String atencionLugar) {
        this.atencionLugar = atencionLugar;
    }

    public String getEvaluacionInicialPaci() {
        return evaluacionInicialPaci;
    }

    public void setEvaluacionInicialPaci(String evaluacionInicialPaci) {
        this.evaluacionInicialPaci = evaluacionInicialPaci;
    }

    public String getEmbarazo() {
        return embarazo;
    }

    public void setEmbarazo(String embarazo) {
        this.embarazo = embarazo;
    }

    public String getGinecoobstetrico() {
        return ginecoobstetrico;
    }

    public void setGinecoobstetrico(String ginecoobstetrico) {
        this.ginecoobstetrico = ginecoobstetrico;
    }

    public String getDificultadRespiratoria() {
        return dificultadRespiratoria;
    }

    public void setDificultadRespiratoria(String dificultadRespiratoria) {
        this.dificultadRespiratoria = dificultadRespiratoria;
    }

    public String getPsiquiatrico() {
        return psiquiatrico;
    }

    public void setPsiquiatrico(String psiquiatrico) {
        this.psiquiatrico = psiquiatrico;
    }

    public String getPiel() {
        return piel;
    }

    public void setPiel(String piel) {
        this.piel = piel;
    }

    public String getEscalaCincinnati() {
        return escalaCincinnati;
    }

    public void setEscalaCincinnati(String escalaCincinnati) {
        this.escalaCincinnati = escalaCincinnati;
    }

    public String getRevisionGenePaci() {
        return revisionGenePaci;
    }

    public void setRevisionGenePaci(String revisionGenePaci) {
        this.revisionGenePaci = revisionGenePaci;
    }

    public String getHallazgosPaci() {
        return hallazgosPaci;
    }

    public void setHallazgosPaci(String hallazgosPaci) {
        this.hallazgosPaci = hallazgosPaci;
    }

    public String getImpresionDiagnos() {
        return impresionDiagnos;
    }

    public void setImpresionDiagnos(String impresionDiagnos) {
        this.impresionDiagnos = impresionDiagnos;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Especialistas getIdEspecialistas() {
        return idEspecialistas;
    }

    public void setIdEspecialistas(Especialistas idEspecialistas) {
        this.idEspecialistas = idEspecialistas;
    }

    public Copago getIdCopago() {
        return idCopago;
    }

    public void setIdCopago(Copago idCopago) {
        this.idCopago = idCopago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHc != null ? idHc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaClinica)) {
            return false;
        }
        HistoriaClinica other = (HistoriaClinica) object;
        if ((this.idHc == null && other.idHc != null) || (this.idHc != null && !this.idHc.equals(other.idHc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.HistoriaClinica[ idHc=" + idHc + " ]";
    }
    
}
