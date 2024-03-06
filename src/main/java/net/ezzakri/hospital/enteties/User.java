package net.ezzakri.hospital.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class User {

    @Id
    private String userId;
    @Column(name = "USER_NAME", unique = true, length = 20)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
}
