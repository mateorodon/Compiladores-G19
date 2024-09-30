package compi.g19.a.AnalisisLexico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
public class Error {
    private final String error;
    private final int nroLinea;

}
