package compi.g19.a.AnalisisLexico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Error {
    private final String error;
    private final int nroLinea;
}
