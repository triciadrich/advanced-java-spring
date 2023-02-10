package platform.codingnomads.co.ioc.lab.initial;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class Desk {
    private String brand;
    private String type;
}
