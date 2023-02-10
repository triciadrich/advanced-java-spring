package platform.codingnomads.co.ioc.lab.initial;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component//candidate for auto detection when using annotation based config and classpath scanning
@RequiredArgsConstructor//lombok annotation that creates constructor with final fields
public class CodingNomad {

    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;


    private final Desk desk;


    public String createAwesomeSoftware() {

        return MessageFormat
                .format("This coding nomad is creating awesome software using, " +
                                "IDE: ({0}:{1}), JDK: ({2}:{3}), Framework: ({4}:{5}), Desk:({6}:{7})" ,
                        ide.getName(),
                        ide.getVersion(),
                        jdk.getName(),
                        jdk.getVersion(),
                        framework.getName(),
                        framework.getVersion(),
                        desk.getBrand(),
                        desk.getType()

                );
    }
}
