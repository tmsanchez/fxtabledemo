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
package mx.tmsanchez.fxtabledemo.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import mx.tmsanchez.fxtabledemo.domain.Person;
import mx.tmsanchez.fxtabledemo.fxutil.CommonController;
import mx.tmsanchez.fxtabledemo.service.PersonService;

/**
 *
 * @author Tito Sanchez
 */
public class DesigntimeController extends CommonController implements Initializable {

    private final PersonService personService = new PersonService();

    private List<Person> personList = new ArrayList();

    @FXML
    private TableView tableView;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        personList = personService.getPersons();
        tableViewUtil.updateTableContent(tableView, personList);

    }

    @FXML
    private void clearList(ActionEvent event) {
        personList.clear();
        tableViewUtil.updateTableContent(tableView, personList);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableViewUtil.assignColumns(Person.class, tableView, personList);
    }

}
