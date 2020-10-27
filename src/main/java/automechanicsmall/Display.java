package automechanicsmall;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Display_table")
public class Display {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

}
