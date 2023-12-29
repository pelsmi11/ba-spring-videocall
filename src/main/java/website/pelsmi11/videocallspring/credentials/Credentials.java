package website.pelsmi11.videocallspring.credentials;



import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Credentials {
    @Value("${APP_ID}")
    private String appID;
    @Value("${SERVER_SECRET}")
    private String serverSecret;
}
