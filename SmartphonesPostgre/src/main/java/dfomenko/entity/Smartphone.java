package dfomenko.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "smartphone")
public class Smartphone {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "model_id")
    private Long modelId;

    @Column(name = "performance_cpu")
    private Long performanceCPU;

    @Column(name = "gaming_performance")
    private Long gamingPerformance;

    @Column(name="camera")
    private Long camera;

    public Smartphone createZeroCharacteristicsSmartphone() {
        return new Smartphone(null, null, null, 0L, 0L, 0L);
    }
}
