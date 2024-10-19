//
//
//package cinema.jfx.events;
//
//import cinema.jfx.controller.LoginController;
//import lombok.NonNull;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//import cinema.jfx.controller.FxView;
//
//import java.io.IOException;
//
///**
// * @author XDSSWAR
// * Created on 04/18/2024
// */
//@Component
//public class StartUpListener implements ApplicationListener<StartUpEvent> {
//    /**
//     * Handles the StartUpEvent by creating and displaying the login window.
//     *
//     * @param event The StartUpEvent instance.
//     */
//    @Override
//    public void onApplicationEvent(@NonNull StartUpEvent event) {
//        try {
//            new LoginController();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
