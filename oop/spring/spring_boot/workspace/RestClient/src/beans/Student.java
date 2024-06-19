package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Student {
    private @Getter @Setter String name;
    private @Getter @Setter String passportNumber;
    
}
