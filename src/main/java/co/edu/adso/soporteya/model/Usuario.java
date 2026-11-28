package co.edu.adso.soporteya.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
public class Usuario {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 120)
    private String nombreCompleto;

    @Column (nullable = false, unique = true, length = 120)
    private String email;

    @Column (length = 100)
    private String password;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false, length = 20)
    private Rol rol;

    private boolean activo = true;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "area_id")
    private Area area;

    @ManyToMany 
    @JoinTable (name = "usuario_categoria", joinColumns = @JoinColumn(name = "usuario_id"),
                inverseJoinColumns = @JoinColumn (name = "categoria_id"))
    private  Set<Categoria> especialidades = new HashSet<>();

    public Usuario(String nombreCompleto, String email, Rol rol, Area area) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.rol = rol;
        this.area = area;
    }

    public boolean atiende(Categoria categoria) {
        return especialidades.stream().anyMatch(c -> c.getId().equals(categoria.getId()));
    }

}
