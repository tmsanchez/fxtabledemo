/*
 * Copyright 2017 Tito Sanchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mx.tmsanchez.fxtabledemo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tito Sanchez
 */
public class MainSceneController implements Initializable {

    private static final String RESOURCE_FOLDER = "/fxml/";
    private static final String RUNTIME_SCENE = RESOURCE_FOLDER + "RuntimeScene.fxml";
    private static final String DESIGNTIME_SCENE = RESOURCE_FOLDER + "DesigntimeScene.fxml";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void testRuntimeController(ActionEvent event) {
        lauchScene(RUNTIME_SCENE, "Test Create columns at Runtime");

    }

    @FXML
    private void testDesigntimeController(ActionEvent event) {
        lauchScene(DESIGNTIME_SCENE, "Test Assign columns using Existing Design");
    }

    private void lauchScene(String sceneName, String title) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(sceneName));

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root, 800, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
