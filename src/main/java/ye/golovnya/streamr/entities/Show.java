package ye.golovnya.streamr.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "show_id_seq")
    @SequenceGenerator(name = "show_id_seq", sequenceName = "show_id_seq")
    private Long id;

    private String title;

    private String serviceName;

    private String image;

    @ManyToMany
    @JoinTable(name = "users_shows", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "show_id"))
    private List<User> users = new ArrayList<>();

}
