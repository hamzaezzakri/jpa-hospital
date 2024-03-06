package net.ezzakri.hospital.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 20)
    private String roleName;
    @Column(name = "DESCRIPTION")
    private String desc;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();
}
