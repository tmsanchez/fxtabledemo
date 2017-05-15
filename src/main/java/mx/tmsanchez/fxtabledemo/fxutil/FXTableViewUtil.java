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
package mx.tmsanchez.fxtabledemo.fxutil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Tito Sanchez
 */
public class FXTableViewUtil {

    private ObservableList<?> observableList;

    public FXTableViewUtil() {

    }

    /**
     * Creates columns for a TableView
     * @param theClass Class to be used to get their properties
     * @param tableView TableView that will contains columns added
     * @param columnHeaders Columnn headers
     * @param itemList Object list to populate TableView
     */
    public void createColumns(Class<?> theClass, TableView tableView, String[] columnHeaders, List<?> itemList) {
        observableList = FXCollections.observableArrayList(itemList);
        List<TableColumn> tableColumns = new ArrayList();
        Field fields[] = theClass.getDeclaredFields();
        int index = 0;
        for (String colHeader : columnHeaders) {
            TableColumn tableColumn = new TableColumn(colHeader);
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(fields[index].getName()));
            tableColumns.add(tableColumn);

            index++;
        }

        tableView.setItems(this.observableList);
        tableView.getColumns().addAll(tableColumns);

    }

    /**
     * Binding existing table columns (already defined in .XML file) using the Id property
     * @param theClass
     * @param tableView
     * @param itemList 
     */
    public void assignColumns(Class<?> theClass, TableView tableView, List<?> itemList) {
        observableList = FXCollections.observableArrayList(itemList);

        Field fields[] = theClass.getDeclaredFields();

        for (Field field : fields) {
            TableColumn tableColumn = getTableColumnById(tableView, field.getName());
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(field.getName()));

        }

        tableView.setItems(this.observableList);

    }

    /**
     * Refresh the content of TableView
     * @param tableView
     * @param itemList 
     */
    public void updateTableContent(TableView tableView, List<?> itemList) {
        tableView.getItems().setAll(itemList);
        tableView.refresh();
    }

    /**
     * Get a Column by their name (thanks to James_D)
     * @see http://stackoverflow.com/questions/23189150/javafx-get-tableview-column-by-name
     * @param <T>
     * @param tableView
     * @param name
     * @return 
     */
    private <T> TableColumn<T, ?> getTableColumnByName(TableView<T> tableView, String name) {
        for (TableColumn<T, ?> col : tableView.getColumns()) {
            if (col.getText().equals(name)) {
                return col;
            }
        }
        return null;
    }

    /**
     * Get a TableColumn by ther css Id
     * @param <T>
     * @param tableView
     * @param name
     * @return 
     */
    private <T> TableColumn<T, ?> getTableColumnById(TableView<T> tableView, String name) {
        for (TableColumn<T, ?> col : tableView.getColumns()) {
            if (col.getId().equals(name)) {
                return col;
            }
        }
        return null;
    }
}
