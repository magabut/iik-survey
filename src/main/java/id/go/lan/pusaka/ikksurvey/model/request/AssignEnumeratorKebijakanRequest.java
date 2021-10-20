package id.go.lan.pusaka.ikksurvey.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AssignEnumeratorKebijakanRequest {
    @JsonProperty("nip_enumerator")
    private String nipEnumerator;
}
