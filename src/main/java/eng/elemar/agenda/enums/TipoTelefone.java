package eng.elemar.agenda.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {
    CASA("CASA"), CELULAR("CELULAR"), COMERCIAL("COMERCIAL");

    private final String description;
}
