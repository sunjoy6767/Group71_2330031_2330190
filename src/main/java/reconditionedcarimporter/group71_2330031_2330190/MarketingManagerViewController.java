package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;

import java.io.IOException;

public class MarketingManagerViewController {
    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("Login-view.fxml", actionEvent);
    }
}
