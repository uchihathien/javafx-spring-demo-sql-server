

package cinema.jfx.events;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;

/**
 * @author XDSSWAR
 * Created on 04/18/2024
 */
public class StartUpEvent extends ApplicationEvent {

    public StartUpEvent(Stage stage) {
        super(stage);
    }

    public Stage getStage(){
        return (Stage) getSource();
    }
}
