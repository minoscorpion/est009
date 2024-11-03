/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author rafae
 */
@Entity
@Table(name = "Movimentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentos.findAll", query = "SELECT m FROM Movimentos m"),
    @NamedQuery(name = "Movimentos.findByMovimentoID", query = "SELECT m FROM Movimentos m WHERE m.movimentoID = :movimentoID"),
    @NamedQuery(name = "Movimentos.findByPessoaID", query = "SELECT m FROM Movimentos m WHERE m.pessoaID = :pessoaID"),
    @NamedQuery(name = "Movimentos.findByQuantidade", query = "SELECT m FROM Movimentos m WHERE m.quantidade = :quantidade"),
    @NamedQuery(name = "Movimentos.findByTipo", query = "SELECT m FROM Movimentos m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "Movimentos.findByPrecoUnitario", query = "SELECT m FROM Movimentos m WHERE m.precoUnitario = :precoUnitario"),
    @NamedQuery(name = "Movimentos.findByDataMovimento", query = "SELECT m FROM Movimentos m WHERE m.dataMovimento = :dataMovimento")})
public class Movimentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MovimentoID")
    private Integer movimentoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PessoaID")
    private int pessoaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrecoUnitario")
    private BigDecimal precoUnitario;
    @Column(name = "DataMovimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMovimento;
    @JoinColumn(name = "ProdutoID", referencedColumnName = "ProdutoID")
    @ManyToOne(optional = false)
    private Produtos produtoID;
    @JoinColumn(name = "UsuarioID", referencedColumnName = "UsuarioID")
    @ManyToOne(optional = false)
    private Usuarios usuarioID;

    public Movimentos() {
    }

    public Movimentos(Integer movimentoID) {
        this.movimentoID = movimentoID;
    }

    public Movimentos(Integer movimentoID, int pessoaID, int quantidade, String tipo, BigDecimal precoUnitario) {
        this.movimentoID = movimentoID;
        this.pessoaID = pessoaID;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.precoUnitario = precoUnitario;
    }

    public Integer getMovimentoID() {
        return movimentoID;
    }

    public void setMovimentoID(Integer movimentoID) {
        this.movimentoID = movimentoID;
    }

    public int getPessoaID() {
        return pessoaID;
    }

    public void setPessoaID(int pessoaID) {
        this.pessoaID = pessoaID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public Produtos getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(Produtos produtoID) {
        this.produtoID = produtoID;
    }

    public Usuarios getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Usuarios usuarioID) {
        this.usuarioID = usuarioID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movimentoID != null ? movimentoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentos)) {
            return false;
        }
        Movimentos other = (Movimentos) object;
        if ((this.movimentoID == null && other.movimentoID != null) || (this.movimentoID != null && !this.movimentoID.equals(other.movimentoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.Movimentos[ movimentoID=" + movimentoID + " ]";
    }
    
}
